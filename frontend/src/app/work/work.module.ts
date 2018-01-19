import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ElModule } from 'element-angular';

import {WorkRoutes, WorkComponents} from './work.routes';
import { SharedModule } from '../common/shared.module';

@NgModule({
  imports: [
    ElModule.forRoot(),
    SharedModule,
    CommonModule,
    WorkRoutes
  ],
  declarations: WorkComponents,
  providers: [],
})
export class WorkModule { }
