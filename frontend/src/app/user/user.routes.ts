import {MenuComponent} from './../main/component/menu/menu.component';
import {CorporationListComponent} from './component/corporation-list/corporation-list.component';
import {CorporationAddComponent} from './component/corporation-add/corporation-add.component';
import {ListComponent} from './component/list/list.component';
import {AddComponent} from './component/add/add.component';

export const userRoutes = [
  {
    path: '',
    component: MenuComponent,
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

export const userComponentList = [
  MenuComponent,
  CorporationListComponent,
  CorporationAddComponent,
  ListComponent,
  AddComponent
];
