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

  ngOnInit(): void {
    /*Carreguem el procés desat pel component proces-form
     per afegir-li els passos*/
    this.proces = this.procesService.getProcesDesat();
  }

  get titol() { return this.passosForm.get('titol'); }
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

  onSubmit() {
    //Afegim pas al procés i ho desem a memòria
    this.length = this.proces.passos.push(this.pas);
    this.pas.numeroDePas = (this.length);
    this.proces.numPassos++;
    this.procesService.desarproces(this.proces);

    this.goToPassosList();
  }

  //Redirecciona a altre pàgina
  goToPassosList() {
    this.router.navigate(['/passos']);
  }

}
