import {LoginComponent} from './component/login/login.component';


export const mainRoutes=[
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'admin/user',
    loadChildren: './../user/user.module'
  },

]

export const mainComponentList=[LoginComponent];
