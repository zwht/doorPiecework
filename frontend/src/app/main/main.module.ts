import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';
import { ElModule } from 'element-angular';

import 'rxjs/Rx';

import { UserModule } from './../user/user.module';


import { AppComponent } from './component/app/app.component';
import { LoginComponent } from './component/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    ElModule.forRoot(),
    UserModule,
    RouterModule.forRoot([
      {
        path: '',
        component: LoginComponent
      },

    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class MainModule { }
