import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {IFootballClub} from "../Models/FootballClub";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {IMatch} from "../Models/Match";

@Injectable({
  providedIn: 'root'
})
export class PremierLeagueService {

  //the url that will be needed to load the API EndPoints
  private URL_FOR_PREMIER_LEAGUE_TEAMS = '/getTeams';
  private URL_FOR_MATCHES_PLAYED = '/getMatchesPlayed';
  private URL_FOR_RANDOM_MATCHES = '/randomMatch'
  private BASE_URL = 'http://localhost:9000';

  constructor(private _http:HttpClient) {}

  /**
   * this method does a get request to the client side where it will return all the teams available in the
   * Premier League
   */
  getPremierLeagueTeams(): Observable<IFootballClub[]> {
    //mapping through the http client request inorder to get the only IFootball Clubs
    return this._http.get(this.BASE_URL + this.URL_FOR_PREMIER_LEAGUE_TEAMS).pipe(map(
      premierLeagueEvaluation => {
        let allTeamGain: IFootballClub[] = [];
        for (let items in premierLeagueEvaluation) {
          if (premierLeagueEvaluation.hasOwnProperty(items)) {
            allTeamGain.push(premierLeagueEvaluation[items]);
          }
        }
        return allTeamGain;
      })
    );
  }

  /**
   * This will retrieve all the type of the Match data from the server side
   */
  getMatchesPlayed() : Observable<IMatch[]>{
    return this._http.get(this.BASE_URL + this.URL_FOR_MATCHES_PLAYED).pipe(map(
      matchEvaluation => {
        let matchItems: IMatch[] = [];
        for (let items in matchEvaluation) {
          if (matchEvaluation.hasOwnProperty(items)) {
            matchItems.push(matchEvaluation[items]);
          }
        }
        return matchItems;
      }
    ));
  }

  /**
   * Calls the random Match played Method from the server side
   */
  getRandomMatch():Observable<IMatch[]>{
    return this._http.get(this.BASE_URL + this.URL_FOR_RANDOM_MATCHES).pipe(map (
      randomEvaluation => {
        let randomPlayMatch:IMatch[] = [];
        for (let randomM in randomEvaluation){
          if (randomEvaluation.hasOwnProperty(randomM)){
            randomPlayMatch.push(randomEvaluation[randomM]);
          }
        }
        return randomPlayMatch;
      }
    ))
  }
}
