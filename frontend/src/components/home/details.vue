<template lang='jade'>
  .device-details
    Breadcrumb(style="font-size:12px;")
      Breadcrumb-item 用户详情
      Breadcrumb-item(v-text="details.userName")
    .device
      .left
        Card(:dis-hover="true")
          Form(:label-width="75")
            Form-item
              img(src="details.userPhoto" v-on:error='errorFn' width="80")
            Form-item(label="用户名")
              span(v-text="details.userName")
            Form-item(label="指静脉号")
              span(v-text="details.fingerPrint")
            Form-item(label="身份证号")
              span(v-text="details.identityId")
            Form-item(label="审核状态")
              span(v-text="!details.reviewState?'待审核':details.reviewState===1?'审核通过':'审核不通过'")
            Form-item(label="审核时间")
              span(v-text="details.reviewTime")
            Form-item(label="审核人")
              span(v-text="details.reviewer")
            Form-item(label="创建时间")
              span(v-text="details.createTime")
            Form-item(label="更新时间")
              span(v-text="details.updateTime")
            Form-item(label="采集终端")
              span(v-text="details.terminalId")
      .right
        p.auth
          span 授权详情
          span
            Btn(type="ghost" v-on:click="updateListFn" style="margin-right:8px") 更新设备有效期
            Btn(type="ghost" v-bind:loading="addLoading" v-on:click="deviceListFn") 添加设备
        Tab(:columns="columns" v-bind:data="list" v-show="!loading" v-on:on-selection-change="(s)=>{selection=s}")
          Btn(type="primary" slot="footer" style="margin-left:8px" v-bind:disabled="!selection.length" v-on:click="removeAuth") 取消授权
        Loading(v-show="loading")
        Page(:total="pageTotal" v-on:on-change="pageChange" v-show="showPage")
        Modal(v-model="modal" v-bind:title="modalTitle" v-on:on-ok="ok" loading)
          Date-picker(type="datetimerange" placeholder="请选择授权有效期" style="width: 300px;margin-bottom:10px" v-bind:editable="false" v-bind:options="{disabledDate:(d)=>d && d.valueOf() < Date.now() - 86400000}" v-on:on-change="(s)=>{date=s.split(' - ')}" v-model="date")
          Transfer(v-bind:data="deviceList" v-bind:render-format="render" v-bind:target-keys="targetKeys" v-on:on-change="TransferChange" v-bind:titles="['设备列表','已选设备列表']")
          div(slot="footer")
            Button(type="ghost" v-on:click="modal=false") 取消
            Btn(type="primary" v-on:click="ok" v-bind:loading="modalLoading" v-bind:class="{disabled:canOk}") 确定
</template>
<script>
  import head from 'asts/images/default.jpeg';
  import userServer from 'rs/user'
  import deviceServer from 'rs/device'
  import authServer from 'rs/auth'
  export default {
    data() {
      return {
        modalLoading:false,
        selection:[],
        date:[],
        modal:false,
        modalTitle:'',
        addLoading:false,
        details:{},
        loading:false,
        list:[],
        columns:[
          {
            type: 'selection',
            width: 60,
            align: 'center'
          },
//          {
//            title:"设备ID",
//            key:"deviceId"
//          },
          {
            title:"设备编号",
            key:"deviceNo"
          },
          {
            title:"设备地址",
            key:"deviceAddress"
          },
          {
            title:"开始时间",
            key:"startTime"
          },
          {
            title:"结束时间",
            key:"endTime"
          }
        ],
        pageSize:10,
        pageTotal:0,
        pageCurrent:0,
        deviceList:[],//设备列表
        targetKeys:[]
      }
    },
    created() {
      this.init();
    },
    directives: {

    },
    computed: {
      showPage(){
        return this.pageTotal>this.pageSize;
      },
      canOk(){
        return !(this.date.length&&this.targetKeys.length)
      }
    },
    filters: {
    },
    methods: {
      init(){
        let id =this.$route.params.id;
        userServer.select({params2:id},{},res=>{
          this.details=res.data;
        });
        this.getList();
      },
      getList(){
        this.loading=true;
        let id =this.$route.params.id,o ={authUserId:id};
        authServer.list({params2:this.pageCurrent,params3:this.pageSize},o,res=>{
          this.list =res.data.content;
          this.list.forEach((l,i)=>{l.key=i+''});
          this.loading=false;
          this.pageTotal =res.data.total;
        },()=>{this.loading=false});
      },
      pageChange(p){
        this.pageCurrent=p-1;
        this.getList();
      },
      //img加载失败
      errorFn(e){
        e.target.src=head;
      },
      //添加设备按钮
      deviceListFn(){
        this.addLoading=true;
        deviceServer.list({params2:0,params3:99999},{},res=>{
          this.deviceList=res.data.content.filter(l=>this.list.findIndex(li=>li.deviceId===l.id)===-1);
          this.deviceList.forEach((l,i)=>{l.key=i+'',l.deviceId=l.id});
          this.modalTitle='添加设备';
          this.addLoading=false;
          this.modal=true;
        },()=>{this.addLoading=false});
      },
      //更新设备有效期按钮
      updateListFn(){
        this.deviceList=this.list;
        this.modalTitle='更新设备有效期';
        this.modal=true;
      },
      //modal --ok
      ok(){
        if(this.canOk){
          this.$Message.error('授权有效期和已选设备列表不能为空');
          return
        }
        this.modalLoading=true;
        let date=this.date;
        let ids=this.deviceList.filter((l)=>this.targetKeys.includes(l.key)).map(l=>l.deviceId);
        let id =this.$route.params.id;
        authServer.addOrUpdate({},{
          newUserId:id,
          deviceIdList:ids,
          startTime:date[0],
          endTime:date[1]
        },()=>{
          this.modal=false;
          this.$Message.success('操作成功');
          this.targetKeys=[];
          this.modalLoading=false;
          this.date=[];
          this.getList();
        },()=>{this.$Message.error('操作失败');this.modal=false;this.modalLoading=false;});
      },
      //穿梭框format
      render(item){
        return item.deviceNumber||item.deviceNo
      },
      TransferChange(t){
        this.targetKeys=t;
      },
      //取消授权
      removeAuth(){
        let id =this.$route.params.id;
        let ids =this.selection.map(l=>l.deviceId);
        authServer.delete({},{
          newUserId:id,
          deviceIdList:ids,
          startTime:'',//后端接口没改，其实不需要传的
          endTime:''
        },()=>{this.$Message.success('删除成功');this.getList();this.selection=[]},()=>{this.$Message.error('删除失败')});
      }
    }
  };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang='less'>
  .device-details{
    height: calc(~"100% - 18px");
    .device{
      display: flex;
      height: 100%;
      >div{
        height: 100%;
        overflow: auto;
      }
      .left{
        flex-shrink:0;
        flex-basis: 30%;
        min-width: 350px;
        padding-top:100px;
        padding-right: 20px;
        >div{
          box-shadow:0 1px 6px rgba(0,0,0,.2);
          .ivu-form-item{
            margin-bottom: 0;
          }
          /*padding-bottom: 100px;*/
        }
      }
      .right{
        flex-basis:70%;
        border-left: 1px solid #e9eaec;
        padding:20px;
        overflow: auto;
        p.auth{
          display: flex;
          justify-content: space-between;
          padding-bottom: 10px;
          span{
            line-height: 32px;
            font-size: 12px;
            color: #999;
          }
        }
        .ivu-table-wrapper,.loading-container{
          height: calc(~"100% - 84px");
        }
        .ivu-page{
          padding-top: 10px;
        }
      }
    }
  }
</style>
