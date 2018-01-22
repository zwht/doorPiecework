import {LoginComponent} from './component/login/login.component';
import {NotFoundComponent} from './component/not-found/not-found.component';
import {MenuComponent} from './component/menu/menu.component';
export const mainRoutes = [
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'admin',
    component: MenuComponent,
    children: [
      {
        path: 'user',
        loadChildren: 'app/user/user.module#UserModule',
        data: {name: '用户管理', menu: true}
      },
      {
        path: 'work',
        loadChildren: 'app/work/work.module#WorkModule',
        data: {name: '工单管理', menu: true}
      },
      {
        path: 'product',
        loadChildren: 'app/product/product.module#ProductModule',
        data: {name: '产品管理', menu: true}
      },
    ]
  },
  {
    path: '**',
    component: NotFoundComponent
  }

];

export const mainComponentList = [LoginComponent, NotFoundComponent, MenuComponent];
