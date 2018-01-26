import {Component, OnInit} from '@angular/core';
import {TicketService} from '../../common/restService/TicketService';
import {Router, ActivatedRoute, Params} from '@angular/router';
import {UserService} from '../../common/restService/UserService';
import {GxService} from '../../common/restService/GxService';
import {DoorService} from '../../common/restService/DoorService';
import {ColorService} from '../../common/restService/ColorService';
import {LineService} from '../../common/restService/LineService';
import {DateSet} from '../../common/service/DateSet';

@Component({
  selector: 'app-ticket-add',
  templateUrl: './ticket-add.component.html',
  styleUrls: ['./ticket-add.component.less'],
  providers: [TicketService, UserService, GxService, DoorService, DateSet,ColorService,LineService]
})
export class TicketAddComponent implements OnInit {
  colorList=[];
  lineList=[];
  changeDate = true;
  userListObj = {3: []};
  ticket = {
    id: null,
    name: null,
    dealersId: null,
    brandId: 1,
    odd: null,
    address: null,
    startTime: null,
    endTime: null,
    createTime: null,
    overTime: null,
    processIds: null,
    corporationId: null,
    state: 0,
    number: 0,
    pay: null
  };
  gxList = [];
  doorList = [];
  emptyDoor = {
    id:null,
    ticketId:null,
    doorId: 0,
    coverWidth: 100,
    coverHeight: 180,
    coverDepth: 70,
    width: 100,
    height: 180,
    sum: 1,
    lbWidth: 100,
    lbHeight: 180,
    lbSum: 2,
    dbWidth: 100,
    dbHeight: 180,
    dbSum: 1,
    lineSum: 1,
    lineLength: 2200,

  };
  productList = [JSON.parse(JSON.stringify(this.emptyDoor))];
  brandList = [
    {
      name: '川峰门业',
      id: 1
    },
    {
      name: '御驰门业',
      id: 2
    }
  ];

  constructor(private ticketService: TicketService,
              private gxService: GxService,
              private colorService: ColorService,
              private doorService: DoorService,
              private lineService:LineService,
              private router: Router,
              private dateSet: DateSet,
              private userService: UserService,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit() {
    this.activatedRoute.queryParams.subscribe((params: Params) => {
      this.ticket.id = params['id'];
      if (this.ticket.id) {
        this.getById();
      }

    });
    this.getUserList();
    this.getDoorList();
    this.getColorList();
    this.getLineList();

  }

  dealersChange(e) {
    this.userListObj[3].forEach(item => {
      if (item.id === e) {
        this.ticket.address = item.address;
      }
    });
  }

  // 复制添加
  copyAdd(item) {
    this.productList.push(JSON.parse(JSON.stringify(item)));
  }

  getById() {
    this.changeDate = false;
    (this.ticketService as any).getById({params: {id: this.ticket.id}})
      .then(response => {
        const rep = (response as any);
        if (rep.code === 200) {
          this.ticket = rep.data;
          this.changeDate = true;
        } else {
        }
      });
  }

  getUserList() {
    (this.userService as any).list({
      params: {
        params2: 1,
        params3: 1000
      }
    })
      .then(response => {
        const rep = (response as any);
        if (rep.code === 200) {
          response.data.data.forEach(item => {
            if (item.roles === '3') {
              this.userListObj['3'].push(item);
            } else if (item.roles === '2') {
              if (!this.userListObj[item.type]) {
                this.userListObj[item.type] = [item];
              } else {
                this.userListObj[item.type].push(item);
              }
            }
          });
          this.getGxList();
        } else {
          console.log(response);
        }
      });
  }

  save() {
    const ticket=JSON.parse(JSON.stringify(this.ticket));
    ticket.startTime = this.dateSet.getDate(ticket.startTime);
    ticket.endTime = this.dateSet.getDate(ticket.endTime);

    if (this.ticket.id) {
      (this.ticketService as any).update({data:ticket})
        .then(response => {
          const rep = (response as any);
          if (rep.code === 200) {
            this.router.navigate(['/admin/product/ticket']);
          } else {
            console.log(response);
          }
        });
    } else {

      (this.ticketService as any).add({data: ticket})
        .then(response => {
          const rep = (response as any);
          if (rep.code === 200) {
            this.productList.forEach(item=>{
              if (!item.id){

              }
            });
            this.router.navigate(['/admin/work/ticket']);
          } else {
            console.log(response);
          }
        });
    }

  }

  getDoorList() {
    (this.doorService as any).list({
      params: {
        params2: 1,
        params3: 1000
      }
    })
      .then(response => {
        const rep = (response as any);
        if (rep.code === 200) {
          this.doorList = response.data.data;
        } else {
          console.log(response);
        }
      });
  }

  getGxList() {
    (this.gxService as any).list({
      params: {
        params2: 1,
        params3: 1000
      }
    })
      .then(response => {
        const rep = (response as any);
        if (rep.code === 200) {
          response.data.data.forEach(item => {
            if (this.userListObj[item.name]) {
              item.userId = this.userListObj[item.name][0].id;
            }
          });
          this.gxList = response.data.data;
        } else {
          console.log(response);
        }
      });
  }
  getColorList() {
    (this.colorService as any).list({
      params: {
        params2: 1,
        params3: 1000
      }
    })
      .then(response => {
        const rep = (response as any);
        if (rep.code === 200) {
          this.colorList = response.data.data;
        } else {
          console.log(response);
        }
      });
  }
  getLineList() {
    (this.lineService as any).list({
      params: {
        params2: 1,
        params3: 1000
      }
    })
      .then(response => {
        const rep = (response as any);
        if (rep.code === 200) {
          this.lineList = response.data.data;
        } else {
          console.log(response);
        }
      });
  }

  // 添加购买产品
  addDoor() {
    this.productList.push(this.emptyDoor);
  }

  // 删除购买产品
  delDoor(i) {
    this.productList.splice(i, 1);
  }

}
