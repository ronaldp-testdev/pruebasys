import { Injectable } from '@angular/core';
import { CommonService } from './common.service';
import { RolOpciones } from '../models/rol-opciones';
import { BASE_ENDPOINT } from '../config/app';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RolOpcionesService extends CommonService<RolOpciones>{

  protected override baseEndpoint = BASE_ENDPOINT+'/rol-opciones';

  constructor(http : HttpClient) {super(http);}


}
