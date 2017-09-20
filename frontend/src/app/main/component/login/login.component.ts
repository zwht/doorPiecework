import {Component, Input, OnInit} from '@angular/core';
import {Headers, Http} from '@angular/http';
import {AuthService} from './../../service/AuthService';
interface Login {
  username: string,
  password: string
}
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.less'],
  providers: [AuthService]
})

export class LoginComponent implements OnInit {
  public login: Login = {
    username: 'zw',
    password: '123456'
  };

  constructor(private http: Http) {
  }

  ngOnInit() {
  }

  onLogin(data) {
    this.http.post('/cfmy/user/login', JSON.stringify(this.login))
      .map(res => res.json())
      .subscribe(response => {
        if (response.code === 200) {
          localStorage.setItem('token', response.data.token);
        } else {
          console.log(data);
        }
      }, err => {
        console.log(err);
      }, () => {
        console.log('Register Complete');
      });
  }
}
