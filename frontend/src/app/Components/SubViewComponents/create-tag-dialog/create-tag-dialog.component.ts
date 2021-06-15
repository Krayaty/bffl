import {Component, OnInit} from '@angular/core';
import {MatDialogRef} from '@angular/material/dialog';
import {DbConnectorService} from '../../../Services/DB-Connect-Services/db-connector.service';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-create-tag-dialog',
  templateUrl: './create-tag-dialog.component.html',
  styleUrls: ['./create-tag-dialog.component.css'],
})
export class CreateTagDialogComponent implements OnInit {

  createTagForm: FormGroup;

  constructor(public dbconnector: DbConnectorService,
              public dialog: MatDialogRef<CreateTagDialogComponent>) {

    this.createTagForm = new FormGroup({
      tagTitle: new FormControl('', {}),
      tagDescription: new FormControl('', {}),
      tagColor: new FormControl('#000000', {}),
    });
  }

  ngOnInit(): void {}

  closeDialog(): void {
    this.dialog.close();
  }

  public createTag(): void {
    this.dbconnector.createTagForGroup(
      this.createTagForm.get('tagTitle').value,
      this.createTagForm.get('tagDescription').value,
      this.createTagForm.get('tagColor').value);

    this.closeDialog();
  }

  public cannotCreateTag(): boolean {
    return (this.createTagForm.get('tagTitle').value === '' && this.createTagForm.get('tagColor').value === '');
  }
}
