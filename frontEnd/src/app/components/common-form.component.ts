import { Directive, OnInit } from "@angular/core";

import { ActivatedRoute, Router } from "@angular/router";
import Swal from "sweetalert2";
import { CommonService } from "../services/common.service";
import { Generic } from "../models/generic";

@Directive()
export abstract class CommonFormComponent <T extends Generic, S extends CommonService<T>> implements OnInit{

  titulo : string;
  model : T;  //Data Binding NgModel -> desde el formulario
  error: any;
  protected redirect : string;
  protected nombreModel : string;

  constructor(protected service : S,
      protected router : Router,
      protected route : ActivatedRoute
  ){}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const id: number = +params.get('id');
      if(id){
        this.service.ver(id).subscribe(m => {
          this.model = m;
          this.titulo = 'Editar ' + this.nombreModel;
        })
      }
    })
  }

  public crear() : void {
    this.service.crear(this.model).subscribe(m => {

      Swal.fire('Nuevo:', `${this.nombreModel} Creado con éxito`, 'success');

      this.router.navigate([this.redirect]);
    }, err => {
      if(err.status === 400){
        this.error = err.error;
      }
    });
  }

  public editar() : void{
    this.service.editar(this.model).subscribe(m => {
      
      Swal.fire('Actualizado:', `${this.nombreModel}  Actualizado con éxito`, 'success');

      this.router.navigate([this.redirect]);
    }, err => {
      if(err.status === 400){
        this.error = err.error;
      }
    });
  }

}

