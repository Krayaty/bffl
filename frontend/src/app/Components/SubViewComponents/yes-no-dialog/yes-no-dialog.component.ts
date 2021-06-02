import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-yes-no-dialog',
  templateUrl: './yes-no-dialog.component.html',
  styleUrls: ['./yes-no-dialog.component.css']
})
export class YesNoDialogComponent implements OnInit {

  constructor(public dialog: MatDialogRef<YesNoDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public msg: string) {}

  ngOnInit(): void {}

  close(successfull: boolean): void {
    this.dialog.close(successfull);
  }

}
