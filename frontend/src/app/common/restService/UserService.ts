/**
 * Created by zhaowei on 2017/10/16.
 */
import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import HandleError from './../../common/service/HandleError';
import {User} from './../../common/class/User';
@Injectable()
export class UserService {

  constructor(private http: Http) {
  }

  /**获取用户列表**/
  private url = '/cfmy/user/';

  public list(obj: Object, obj1: Object): Promise<void> {
    return this.http.post(this.url + 'getUserList/' + (obj as any).pageNum + '/' + (obj as any).pageSize,
      JSON.stringify(obj1 ? obj1 : {}))
      .toPromise()
      .then(response => response.json())
      .catch(HandleError);
  }

  public getById(id: String): Promise<void> {
    return this.http.get(this.url + 'getById?id=' + id)
      .toPromise()
      .then(response => response.json())
      .catch(HandleError);
  }

  // 添加用户
  public add(user: User): Promise<void> {
    return this.http.post(this.url + 'add',
      JSON.stringify(user))
      .toPromise()
      .then(response => response.json())
      .catch(HandleError);
  }

  public del(id: String): Promise<void> {
    return this.http.get(this.url + 'del?id=' + id)
      .toPromise()
      .then(response => response.json())
      .catch(HandleError);
  }
}
