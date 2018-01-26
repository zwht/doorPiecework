import {Component, Input, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {LoginVo} from '../../../common/class/LoginVo';
import {AuthService} from '../../../common/restService/AuthService';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.less'],
  providers: [AuthService]
})

export class LoginComponent implements OnInit {
  login = new LoginVo('', '');

  constructor(private router: Router,
              private authService: AuthService) {
  }

  ngOnInit() {
    const that=this;
    $(document).unbind("keyup");
    $(document).keyup(function(event){
      if(event.keyCode ==13&&that.router.url==='/'){
        that.onLogin()
      }
    });
  }

  onLogin() {
    this.authService['login']({data: this.login})
      .then(response => {
        const rep = (response as any);
        if (rep.code === 200) {
          localStorage.setItem('userName', this.login.name);
          localStorage.setItem('token', rep.data.token);
          this.router.navigateByUrl('/admin/user/company');
        } else {
          console.log(data);
        }
      })
      .catch(err => {
      });
  }
}
