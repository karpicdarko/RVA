import { AppRoutingModule } from './app-routing.module';
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
import { HomeComponent } from './Components/core/home/home.component';
import { AboutComponent } from './Components/core/about/about.component';
import { AuthorComponent } from './Components/core/author/author.component';
import { TimComponent } from './Components/tim/tim.component';
import { LigaComponent } from './Components/liga/liga.component';
import { NacionalnostComponent } from './Components/nacionalnost/nacionalnost.component';
import { IgracComponent } from './Components/igrac/igrac.component';
import { from } from 'rxjs';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    AuthorComponent,
    TimComponent,
    LigaComponent,
    NacionalnostComponent,
    IgracComponent,

  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
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
