import {Injectable} from '@angular/core';
import {Headers, Http} from '@angular/http';
import {InterceptorService} from 'ng2-interceptors';
import 'rxjs/add/operator/toPromise';

import {LoginVo} from '../class/vo/LoginVo';


@Injectable()
export class AuthService {

  private headers = new Headers({'Content-Type': 'application/json'});

  constructor(private http: InterceptorService) {
  }

  // 登陆
  private url_authLogin = 'auth/login';

  login(account: string, password: string): Promise<LoginVo> {

    console.log("登陆:" + account + "," + password);
    return this.http.post(this.url_authLogin,
      JSON.stringify({account: account, password: password}))
      .toPromise()
      .then(response => response.json().data as LoginVo)
      .catch(this.handleError);
  }

  // 注销
  private url_authLogout = 'auth/logout';

  logout(userId: string): Promise<void> {
    return this.http.post(this.url_authLogout,
      JSON.stringify({userId: userId}), {headers: this.headers})
      .toPromise()
      .then(() => null)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('发生错误', error);
    return Promise.reject(error.message || error);
  }
}
