import { Component, OnInit } from "@angular/core";
import { CommonFormComponent } from "../common-form.component";
import { Persona } from "../../models/persona";
import { PersonaService } from "../../services/persona.service";
import { ActivatedRoute, Router } from "@angular/router";

@Component({
  selector: 'app-persona-form',
  templateUrl: './persona-form.component.html'
})
export class PersonaFormComponent extends CommonFormComponent<Persona, PersonaService> implements OnInit{
  constructor(service : PersonaService, router : Router, route : ActivatedRoute){
    super(service, router, route)
    this.titulo = "Crear Personas";
    this.model = new Persona();
    this.redirect = '/personas';
    this.nombreModel = Persona.name;
  }
}
