import { Component, OnInit } from '@angular/core';
import { RoleService } from '../../services/role.service';
import { Role } from '../../models/role';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonFormComponent } from '../common-form.component';


@Component({
  selector: 'app-role-form',
  templateUrl: './role-form.component.html'
})
export class RoleFormComponent extends CommonFormComponent<Role, RoleService> implements OnInit{
  constructor(service : RoleService, router : Router, route : ActivatedRoute){
    super(service, router, route)
    this.titulo = "Crear Roles";
    this.model = new Role();
    this.redirect = '/roles';
    this.nombreModel = Role.name;
  }
}