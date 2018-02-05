import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {TicketListComponent} from './ticket-list/ticket-list.component';
import {TicketAddComponent} from './ticket-add/ticket-add.component';
const routes: Routes = [
  {
    path: '',
    data: {
      name: '工单管理'
    },
    children: [
      {
        path: 'ticket',
        component: TicketListComponent,
        data: {
          name: '订单',
          menu: true
        }
      },
      {
        path: 'ticket/add',
        component: TicketAddComponent,
        data: {
          name: '添加'
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
export const WorkComponents = [TicketListComponent, TicketAddComponent];
export const WorkList = routes;
