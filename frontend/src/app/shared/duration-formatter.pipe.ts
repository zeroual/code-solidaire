import { Pipe, PipeTransform } from '@angular/core';

@Pipe({name: 'durationFormatter'})
export class DurationFormatter implements PipeTransform {
  transform(value: number): string {
    return Math.round(value / 60) + " min";
  }
} 