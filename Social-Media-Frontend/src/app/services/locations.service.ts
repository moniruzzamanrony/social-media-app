import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment.prod';
import {Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';


@Injectable()
export class LocationsService {

  baseUrl: string = environment.baseUrl;

  constructor(private http: HttpClient) {
  }

  public getLocation(): Observable<any> {
    const url = this.baseUrl + 'public/locations';
    return this.http.get(url);

  }

  public getMyStatus(): Observable<any> {
    const url = this.baseUrl + 'public/status';
    return this.http.get(url, {
      headers: new HttpHeaders({
        Authorization: 'Bearer ' + localStorage.getItem('token')
      })
    });

  }
}
