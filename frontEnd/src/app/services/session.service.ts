import { Injectable } from '@angular/core';
import { Session } from '../models/session';
import { HttpClient } from '@angular/common/http';
import { BASE_ENDPOINT } from '../config/app';
import { CommonService } from './common.service';

@Injectable({
  providedIn: 'root'
})
export class SessionService extends CommonService<Session>{

  protected override baseEndpoint = BASE_ENDPOINT+'/sessions';

  constructor(http : HttpClient) {super(http);}

}
