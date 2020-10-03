import { Component, OnInit } from '@angular/core';
import { AuthService0 } from '../services/auth0.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor(public auth: AuthService0) { }

  ngOnInit() {
  }

}