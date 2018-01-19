import {Component, OnInit} from '@angular/core';
import {CorporationService} from '../../../common/restService/CorporationService';
import {Router} from '@angular/router';
@Component({
  selector: 'app-corporation-list',
  templateUrl: './corporation-list.component.html',
  styleUrls: ['./corporation-list.component.css'],
  providers: [CorporationService]
})
export class CorporationListComponent implements OnInit {
  list = [];
  total = 0;
  pageNum = 1;

  constructor(private corporationService: CorporationService,
              private router: Router) {
  }

  ngOnInit() {
    this.getList();
  }

  getList() {
    (this.corporationService as any).list({
      pageNum: this.pageNum,
      pageSize: 10
    }, {})
      .then(response => {
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

  updateState(item, k) {
    (this.corporationService as any).updateState({
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
