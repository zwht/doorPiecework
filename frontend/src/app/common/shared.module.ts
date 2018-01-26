// 公共模块
import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ElModule} from 'element-angular';
import {CropperImgComponent} from './components/cropper-img/cropper-img.component';
import {ZwHttpInterceptor} from './service/ZwHttpInterceptor';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import {HttpServer} from './service/HttpServer';
import {DateSet} from './service/DateSet';


@NgModule({
  imports: [
    CommonModule,
    HttpClientModule,
    ElModule.forRoot()
  ],
  declarations: [CropperImgComponent],
  exports: [CropperImgComponent],
  providers: [
    DateSet,
    HttpServer,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: ZwHttpInterceptor,
      multi: true,
    }
  ]
})
export class SharedModule {
}
