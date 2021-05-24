import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proces } from '../proces';
import { ProcesService } from '../proces.service';
import { Resultat } from '../resultat';
import { ResultatService } from '../resultat.service';
import { Usuari } from '../usuari';

/*
 * Classe que controla el inici de la realització del procés guiat,
 * on l'usuari/treballador polsa el botó iniciar per començar-ho.
 */
@Component({
  selector: 'app-play-proces',
  templateUrl: './play-proces.component.html',
  styleUrls: ['./play-proces.component.css']
})


export class PlayProcesComponent implements OnInit {

  idProces: any;
  idUsuari: any;
  proces = new Proces();
  resultat = new Resultat();
  usuari = new Usuari();


  constructor(private route: ActivatedRoute, private procesService: ProcesService,
    private resultatService: ResultatService, private router: Router) { }


  /**
   * Al iniciar el component s'agafen els paràmetres per saber quin proces i
   * quin usuari venen de springboot, per tal de que el treballador segueixi
   * el proces i puguem generar un resultat amb proces i usuari.
   */
  ngOnInit(): void {
    this.idProces = this.route.snapshot.params['idProces'];
    this.idUsuari = this.route.snapshot.params['idUsuari'];

    this.proces = new Proces();
    this.resultat = new Resultat();
    this.usuari.userId = this.idUsuari;
    this.resultat.usuari = this.usuari;


    this.procesService.getProcesbyId(this.idProces).subscribe(dades => {
      this.proces = dades;
      this.proces.passos.sort(function (a, b) {
        return a.numeroDePas - b.numeroDePas;
      })
    });

  }

  /**
   * Al polsar START del procés guiat inicialitzem el resultat que desarem al
   * resultatService i redireccionem al component play-pas
   */
  iniciarProces() {
    this.resultatService.pasActual = 0;
    this.resultatService.resultatDesat.tempsPassos.length = this.proces.passos.length;

    this.resultatService.desarResultat(this.resultat);
    this.procesService.desarproces(this.proces);

    this.router.navigate(['play-pas']);
  }

}

