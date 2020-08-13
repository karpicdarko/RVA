import { Liga } from './../../../Models/liga';
import { LigaService } from './../../../services/liga.service';
import { Component, OnInit, Inject } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-liga-dialog',
  templateUrl: './liga-dialog.component.html',
  styleUrls: ['./liga-dialog.component.css']
})
export class LigaDialogComponent implements OnInit {

  public flag: number;

  constructor(public ligaService: LigaService,
              public snackBar: MatSnackBar,
              public dialogRef: MatDialogRef<LigaDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: Liga) { }

  ngOnInit(): void {
  }

  public add(): void {
    this.ligaService.addLiga(this.data);
    this.snackBar.open('Uspesno dodata liga: ' + this.data.oznaka, 'U redu', {duration:2500});
  }

  public update(): void {
    this.ligaService.updateLiga(this.data);
    this.snackBar.open('Uspesno modifikovana liga: ' + this.data.oznaka, 'U redu', {duration:2500});
  }

  public delete(): void {
    this.ligaService.deleteLiga(this.data.id);
    this.snackBar.open('Uspesno obrisana liga: ' + this.data.oznaka, 'U redu', {duration:2500});
  }

  public cancel(): void {
    this.dialogRef.close();
    this.snackBar.open('Odustali ste', 'U redu', {duration:1000});
  }

}
