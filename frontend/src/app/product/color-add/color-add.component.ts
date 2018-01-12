import {Component, OnInit} from '@angular/core';
import {ColorService} from '../../common/restService/ColorService';
import {Router, ActivatedRoute, Params} from '@angular/router';
@Component({
  selector: 'app-color-add',
  templateUrl: './color-add.component.html',
  styleUrls: ['./color-add.component.less'],
  providers: [ColorService]
})
export class ColorAddComponent implements OnInit {


  color = {
    id: null,
    name: null,
    img: null,
    value: null
  };

  constructor(private colorService: ColorService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit() {
    this.activatedRoute.queryParams.subscribe((params: Params) => {
      this.color.id = params['id'];
      if (this.color.id) {
        this.getById();
      }

    });
  }

  getById() {
    (this.colorService as any).getById(this.color.id)
      .then(response => {
        const rep = (response as any);
        if (rep.code === 200) {
          this.color = rep.data;
        } else {
        }
      });
  }

  save() {
    if (this.color.id) {
      (this.colorService as any).update(this.color)
        .then(response => {
          const rep = (response as any);
          if (rep.code === 200) {
            this.router.navigate(['/admin/product/color']);
          } else {
            console.log(response);
          }
        });
    } else {
      (this.colorService as any).add(this.color)
        .then(response => {
          const rep = (response as any);
          if (rep.code === 200) {
            this.router.navigate(['/admin/product/color']);
          } else {
            console.log(response);
          }
        });
    }

  }


}
