import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {AuthService} from '../../services/auth.service';

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.css']
})
export class MyProfileComponent implements OnInit {

  profileDetails: any;
  isNotFoundProfile: boolean = true;

  constructor(private router: Router,
              private authService: AuthService) { }

  ngOnInit() {
    this.getProfileDetails();
  }
  private getProfileDetails() {
    this.authService.getProfileDetails().subscribe(res => {
      this.profileDetails = res;
      this.isNotFoundProfile = false;
      console.log(res);
    }, err => {
      console.log(err);
    });
  }
}
