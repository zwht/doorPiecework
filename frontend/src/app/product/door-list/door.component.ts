import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {DoorService} from '../../common/restService/DoorService';
@Component({
  selector: 'app-door',
  templateUrl: './door.component.html',
  styleUrls: ['./door.component.less'],
  providers: [DoorService]
})
export class DoorComponent implements OnInit {

  list = [];
  total = 0;
  pageNum = 1;

  constructor(private doorService: DoorService,
              private router: Router) {
  }

  ngOnInit() {
    this.getList();
  }

  getList() {
    (this.doorService as any).list({
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
    this.router.navigate(['/admin/product/door/add'], {queryParams: {id: item ? item.id : ''}});
  }

  del(id) {
    (this.doorService as any).del(id)
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
