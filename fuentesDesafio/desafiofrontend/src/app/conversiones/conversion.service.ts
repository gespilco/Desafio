import { Injectable } from '@angular/core';
import { Conversion } from './conversion';

@Injectable()
export class ConversionService {

  constructor() { }

  getConversiones(): Conversion[]{
    return null;
  }
}
