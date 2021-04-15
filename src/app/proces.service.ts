import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs'
import { Proces } from './proces';

@Injectable({
  providedIn: 'root'
})
export class ProcesService {

  private baseURL = "http://localhost:8080/api/v1/newproces";

  constructor(private httpClient: HttpClient ) { }

  //Petició post a Spring Boot per crear una procès
  crearProces(proces: Proces): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, proces);
  }

}
