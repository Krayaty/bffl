import {Color} from 'ag-grid-community';

export function isTagColorLight(c: Color): boolean {
  const hsb = c.toHSB();

  if (hsb[0] > 30 && hsb[0] < 180 && hsb[2] > .6) {
    return true;
  }

  if (hsb[2] > .6 && hsb[1] < .8) {
    return true;
  }

  return false;
}
