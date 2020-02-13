import { Component, OnInit } from '@angular/core';
import { Conversion} from './conversion';
import {ConversionService} from './conversion.service';

@Component({
  selector: 'app-conversiones',
  templateUrl: './conversiones.component.html',
  styleUrls: ['./conversiones.component.css']
})
export class ConversionesComponent implements OnInit {

  conversiones: Conversion[] = [
    {id: 1, monto:'250', monedaOrigen:'', monedaDestino:''}
  ];

  constructor(private conversionService: ConversionService) { }

  ngOnInit() {
    //this.conversiones = this.conversionService
  }

}
