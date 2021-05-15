import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Resultat } from './resultat';

@Injectable({
  providedIn: 'root'
})
export class ResultatService {

  baseURL = "http://localhost:8080/api/resultat/saveresultat"

  resultatDesat : Resultat = new Resultat();
  pasActual: number = 0;

  constructor(private httpClient: HttpClient) { }

  //Petició POST a Spring Boot (ResultatRestController) per desar el resultat
  crearResultat(resultat: Resultat): Observable<Object> {
    return this.httpClient.post(`${this.baseURL}`, resultat);
  }

  //Petició GET a Spring Boot (UsuariRestController) per obtenir el nom del usuari actual
  

  //Desar resultat a memòria
  desarResultat(resultat: Resultat){
    this.resultatDesat = resultat;
  }

  //Getter del resultat desar a memòria
  getResultatDesat(){
    return this.resultatDesat;
  }

  getPasActual(){
    return this.pasActual;
  }

}
