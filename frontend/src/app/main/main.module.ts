import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {Http, HttpModule, XHRBackend, RequestOptions} from '@angular/http';
import {RouterModule} from '@angular/router';
import {ElModule} from 'element-angular';

import 'rxjs/Rx';

//拦截器代码
import {HttpInterceptorService} from './core/http/HttpInterceptorService';

import {UserModule} from './../user/user.module';




import {AppComponent} from './component/app/app.component';
import {LoginComponent} from './component/login/login.component';

export function interceptorFactory(xhrBackend: XHRBackend, requestOptions: RequestOptions) {
  let service = new HttpInterceptorService(xhrBackend, requestOptions);
  return service;
}

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    ElModule.forRoot(),
    UserModule,
    RouterModule.forRoot([
      {
        path: '',
        component: LoginComponent
      },

    ])
  ],
  providers: [ HttpInterceptorService,
    {
      provide: Http,
      useFactory: interceptorFactory,
      deps: [XHRBackend, RequestOptions]
    }],
  bootstrap: [AppComponent]
})

export class MainModule {
}
