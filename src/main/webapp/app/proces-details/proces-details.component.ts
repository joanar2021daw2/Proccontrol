import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proces } from '../proces';
import { ProcesService } from '../proces.service';

/**
 * Aquesta classe serveix per veure detalls d'un procés, com els passos que té i gestionar
 */
@Component({
  selector: 'app-proces-details',
  templateUrl: './proces-details.component.html',
  styleUrls: ['./proces-details.component.css']
})
export class ProcesDetailsComponent implements OnInit {

  idProces: any;
  proces = new Proces();

  constructor(private route: ActivatedRoute, private procesService: ProcesService,
    private router: Router) { }

  /**
   * Agafem id del procés de la ruta, cridem ProcesService i ordenem passos
   */
  ngOnInit(): void {
    this.idProces = this.route.snapshot.params['idProces'];

    this.proces = new Proces();
    this.procesService.getProcesbyId(this.idProces).subscribe(dades => {
      this.proces = dades;
      this.proces.passos.sort(function (a, b) {
        return a.numeroDePas - b.numeroDePas;
      })
    });

  }
  /**
   * Actualitzar procés d'un procés
   * @param idProces id d'un procés
   */
  updateProces(idProces: number) {
    this.router.navigate(['update-proces', idProces]);
  }

}
