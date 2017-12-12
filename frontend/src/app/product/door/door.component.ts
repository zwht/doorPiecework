import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {DoorService} from '../../common/restService/DoorService';
@Component({
  selector: 'app-door',
  templateUrl: './door.component.html',
  styleUrls: ['./door.component.css'],
  providers: [DoorService]
})
export class DoorComponent implements OnInit {

  list = [];

  constructor(private doorService: DoorService,
              private router: Router) {
  }

  ngOnInit() {
    this.getList();
  }

  getList() {
    (this.doorService as any).list({
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
    this.router.navigate(['/admin/product/door/add'], {queryParams: {id: item ? item.id : ''}});
  }

  del(item, k) {
    (this.doorService as any).updateState({
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
