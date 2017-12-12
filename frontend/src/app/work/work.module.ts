import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {WorkRoutes, WorkComponents} from './work.routes';
import { ElModule } from 'element-angular';
@NgModule({
  imports: [
    ElModule.forRoot(),
    CommonModule,
    WorkRoutes
  ],
  declarations: WorkComponents
})
export class WorkModule { }
