import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs'
import { Proces } from './proces';

/**
 * Aquesta classe conté serveis del procés
 */
@Injectable({
  providedIn: 'root'
})
export class ProcesService {

  private procesDesat: Proces = new Proces();

  private baseURL = "http://localhost:8080/api/v1/newproces";
  private allProcessosURL = "http://localhost:8080/api/v1/processos";


  constructor(private httpClient: HttpClient) { }

  /**
   * Petició POST a Spring Boot per crear una procès
   * @param proces un objecte JSON procés
   * @returns post
   */
  crearProces(proces: Proces): Observable<Object> {
    return this.httpClient.post(`${this.baseURL}`, proces);
  }

  /**
   * Petició Get d'un proces per id
   * @param idProces id d'un procés
   * @returns  getbyid
   */
  getProcesbyId(idProces: number): Observable<Proces> {
    return this.httpClient.get<Proces>(`${this.allProcessosURL}/${idProces}`);
  }

  /**
   * Petició GET per obtenir llistat de processos
   * @returns get all
   */
  getAllProcessos(): Observable<Proces[]> {
    return this.httpClient.get<Proces[]>(`${this.allProcessosURL}`);
  }

  /**
   * Petició put per actualitzar un procès
   * @param idProces id d'un procés
   * @param proces un objecte JSON procés
   * @returns put
   */
  updateProces(idProces: number, proces: Proces): Observable<Object> {
    return this.httpClient.put(`${this.allProcessosURL}/${idProces}`, proces);
  }

  /**
   * Esborrar un procés
   * @param idProces id d'un procés
   * @returns delete
   */
  deleteProces(idProces: number): Observable<Object> {
    return this.httpClient.delete(`${this.allProcessosURL}/${idProces}`);
  }

  /**
   * Desa proces a memòria
   * @param proces un objecte JSON procés
   */
  desarproces(proces: Proces) {
    this.procesDesat = proces;
  }

  /**
   * Getter del proces desat a memòria
   * @returns proces desat
   */
  getProcesDesat() {
    return this.procesDesat;
  }

}
