import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {GxService} from '../../common/restService/GxService';
@Component({
  selector: 'app-gx-list',
  templateUrl: './gx-list.component.html',
  styleUrls: ['./gx-list.component.css'],
  providers: [GxService]
})
export class GxListComponent implements OnInit {

  list = [];

  constructor(private gxService: GxService,
              private router: Router) {
  }

  ngOnInit() {
    this.getList();
  }

  getList() {
    (this.gxService as any).list({
      pageNum: 1,
      pageSize: 50
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
    this.router.navigate(['/admin/product/gx/add'], {queryParams: {id: item ? item.id : ''}});
  }

  del(id) {
    (this.gxService as any).del(id)
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
