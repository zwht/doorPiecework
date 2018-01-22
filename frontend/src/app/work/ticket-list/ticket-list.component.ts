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
  loading = false;
  list = [];
  total = 0;
  pageNum = 1;

  constructor(private ticketService: TicketService,
              private router: Router) {
  }

  ngOnInit() {
    this.getList();
  }

  getList() {
    this.loading = true;
    (this.ticketService as any).list({
      pageNum: this.pageNum,
      pageSize: 10
    }, {})
      .then(response => {
        this.loading = false;
        const rep = (response as any);
        if (rep.code === 200) {
          this.total = response.data.pageCount;
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
