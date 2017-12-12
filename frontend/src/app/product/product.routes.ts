import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {DoorComponent} from './door/door.component';
import {DoorAddComponent} from './door-add/door-add.component';
import {GxListComponent} from './gx-list/gx-list.component';
import {GxAddComponent} from './gx-add/gx-add.component';

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
          name: 'door列表',
          menu: true
        }
      },
      {
        path: 'door/add',
        component: DoorAddComponent,
        data: {
          name: '添加'
        }
      },
      {
        path: 'gx',
        component: GxListComponent,
        data: {
          name: '工序列表',
          menu: true
        }
      },
      {
        path: 'gx/add',
        component: GxAddComponent,
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
export const ProductComponents = [DoorComponent, DoorAddComponent, GxListComponent, GxAddComponent];
export const ProductList = routes;
