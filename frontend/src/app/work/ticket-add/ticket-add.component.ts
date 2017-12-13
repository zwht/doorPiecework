import {Component, OnInit} from '@angular/core';
import {TicketService} from '../../common/restService/TicketService';
import {Router, ActivatedRoute, Params} from '@angular/router';
@Component({
  selector: 'app-ticket-add',
  templateUrl: './ticket-add.component.html',
  styleUrls: ['./ticket-add.component.css'],
  providers: [TicketService]
})
export class TicketAddComponent implements OnInit {


  ticket = {
    id: null,
    name: "999",
    price: null,
    type: null,
    state: 0
  };

  constructor(private ticketService: TicketService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit() {
    this.activatedRoute.queryParams.subscribe((params: Params) => {
      this.ticket.id = params['id'];
      if (this.ticket.id) {
        this.getById();
      }

    });
  }

  getById() {
    (this.ticketService as any).getById(this.ticket.id)
      .then(response => {
        const rep = (response as any);
        if (rep.code === 200) {
          this.ticket = rep.data;
        } else {
        }
      });
  }

  save() {
    if (this.ticket.id) {
      (this.ticketService as any).update(this.ticket)
        .then(response => {
          const rep = (response as any);
          if (rep.code === 200) {
            this.router.navigate(['/admin/product/ticket']);
          } else {
            console.log(response);
          }
        });
    } else {
      (this.ticketService as any).add(this.ticket)
        .then(response => {
          const rep = (response as any);
          if (rep.code === 200) {
            this.router.navigate(['/admin/work/ticket']);
          } else {
            console.log(response);
          }
        });
    }

  }

}
