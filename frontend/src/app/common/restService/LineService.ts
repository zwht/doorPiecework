/**
 * Created by zhaowei on 2017/10/16.
 */
import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import HandleError from './../service/HandleError';
import {Line} from '../class/Line';
@Injectable()
export class LineService {

  constructor(private http: Http) {
  }

  /**获取用户列表**/
  private url = '/cfmy/line/';

  // 添加
  public add(line: Line): Promise<void> {
    return this.http.post(this.url + 'add',
      JSON.stringify(line))
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

  public update(line: Line): Promise<void> {
    return this.http.post(this.url + 'update',
      JSON.stringify(line))
      .toPromise()
      .then(response => response.json())
      .catch(HandleError);
  }

}
