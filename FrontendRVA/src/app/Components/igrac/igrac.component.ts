import { IgracService } from './../../services/igrac.service';
import { Tim } from './../../Models/tim';
import { Igrac } from './../../Models/igrac';
import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';

@Component({
  selector: 'app-igrac',
  templateUrl: './igrac.component.html',
  styleUrls: ['./igrac.component.css']
})
export class IgracComponent implements OnInit {

  displayedColumns = ['id', 'ime', 'prezime', 'brojReg', 'datumRodjenja', 'nacionalnost', 'tim', 'actions'];
  dataSource: MatTableDataSource<Igrac>;

  @Input() selektovaniTim: Tim;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(public igracService: IgracService) { }

  ngOnInit(): void{
  }

  ngOnChanges() {
    if (this.selektovaniTim.id) {
      debugger;
      this.loadData();
    }
  }

  public loadData() {
    this.igracService.getIgraciZaTim(this.selektovaniTim.id)
      .subscribe(data => {
        this.dataSource = new MatTableDataSource(data);
        //pretraga po nazivu ugnježdenog objekta
        this.dataSource.filterPredicate = (data, filter: string) => {
          const accumulator = (currentTerm, key) => {
            return key === 'nacionalnost' ? currentTerm + data.nacionalnost.naziv : currentTerm + data[key];
          };
          const dataStr = Object.keys(data).reduce(accumulator, '').toLowerCase();
          const transformedFilter = filter.trim().toLowerCase();
          return dataStr.indexOf(transformedFilter) !== -1;
        };

        //sortiranje po nazivu ugnježdenog objekta
        this.dataSource.sortingDataAccessor = (data, property) => {
          switch (property) {
            case 'nacionalnost': return data.nacionalnost.naziv.toLocaleLowerCase();
            default: return data[property];
          }
        };

        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      });

  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim();
    filterValue = filterValue.toLocaleLowerCase();
    this.dataSource.filter = filterValue;
  }

}
