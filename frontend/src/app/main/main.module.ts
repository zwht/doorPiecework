import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {Http, HttpModule, XHRBackend, RequestOptions} from '@angular/http';
import {RouterModule} from '@angular/router';
import { ElModule } from 'element-angular';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';

// 拦截器代码
import {HttpInterceptorService} from './core/http/HttpInterceptorService';
export function interceptorFactory(xhrBackend: XHRBackend, requestOptions: RequestOptions) {
  debugger
  return new HttpInterceptorService(xhrBackend, requestOptions);
}

import {AppComponent} from './component/app/app.component';
import {mainRoutes, mainComponentList} from './main.routes';


@NgModule({
  declarations: [].concat([AppComponent], mainComponentList),
  imports: [
    ElModule.forRoot(),
    BrowserModule,
    NoopAnimationsModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(mainRoutes, {useHash: true})
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
