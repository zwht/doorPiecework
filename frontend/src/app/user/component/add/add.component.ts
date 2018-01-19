import {Component, OnInit} from '@angular/core';
import {UserService} from '../../../common/restService/UserService';
import {GxService} from '../../../common/restService/GxService';
import {Router} from '@angular/router';
@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css'],
  providers: [UserService, GxService]
})
export class AddComponent implements OnInit {
  gxList = [];
  user = {
    name: null,
    password: null,
    phone: null,
    loginName: null,
    type: '',
    roles: null,
    state: 1,
    address: null
  };

  constructor(private userService: UserService,
              private gxService: GxService,
              private router: Router) {
  }

  ngOnInit() {
    this.getGxList();
  }

  handle(event: any): void {
    this.user.type = event;
  }

  getGxList() {
    (this.gxService as any).list({
      pageNum: 1,
      pageSize: 50
    }, {})
      .then(response => {
        const rep = (response as any);
        if (rep.code === 200) {
          this.gxList = response.data.data;
        } else {
          console.log(response);
        }
      });
  }

  save() {
    (this.userService as any).add(this.user)
      .then(response => {
        const rep = (response as any);
        if (rep.code === 200) {
          this.router.navigate(['/admin/user/list']);
        } else {
          console.log(response);
        }
      });
  }


}
