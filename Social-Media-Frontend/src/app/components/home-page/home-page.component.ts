import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {
  postStatus: FormGroup;

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.postStatus = this.formBuilder.group({
      status: new FormControl(''),
      location: new FormControl(''),
      privacy: new FormControl('')
    });
  }

  onSubmit() {
    console.log('123');
  }
}
