import {Component, Input, OnInit} from '@angular/core';
import { Headers, Http } from '@angular/http';

interface Login {
  username:string,
  password:string
}
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.less']
})

export class LoginComponent implements OnInit {
  public login: Login = {
    username: 'zw',
    password: '123456'
  };
  constructor(private http: Http) {}
  ngOnInit() {}
  onLogin(data) {
    var headers = new Headers();
    headers.append('Content-Type', 'application/json; charset=utf-8');
    this.http.post('/cfmy/user/login', JSON.stringify(data),
      {headers: headers})
      .map(res => res.json())
      .subscribe(
        data => {
          localStorage.setItem('id_token', data.id_token), console.log(data)
        },
        err => console.log(err),
        () => console.log('Register Complete')
      );
  }


}
