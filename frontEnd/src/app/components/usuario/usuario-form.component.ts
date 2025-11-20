import { Component, OnInit } from '@angular/core';
import { CommonFormComponent } from '../common-form.component';
import { User } from '../../models/user';
import { UserService } from '../../services/user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { UserDto } from '../../models/user-dto';

@Component({
  selector: 'app-usuario-form',
  templateUrl: './usuario-form.component.html'
})
export class UsuarioFormComponent  extends CommonFormComponent<UserDto, UserService> implements OnInit{
  constructor(service : UserService, router : Router, route : ActivatedRoute){
    super(service, router, route)
    this.titulo = "Crear Usuario";
    this.model = new UserDto();
    this.redirect = '/usuarios';
    this.nombreModel = User.name;
  }
}
