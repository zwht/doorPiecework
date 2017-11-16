import {LoginComponent} from './component/login/login.component';


export const mainRoutes = [
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'user',
    loadChildren: './../user/user.module',
    data: {name: '用户管理', menu: true}
  },
  {
    path: 'work',
    loadChildren: './../work/work.module',
    data: {name: '工单管理', menu: true}
  },
  {
    path: 'product',
    loadChildren: './../product/product.module',
    data: {name: '产品管理', menu: true}
  }

];

export const mainComponentList = [LoginComponent];
