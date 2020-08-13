import { NacionalnostService } from './../../../services/nacionalnost.service';
import { IgracService } from './../../../services/igrac.service';
import { Igrac } from './../../../Models/igrac';
import { Nacionalnost } from './../../../Models/nacionalnost';
import { Component, OnInit, Inject } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-igrac-dialog',
  templateUrl: './igrac-dialog.component.html',
  styleUrls: ['./igrac-dialog.component.css']
})
export class IgracDialogComponent implements OnInit {
  nacionalnosti: Nacionalnost[];
  public flag: number;

  constructor(public snackBar: MatSnackBar,
              public dialogRef: MatDialogRef<IgracDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: Igrac,
              public igracService: IgracService,
              public nacionalnostService: NacionalnostService
  ) { }


  ngOnInit() {
    this.nacionalnostService.getAllNacionalnost().subscribe(nacionalnosti =>
      this.nacionalnosti = nacionalnosti
    );
  }

  compareTo(a, b) {
    return a.id === b.id;
  }

  public add(): void {
    this.igracService.addIgrac(this.data);
    this.snackBar.open('Uspešno dodat igrac ' + this.data.brojReg, 'U redu', { duration: 2500 });
  }

  public update(): void {
    this.igracService.updateIgrac(this.data);
    this.snackBar.open('Uspešno modifikovan igrac', 'U redu', { duration: 2500 });
  }

  public delete(): void {
    this.igracService.deleteIgrac(this.data.id);
    this.snackBar.open('Uspešno obrisan igrac', 'U redu', { duration: 2000 });
  }

  public cancel(): void {
    this.dialogRef.close();
    this.snackBar.open('Odustali ste', 'U redu', { duration: 1000 });
  }



}
