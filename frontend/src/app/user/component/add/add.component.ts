import {Component, OnInit} from '@angular/core';
import {UserService} from './../../service/UserService';
import {Router} from '@angular/router';
@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css'],
  providers: [UserService]
})
export class AddComponent implements OnInit {
  user = {
    name: null,
    password: null,
    phone: null,
    loginName: null,
    type: null,
    roles: null,
    state:1
  };

  constructor(private userService: UserService,
              private router: Router) {
  }

  ngOnInit() {
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
