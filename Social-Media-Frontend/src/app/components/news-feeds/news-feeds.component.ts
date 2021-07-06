import {Component, OnInit} from '@angular/core';
import {NewsFeedsService} from '../../services/news-feeds.service';

@Component({
  selector: 'app-news-feeds',
  templateUrl: './news-feeds.component.html',
  styleUrls: ['./news-feeds.component.css']
})
export class NewsFeedsComponent implements OnInit {

  statusList: any = [];

  constructor(private newsFeedsService: NewsFeedsService) {
  }

  ngOnInit() {
    this.getAllPublicStatus();
  }

  private getAllPublicStatus() {
    this.newsFeedsService.getAllPublicStatus().subscribe(status => {
      console.log(status);
      this.statusList = status;
    });
  }
}
