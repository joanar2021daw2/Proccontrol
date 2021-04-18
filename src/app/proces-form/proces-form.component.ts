import { Component, OnInit } from '@angular/core';
import { Proces } from '../proces';
import { Referencia } from '../referencia';
import { ReferenciaService } from '../referencia.service';
import { ProcesService } from '../proces.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-proces-form',
  templateUrl: './proces-form.component.html',
  styleUrls: ['./proces-form.component.css']
})
export class ProcesFormComponent implements OnInit {

  proces: Proces = new Proces();
  referencies: Referencia[] | undefined;

  constructor(private referenciaService: ReferenciaService, private procesService: ProcesService,
    private router: Router) { }

  ngOnInit(): void {
    this.getAllReferencies();
  }

  onSubmit() {
    console.log(this.proces);
    this.procesService.desarproces(this.proces);
    
    //this.saveProces();
  }

  //Crida llistat referencies per sel·leccionar al formulari
  private getAllReferencies() {
    this.referenciaService.getAllReferencies().subscribe(dades => {
      this.referencies = dades;
    });
  }

  //Desar proces completat a PringBoot
  private saveProces(){
    this.procesService.crearProces(this.proces).subscribe( dades => {
      console.log(dades);
      this.goToProcesList();
    },
    error => console.log(error));
  }

  goToProcesList(){
    this.router.navigate(['/proces']);
  }



}
