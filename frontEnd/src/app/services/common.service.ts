import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Generic } from '../models/generic';
import { Observable } from 'rxjs';


export abstract class CommonService <T extends Generic> {

  protected baseEndpoint : string = '';
  protected cabeceras : HttpHeaders = new HttpHeaders({'Content-Type' : 'application/json'})
  constructor(protected http: HttpClient) {}

  public listar(): Observable<T[]> {
    return this.http.get<T[]>(this.baseEndpoint);
  }

  public listarPaginas(page: string, size: string) : Observable<any>{
    const params = new HttpParams()
      .set('page', page)
      .set('size', size);
    return this.http.get<any>(this.baseEndpoint+'/pagina', {params: params});
  }

  public ver(id : number) : Observable<T>{
    return this.http.get<T>(`${this.baseEndpoint}/${id}`);
  }

  public crear(type : T) : Observable<T>{

    return this.http.post<T>(this.baseEndpoint, type, 
          {headers: this.cabeceras});
  }

  public editar(type : T) : Observable<T>{
    return this.http.put<T>(`${this.baseEndpoint}/${type.id}`, type, 
          {headers: this.cabeceras});
  }

  public eliminar(id: number) : Observable<void>{
    return this.http.delete<void>(`${this.baseEndpoint}/${id}`);
  }
}
