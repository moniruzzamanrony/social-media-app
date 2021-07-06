import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {AuthService} from '../../services/auth.service';
import {NewsFeedsService} from '../../services/news-feeds.service';

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.css']
})
export class MyProfileComponent implements OnInit {

  profileDetails: any;
  isNotFoundProfile: boolean = true;
  statusList: any = [];

  constructor(private router: Router,
              private authService: AuthService,
              private newsFeedsService: NewsFeedsService) {
  }

  ngOnInit() {
    this.getProfileDetails();
    this.getMyStatus();
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

  private getMyStatus() {
    this.newsFeedsService.getMyStatus().subscribe(status => {
      console.log(status);
      this.statusList = status;
    });
  }

  gotoEdit(id: string) {
    this.router.navigate(['home-page/' + id]);
  }
}
