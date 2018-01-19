import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';

import {CorporationListComponent} from './component/corporation-list/corporation-list.component';
import {CorporationAddComponent} from './component/corporation-add/corporation-add.component';
import {ListComponent} from './component/user-list/list.component';
import {AddComponent} from './component/user-add/add.component';

export const routes: Routes = [
  {
    path: '',
    data: {
      name: '用户管理'
    },
    children: [
      {
        path: 'company',
        component: CorporationListComponent,
        data: {
          name: '企业列表',
          menu: true
        }
      },
      {
        path: 'company/add',
        component: CorporationAddComponent,
        data: {
          name: '添加企业'
        }
      },
      {
        path: 'list',
        component: ListComponent,
        data: {
          name: '用户列表',
          menu: true
        }
      },
      {
        path: 'add',
        component: AddComponent,
        data: {
          name: '添加用户'
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
export class UserRoutes {
}

export const UserComponents = [
  CorporationListComponent,
  CorporationAddComponent,
  ListComponent,
  AddComponent
];
export const UserList = routes;
