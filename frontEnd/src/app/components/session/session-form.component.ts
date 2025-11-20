import { Component, OnInit } from '@angular/core';
import { CommonFormComponent } from '../common-form.component';
import { Session } from '../../models/session';
import { SessionService } from '../../services/session.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-session-form',
  templateUrl: './session-form.component.html'
})
export class SessionFormComponent extends CommonFormComponent<Session, SessionService> implements OnInit{
  constructor(service : SessionService, router : Router, route : ActivatedRoute){
    super(service, router, route)
    this.titulo = "Crear Sesion";
    this.model = new Session();
    this.redirect = '/sessions';
    this.nombreModel = Session.name;
  }
}
