import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {Http, HttpModule, XHRBackend, RequestOptions} from '@angular/http';
import {RouterModule} from '@angular/router';
import { ElModule } from 'element-angular';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { SharedModule } from '../common/shared.module';


import {AppComponent} from './component/app/app.component';
import {mainRoutes, mainComponentList} from './main.routes';


@NgModule({
  declarations: [].concat([AppComponent], mainComponentList),
  imports: [
    ElModule.forRoot(),
    BrowserModule,
    NoopAnimationsModule,
    FormsModule,
    HttpModule,
    SharedModule,
    RouterModule.forRoot(mainRoutes, {useHash: true})
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class MainModule {
}
