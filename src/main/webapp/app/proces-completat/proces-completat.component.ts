import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-proces-completat',
  templateUrl: './proces-completat.component.html',
  styleUrls: ['./proces-completat.component.css']
})
export class ProcesCompletatComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  tornar() {
    window.location.href = 'http://localhost:8080/';
  }


}
