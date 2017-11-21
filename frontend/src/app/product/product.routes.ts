import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {DoorComponent} from './door/door.component';
import {CropperImgComponent} from './../main/component/cropper-img/cropper-img.component';
const routes: Routes = [
  {
    path: '',
    data: {
      name: '产品管理'
    },
    children: [
      {
        path: 'door',
        component: DoorComponent,
        data: {
          name: '门列表',
          menu: true
        }
      }
    ]
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule]
})

export class ProductRoutes {
}
export const ProductComponents = [DoorComponent, CropperImgComponent];
export const ProductList = routes;
