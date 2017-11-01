import {Component, OnInit} from '@angular/core';
import {CorporationService} from './../../service/CorporationService';

@Component({
  selector: 'app-corporation-list',
  templateUrl: './corporation-list.component.html',
  styleUrls: ['./corporation-list.component.css'],
  providers: [CorporationService]
})
export class CorporationListComponent implements OnInit {
  list = [];

  constructor(private corporationService: CorporationService) {
  }

  ngOnInit() {
    this.getList();
  }
  getList() {
    (this.corporationService as any).list({
      pageNum: 1,
      pageSize: 10
    }, {name:'日本人'})
      .then(response => {
        const rep = (response as any);
        if (rep.code === 200) {
          this.list = response.data.data;
        } else {
          console.log(response);
        }
      });
  }

}
