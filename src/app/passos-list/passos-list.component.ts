import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pas } from '../pas';
import { Proces } from '../proces';
import { ProcesService } from '../proces.service';

@Component({
  selector: 'app-passos-list',
  templateUrl: './passos-list.component.html',
  styleUrls: ['./passos-list.component.css']
})
export class PassosListComponent implements OnInit {

  passos: Pas[] = [];
  proces: Proces = new Proces();

  constructor(private procesService: ProcesService, private route: Router) { }

  ngOnInit(): void {
    //Al iniciar passos list recuperem procés desat
    this.proces = this.procesService.getProcesDesat();
    //Per mostrar passos a la plantilla
    this.passos = this.proces.passos;
    
    console.log("ListOnInit: Proces amb pas");
    console.log(this.proces);
  }

  afegirPas(){
    //Desem pas i tornem al formulari dels passos
    this.procesService.desarproces(this.proces);
    this.route.navigate(['passos-form']);
  }

}
