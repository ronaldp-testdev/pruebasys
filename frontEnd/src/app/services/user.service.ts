import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { CommonService } from './common.service';
import { BASE_ENDPOINT } from '../config/app';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService extends CommonService<User>{

  protected override baseEndpoint = BASE_ENDPOINT+'/usuarios';

  constructor(http : HttpClient) {super(http);}
}
