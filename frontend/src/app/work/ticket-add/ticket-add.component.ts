import {Component, OnInit} from '@angular/core';
import {TicketService} from '../../common/restService/TicketService';
import {Router, ActivatedRoute, Params} from '@angular/router';
import {UserService} from '../../common/restService/UserService';
import {GxService} from '../../common/restService/GxService';
import {DoorService} from '../../common/restService/DoorService';
import {ColorService} from '../../common/restService/ColorService';
import {LineService} from '../../common/restService/LineService';
import {ProductService} from '../../common/restService/ProductService';
import {DateSet} from '../../common/service/DateSet';

@Component({
  selector: 'app-ticket-add',
  templateUrl: './ticket-add.component.html',
  styleUrls: ['./ticket-add.component.less'],
  providers: [ProductService, TicketService, UserService, GxService, DoorService, DateSet, ColorService, LineService]
})
export class TicketAddComponent implements OnInit {
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
    pay: null
  };
  emptyProduct = {
    id:null,
    name:null,
    doorId:null,
    doorImg:null,
    processIds:null,
    img:null,
    mark:null,
    startTime:null,
    endTime:null,
    corporationId:null,
    coverWidth:null,
    coverHeight:null,
    coverDepth:null,
    widht:null,
    height:null,
    lbWidth:null,
    lbHeight:null,
    dbWidth:null,
    dbHeight:null,
    colorId:null,
    colorImg:null,
    lineId:null,
    lineImg:null,
    lineSum:null,
    productcol:null,
    type:null,
    isModule:null,
    moduleId:null,
    state:null,
    lbSum:null,
    dbSum:null,
    sum:null,
    lineLength:null,
    ticketId:null
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
  stat = {
    doors: 0,
    doorT: 0,
    lines: 0
  };
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
  getDataKey=0;

  constructor(private ticketService: TicketService,
              private gxService: GxService,
              private colorService: ColorService,
              private doorService: DoorService,
              private lineService: LineService,
              private productService: ProductService,
              private router: Router,
              private dateSet: DateSet,
              private userService: UserService,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit() {
    const thant=this;
    function init(){
      thant.getDataKey++;
      if(thant.getDataKey==3){
        thant.activatedRoute.queryParams.subscribe((params: Params) => {
          thant.ticket.id = params['id'];
          if (thant.ticket.id) {
            thant.getById();
            thant.getProductList();
          }
        });
      }
    }
    this.getUserList();
    this.getDoorList(init);
    this.getColorList(init);
    this.getLineList(init);

  }

  doorChange(e,it) {
    if(e&&it) it.doorImg=this.doorListObj[e].img;
    this.gxList.forEach(item => {
      item.values = 0;
    });
    this.stat = {
      doors: 0,
      doorT: 0,
      lines: 0
    };
    setTimeout(() => {
      this.productList.forEach(item => {
        if (!item.doorId||item.doorId=='0') return;
        item.doorObj = this.doorListObj[item.doorId];
        this.stat.doors += 1;
        this.stat.doorT += 1;
        this.stat.lines += item.lineSum;
        item.doorObj.gx.forEach(fuck => {
          this.gxList.forEach(fuck1 => {
            if (fuck.id == fuck1.id) fuck1.values += fuck.price;
          });

        })
      });
    }, 100);


  }

  dealersChange(e) {
    this.userListObj[3].forEach(item => {
      if (item.id === e) {
        this.ticket.address = item.address;
      }
    });
  }
  colorChange(e,item){
    item.colorImg=this.colorListObj[e].img;
  }
  lineChange(e,item){
    item.lineImg=this.lineListObj[e].img;
  }

  // 复制添加
  copyAdd(item) {
    this.productList.push(JSON.parse(JSON.stringify(item)));
    this.doorChange();
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
  getProductList(){
    this.productService['list']({
      params: {
        params2: 1,
        params3: 100
      },
      data: {ticketId:this.ticket.id}
    })
      .then(rep => {
        if(rep.data.data&&rep.data.data.length){
          rep.data.data.forEach(item=>{
            if(item.doorId&&item.doorId!='0')item.doorImg=this.doorListObj[item.doorId].img;
            if(item.colorId&&item.colorId!='0')item.colorImg=this.colorListObj[item.colorId].img;
            if(item.lineId&&item.lineId!='0')item.lineImg=this.lineListObj[item.lineId].img;
          });
          this.productList=rep.data.data;
        }
        this.doorChange();
      })
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


  saveProduct(){
    const that=this;
    this.productService['addList']({
      data: {
        ticketId: this.ticket.id,
        products: this.productList
      }
    })
      .then(rep => {
        that.getProductList();
      })
  }
  save() {
    const ticket = JSON.parse(JSON.stringify(this.ticket));
    ticket.startTime = this.dateSet.getDate(ticket.startTime);
    ticket.endTime = this.dateSet.getDate(ticket.endTime);

    if (this.ticket.id) {
      (this.ticketService as any).update({data: ticket})
        .then(response => {
          const rep = (response as any);
          if (rep.code === 200) {
            this.router.navigate(['/admin/work/ticket/add'], {queryParams: {id: this.ticket.id}});
            this.saveProduct();
          } else {
            console.log(response);
          }
        });


    } else {

      (this.ticketService as any).add({data: ticket})
        .then(response => {
          const rep = (response as any);
          if (rep.code === 200) {
            this.ticket = rep.data;
            this.router.navigate(['/admin/work/ticket/add'], {queryParams: {id: this.ticket.id}});
            this.saveProduct();
          } else {
            console.log(response);
          }
        });
    }

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
          this.gxList.forEach(item=>{
            this.gxListObj[item.id]=item;
          })
          this.doorChange();
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
          this.colorList.forEach(item=>{
            this.colorListObj[item.id]=item;
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
          this.lineList.forEach(item=>{
            this.lineListObj[item.id]=item;
          })
        } else {
          console.log(response);
        }
        callBack();
      });
  }

  // 添加购买产品
  addDoor() {
    this.productList.push(JSON.parse(JSON.stringify(this.emptyDoor)));
    this.doorChange();
  }

  // 删除购买产品
  delDoor(item,i) {

    if(item.id){
      this.productService['del']({
        params:{id:item.id}
      })
        .then(rep => {
          this.productList.splice(i, 1);
        })
    }else{
      this.productList.splice(i, 1);
    }
    this.doorChange();
  }

}
