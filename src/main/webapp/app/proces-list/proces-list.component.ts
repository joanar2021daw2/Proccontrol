import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Proces } from '../proces';
import { ProcesService } from '../proces.service';

@Component({
  selector: 'app-proces-list',
  templateUrl: './proces-list.component.html',
  styleUrls: ['./proces-list.component.css']
})
/**
 * Aquesta classe serveix per llistar tots els processos
 */
export class ProcesListComponent implements OnInit {

  /** 
   * Missatge de confirmació quan volem esborrar un procés
   * */
  popoverTitle = "Confirmació d'eliminació";
  
  /** 
   * Missatge de confirmació quan volem esborrar un procés
   * */
  popoverMessage = "Realment vol eliminar el procés?";

  /**
   * Llista procés
   */
  processos: Proces[] | undefined;

  constructor(private procesService: ProcesService,
    private router: Router) { }

  ngOnInit(): void {
    this.getAllProcessos();
  }

  /**
   * Subscriu les dades per mostrar-les a la template
  */
  private getAllProcessos() {
    this.procesService.getAllProcessos().subscribe(dades => {
      this.processos = dades;
    })
  }

  /**
   * Per anar i veure els detalls d'un prcoés
   * @param idProces id del procés
   */
  procesDetails(idProces: number) {
    this.router.navigate(['proces-details', idProces]);
  }

  /**
   * Per anar i editar el procés
   * @param idProces id del procés
   */
  updateProces(idProces: number) {
    this.router.navigate(['update-proces', idProces]);
  }

  /**
   * Per anar i esborrar el procés
   * @param idProces id del procés
   */
  deleteProces(idProces: number) {
    this.procesService.deleteProces(idProces).subscribe(dades => {
      console.log(dades);
      this.getAllProcessos();
    })
  }

  cancelClicked() { }

}