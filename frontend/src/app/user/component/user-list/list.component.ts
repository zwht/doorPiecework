import {Component, OnInit} from '@angular/core';
import {UserService} from '../../../common/restService/UserService';
import {Router} from '@angular/router';
@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css'],
  providers: [UserService]
})
export class ListComponent implements OnInit {
  list = [];

  constructor(private userService: UserService,
              private router: Router) {
  }

  ngOnInit() {
    this.getList();
  }

  add(item) {
    this.router.navigate(['/admin/user/add'], {queryParams: {id: item ? item.id : ''}});
  }

  getList() {
    (this.userService as any).list({
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

  del(id) {
    (this.userService as any).del(id)
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
