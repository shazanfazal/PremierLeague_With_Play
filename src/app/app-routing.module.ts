import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PremierLeagueTableComponent} from "./FootballComponent/premier-league-table/premier-league-table.component";
import {MatchPreviewTableComponent} from "./FootballComponent/match-preview-table/match-preview-table.component";
import {AddPlayMatchComponent} from "./FootballComponent/add-play-match/add-play-match.component";
import {PageNotFoundComponent} from "./PageNotFound/page-not-found/page-not-found.component";

const routes: Routes = [
  {path: '', component:PremierLeagueTableComponent, pathMatch: 'full'},
  {path: 'leagueTable', component:PremierLeagueTableComponent},
  {path: 'matchTable',component:MatchPreviewTableComponent},
  {path: 'addMatch',component:AddPlayMatchComponent},
  {path: '**', component:PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routersArray = [PremierLeagueTableComponent,MatchPreviewTableComponent,PageNotFoundComponent,AddPlayMatchComponent];
