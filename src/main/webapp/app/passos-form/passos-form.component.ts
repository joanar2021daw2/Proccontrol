import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Pas } from '../pas';
import { ProcesService } from '../proces.service';

@Component({
  selector: 'app-passos-form',
  templateUrl: './passos-form.component.html',
  styleUrls: ['./passos-form.component.css']
})
/**
 * Aquesta classe serveix per crear un pas
 */
export class PassosFormComponent implements OnInit {

  proces: any;
  pas = new Pas();
  passos: Pas[] = [];
  length: number = 0;

  passosForm: FormGroup = new FormGroup({
    titol: new FormControl(null, Validators.required),
    descripcio: new FormControl(null, Validators.required)
  });

  constructor(private procesService: ProcesService, private router: Router) { }

  /**
   * Carreguem el procés desat pel component proces-form
     per afegir-li els passos
   */
  ngOnInit(): void {
    this.proces = this.procesService.getProcesDesat();
  }

  /**
   * Retornar titol a la pàgina HTML
   */
  get titol() { return this.passosForm.get('titol'); }

  /**
   * Retornar descripció a la pàgina HTML
   */
  get descripcio() { return this.passosForm.get('descripcio'); }

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
   * Afegim pas al procés i ho desem a memòria, quan cliquem el botó SUBMIT
   */
  onSubmit() {
    this.length = this.proces.passos.push(this.pas);
    this.pas.numeroDePas = (this.length);
    this.proces.numPassos++;
    this.procesService.desarproces(this.proces);

    this.goToPassosList();
  }

  /**
   * Redirecciona a la pàgina llista de passos
   */
  goToPassosList() {
    this.router.navigate(['/passos']);
  }

}
