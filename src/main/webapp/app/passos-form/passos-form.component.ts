import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Pas } from '../pas';
import { ProcesService } from '../proces.service';

/**
 * Aquesta classe serveix per crear passos quan creem un procés
 */
@Component({
  selector: 'app-passos-form',
  templateUrl: './passos-form.component.html',
  styleUrls: ['./passos-form.component.css']
})
export class PassosFormComponent implements OnInit {

  proces: any;
  pas = new Pas();
  passos: Pas[] = [];
  length: number = 0;

  /**Enllaçar amb html */
  passosForm: FormGroup = new FormGroup({
    titol: new FormControl(null, Validators.required),
    descripcio: new FormControl(null, Validators.required)
  });


  constructor(private procesService: ProcesService, private router: Router) { }
  /**
   * Carreguem el procés desat pel component proces-form
   * per afegir-li els passos 
   */
  ngOnInit(): void {
    this.proces = this.procesService.getProcesDesat();
  }

  /** Per retornar dades titol a html*/
  get titol() { return this.passosForm.get('titol'); }
  /** Per retornar dades descripcio a html*/
  get descripcio() { return this.passosForm.get('descripcio'); }

  /**
   * Seleccionar imatge per pujar
   * @param e qualsevol fitxer
   */
  onSelectFile(e: any) {
    if (e.target.files) {
      var reader = new FileReader();
      reader.readAsDataURL(e.target.files[0]);
      reader.onload = (event: any) => {
        this.pas.imatge = event.target.result;
        console.log(this.pas.imatge);
      }
    }
  }

  /**
   * Afegim pas al procés i ho desem a memòria
   */
  onSubmit() {
    this.length = this.proces.passos.push(this.pas);
    this.pas.numeroDePas = (this.length);
    this.proces.numPassos++;
    this.procesService.desarproces(this.proces);

    this.goToPassosList();
  }

  /**
   * Redirecciona a altre pàgina
   */
  goToPassosList() {
    this.router.navigate(['/passos']);
  }

}
