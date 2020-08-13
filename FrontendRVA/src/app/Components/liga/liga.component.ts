import { LigaService } from './../../services/liga.service';
import { Liga } from './../../Models/liga';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatDialog } from '@angular/material/dialog';
import { LigaDialogComponent } from '../dialogs/liga-dialog/liga-dialog.component';

@Component({
  selector: 'app-liga',
  templateUrl: './liga.component.html',
  styleUrls: ['./liga.component.css'],
})
export class LigaComponent implements OnInit {
  displayedColumns = ['id', 'naziv', 'oznaka', 'actions'];
  dataSource: MatTableDataSource<Liga>;

  @ViewChild(MatPaginator, { static: false }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: false }) sort: MatSort;

  constructor(private ligaService: LigaService, private dialog: MatDialog) {}

  ngOnInit(): void {
    this.loadData();
  }

  public loadData() {
    this.ligaService.getAllLiga().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);

      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }

  public openDialog(
    flag: number,
    id?: number,
    naziv?: string,
    oznaka?: string
  ) {
    const dialogRef = this.dialog.open(LigaDialogComponent, {
      data: { id, naziv, oznaka },
    });

    dialogRef.componentInstance.flag = flag;

    dialogRef.afterClosed().subscribe((result) => {
      if (result === 1) {
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
