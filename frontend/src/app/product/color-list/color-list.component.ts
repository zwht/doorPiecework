import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {ColorService} from '../../common/restService/ColorService';
@Component({
  selector: 'app-color-list',
  templateUrl: './color-list.component.html',
  styleUrls: ['./color-list.component.less'],
  providers: [ColorService]
})
export class ColorListComponent implements OnInit {
  list = [];

  constructor(private colorService: ColorService,
              private router: Router) {
  }

  ngOnInit() {
    this.getList();
  }

  getList() {
    (this.colorService as any).list({
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
    this.router.navigate(['/admin/product/color/add'], {queryParams: {id: item ? item.id : ''}});
  }

  del(id) {
    (this.colorService as any).del(id)
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
