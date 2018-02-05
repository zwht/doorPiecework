import { Component, OnInit } from '@angular/core';
import {ProcessService} from '../../common/restService/ProcessService';
import {Router} from '@angular/router';
import {DateSet} from '../../common/service/DateSet';
@Component({
  selector: 'app-salary',
  templateUrl: './salary.component.html',
  styleUrls: ['./salary.component.less'],
  providers: [ProcessService]
})
export class SalaryComponent implements OnInit {
  search={
    startTime:(new Date())-86400000*30,
    endTime:(new Date())-1,
  };
  list = [];
  total = 0;
  pageSize=20;
  pageNum = 1;
  loading = false;


  constructor(private processService: ProcessService,
              private router: Router,
              private dateSet: DateSet
  ) {
  }

  ngOnInit() {
    this.getList();
  }

  getList() {
    this.loading = true;
    (this.processService as any).list({
      params: {
        params2: this.pageNum,
        params3: this.pageSize
      },
      data:{
        startTime:this.dateSet.getDate1(this.search.startTime),
        endTime:this.dateSet.getDate1(this.search.endTime)+86400000
      }
    })
      .then(response => {
        this.loading = false;
        const rep = (response as any);
        if (rep.code === 200) {
          this.total = response.data.pageCount;
          this.list = response.data.data;
        } else {
          console.log(response);
        }
      });
  }

  add(item) {
    this.router.navigate(['/admin/user/company/add'], {queryParams: {id: item ? item.id : ''}});
  }


}
