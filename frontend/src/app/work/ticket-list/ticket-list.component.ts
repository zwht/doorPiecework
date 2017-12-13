import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {TicketService} from '../../common/restService/TicketService';
@Component({
  selector: 'app-ticket-list',
  templateUrl: './ticket-list.component.html',
  styleUrls: ['./ticket-list.component.css'],
  providers: [TicketService]
})
export class TicketListComponent implements OnInit {

  list = [];

  constructor(private ticketService: TicketService,
              private router: Router) {
  }

  ngOnInit() {
    this.getList();
  }

  getList() {
    (this.ticketService as any).list({
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

  add(item) {
    this.router.navigate(['/admin/work/ticket/add'], {queryParams: {id: item ? item.id : ''}});
  }

  del(item, k) {
    (this.ticketService as any).updateState({
      id: item.id,
      state: k
    })
      .then(response => {
        const rep = (response as any);
        if (rep.code === 200) {
          this.getList();
        } else {
          console.log(response);
        }
      });
  }

}
