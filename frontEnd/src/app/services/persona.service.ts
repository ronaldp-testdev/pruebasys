import { Injectable } from '@angular/core';
import { CommonService } from './common.service';
import { Persona } from '../models/persona';
import { HttpClient } from '@angular/common/http';
import { BASE_ENDPOINT } from '../config/app';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonaService extends CommonService<Persona>{

  protected override baseEndpoint = BASE_ENDPOINT+'/personas';

  constructor(http : HttpClient) {super(http);}

  public cargaMasivaCSV(csv: File) : Observable<Persona>{
    const formData = new FormData();
    formData.append('csv', csv);
    return this.http.post<Persona>(this.baseEndpoint + '/csv', 
    formData);
  }


}
