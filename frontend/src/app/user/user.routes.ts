import {MenuComponent} from './../main/component/menu/menu.component';
import {CompanyComponent} from './component/company/company.component';
import {CompanyAddComponent} from './component/company-add/company-add.component';
import {ListComponent} from './component/list/list.component';
import {AddComponent} from './component/add/add.component';

export const userRoutes = [
  {
    path: '',
    component: MenuComponent,
    children: [
      {
        path: 'company',
        component: CompanyComponent,
        data: {
          name: '企业列表',
          menu: true
        }
      },
      {
        path: 'company/add',
        component: CompanyAddComponent,
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
  CompanyComponent,
  CompanyAddComponent,
  ListComponent,
  AddComponent
];
