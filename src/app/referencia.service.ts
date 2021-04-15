import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Referencia } from './referencia';

@Injectable({
  providedIn: 'root'
})
export class ReferenciaService {

  private baseURL = "http://localhost:8080/api/v1/referencies";

  constructor(private httpClient: HttpClient) { }

  
  getAllReferencies() : Observable<Referencia[]>{
    return this.httpClient.get<Referencia[]>(`${this.baseURL}`);
  }

  
}
