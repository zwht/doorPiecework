import {Component, OnInit} from '@angular/core';
import {TicketService} from '../../common/restService/TicketService';
import {Router, ActivatedRoute, Params} from '@angular/router';
import {UserService} from '../../common/restService/UserService';
import {GxService} from '../../common/restService/GxService';
import {DoorService} from '../../common/restService/DoorService';
import {ColorService} from '../../common/restService/ColorService';
import {LineService} from '../../common/restService/LineService';
import {ProductService} from '../../common/restService/ProductService';
import {ProcessService} from '../../common/restService/ProcessService';
import {DateSet} from '../../common/service/DateSet';
import { ElMessageService } from 'element-angular'

@Component({
  selector: 'app-ticket-print',
  templateUrl: './ticket-print.component.html',
  styleUrls: ['./ticket-print.component.less'],
  providers: [ProcessService,ProductService, TicketService, UserService, GxService, DoorService, DateSet, ColorService, LineService]
})
export class TicketPrintComponent implements OnInit {
  printCSS: string[];
  printStyle: string;
  printBtnBoolean = true;
  printItem = {
    id:null,
    contact:null,
    address:null,
    idcard:null,
    contacttel:null,
    licenseplate:null,
    cartype:null

  };


  toggle=false;
  colorList = [];
  colorListObj = {};
  lineList = [];
  lineListObj = {};
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
    pay: null,
    sumDoor:null,
    sumTaoban:null,
    sumLine:null
  };
  gxList = [];
  gxListObj = {};
  doorList = [];
  doorListObj = {};
  emptyDoor = {
    id: null,
    ticketId: null,
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
  getDataKey = 0;

  constructor(private ticketService: TicketService,
              private gxService: GxService,
              private colorService: ColorService,
              private doorService: DoorService,
              private lineService: LineService,
              private productService: ProductService,
              private processService: ProcessService,
              private router: Router,
              private message: ElMessageService,
              private dateSet: DateSet,
              private userService: UserService,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit() {
    const thant = this;

    function init() {
      thant.getDataKey++;
      if (thant.getDataKey == 4) {
        thant.activatedRoute.queryParams.subscribe((params: Params) => {
          thant.ticket.id = params['id'];
          if (thant.ticket.id) {
            thant.getById();
            thant.getProductList();
            thant.getProcessList();
          }
        });
      }
    }

    this.getUserList(init);
    this.getDoorList(init);
    this.getColorList(init);
    this.getLineList(init);

  }

  printComplete() {

    this.printBtnBoolean = true;
  }

  beforePrint(item) {
    this.printItem=item;
    this.printBtnBoolean = false;
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

  getProductList() {
    this.productService['list']({
      params: {
        params2: 1,
        params3: 100
      },
      data: {ticketId: this.ticket.id}
    })
      .then(rep => {
        if (rep.data.data && rep.data.data.length) {
          rep.data.data.forEach(item => {
            if (item.doorId && item.doorId != '0') item.doorImg = this.doorListObj[item.doorId].img;
            if (item.colorId && item.colorId != '0') item.colorImg = this.colorListObj[item.colorId].img;
            if (item.lineId && item.lineId != '0') item.lineImg = this.lineListObj[item.lineId].img;
          });
          this.productList = rep.data.data;
        }
      })
  }
  getProcessList(){
    this.processService['list']({
      params: {
        params2: 1,
        params3: 100
      },
      data: {ticketId: this.ticket.id}
    })
      .then(rep => {
        if (rep.data.data && rep.data.data.length) {
          rep.data.data.forEach(item => {
            this.gxList.forEach(obj=>{
              if(item.gxId==obj.id){
                obj.processId=item.id;
                obj.price=item.price;
                obj.userId=item.userId;
              }
            });
          });
        }
      })
  }

  getUserList(callBack) {
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
            } else if (item.roles === '4') {
              if (!this.userListObj[item.type]) {
                this.userListObj[item.type] = [item];
              } else {
                this.userListObj[item.type].push(item);
              }
            }
          });
          this.getGxList(callBack);
        } else {
          console.log(response);
        }
      });
  }

  getDoorList(callBack) {
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
          this.doorList.forEach(item => {
            this.doorListObj[item.id] = item;
          })

        } else {
          console.log(response);
        }
        callBack();
      });
  }

  getGxList(callBack) {
    (this.gxService as any).list({
      params: {
        params2: 1,
        params3: 1000
      }
    })
      .then(response => {
        callBack();
        const rep = (response as any);
        if (rep.code === 200) {
          response.data.data.forEach(item => {
            if (this.userListObj[item.name]) {
              item.userId = this.userListObj[item.name][0].id;
            }
          });

          this.gxList = response.data.data;
          this.gxList.forEach(item => {
            item.price=0;
            this.gxListObj[item.id] = item;
          });
        } else {
          console.log(response);
        }
      });
  }

  getColorList(callBack) {
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
          this.colorList.forEach(item => {
            this.colorListObj[item.id] = item;
          })
        } else {
          console.log(response);
        }
        callBack();
      });
  }

  getLineList(callBack) {
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
          this.lineList.forEach(item => {
            this.lineListObj[item.id] = item;
          })
        } else {
          console.log(response);
        }
        callBack();
      });
  }

  print(){
    this.router.navigate(['/admin/work/ticket/print'], {queryParams: {id: this.ticket.id}});
  }

}
