/**
 * Created by zhaowei on 2017/10/16.
 */
import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import HandleError from './../service/HandleError';
import {Color} from '../class/Color';
@Injectable()
export class ColorService {

  constructor(private http: Http) {
  }

  /**获取用户列表**/
  private url = '/cfmy/color/';

  // 添加
  public add(color: Color): Promise<void> {
    return this.http.post(this.url + 'add',
      JSON.stringify(color))
      .toPromise()
      .then(response => response.json())
      .catch(HandleError);
  }

  public list(obj: Object, body: Object): Promise<void> {
    return this.http.post(this.url + 'list/' + (obj as any).pageNum + '/' + (obj as any).pageSize,
      JSON.stringify(body ? body : {}))
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

  public update(color: Color): Promise<void> {
    return this.http.post(this.url + 'update',
      JSON.stringify(color))
      .toPromise()
      .then(response => response.json())
      .catch(HandleError);
  }

}
