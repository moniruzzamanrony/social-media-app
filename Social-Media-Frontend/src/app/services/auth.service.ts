import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment.prod';
import {Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';


@Injectable()
export class AuthService {

  baseUrl: string = environment.baseUrl;

  constructor(private http: HttpClient) {
  }

  public signUp(body: any): Observable<any> {
    const url = this.baseUrl + 'public/signup';
    return this.http.post(url, body);

  }

  public login(body: any): Observable<any> {
    const url = this.baseUrl + 'public/signin';
    return this.http.post(url, body);

  }

  public getProfileDetails(): Observable<any> {

    const url = this.baseUrl + 'api/profile';
    return this.http.get(url, {
      headers: new HttpHeaders({
        Authorization: 'Bearer ' + localStorage.getItem('token')
      })
    });

  }

}
