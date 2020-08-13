import { LigaService } from './../../../services/liga.service';
import { Liga } from './../../../Models/liga';
import { TimService } from './../../../services/tim.service';
import { Tim } from './../../../Models/tim';
import { Component, OnInit, Inject } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-tim-dialog',
  templateUrl: './tim-dialog.component.html',
  styleUrls: ['./tim-dialog.component.css'],
})
export class TimDialogComponent implements OnInit {
  lige: Liga[];
  public flag: number;

  constructor(
    public snackBar: MatSnackBar,
    public dialogRef: MatDialogRef<TimDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Tim,
    public timService: TimService,
    public ligaService: LigaService
  ) {}

  ngOnInit() {
    this.ligaService
      .getAllLiga()
      .subscribe((lige) => (this.lige = lige));
  }
  compareTo(a, b) {
    return a.id == b.id;
  }

  public add(): void {
    this.timService.addTim(this.data);
    this.snackBar.open('Uspešno dodat tim: ' + this.data.naziv, 'U redu', {
      duration: 2500,
    });
  }

  public update(): void {
    this.timService.updateTim(this.data);
    this.snackBar.open('Uspešno modifikovan tim: ' + this.data.id, 'U redu', {
      duration: 2500,
    });
  }

  public delete(): void {
    this.timService.deleteTim(this.data.id);
    this.snackBar.open('Uspešno obrisan tim: ' + this.data.id, 'U redu', {
      duration: 2500,
    });
  }

  public cancel(): void {
    this.dialogRef.close();
    this.snackBar.open('Odustali ste', 'U redu', { duration: 1000 });
  }
}
