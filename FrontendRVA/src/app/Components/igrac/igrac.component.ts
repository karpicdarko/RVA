import { IgracDialogComponent } from './../dialogs/igrac-dialog/igrac-dialog.component';
import { Nacionalnost } from './../../Models/nacionalnost';
import { IgracService } from './../../services/igrac.service';
import { Tim } from './../../Models/tim';
import { Igrac } from './../../Models/igrac';
import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-igrac',
  templateUrl: './igrac.component.html',
  styleUrls: ['./igrac.component.css'],
})
export class IgracComponent implements OnInit {
  displayedColumns = [
    'id',
    'ime',
    'prezime',
    'brojReg',
    'datumRodjenja',
    'nacionalnost',
    'tim',
    'actions',
  ];
  dataSource: MatTableDataSource<Igrac>;

  @Input() selektovaniTim: Tim;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(public igracService: IgracService, private dialog: MatDialog) {}

  ngOnInit(): void {}

  ngOnChanges() {
    if (this.selektovaniTim.id) {
      debugger;
      this.loadData();
    }
  }

  public loadData() {
    this.igracService
      .getIgraciZaTim(this.selektovaniTim.id)
      .subscribe((data) => {
        this.dataSource = new MatTableDataSource(data);
        //pretraga po nazivu ugnježdenog objekta
        this.dataSource.filterPredicate = (data, filter: string) => {
          const accumulator = (currentTerm, key) => {
            return key === 'nacionalnost'
              ? currentTerm + data.nacionalnost.naziv
              : currentTerm + data[key];
          };
          const dataStr = Object.keys(data)
            .reduce(accumulator, '')
            .toLowerCase();
          const transformedFilter = filter.trim().toLowerCase();
          return dataStr.indexOf(transformedFilter) !== -1;
        };

        //sortiranje po nazivu ugnježdenog objekta
        this.dataSource.sortingDataAccessor = (data, property) => {
          switch (property) {
            case 'nacionalnost':
              return data.nacionalnost.naziv.toLocaleLowerCase();
            default:
              return data[property];
          }
        };

        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      });
  }

  public openDialog(
    flag: number,
    id?: number,
    ime?: string,
    prezime?: string,
    brojReg?: string,
    datumRodjenja?: Date,
    nacionalnost?: Nacionalnost,
    tim?: Tim
  ) {
    const dialogRef = this.dialog.open(IgracDialogComponent, {
      data: {
        id,
        ime,
        prezime,
        brojReg,
        datumRodjenja,
        nacionalnost,
        tim,
      },
    });
    dialogRef.componentInstance.flag = flag;
    if(flag === 1) {
      dialogRef.componentInstance.data.tim = this.selektovaniTim;
    }

    dialogRef.afterClosed().subscribe((result) => {
      if(result === 1) {
        this.loadData();
      }

    });
  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim();
    filterValue = filterValue.toLocaleLowerCase();
    this.dataSource.filter = filterValue;
  }
}
