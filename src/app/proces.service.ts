import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs'
import { Proces } from './proces';

@Injectable({
  providedIn: 'root'
})
export class ProcesService {
  
  private procesDesat: Proces | undefined;

  private baseURL = "http://localhost:8080/api/v1/newproces";
  private allProcessosURL = "http://localhost:8080/api/v1/processos";


  constructor(private httpClient: HttpClient) { }

  //Petició POST a Spring Boot per crear una procès
  crearProces(proces: Proces): Observable<Object> {
    return this.httpClient.post(`${this.baseURL}`, proces);
  }

  //Petició Get d'un proces per id
  getProcesbyId(idProces: number): Observable<Proces>{
    return this.httpClient.get<Proces>(`${this.allProcessosURL}/${idProces}`);
  } 

  //Petició GET per obtenir llistat de processos
  getAllProcessos(): Observable<Proces[]>{
    return this.httpClient.get<Proces[]>(`${this.allProcessosURL}`);
  }

  //Petició put per actualitzar un procès
  updateProces(idProces: number, proces: Proces): Observable<Object>{
    return this.httpClient.put(`${this.allProcessosURL}/${idProces}`, proces);
  }

  deleteProces(idProces: number): Observable<Object>{
    return this.httpClient.delete(`${this.allProcessosURL}/${idProces}`);
  }

  //Desa proces en memòria
  desarproces(proces: Proces){
    this.procesDesat = proces;
  }

  //Getter del procesDesat
  getProcesDesat(){
    return this.procesDesat;
  }

}
