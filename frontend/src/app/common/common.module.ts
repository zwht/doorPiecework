// 公共模块
import {NgModule} from '@angular/core';
import {CropperImgComponent} from '../main/component/cropper-img/cropper-img.component';

@NgModule({
  imports: [

  ],
  exports: [
    CropperImgComponent
  ],
  declarations: [CropperImgComponent],
})
export class SharedModule {
}
