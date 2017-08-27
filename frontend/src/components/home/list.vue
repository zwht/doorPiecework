<template lang='jade'>
  .list-container
    Tab(:columns="head" v-bind:data="users" v-show="!loading")
    Loading(v-show="loading")
    Page(:total="pageTotal" show-elevator show-sizer placement="top" v-on:on-change="pageChange" v-on:on-page-size-change="pageSizeChange" v-show="showPage")
    Modal(v-model="modal" title='转移授权' v-on:on-ok="transferFn" loading)
      span(style='margin-right:10px') 目标用户
      Select(v-model="transfer.newId" style="width:300px")
        Option(v-for="(item,index) in allUser" v-bind:value="item.id" v-text="item.userName" v-bind:key="index")
</template>

<script>
  import userServer from 'rs/user'
  import authServer from 'rs/auth'
  import head from 'asts/images/default.jpeg';
export default {
	name: 'home',
	data() {
    return {
      allUser:[],
      modal:false,
      transfer:{
        oldId:'',
        newId:''
      },
      head:[
        {
          title:'姓名',
          key:'userName'
        },
        {
          title:'身份证号',
          key:"identityId"
        },
//        {
//          title:'照片',
//          key:'userPhoto',
//          render:(h,p)=>{
//            return h('img',{
//              attrs:{
//                src:p.row.userPhoto
//              },
//              style:{
//                width:"30px",
//                verticalAlign:'middle'
//              },
//              on:{
//                error(e){
//                  e.target.src=head
//                }
//              }
//            });
//          }
//        },
        {
          title:'采集终端ID',
          key:'terminalId'
        },
        {
          title:'操作',
          key:'toDetails',
          render:(h,p)=>{
            return h('div',[h('Button',{
              props:{type:'text'},
              on:{
                click:()=>{
                  this.$router.push('/home/list/'+p.row.id);
                }
              }
            },'详情'),h('Btn',{
              props:{type:'text'},
              on:{
                click:()=>{
//                  this.$router.push('/home/list/'+p.row.id);
                  this.getAll(p.row.id);
                }
              }
            },'转移')]);
          }
        }
      ],
      users:[],
      pageSize:10,
      pageTotal:0,
      pageCurrent:1,
      loading:false
    }
	},
	created() {
    this.init();
	},
	directives: {

	},
	computed: {
    showPage(){
      return this.pageTotal>this.pageSize
    }
	},
	filters: {
	},
	methods: {
    init(){
      this.loading=true;
      userServer.selectAll({params2:this.pageCurrent-1,params3:this.pageSize},{reviewState:1},res=>{
        this.loading=false;
        this.users=res.data.content;
        this.pageTotal=res.data.total;
      },()=>{this.loading=false});
    },
    getAll(id){
      this.transfer.newId='';this.allUser=[];
      userServer.selectAll({params2:0,params3:99999},{reviewState:1},res=>{
        this.allUser=res.data.content.filter(l=>l.id!==id);
        this.modal=true;
        this.transfer.oldId=id;
        let a =this.allUser[0];
        if(a)this.transfer.newId=a.id;
      });
    },
    pageChange(p){
      this.pageCurrent=p;
      this.init();
    },
    pageSizeChange(s){
      this.pageSize=s;
      this.init();
    },
    //转移
    transferFn(){
      authServer.transfer({},this.transfer,()=>{
        this.$Message.success('授权转移成功');
        this.modal=false;
      },()=>{this.$Message.error('授权转移失败');this.modal=false;});
    }
	}
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang='less'>
  .list-container{
    height: 100%;
    .ivu-page{
      padding-top: 10px;
    }
  }
  .ivu-table-wrapper,.loading-container{
    /*flex-grow:1;*/
    /*overflow: auto;*/
    height: calc(~"100% - 42px");
  }
</style>
