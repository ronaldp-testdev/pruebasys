import { Component } from '@angular/core';
import { CommonListarComponent } from '../common-listar.component';
import { Role } from '../../models/role';
import { RoleService } from '../../services/role.service';
import { BASE_ENDPOINT } from '../../config/app';

@Component({
  selector: 'app-role',
  templateUrl: './role.component.html'
})
export class RoleComponent extends CommonListarComponent<Role, RoleService>{

  baseEndpoint = BASE_ENDPOINT+'/roles';
  
  constructor(service : RoleService){
    super(service);
    this.titulo  = 'Listado de Roles';
    this.nombreModel = Role.name
  }

}
