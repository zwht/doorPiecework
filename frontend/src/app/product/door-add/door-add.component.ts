import {Component, OnInit} from '@angular/core';
import {DoorService} from '../../common/restService/DoorService';
import {Router, ActivatedRoute, Params} from '@angular/router';
@Component({
  selector: 'app-door-add',
  templateUrl: './door-add.component.html',
  styleUrls: ['./door-add.component.css'],
  providers: [DoorService]
})
export class DoorAddComponent implements OnInit {

  door = {
    id: null,
    name: null,
    img: null,
    gxids: null,
    createTime: null,
    state: 0
  };

  constructor(private doorService: DoorService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit() {
    this.activatedRoute.queryParams.subscribe((params: Params) => {
      this.door.id = params['id'];
      this.getById();

    });
  }

  getById() {
    (this.doorService as any).getById(this.door.id)
      .then(response => {
        const rep = (response as any);
        if (rep.code === 200) {
          this.door = rep.data;
        } else {
        }
      });
  }

  save() {
    if (this.door.id) {
      (this.doorService as any).update(this.door)
        .then(response => {
          const rep = (response as any);
          if (rep.code === 200) {
            this.router.navigate(['/admin/product/door']);
          } else {
            console.log(response);
          }
        });
    } else {
      (this.doorService as any).add(this.door)
        .then(response => {
          const rep = (response as any);
          if (rep.code === 200) {
            this.router.navigate(['/admin/product/door']);
          } else {
            console.log(response);
          }
        });
    }

  }

}
