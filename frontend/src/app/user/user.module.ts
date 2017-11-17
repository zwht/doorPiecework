import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {UserRoutes, UserComponents} from './user.routes';
@NgModule({
  imports: [
    FormsModule,
    CommonModule,
    UserRoutes
  ],
  declarations: UserComponents
})
export class UserModule {
}
