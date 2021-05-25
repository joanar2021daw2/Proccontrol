import { Component, OnInit } from '@angular/core';
import { Proces } from '../proces';
import { Referencia } from '../referencia';
import { ReferenciaService } from '../referencia.service';
import { ProcesService } from '../proces.service';
import { Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';

/**
 * Aquesta classe serveix per crear procés
 */
@Component({
  selector: 'app-proces-form',
  templateUrl: './proces-form.component.html',
  styleUrls: ['./proces-form.component.css']
})
export class ProcesFormComponent implements OnInit {

  proces: Proces = new Proces();
  referencies: Referencia[] | undefined;
  procesForm: FormGroup = new FormGroup({
    nom: new FormControl(null, Validators.required),
    referencia: new FormControl(null, Validators.required),
  });

  constructor(private referenciaService: ReferenciaService, private procesService: ProcesService,
    private router: Router) { }

  /**
   * Obtenir totes les referencies
   */
  ngOnInit(): void {
    this.getAllReferencies();
  }

  /**Enllaçar amb html */
  get nom() { return this.procesForm.get('nom'); }
  get referencia() { return this.procesForm.get('referencia'); }

  /**
   * Quan es clica, es guarda el procés i redirecciona a formulari de crear passos
   */
  onSubmit() {
    //console.log(this.proces);
    this.procesService.desarproces(this.proces);
    this.router.navigate(['passos-form']);
    //this.saveProces();
  }

  /**
   * Crida llistat referencies per sel·leccionar al formulari
   */
  private getAllReferencies() {
    this.referenciaService.getAllReferencies().subscribe(dades => {
      this.referencies = dades;
    });
  }

  /**
   * Desar proces completat a SpringBoot
   */
  private saveProces() {
    this.procesService.crearProces(this.proces).subscribe(dades => {
      console.log(dades);
      this.goToProcesList();
    },
      error => console.log(error));
  }

  /**
   * Redirecciona a altre pàgina
   */
  goToProcesList() {
    this.router.navigate(['/proces']);
  }

}
