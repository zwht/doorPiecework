import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import { FileUploadModule } from 'ng2-file-upload';
import {ProductRoutes, ProductComponents} from './product.routes';
@NgModule({
  imports: [
    FormsModule,
    CommonModule,
    ProductRoutes,
    FileUploadModule
  ],
  declarations: ProductComponents
})
export class ProductModule {
}
