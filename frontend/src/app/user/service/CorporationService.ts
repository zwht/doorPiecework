/**
 * Created by zhaowei on 2017/10/16.
 */
import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import HandleError from './../../common/service/HandleError';
import {Corporation} from './../../common/class/Corporation';
@Injectable()
export class CorporationService {

  constructor(private http: Http) {
  }

  /**获取用户列表**/
  private url_authLogin = '/cfmy/corporation/list';

  public list(obj: Object, body: Object): Promise<void> {
    return this.http.post(this.url_authLogin + '/' + (obj as any).pageNum + '/' + (obj as any).pageSize,
      JSON.stringify(body ? body : {}))
      .toPromise()
      .then(response => response.json())
      .catch(HandleError);
  }

  // 添加公司
  public add(corporation: Corporation): Promise<void> {
    return this.http.post('/cfmy/corporation/add',
      JSON.stringify(corporation))
      .toPromise()
      .then(response => response.json())
      .catch(HandleError);
  }

  // 删除公司
  public del(id: String): Promise<void> {
    return this.http.get('/cfmy/corporation/del?id=' + id)
      .toPromise()
      .then(response => response.json())
      .catch(HandleError);
  }
}
