import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment.prod';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';


@Injectable()
export class NewsFeedsService {

  baseUrl: string = environment.baseUrl;

  constructor(private http: HttpClient) {
  }

  public getAllPublicStatus(): Observable<any> {
    const url = this.baseUrl + 'public/status';
    return this.http.get(url);

  }

}
