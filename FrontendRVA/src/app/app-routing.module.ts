import { RouterModule } from '@angular/router';
import { AuthorComponent } from './Components/core/author/author.component';
import { AboutComponent } from './Components/core/about/about.component';
import { HomeComponent } from './Components/core/home/home.component';
import { NacionalnostComponent } from './Components/nacionalnost/nacionalnost.component';
import { TimComponent } from './Components/tim/tim.component';
import { LigaComponent } from './Components/liga/liga.component';
import { NgModule, Component } from '@angular/core';



const Routes = [
  {path: 'liga', component: LigaComponent},
  {path: 'tim', component: TimComponent},
  {path: 'nacionalnost', component: NacionalnostComponent},
  {path: 'home', component: HomeComponent},
  {path: 'about', component: AboutComponent},
  {path: 'author', component: AuthorComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'}
];


@NgModule({
  imports: [RouterModule.forRoot(Routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
