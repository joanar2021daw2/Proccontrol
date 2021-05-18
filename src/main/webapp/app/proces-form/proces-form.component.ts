import { Component, OnInit } from '@angular/core';
import { Proces } from '../proces';
import { Referencia } from '../referencia';
import { ReferenciaService } from '../referencia.service';
import { ProcesService } from '../proces.service';
import { Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-proces-form',
  templateUrl: './proces-form.component.html',
  styleUrls: ['./proces-form.component.css']
})
/**
 * Aquesta classe serveix per crear un procés
 */
export class ProcesFormComponent implements OnInit {

  proces: Proces = new Proces();
  referencies: Referencia[] | undefined;
  procesForm: FormGroup = new FormGroup({
    nom: new FormControl(null, Validators.required),
    referencia: new FormControl(null, Validators.required),
  });

  constructor(private referenciaService: ReferenciaService, private procesService: ProcesService,
    private router: Router) { }

  ngOnInit(): void {
    this.getAllReferencies();
  }

  get nom() { return this.procesForm.get('nom'); }
  get referencia() { return this.procesForm.get('referencia'); }

  /**
   * Una vegada clicat el botó SUBMIT, va crear el procés i canvi ruta
   */
  onSubmit() {
    this.procesService.desarproces(this.proces);
    this.router.navigate(['passos-form']);
    //this.saveProces();
  }

  /**
   * Obtenir totes les referències i subscriure-les
  */
  private getAllReferencies() {
    this.referenciaService.getAllReferencies().subscribe(dades => {
      this.referencies = dades;
    });
  }

  private saveProces(){
    this.procesService.crearProces(this.proces).subscribe( dades => {
      console.log(dades);
      this.goToProcesList();
    },
    error => console.log(error));
  }

  /**
   * Redirecciona a altre pàgina
   */
  goToProcesList(){
    this.router.navigate(['/proces']);
  }

}