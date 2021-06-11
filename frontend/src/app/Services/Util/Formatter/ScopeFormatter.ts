export function scopeToString(scope: number): string {
  if (scope > 0){
    const years = (((scope / 60) / 60) / 24) / 365;
    let help: number = years - Math.floor(years);

    const days = help * 365;
    help = days - Math.floor(days);

    const hours = help * 24;
    help = hours - Math.floor(hours);

    const minutes = help * 60;
    help = minutes - Math.floor(minutes);

    const seconds = help * 60;

    return Math.floor(years) + 'y ' + Math.floor(days) + 'd ' + Math.floor(hours) + 'h '
      + Math.floor(minutes) + 'm ' + Math.floor(seconds) + 's';
  }

  return 'forever';
}
