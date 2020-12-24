import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-page-not-found',
  templateUrl: './page-not-found.component.html',
  styleUrls: ['./page-not-found.component.css']
})
export class PageNotFoundComponent implements OnInit {

  constructor(private _route:Router) { }

  ngOnInit(): void {
  }
  //button click event to navigate back to the base URL
  backToBaseUrl(){
    this._route.navigate(['/']);
  }
}
