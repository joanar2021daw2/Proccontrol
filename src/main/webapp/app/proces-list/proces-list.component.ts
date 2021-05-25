import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Proces } from '../proces';
import { ProcesService } from '../proces.service';

/**
 * Aquesta classe serveix per llistar i gestionar els processos
 */
@Component({
  selector: 'app-proces-list',
  templateUrl: './proces-list.component.html',
  styleUrls: ['./proces-list.component.css']
})

export class ProcesListComponent implements OnInit {

  popoverTitle = "Confirmació d'eliminació";
  popoverMessage = "Realment vol eliminar el procés?";

  processos: Proces[] | undefined;

  constructor(private procesService: ProcesService,
    private router: Router) { }

  /**
   * Obtenir tots els processos
   */
  ngOnInit(): void {
    this.getAllProcessos();
    //console.log(this.processos);
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
   * Anar a veure els detalls d'un procés
   * @param idProces id del procés
   */
  procesDetails(idProces: number) {
    this.router.navigate(['proces-details', idProces]);
  }

  /**
   * Anar a actualitzar un procés
   * @param idProces id del procés
   */
  updateProces(idProces: number) {
    this.router.navigate(['update-proces', idProces]);
  }

  /**
   * Esborrar un procés
   * @param idProces id del procés
   */
  deleteProces(idProces: number) {
    this.procesService.deleteProces(idProces).subscribe(dades => {
      console.log(dades);
      this.getAllProcessos();
    })
  }

  /**
   * Cancelar
   */
  cancelClicked() { }

}
