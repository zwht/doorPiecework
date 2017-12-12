import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {UserRoutes, UserComponents} from './user.routes';
import { ElModule } from 'element-angular';
@NgModule({
  imports: [
    ElModule.forRoot(),
    FormsModule,
    CommonModule,
    UserRoutes
  ],
  declarations: UserComponents
})
export class UserModule {
}
