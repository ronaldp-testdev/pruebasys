import { Component, OnInit } from '@angular/core';
import { CommonFormComponent } from '../common-form.component';
import { RolOpciones } from '../../models/rol-opciones';
import { RolOpcionesService } from '../../services/rol-opciones.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-rol-opciones-form',
  templateUrl: './rol-opciones-form.component.html'
})
export class RolOpcionesFormComponent extends CommonFormComponent<RolOpciones, RolOpcionesService> implements OnInit{
  constructor(service : RolOpcionesService, router : Router, route : ActivatedRoute){
    super(service, router, route)
    this.titulo = "Crear Opciones Basadas en Roles";
    this.model = new RolOpciones();
    this.redirect = '/rol-opciones';
    this.nombreModel = RolOpciones.name;
  }
}
