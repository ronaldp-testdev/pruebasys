import { Component } from '@angular/core';
import { Persona } from '../../models/persona';
import { BASE_ENDPOINT } from '../../config/app';
import { PersonaService } from '../../services/persona.service';
import { CommonListarComponent } from '../common-listar.component';

@Component({
  selector: 'app-persona',
  templateUrl: './persona.component.html'
})
export class PersonaComponent extends CommonListarComponent<Persona, PersonaService>{

  baseEndpoint = BASE_ENDPOINT+'/personas';
  
  constructor(service : PersonaService){
    super(service);
    this.titulo  = 'Listado de Personas';
    this.nombreModel = Persona.name
  }
}
