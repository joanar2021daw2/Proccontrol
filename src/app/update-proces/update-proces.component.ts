import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proces } from '../proces';
import { ProcesService } from '../proces.service';
import { Referencia } from '../referencia';
import { ReferenciaService } from '../referencia.service';

@Component({
  selector: 'app-update-proces',
  templateUrl: './update-proces.component.html',
  styleUrls: ['./update-proces.component.css']
})
export class UpdateProcesComponent implements OnInit {

  idProces: number = 0;
  proces: Proces = new Proces();
  referencies: Referencia[] | undefined;

  constructor(private procesService: ProcesService,
    private route: ActivatedRoute, private referenciaService: ReferenciaService,
    private router: Router) { }

  ngOnInit(): void {
    //Agafem l'id de l'url amb ActivatedRoute
    this.idProces = this.route.snapshot.params['idProces'];

    this.getProcesById(this.idProces);
    this.getAllReferencies();
  }

  onSubmit() {
    console.log(this.proces);
    this.procesService.updateProces(this.idProces, this.proces).subscribe( dadaes => {
      this.goToProcesList();
    }, error => console.log(error));
  }

  //Crida un procès per la id 
  private getProcesById(idProces: number) {
    this.procesService.getProcesbyId(idProces).subscribe(dades => {
      this.proces = dades;
    }, error => console.log(error));
  }

  //Crida llistat referencies per sel·leccionar al formulari
  private getAllReferencies() {
    this.referenciaService.getAllReferencies().subscribe(dades => {
      this.referencies = dades;
    });
  }

  goToProcesList(){
    this.router.navigate(['/proces']);
  }

}
