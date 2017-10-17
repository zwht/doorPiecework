import {Injectable} from '@angular/core';
import {Headers, Http} from '@angular/http';

import {LoginVo} from '../class/vo/LoginVo';
import {Response} from '../class/vo/Response';


@Injectable()
export class AuthService {
  constructor(private http: Http) {
  }

  // 登陆
  private url_authLogin = '/cfmy/user/login';

  login(loginVo: LoginVo): Promise<Response<void>> {
    return this.http.post(this.url_authLogin,
      JSON.stringify(loginVo))
      .toPromise()
      .then(response => response.json())
      .catch(this.handleError);
  }

  // 注销
  private url_authLogout = 'auth/logout';

  logout(userId: string): Promise<void> {
    return this.http.post(this.url_authLogout,
      JSON.stringify({userId: userId}))
      .toPromise()
      .then(() => null)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('发生错误', error);
    return Promise.reject(error.message || error);
  }
}
