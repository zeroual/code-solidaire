import { Pipe, PipeTransform } from '@angular/core';

@Pipe({name: 'distanceFormatter'})
export class DistanceFormatter implements PipeTransform {
  transform(value: number): string {
    return value + " m";
  }
} 