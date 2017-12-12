import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {DoorComponent} from './door/door.component';
import {DoorAddComponent} from './door-add/door-add.component';
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
          name: '列表',
          menu: true
        }
      },
      {
        path: 'door/add',
        component: DoorAddComponent,
        data: {
          name: '添加'
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
export const ProductComponents = [DoorComponent, CropperImgComponent, DoorAddComponent];
export const ProductList = routes;
