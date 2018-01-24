// 公共模块
import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ElModule} from 'element-angular';
import {CropperImgComponent} from './components/cropper-img/cropper-img.component';

// 拦截器代码
import {Http, XHRBackend, RequestOptions} from '@angular/http';
import {HttpInterceptorService} from './service/HttpInterceptorService';
export function interceptorFactory(xhrBackend: XHRBackend, requestOptions: RequestOptions) {
  return new HttpInterceptorService(xhrBackend, requestOptions);
}
@NgModule({
  imports: [
    CommonModule,
    ElModule.forRoot()
  ],
  declarations: [CropperImgComponent],
  exports: [CropperImgComponent],
  providers: [HttpInterceptorService,
    {
      provide: Http,
      useFactory: interceptorFactory,
      deps: [XHRBackend, RequestOptions]
    }
  ],
})
export class SharedModule {
}
