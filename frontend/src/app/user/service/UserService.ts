/**
 * Created by zhaowei on 2017/10/16.
 */
import {Injectable} from '@angular/core';
import {Headers, Http} from '@angular/http';

@Injectable()
export class UserService {

  constructor(private http: Http) {
  }

  /**获取用户列表**/
  private url_authLogin = '/cfmy/user/getUserList';

  public list(obj: Object, obj1: Object): Promise<void> {
    return this.http.post(this.url_authLogin+'/'+(obj as any).pageNum+'/'+(obj as any).pageSize,
      JSON.stringify(obj1 ? obj1 : {}))
      .toPromise()
      .then(response => response.json())
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('发生错误', error);
    return Promise.reject(error.message || error);
  }
}
