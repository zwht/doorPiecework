import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
@Component({
  selector: 'app-door',
  templateUrl: './door.component.html',
  styleUrls: ['./door.component.css']
})
export class DoorComponent implements OnInit {

  constructor( private router: Router) {
  }

  ngOnInit() {
  }

  go() {
    this.router.navigateByUrl('/work/door');
  }

}
