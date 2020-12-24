import { Component, OnInit } from '@angular/core';
import {PremierLeagueService} from "../../Services/premier-league.service";
import {IMatch} from "../../Models/Match";
import {SortingService} from "../../Services/sorting.service";

@Component({
  selector: 'app-match-preview-table',
  templateUrl: './match-preview-table.component.html',
  styleUrls: ['./match-preview-table.component.css']
})
export class MatchPreviewTableComponent implements OnInit {

  allMatchesPlayed:IMatch[] = [];  //to store all the matches played
  getPlayedMatchDate: string;
  constructor(private _matchesGain:PremierLeagueService, private _sortM:SortingService) { }

  ngOnInit(): void {
    //as the page is loaded the response of the arraylist is being added to the array
    this._matchesGain.getMatchesPlayed().subscribe(data => {
      this.allMatchesPlayed = data;
    }, error => {
      console.log(error);
    })
  }

  //click event method to sort the date
  onSortDate(){
    this._sortM.sortingWithDate(this.allMatchesPlayed);
  }

  onSearch(){
    if (this.getPlayedMatchDate == ""){
      this.ngOnInit();
    }
    this.allMatchesPlayed = this.allMatchesPlayed.filter(getDate => {
      if (String(getDate.matchDatePlayed.dayOfTheMonth).match(this.getPlayedMatchDate)) {
        return String(getDate.matchDatePlayed.dayOfTheMonth).match(this.getPlayedMatchDate);
      }else if (String(getDate.matchDatePlayed.monthOfTheYear).match(this.getPlayedMatchDate)){
        return String(getDate.matchDatePlayed.monthOfTheYear).match(this.getPlayedMatchDate);
      }else if (String(getDate.matchDatePlayed.year).match(this.getPlayedMatchDate)){
        return String(getDate.matchDatePlayed.year).match(this.getPlayedMatchDate);
      }else {
        return false;
      }
    })
  }
}
