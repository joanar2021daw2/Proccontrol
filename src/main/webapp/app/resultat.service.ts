import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Resultat } from './resultat';

/**
 * Aquesta classe conté serveis del resultat
 */
@Injectable({
  providedIn: 'root'
})
export class ResultatService {

  baseURL = "http://localhost:8080/api/resultat/saveresultat"

  resultatDesat: Resultat = new Resultat();
  pasActual: number = 0;

  constructor(private httpClient: HttpClient) { }

  /**
   * Petició POST a Spring Boot (ResultatRestController) per desar el resultat
   * @param resultat un objecte JSON resultat
   * @returns post
   */
  crearResultat(resultat: Resultat): Observable<Object> {
    return this.httpClient.post(`${this.baseURL}`, resultat);
  }

  //Petició GET a Spring Boot (UsuariRestController) per obtenir el nom del usuari actual


  /**
   * Desar resultat a memòria
   * @param resultat un objecte JSON resultat
   */
  desarResultat(resultat: Resultat) {
    this.resultatDesat = resultat;
  }

  /**
   * Getter del resultat desar a memòria
   * @returns resultat desat
   */
  getResultatDesat() {
    return this.resultatDesat;
  }

  /**
   *  Getter del pas actual
   * @returns pas actual
   */
  getPasActual() {
    return this.pasActual;
  }

}
