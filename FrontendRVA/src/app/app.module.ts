import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatExpansionModule } from '@angular/material/expansion';

import { AppComponent } from './app.component';
import { LigaComponent } from './components/liga/liga.component';
import { IgracComponent } from './components/igrac/igrac.component';
import { TimComponent } from './components/tim/tim.component';
import { NacionalnostComponent } from './components/nacionalnost/nacionalnost.component';
import { HomeComponent } from './components/core/home/home.component';
import { AutorComponent } from './components/core/autor/autor.component';
import { AboutComponent } from './components/core/about/about.component';

@NgModule({
  declarations: [
    AppComponent,
    LigaComponent,
    IgracComponent,
    TimComponent,
    NacionalnostComponent,
    HomeComponent,
    AutorComponent,
    AboutComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatIconModule,
    MatSidenavModule,
    MatListModule,
    MatGridListModule,
    MatExpansionModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
