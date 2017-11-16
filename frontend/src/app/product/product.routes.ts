import {MenuComponent} from './../main/component/menu/menu.component';
import {DoorComponent} from './door/door.component';
export const productRoutes = [
  {
    path: '',
    component: MenuComponent,
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

export const productComponentList = [
  MenuComponent,
  DoorComponent
];
