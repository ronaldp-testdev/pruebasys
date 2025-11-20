import { Injectable } from '@angular/core';
import { CommonService } from './common.service';
import { Role } from '../models/role';
import { HttpClient } from '@angular/common/http';
import { BASE_ENDPOINT } from '../config/app';

@Injectable({
  providedIn: 'root'
})
export class RoleService extends CommonService<Role>{

  protected override baseEndpoint = BASE_ENDPOINT+'/roles';

  constructor(http : HttpClient) {super(http);}


}
