import {Component, OnInit} from '@angular/core';
import {CorporationService} from './../../service/CorporationService';
import {Router} from '@angular/router';
@Component({
  selector: 'app-corporation-list',
  templateUrl: './corporation-list.component.html',
  styleUrls: ['./corporation-list.component.css'],
  providers: [CorporationService]
})
export class CorporationListComponent implements OnInit {
  list = [];

  constructor(private corporationService: CorporationService,
              private router: Router) {
  }

  ngOnInit() {
    this.getList();
  }

  getList() {
    (this.corporationService as any).list({
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
    this.router.navigate(['/admin/user/company/add']);
  }

  del(item) {
    (this.corporationService as any).del(item.id)
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
