import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import {FormsModule} from '@angular/forms';
import {userRoutes,userComponentList} from './user.routes';
@NgModule({
  imports: [
    FormsModule,
    CommonModule,
    RouterModule.forChild(userRoutes)
  ],
  declarations: userComponentList
})
export default class UserModule { }
