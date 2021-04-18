import { Component, OnInit } from '@angular/core';
import { passos } from '../passos';
import { Proces } from '../proces';
import { ProcesService } from '../proces.service';

@Component({
  selector: 'app-passos-list',
  templateUrl: './passos-list.component.html',
  styleUrls: ['./passos-list.component.css']
})
export class PassosListComponent implements OnInit {

  passos = passos;
  private proces: Proces | undefined;

  constructor(private procesService: ProcesService) { }

  ngOnInit(): void {
    this.proces = this.procesService.getProcesDesat();
    
  }

}
