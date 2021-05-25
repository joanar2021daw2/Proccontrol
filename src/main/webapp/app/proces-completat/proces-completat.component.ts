import { Component, OnInit } from '@angular/core';

/**
 * Aquesta classe servei per quan un procés s'ha 
 */
@Component({
  selector: 'app-proces-completat',
  templateUrl: './proces-completat.component.html',
  styleUrls: ['./proces-completat.component.css']
})
export class ProcesCompletatComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  /**
   * Una vegada completada, tornar a index
   */
  tornar() {
    window.location.href = 'http://localhost:8080/';
  }


}
