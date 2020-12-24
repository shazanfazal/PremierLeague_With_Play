import { Injectable } from '@angular/core';
import {IFootballClub} from "../Models/FootballClub";
import {IMatch} from "../Models/Match";

@Injectable({
  providedIn: 'root'
})
export class SortingService {

  constructor() { }

  /**
   * SORTS THE DATA ACCORDING TO THE GOAL SCORED
   * @param arraysOfTeam the array that will be passed that needs to be sorted
   */
  sortingAccordingToGS(arraysOfTeam:IFootballClub[]){
    arraysOfTeam.sort((firstOBJ,secondOBJ) => {
      if (firstOBJ.noOfGoalScored > secondOBJ.noOfGoalScored){
        return -1;
      }else if (firstOBJ.noOfGoalScored < secondOBJ.noOfGoalScored){
        return  1;
      }else {
        return 0;
      }
    })
  }

  /**
   * sorts the data according to the wins of a team
   * @param arrayOfTeams array where the teams are stored
   */
  sortingAccordingToWin(arrayOfTeams:IFootballClub[]){
    arrayOfTeams.sort((firstOBJ,secondOBJ) => {
      if (firstOBJ.noOfMatchesWon > secondOBJ.noOfMatchesWon){
        return -1;
      }else if (firstOBJ.noOfMatchesWon < secondOBJ.noOfMatchesWon){
        return 1;
      }else {
        return 0;
      }
    })
  }

  /**
   * sorting according to the dates
   * @param arrayOfMatches the arrayList that the Matches are stored
   */
  sortingWithDate(arrayOfMatches:IMatch[]){
    arrayOfMatches.sort((firstOBJMatch, secondOBJMatch) => {
      let result =  this.convertToMinutes(firstOBJMatch);
      let result2 = this.convertToMinutes(secondOBJMatch);
      if (result < result2){
        return -1;
      }else if (result > result2){
        return 1;
      }else {
        return 0;
      }
    })
  }

  /**
   * converting date to minutes so that it will be sorted easily
   * @param value the total minutes that will be returned
   */
  convertToMinutes(value:IMatch): number{
    let day = value.matchDatePlayed.dayOfTheMonth * 24 * 60;
    let month = value.matchDatePlayed.monthOfTheYear * 30 * 24 * 60;
    let year = value.matchDatePlayed.year * 365 * 24 * 60;
    let hour = value.matchDatePlayed.hourOfTheDay * 60
    let minute = value.matchDatePlayed.minutesOfTheDay;
    return (day + month + year + hour + minute);
  }
}
