import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule, routersArray } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './NavigationBar/nav-bar/nav-bar.component';
import {PremierLeagueService} from "./Services/premier-league.service";
import {SortingService} from "./Services/sorting.service";
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    routersArray,
    NavBarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [PremierLeagueService,SortingService],
  bootstrap: [AppComponent]
})
export class AppModule { }
