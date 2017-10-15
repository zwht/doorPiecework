import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {Http, HttpModule, XHRBackend, RequestOptions} from '@angular/http';
import {RouterModule} from '@angular/router';


import 'rxjs/Rx';

//拦截器代码
import {HttpInterceptorService} from './core/http/HttpInterceptorService';

import {AppComponent} from './component/app/app.component';
import {mainRoutes, mainComponentList} from './main.routes';
export function interceptorFactory(xhrBackend: XHRBackend, requestOptions: RequestOptions) {
  let service = new HttpInterceptorService(xhrBackend, requestOptions);
  return service;
}

@NgModule({
  declarations: [].concat([AppComponent],mainComponentList),
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(mainRoutes)
  ],
  providers: [HttpInterceptorService,
    {
      provide: Http,
      useFactory: interceptorFactory,
      deps: [XHRBackend, RequestOptions]
    }],
  bootstrap: [AppComponent]
})

export class MainModule {
}
