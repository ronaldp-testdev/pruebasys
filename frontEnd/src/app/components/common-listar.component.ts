import { Directive, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import Swal from "sweetalert2";
import { Generic } from '../models/generic';
import { CommonService } from '../services/common.service';

@Directive()
export abstract class CommonListarComponent <T extends Generic, S extends CommonService<T>> implements OnInit{
  titulo : string = '';
  lista: T[] = [];
  protected nombreModel : string = '';
  totalRegistros = 0;
  paginaActual = 0;
  totalPorPagina = 4;
  pageSizeOptions : number[] = [3, 5, 10, 25, 100];
  @ViewChild(MatPaginator, {static : true}) paginator : MatPaginator;

  constructor(protected service : S){}

  ngOnInit(): void {
    //Paginación
    this.calcularRangos();
    //this.service.listar().subscribe(alumnos => this.alumnos = alumnos);
  }

  paginar(event : PageEvent) : void {
    this.paginaActual = event.pageIndex;
    this.totalPorPagina = event.pageSize;
    //Paginar
    this.calcularRangos();
  }

  //Método para calcular Rangos de la Paginación

  private calcularRangos(){
    this.service.listarPaginas(this.paginaActual.toString(), this.totalPorPagina.toString())
      .subscribe(p => {
        this.lista = p.content as T[];
        this.totalRegistros = p.totalElements as number;
        this.paginator._intl.itemsPerPageLabel = 'Registros por Página:';
      });
  }
  public eliminar(type : T) : void {

    Swal.fire({
      title: "¡Cuidado!",
      text: `¿ Seguro que desea cambiar el estado del elemento con ID# ${type.id} ?`,
      icon: "warning",
      showCancelButton: true,
      cancelButtonText: "Cancelar",
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Sí, cambiar"
    }).then((result) => {
      if (result.isConfirmed) {
        this.service.eliminar(type.id).subscribe(() => {
          

          this.calcularRangos();

  
          Swal.fire('Estado Cambiado (Activado / Desactivado)', `${this.nombreModel} cambiado de estado con éxito`, 'success');
        });
      }
    });

 
  }



}

