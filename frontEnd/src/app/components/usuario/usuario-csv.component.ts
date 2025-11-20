import { Component, OnInit } from '@angular/core';

import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Persona } from '../../models/persona';
import { PersonaService } from '../../services/persona.service';

@Component({
  selector: 'app-usuario-csv',
  templateUrl: './usuario-csv.component.html'
})
export class UsuarioCSVComponent implements OnInit{
  titulo : string;
  usuarios : Persona[] = [];
  private model : Persona;  //Data Binding NgModel -> desde el formulario
  private error: any;
  private redirect : string;
  private nombreModel : string;
  private archivoSeleccionado : File;

  constructor(private service : PersonaService, private router : Router, private route : ActivatedRoute){
    this.titulo = "Carga Masiva de Usuarios (CSV)";
    this.model = new Persona();
    this.redirect = '/personas';
    this.nombreModel = Persona.name;
  }

  seleccionarArchivo(event) : void {
    this.archivoSeleccionado = event.target.files[0];

    if(this.archivoSeleccionado.type.indexOf('csv')>0 ) {
        
       let file : File = this.archivoSeleccionado
        
         let reader: FileReader = new FileReader();
         reader.readAsText(file);
         reader.onload = (e) => {
            let csv: string = reader.result as string;
            this.convertCSVStringtoList(csv)
         }
      }

  }

  public loadCSVtoServer() : void {
    this.service.cargaMasivaCSV(this.archivoSeleccionado)
    .subscribe(() => {
      Swal.fire('Nuevo:', 'CSV cargado con Éxito', 'success');
      this.router.navigate([this.redirect]);
    }, err => {
      if (err.status === 400) {
        this.error = err.error;
      }
    });
  }

  private convertCSVStringtoList(csvString: string){
    this.usuarios = [];
    var lines : string[] = csvString.split('\n');
    var dataValues = lines.splice(1).map(function (dataLine) { return dataLine.split(','); });
    dataValues.forEach((d) => {
      var userTmp : Persona = new Persona;
      userTmp.nombres = d[0]
      userTmp.apellidos = d[1]
      userTmp.identificacion = d[2]
      userTmp.fechaNacimiento = d[3];
      this.usuarios.push(userTmp)
    })
    console.log(this.usuarios)
  }

  ngOnInit(): void {}



}
