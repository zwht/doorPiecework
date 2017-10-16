import {Component, Input, OnInit} from '@angular/core';
import {Headers, Http} from '@angular/http';
import {Router} from '@angular/router';
import {LoginVo} from './../../class/vo/LoginVo';
import {HeroService} from './../../service/HeroService';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.less'],
  providers: [HeroService]
})

export class LoginComponent implements OnInit {
  login = {
    username: 'zw',
    password: '123456'
  };

  constructor(private http: Http,
              private router:Router,
              private heroService:HeroService) {
  }

  ngOnInit() {
    console.log(this);
  }

  onLogin(data) {
    this.http.post('/cfmy/user/login', JSON.stringify(this.login))
      .map(res => res.json())
      .subscribe(response => {
        if (response.code === 200) {
          localStorage.setItem('token', response.data.token);
          this.router.navigate(['/admin/user/list']);
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
