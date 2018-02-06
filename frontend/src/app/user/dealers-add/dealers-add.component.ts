import {Component, OnInit} from '@angular/core';
import {UserService} from '../../common/restService/UserService';
import {GxService} from '../../common/restService/GxService';
import {Router, ActivatedRoute, Params} from '@angular/router';
@Component({
  selector: 'app-dealers-add',
  templateUrl: './dealers-add.component.html',
  styleUrls: ['./dealers-add.component.less'],
  providers: [UserService, GxService]
})
export class DealersAddComponent implements OnInit {
  title='';
  gxList = [];
  user = {
    id: null,
    name: null,
    password: null,
    phone: null,
    loginName: null,
    type: null,
    roles: 3,
    state: 1,
    address: null
  };

  constructor(private userService: UserService,
              private gxService: GxService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit() {
    this.activatedRoute.queryParams.subscribe((params: Params) => {
      this.user.id = params['id'];
      if (this.user.id) {
        this.getById();
      }

    });

    this.getGxList();
  }

  getById() {
    (this.userService as any).getById({params: {id: this.user.id}})
      .then(response => {
        const rep = (response as any);
        if (rep.code === 200) {
          this.user = rep.data;
        } else {
        }
      });
  }

  handle(event: any): void {
    this.user.type = event;
  }

  getGxList() {
    (this.gxService as any).list({
      params: {
        params2: 1,
        params3: 1000
      }
    })
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
    if (this.user.id) {
      this.user.password=null;
      (this.userService as any).update({data: this.user})
        .then(response => {
          const rep = (response as any);
          if (rep.code === 200) {
            this.router.navigate(['/admin/user/list']);
          } else {
            console.log(response);
          }
        });
    } else {
      (this.userService as any).add({data: this.user})
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

}
