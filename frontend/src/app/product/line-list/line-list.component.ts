import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {LineService} from '../../common/restService/LineService';
@Component({
  selector: 'app-line-list',
  templateUrl: './line-list.component.html',
  styleUrls: ['./line-list.component.less'],
  providers: [LineService]
})
export class LineListComponent implements OnInit {
  list = [];

  constructor(private lineService: LineService,
              private router: Router) {
  }

  ngOnInit() {
    this.getList();
  }

  getList() {
    (this.lineService as any).list({
      pageNum: 1,
      pageSize: 10
    }, {})
      .then(response => {
        const rep = (response as any);
        if (rep.code === 200) {
          this.list = response.data.data;
        } else {
          console.log(response);
        }
      });
  }

  add(item) {
    this.router.navigate(['/admin/product/line/add'], {queryParams: {id: item ? item.id : ''}});
  }

  del(item, k) {
    (this.lineService as any).updateState({
      id: item.id,
      state: k
    })
      .then(response => {
        const rep = (response as any);
        if (rep.code === 200) {
          this.getList();
        } else {
          console.log(response);
        }
      });
  }

}
