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
        component: ListComponent,
        data:{
          name:"用户列表",
          menu:true
        }
      },
      {
        path: 'add',
        component: AddComponent,
        data:{
          name:"添加用户"
        }
      }
    ]
  }
];

export const userComponentList = [
  MenuComponent,
  ListComponent,
  AddComponent
];
