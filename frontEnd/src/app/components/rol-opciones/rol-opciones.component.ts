import { Component } from '@angular/core';
import { CommonListarComponent } from '../common-listar.component';
import { RolOpciones } from '../../models/rol-opciones';
import { RolOpcionesService } from '../../services/rol-opciones.service';
import { BASE_ENDPOINT } from '../../config/app';

@Component({
  selector: 'app-rol-opciones',
  templateUrl: './rol-opciones.component.html'
})
export class RolOpcionesComponent extends CommonListarComponent<RolOpciones, RolOpcionesService>{

  baseEndpoint = BASE_ENDPOINT+'/rol-opciones';
  
  constructor(service : RolOpcionesService){
    super(service);
    this.titulo  = 'Listado de Opciones Basados en Roles';
    this.nombreModel = RolOpciones.name;
  }
}
