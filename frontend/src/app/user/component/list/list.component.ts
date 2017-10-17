import {Component, OnInit} from '@angular/core';
import {UserService} from './../../service/UserService';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css'],
  providers: [UserService]
})
export class ListComponent implements OnInit {

  constructor(private userService: UserService) {
  }

  ngOnInit() {
    this.getUserList();
  }

  getUserList() {
    //this.userService.getUserList("zw","123456");
  }

}
