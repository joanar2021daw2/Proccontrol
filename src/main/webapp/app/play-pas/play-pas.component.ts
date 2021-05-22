import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Pas } from '../pas';
import { Proces } from '../proces';
import { ProcesService } from '../proces.service';
import { Resultat } from '../resultat';
import { ResultatService } from '../resultat.service';

@Component({
  selector: 'app-play-pas',
  templateUrl: './play-pas.component.html',
  styleUrls: ['./play-pas.component.css']
})
export class PlayPasComponent implements OnInit {

  idProces: any;
  proces = new Proces();
  pas = new Pas();
  resultat = new Resultat();
  pasActual: number = 0;
  comentari: string = "";
  temps: number = 0;
  interval: any;
  play: any;

  constructor(private route: ActivatedRoute, private procesService: ProcesService,
    private resultatService: ResultatService, private router: Router) { }


  //Al iniciar carreguem el proces i el resultat desat a memòria per completar-ho
  ngOnInit(): void {
    this.resultat = this.resultatService.getResultatDesat();
    this.pasActual = this.resultatService.getPasActual();
    this.proces = this.procesService.getProcesDesat();

    this.iniciarTemportitzador();

    this.pas = this.proces.passos[this.pasActual];
  }

  /**
    * pasSeguent
    * Mètode que gestiona quan el treballador polsa pas següent
    * 
    */
  pasSeguent() {

    //Parem temporitzador i desem el temps a l'array del resultat
    this.pararTemporitzador();
    this.resultat.tempsPassos[this.pasActual] = this.temps;
    this.resultat.tempsTotal += this.temps;
    this.resultat.comentariPassos[this.pasActual] = this.comentari;

    this.comentari = "";
    this.temps = 0;

    //Si arribem al pas final desem el reultat a la BD i retornem a inici app    
    if (this.pasActual >= (this.proces.numPassos - 1)) {
      this.resultat.proces.idProces = this.proces.idProces;
      console.log(this.resultat.proces);
      this.resultatService.crearResultat(this.resultat).subscribe(dades => {
        console.log(dades);
      },
        error => console.log(error));
      console.log("proces finalitzat, gràcies!");
      this.router.navigate(['proces-completat']);
      
    } else {
      this.resultatService.pasActual++;
      this.pasActual = this.resultatService.pasActual;
      this.pas = this.proces.passos[this.pasActual];
      this.iniciarTemportitzador();
    }

  }

  iniciarTemportitzador() {
    this.play = false;
    this.interval = setInterval(() => {
      this.temps++;
    }, 1000)
  }

  pararTemporitzador() {
    this.play = false;
    clearInterval(this.interval);
  }

}
