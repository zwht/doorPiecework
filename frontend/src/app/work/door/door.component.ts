import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
@Component({
  selector: 'app-door',
  templateUrl: './door.component.html',
  styleUrls: ['./door.component.css']
})
export class DoorComponent implements OnInit {

  img=""
  constructor(private router: Router) {
  }

  ngOnInit() {

  }

  saveEnd(data,hhh) {
    this.img=data.url;
  }

}
