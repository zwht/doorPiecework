import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import HandleError from './../../common/service/HandleError';

import {LoginVo} from '../class/vo/LoginVo';

@Injectable()
export class AuthService {
  constructor(private http: Http) {
  }

  // 登陆
  private url_authLogin = '/cfmy/user/login';

  login(loginVo: LoginVo): Promise<void> {
    return this.http.post(this.url_authLogin,
      JSON.stringify(loginVo))
      .toPromise()
      .then(response => response.json())
      .catch(HandleError);
  }

  // 注销
  private url_authLogout = 'auth/logout';

  logout(userId: string): Promise<void> {
    return this.http.post(this.url_authLogout,
      JSON.stringify({userId: userId}))
      .toPromise()
      .then(() => null)
      .catch(HandleError);
  }
}
