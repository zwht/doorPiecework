import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {UserRoutes, UserComponents} from './user.routes';
import { ElModule } from 'element-angular';


// 拦截器代码
import {Http, HttpModule, XHRBackend, RequestOptions} from '@angular/http';
import {HttpInterceptorService} from '../main/core/http/HttpInterceptorService';
export function interceptorFactory(xhrBackend: XHRBackend, requestOptions: RequestOptions) {
  return new HttpInterceptorService(xhrBackend, requestOptions);
}


@NgModule({
  imports: [
    ElModule.forRoot(),
    FormsModule,
    CommonModule,
    UserRoutes
  ],
  providers: [HttpInterceptorService,
    {
      provide: Http,
      useFactory: interceptorFactory,
      deps: [XHRBackend, RequestOptions]
    }],
  declarations: UserComponents
})
export class UserModule {
}
