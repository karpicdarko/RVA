import { Liga } from './../../Models/liga';
import { TimService } from './../../services/tim.service';
import { Tim } from './../../Models/tim';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatDialog } from '@angular/material/dialog';
import { TimDialogComponent } from '../dialogs/tim-dialog/tim-dialog.component';

@Component({
  selector: 'app-tim',
  templateUrl: './tim.component.html',
  styleUrls: ['./tim.component.css']
})
export class TimComponent implements OnInit {

  displayedColumns = ['id', 'naziv', 'osnovan', 'sediste', 'liga', 'actions'];
  dataSource: MatTableDataSource<Tim>;
  selektovaniTim: Tim;


  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(public timService: TimService,
              private dialog: MatDialog) { }

  ngOnInit() {
    this.loadData();
  }

  public loadData() {
   this.timService.getAllTim().subscribe(data => {
     this.dataSource = new MatTableDataSource(data);

     // pretraga po nazivu ugnježdenog objekta
     this.dataSource.filterPredicate = (data, filter: string) => {
       const accumulator = (currentTerm, key) => {
         return key === 'liga' ? currentTerm + data.liga.naziv : currentTerm + data[key];
       };
       const dataStr = Object.keys(data).reduce(accumulator, '').toLowerCase();
       const transformedFilter = filter.trim().toLowerCase();
       return dataStr.indexOf(transformedFilter) !== -1;
     };

      // sortiranje po nazivu ugnježdenog objekta
     this.dataSource.sortingDataAccessor = (data, property) => {
       switch (property) {
         case 'liga': return data.liga.naziv.toLocaleLowerCase();
         default: return data[property];
       }
     };

     this.dataSource.paginator = this.paginator;
     this.dataSource.sort = this.sort;
   });

 }

  selectRow(row: any){
   this.selektovaniTim = row;
  }

  public openDialog(flag: number, id?: number, naziv?: string, osnovan?: Date, sediste?: string, liga?: Liga ) {
    const dialogRef = this.dialog.open(TimDialogComponent,
       { data: { id, naziv, osnovan, sediste, liga  } });
    dialogRef.componentInstance.flag = flag;

    dialogRef.afterClosed().subscribe(result => {
      if (result === 1){
         this.loadData();
      }
    });
  }

  applyFilter(filterValue: string){
   filterValue = filterValue.trim();
   filterValue = filterValue.toLocaleLowerCase();
   this.dataSource.filter = filterValue;
 }

}
