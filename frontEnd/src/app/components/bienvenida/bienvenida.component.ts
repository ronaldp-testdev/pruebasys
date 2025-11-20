import { Component } from '@angular/core';
import { Session } from '../../models/session';

@Component({
  selector: 'app-bienvenida',
  templateUrl: './bienvenida.component.html'
})
export class BienvenidaComponent {
  titulo: string = '';
  model : Session;

  constructor(){
    this.titulo = 'Titulo';
    this.model = new Session;
  }

}
