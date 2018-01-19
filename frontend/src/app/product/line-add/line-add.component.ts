import {Component, OnInit} from '@angular/core';
import {LineService} from '../../common/restService/LineService';
import {Router, ActivatedRoute, Params} from '@angular/router';
@Component({
  selector: 'app-line-add',
  templateUrl: './line-add.component.html',
  styleUrls: ['./line-add.component.less'],
  providers: [LineService]
})
export class LineAddComponent implements OnInit {


  line = {
    id: null,
    name: null,
    img: null,
    value: null
  };

  constructor(private lineService: LineService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit() {
    this.activatedRoute.queryParams.subscribe((params: Params) => {
      this.line.id = params['id'];
      if (this.line.id) {
        this.getById();
      }

    });
  }
  imageChange(data) {
    this.line.img = data.url;
  }
  getById() {
    (this.lineService as any).getById(this.line.id)
      .then(response => {
        const rep = (response as any);
        if (rep.code === 200) {
          this.line = rep.data;
        } else {
        }
      });
  }

  save() {
    if (this.line.id) {
      (this.lineService as any).update(this.line)
        .then(response => {
          const rep = (response as any);
          if (rep.code === 200) {
            this.router.navigate(['/admin/product/line']);
          } else {
            console.log(response);
          }
        });
    } else {
      (this.lineService as any).add(this.line)
        .then(response => {
          const rep = (response as any);
          if (rep.code === 200) {
            this.router.navigate(['/admin/product/line']);
          } else {
            console.log(response);
          }
        });
    }

  }


}
