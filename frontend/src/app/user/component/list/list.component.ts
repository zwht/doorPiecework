import {Component, OnInit} from '@angular/core';
import {UserService} from './../../service/UserService';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css'],
  providers: [UserService]
})
export class ListComponent implements OnInit {
  list = [];

  constructor(private userService: UserService) {
  }

  ngOnInit() {
    this.getUserList();
  }

  getUserList() {
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

}
