import { Component, OnInit } from '@angular/core';
import { PremierLeagueService } from "../../Services/premier-league.service";
import {IMatch} from "../../Models/Match";

@Component({
  selector: 'app-add-play-match',
  templateUrl: './add-play-match.component.html',
  styleUrls: ['./add-play-match.component.css']
})
export class AddPlayMatchComponent implements OnInit {

  randomMatch:IMatch[] = []; //array to store display the match Played by the each click made
  constructor(private _serviceGain:PremierLeagueService) { }

  ngOnInit(): void {
  }

  //button click even which will call the routes in the framework inorder to add the random match
  onPlay(){
    this._serviceGain.getRandomMatch().subscribe(data => {
      this.randomMatch = data },
        error => {console.log(error) //if the server is down then this error will be send
    });
  }
}
