import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {ProductRoutes, ProductComponents} from './product.routes';
@NgModule({
  imports: [
    FormsModule,
    CommonModule,
    ProductRoutes
  ],
  declarations: ProductComponents
})
export class ProductModule {
}
