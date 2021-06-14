// Format: 'DD. MMM yyyy hh:mm:ss A'
export function formatDateFromGrid(ts: any): string {
  const date = ts.value.toString().split(' ');
  return date[1] + '-' + date[2] + '-' + date[3] + ' ' + date[4];
}

export function formatDateFromDate(ts: Date): string {
  const date = ts.toString().split(' ');
  return date[1] + '-' + date[2] + '-' + date[3] + ' ' + date[4];
}
