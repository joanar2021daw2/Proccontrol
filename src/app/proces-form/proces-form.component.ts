import { Component, OnInit } from '@angular/core';
import { Proces } from '../proces';
import { Referencia } from '../referencia';
import { ReferenciaService } from '../referencia.service';
import { ProcesService } from '../proces.service';



@Component({
  selector: 'app-proces-form',
  templateUrl: './proces-form.component.html',
  styleUrls: ['./proces-form.component.css']
})
export class ProcesFormComponent implements OnInit {

  proces: Proces = new Proces();
  referencies: Referencia[] | undefined;

  constructor(private referenciaService: ReferenciaService, private procesService: ProcesService) { }

  ngOnInit(): void {
    this.getAllReferencies();
  }

  onSubmit() {
    console.log(this.proces);
    this.saveProces();
  }

  //Petició GET a SpringBoot pel select de referencies
  private getAllReferencies() {
    this.referenciaService.getAllReferencies().subscribe(dades => {
      this.referencies = dades;
    });
  }

  //Petició POST a SpringBoot per crear el procés
  private saveProces(){
    this.procesService.crearProces(this.proces).subscribe( dades => {
      console.log(dades);
    },
    error => console.log(error));
  }

}
