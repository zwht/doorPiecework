import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {WorkRoutes, WorkComponents} from './work.routes';
@NgModule({
  imports: [
    CommonModule,
    WorkRoutes
  ],
  declarations: WorkComponents
})
export class WorkModule { }
