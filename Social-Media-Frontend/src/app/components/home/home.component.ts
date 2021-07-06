import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {AuthService} from '../../services/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  profileDetails: any;
  isNotFoundProfile: boolean = true;

  constructor(private router: Router,
              private authService: AuthService) {
  }

  ngOnInit() {
    this.showDashboard();
    this.getProfileDetails();
  }

  showDashboard(): void {
    this.router.navigate(['/news-feed']);
  }

  showEmployeesList(): void {
    this.router.navigate(['employees/employees-list']);
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

  logout() {
    localStorage.removeItem('token');
    window.location.reload();
  }
}
