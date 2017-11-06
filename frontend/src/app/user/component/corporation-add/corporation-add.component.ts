import {Component, OnInit} from '@angular/core';
import {CorporationService} from './../../service/CorporationService';
import {Router} from '@angular/router';
@Component({
  selector: 'app-corporation-add',
  templateUrl: './corporation-add.component.html',
  styleUrls: ['./corporation-add.component.css'],
  providers: [CorporationService]
})
export class CorporationAddComponent implements OnInit {
  component = {
    name: null,
    address: null
  };

  constructor(private corporationService: CorporationService,
              private router: Router) {
  }

  ngOnInit() {
  }

  save() {
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
