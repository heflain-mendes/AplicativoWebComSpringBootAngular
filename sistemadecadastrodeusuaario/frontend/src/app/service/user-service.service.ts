import { User } from './../model/user/user';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable'; //o caminho d import mudou

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  private userUrl: string;

  constructor(private http: HttpClient) {
    this.userUrl = 'http://localhost:8080/users';
  }

  public findAll() : Observable<User[]>{
    return this.http.get<User[]>(this.userUrl);
  }

  public save(user : User) : Observable<Object>  {
    return this.http.post(this.userUrl, user);
  }
}
