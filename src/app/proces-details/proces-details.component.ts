import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Proces } from '../proces';
import { ProcesService } from '../proces.service';

@Component({
  selector: 'app-proces-details',
  templateUrl: './proces-details.component.html',
  styleUrls: ['./proces-details.component.css']
})
export class ProcesDetailsComponent implements OnInit {

  idProces: any;
  proces = new Proces();

  constructor(private route: ActivatedRoute, private procesService: ProcesService) { }

  ngOnInit(): void {
    this.idProces = this.route.snapshot.params['idProces'];

    this.proces = new Proces();
    this.procesService.getProcesbyId(this.idProces).subscribe( dades => {
      this.proces = dades;
    });
  }

}
