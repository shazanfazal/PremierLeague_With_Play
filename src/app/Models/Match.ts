import {IDateTime} from "./DateTime";

export interface IMatch{
  homeTeamMatch: string;
  awayTeamMatch: string;
  homeGoalScored: number;
  awayGoalScored: number;
  matchDatePlayed: IDateTime
}
