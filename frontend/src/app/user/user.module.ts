import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { MenuComponent } from './../main/component/menu/menu.component';

import { ListComponent } from './component/list/list.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot([
      {
        path: 'admin',
        component: MenuComponent,
        children:[
          {
            path: 'user/list',
            component: ListComponent
          }
        ]
      }
    ])
  ],
  declarations: [MenuComponent,ListComponent]
})
export class UserModule { }
