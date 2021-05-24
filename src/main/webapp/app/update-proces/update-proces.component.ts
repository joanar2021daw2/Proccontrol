import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Proces } from '../proces';
import { ProcesService } from '../proces.service';
import { Referencia } from '../referencia';
import { ReferenciaService } from '../referencia.service';

/**
 * Aquesta classe serveix per actualitzar procés
 */
@Component({
  selector: 'app-update-proces',
  templateUrl: './update-proces.component.html',
  styleUrls: ['./update-proces.component.css']
})
export class UpdateProcesComponent implements OnInit {

  idProces: number = 0;
  proces: Proces = new Proces();
  referencies: Referencia[] | undefined;

  /**Enllaçar amb html */
  updateForm: FormGroup = new FormGroup({
    nomProces: new FormControl(null, Validators.required),
    referencia: new FormControl(null, Validators.required)
  });

  constructor(private procesService: ProcesService,
    private route: ActivatedRoute, private referenciaService: ReferenciaService,
    private router: Router) { }

  ngOnInit(): void {
    //Agafem l'id de l'url amb ActivatedRoute per carregar-lo al formulari
    this.idProces = this.route.snapshot.params['idProces'];

    this.getProcesById(this.idProces);
    this.getAllReferencies();
  }

  /** Per retornar dades nom procés a html*/
  get nomProces() { return this.updateForm.get('nomProces'); }
  /** Per retornar dades referència a html*/
  get referencia() { return this.updateForm.get('referencia'); }

  /**
   * Mètode per modificar la imatge del pas corresponent
   * @param e qualsevol fitxer
   * @param pas un pas concret
   */
  onSelectFile(e: any, pas: any) {
    if (e.target.files) {
      var reader = new FileReader();
      reader.readAsDataURL(e.target.files[0]);
      reader.onload = (event: any) => {
        pas.imatge = event.target.result;
        console.log(pas.imatge);
      }
    }
  }

  /**
   * Quan es clica a, actualitza el procés
   */
  onSubmit() {
    console.log(this.proces);
    this.procesService.updateProces(this.idProces, this.proces).subscribe(dadaes => {
      this.procesDetails(this.idProces);
    }, error => console.log(error));
  }

  /**
   * Crida un procès per la id
   * @param idProces id d'un procés
   */
  private getProcesById(idProces: number) {
    this.procesService.getProcesbyId(idProces).subscribe(dades => {
      this.proces = dades;
      this.proces.passos.sort(function (a, b) {
        return a.numeroDePas - b.numeroDePas;
      })
    }, error => console.log(error));
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
   * Anar a veure detalls d'un procés
   * @param idProces id d'un procés
   */
  procesDetails(idProces: number) {
    this.router.navigate(['proces-details', idProces]);
  }

}
