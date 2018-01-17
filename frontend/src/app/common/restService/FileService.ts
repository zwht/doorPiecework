/**
 * Created by zhaowei on 2017/10/16.
 */
import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import HandleError from './../service/HandleError';

@Injectable()
export class FileService {

  constructor(private http: Http) {
  }

  /**获取用户列表**/
  private url = '/cfmy/file/';


  public upToken(): Promise<void> {
    return this.http.get(this.url + 'upToken')
      .toPromise()
      .then(response => response.json())
      .catch(HandleError);
  }
}
