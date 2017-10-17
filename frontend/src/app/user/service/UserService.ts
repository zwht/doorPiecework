/**
 * Created by zhaowei on 2017/10/16.
 */
import {Injectable} from '@angular/core';
import {Headers, Http} from '@angular/http';

@Injectable()
export class UserService {

  constructor(private http: Http) {
  }

  // 登陆
  private url_authLogin = '/cfmy/user/login';

  private handleError(error: any): Promise<any> {
    console.error('发生错误', error);
    return Promise.reject(error.message || error);
  }
}
