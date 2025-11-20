import { Component } from '@angular/core';
import { CommonListarComponent } from '../common-listar.component';
import { User } from '../../models/user';
import { UserService } from '../../services/user.service';
import { BASE_ENDPOINT } from '../../config/app';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html'
})
export class UsuarioComponent extends CommonListarComponent<User, UserService>{

  baseEndpoint = BASE_ENDPOINT+'/usuarios';
  
  constructor(service : UserService){
    super(service);
    this.titulo  = 'Listado de Usuarios';
    this.nombreModel = User.name
  }

}
