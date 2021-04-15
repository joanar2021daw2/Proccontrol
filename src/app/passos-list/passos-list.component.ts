import { Component, OnInit } from '@angular/core';
import { passos } from '../passos';

@Component({
  selector: 'app-passos-list',
  templateUrl: './passos-list.component.html',
  styleUrls: ['./passos-list.component.css']
})
export class PassosListComponent implements OnInit {

  passos = passos;

  constructor() { }

  ngOnInit(): void {
  }

}
