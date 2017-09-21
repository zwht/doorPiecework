import {MenuComponent} from './../main/component/menu/menu.component';
import {ListComponent} from './component/list/list.component';
import {AddComponent} from './component/add/add.component';

export const userRoutes = [
  {
    path: '',
    component: MenuComponent,
    children: [
      {
        path: 'list',
        component: ListComponent
      },
      {
        path: 'add',
        component: AddComponent
      }
    ]
  }
];

export const userComponentList = [
  MenuComponent,
  ListComponent,
  AddComponent
];
