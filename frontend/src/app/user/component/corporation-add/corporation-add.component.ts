import {Component, OnInit} from '@angular/core';
import {CorporationService} from '../../../common/restService/CorporationService';
import {Router, ActivatedRoute, Params} from '@angular/router';
@Component({
  selector: 'app-corporation-add',
  templateUrl: './corporation-add.component.html',
  styleUrls: ['./corporation-add.component.css'],
  providers: [CorporationService]
})
export class CorporationAddComponent implements OnInit {
  component = {
    id: null,
    name: null,
    address: null
  };

  constructor(private corporationService: CorporationService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit() {
    this.activatedRoute.queryParams.subscribe((params: Params) => {
      this.component.id = params['id'];
      this.getById();

    });
  }

  getById() {
    (this.corporationService as any).getById(this.component.id)
      .then(response => {
        const rep = (response as any);
        if (rep.code === 200) {
          this.component = rep.data;
        } else {
        }
      });
  }

  save() {
    if (this.component.id) {
      (this.corporationService as any).update(this.component)
        .then(response => {
          const rep = (response as any);
          if (rep.code === 200) {
            this.router.navigate(['/admin/user/company']);
          } else {
            console.log(response);
          }
        });
    } else {
      (this.corporationService as any).add(this.component)
        .then(response => {
          const rep = (response as any);
          if (rep.code === 200) {
            this.router.navigate(['/admin/user/company']);
          } else {
            console.log(response);
          }
        });
    }

  }

}
