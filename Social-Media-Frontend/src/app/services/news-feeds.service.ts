import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment.prod';
import {Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';


@Injectable()
export class NewsFeedsService {

  baseUrl: string = environment.baseUrl;

  constructor(private http: HttpClient) {
  }

  public getAllPublicStatus(): Observable<any> {
    const url = this.baseUrl + 'public/status';
    return this.http.get(url);

  }

  public getMyStatus(): Observable<any> {
    const url = this.baseUrl + 'api/my/status';
    return this.http.get(url, {
      headers: new HttpHeaders({
        Authorization: 'Bearer ' + localStorage.getItem('token')
      })
    });
  }

  public getMyStatusById(id: string): Observable<any> {
    const url = this.baseUrl + 'api/my/status/' + id;
    return this.http.get(url, {
      headers: new HttpHeaders({
        Authorization: 'Bearer ' + localStorage.getItem('token')
      })
    });
  }

  public postMyStatus(body: any): Observable<any> {
    const url = this.baseUrl + 'api/status/create';
    return this.http.post(url, body, {
      headers: new HttpHeaders({
        Authorization: 'Bearer ' + localStorage.getItem('token')
      })
    });
  }

  updateMyStatus(body: any, postId: string): Observable<any> {
    const url = this.baseUrl + 'api/my/status/' + postId;
    return this.http.put(url, body, {
      headers: new HttpHeaders({
        Authorization: 'Bearer ' + localStorage.getItem('token')
      })
    });
  }
}
