import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Referencia } from './referencia';

/**
 * Aquesta classe conté serveis de la referència
 */
@Injectable({
  providedIn: 'root'
})
export class ReferenciaService {

  private baseURL = "http://localhost:8080/api/v1/referencies";

  constructor(private httpClient: HttpClient) { }

  /**
   * Petició a Spring Boot per obtenir totes les referències existents
   * @returns get
   */
  getAllReferencies(): Observable<Referencia[]> {
    return this.httpClient.get<Referencia[]>(`${this.baseURL}`);
  }

}
