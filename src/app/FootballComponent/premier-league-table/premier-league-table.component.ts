import {Component, OnInit} from '@angular/core';
import {IFootballClub} from "../../Models/FootballClub";
import {PremierLeagueService} from "../../Services/premier-league.service";
import {SortingService} from "../../Services/sorting.service";

@Component({
  selector: 'app-premier-league-table',
  templateUrl: './premier-league-table.component.html',
  styleUrls: ['./premier-league-table.component.css']
})
export class PremierLeagueTableComponent implements OnInit {

  addAllTeamsToView: IFootballClub[] = [];  //to save all the matches Played

  constructor(private _serviceOfPL: PremierLeagueService, private _sortM:SortingService) {
  }

  ngOnInit(): void {
    this._serviceOfPL.getPremierLeagueTeams().subscribe(data =>
      {
        this.addAllTeamsToView = data
      }, error => {
        console.log(error)
      }
    );
  }

  //method to sort according to the goal scored
  onSortWithGS(){
   this._sortM.sortingAccordingToGS(this.addAllTeamsToView);
  }

  //method to sort according to the win count
  onSortWithWin(){
    this._sortM.sortingAccordingToWin(this.addAllTeamsToView);
  }
}
