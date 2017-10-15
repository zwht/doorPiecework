import {LoginComponent} from './component/login/login.component';


export const mainRoutes=[
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'admin/user',
    loadChildren: './../user/user.module',
    data:{name:"用户管理",menu:true}
  },

];

export const mainComponentList=[LoginComponent];
