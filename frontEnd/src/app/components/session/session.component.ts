import { Component } from '@angular/core';
import { CommonListarComponent } from '../common-listar.component';
import { Session } from '../../models/session';
import { SessionService } from '../../services/session.service';
import { BASE_ENDPOINT } from '../../config/app';

@Component({
  selector: 'app-session',
  templateUrl: './session.component.html'
})
export class SessionComponent extends CommonListarComponent<Session, SessionService>{

  baseEndpoint = BASE_ENDPOINT+'/sessions';
  
  constructor(service : SessionService){
    super(service);
    this.titulo  = 'Listado de Sesiones';
    this.nombreModel = Session.name
  }
}
