import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {AuthService} from '../../services/auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  signUpFromGroup: FormGroup;
  isError: boolean = false;

  constructor(private fb: FormBuilder,
              private authService: AuthService,
              private router: Router) {
  }

  ngOnInit() {
    this.signUpFromGroup = this.fb.group({
      address: ['', Validators.required],
      email: ['', Validators.required],
      name: ['', Validators.required],
      password: ['', Validators.required],
      phoneNo: ['', Validators.required],
      username: ['user', Validators.required]
    });
  }

  signUp() {
    if (this.signUpFromGroup.valid) {
      this.authService.signUp(this.signUpFromGroup.value).subscribe(res => {
        this.router.navigate(['/login']);
        console.log('Success');
      }, err => {
        console.log(err);
        this.router.navigate(['/login']);
      });

    }
  }
}
