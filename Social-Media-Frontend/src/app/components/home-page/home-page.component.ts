import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {LocationsService} from '../../services/locations.service';
import {NewsFeedsService} from '../../services/news-feeds.service';
import {ActivatedRoute, Router} from '@angular/router';


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {
  postStatus: FormGroup;
  locationList: any = [];
  postId: string;
  buttonLabel: string;
  isError: boolean = false;
  isSuccess: boolean = false;

  constructor(private formBuilder: FormBuilder,
              private _locationsService: LocationsService,
              private newsFeedsService: NewsFeedsService,
              private route: ActivatedRoute,
              private router: Router) {
    this.getLocations();
  }

  ngOnInit() {
    this.postStatus = this.formBuilder.group({
      statusBody: new FormControl(''),
      location: new FormControl(''),
      postPrivecy: new FormControl('')
    });
    console.log(this.postId);
    this.postId = this.route.snapshot.paramMap.get('id');
    console.log(this.postId);

    if (this.postId === null) {
      this.buttonLabel = 'Post';
    } else {
      this.buttonLabel = 'Update';
      this.loadDataFromUpdate();
    }
  }

  onSubmit(butType: string) {
    if (butType === 'Post') {
      this.newsFeedsService.postMyStatus(this.postStatus.value).subscribe(res => {
        this.isSuccess = true;
        this.postStatus.reset();
      }, error => {
        this.isError = true;
      });
    } else {
      this.newsFeedsService.updateMyStatus(this.postStatus.value, this.postId).subscribe(res => {
        this.isSuccess = true;
        this.postStatus.reset();
      }, error => {
        this.isError = true;
      });
    }


  }

  private getLocations() {
    this._locationsService.getLocation().subscribe(res => {
      this.locationList = res;
    });
  }

  private loadDataFromUpdate() {
    this.newsFeedsService.getMyStatusById(this.postId).subscribe(res => {
      this.postStatus.patchValue({
        statusBody: res.statusBody,
        location: res.location,
        postPrivecy: res.postPrivecy
      });
    }, error => {
    });
  }
}
