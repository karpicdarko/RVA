import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Nacionalnost } from './../Models/nacionalnost';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NacionalnostService {

  private readonly API_URL = 'http://localhost:8083/nacionalnost/';

  dataChange: BehaviorSubject<Nacionalnost[]> = new BehaviorSubject<Nacionalnost[]>([]);


  constructor(private httpClient: HttpClient) { }

  public getAllNacionalnost(): Observable<Nacionalnost[]> {
    this.httpClient.get<Nacionalnost[]>(this.API_URL).subscribe(data =>{
      this.dataChange.next(data);
    },
    (error: HttpErrorResponse) => {
      console.log(error.name + ' ' + error.message);
    });

    return this.dataChange.asObservable();
  }

  public addNacionalnost(nacionalnost: Nacionalnost): void {
    nacionalnost.id = 0;
    this.httpClient.post(this.API_URL, nacionalnost).subscribe();
  }

  public updateNacionalnost(nacionalnost: Nacionalnost): void {
    this.httpClient.put(this.API_URL, nacionalnost).subscribe();
  }

  public deleteNacionalnost(id: number): void {
    console.log(this.API_URL + id );
    this.httpClient.delete(this.API_URL + id).subscribe();
  }
}
