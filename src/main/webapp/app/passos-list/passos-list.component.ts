import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pas } from '../pas';
import { Proces } from '../proces';
import { ProcesService } from '../proces.service';

/**
 * Aquesta classe serveix per llistar i gestionar tots els processos
 */
@Component({
  selector: 'app-passos-list',
  templateUrl: './passos-list.component.html',
  styleUrls: ['./passos-list.component.css']
})
export class PassosListComponent implements OnInit {

  passos: Pas[] = [];
  proces: Proces = new Proces();

  constructor(private procesService: ProcesService, private route: Router) { }
  /**
   * Al iniciar passos list recuperem procés desat i per mostrar passos a la plantilla
   */
  ngOnInit(): void {
    this.proces = this.procesService.getProcesDesat();
    this.passos = this.proces.passos;
  }

  /**
   * Desem pas i tornem al formulari dels passos
   */
  afegirPas() {
    this.procesService.desarproces(this.proces);
    this.route.navigate(['passos-form']);
  }

  /**
   * Desar proces completat a SpringBoot
   */
  saveProces() {
    this.proces.numPassos = this.proces.passos.length;
    this.procesService.crearProces(this.proces).subscribe(dades => {
      console.log(dades);
      this.route.navigate(['proces']);
    },
      error => console.log(error));
  }

}
