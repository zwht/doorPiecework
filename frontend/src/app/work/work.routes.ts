import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';

import {DoorComponent} from './door/door.component';
const routes: Routes = [
  {
    path: '',
    data: {
      name: '工单管理'
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
@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule]
})

export class WorkRoutes {
}
export const WorkComponents = [DoorComponent];
export const WorkList = routes;
