import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Proces } from '../proces';
import { ProcesService } from '../proces.service';

@Component({
  selector: 'app-proces-list',
  templateUrl: './proces-list.component.html',
  styleUrls: ['./proces-list.component.css']
})

export class ProcesListComponent implements OnInit {

  popoverTitle="Confirmació d'eliminació";
  popoverMessage="Realment vol eliminar el procés?";

  processos: Proces[] | undefined;

  constructor(private procesService: ProcesService,
    private router: Router) { }

  ngOnInit(): void {
    this.getAllProcessos();
    //console.log(this.processos);
  }

  //Subscriu les dades per mostrar-les a la template
  private getAllProcessos() {
    this.procesService.getAllProcessos().subscribe(dades => {
      this.processos = dades;
    })
  }

  procesDetails(idProces: number){
    this.router.navigate(['proces-details', idProces]);
  }

  updateProces(idProces : number){
    this.router.navigate(['update-proces', idProces]);
  }

  deleteProces(idProces: number){
    this.procesService.deleteProces(idProces).subscribe( dades => {
      console.log(dades);
      this.getAllProcessos();
    })
  }

  cancelClicked(){}

}
