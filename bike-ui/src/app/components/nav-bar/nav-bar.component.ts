import { Component, OnInit } from '@angular/core';
import { AuthService0 } from '../../services/auth0.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  constructor(public auth: AuthService0) { }

  ngOnInit() {
  }

}