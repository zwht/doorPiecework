<template lang='jade'>
  .list-container
    Table(:columns="head" v-bind:data="users" v-show="!loading")
    Loading(v-show="loading")
    Page(:total="pageTotal" show-elevator show-sizer placement="top" v-on:on-change="pageChange" v-on:on-page-size-change="pageSizeChange" v-show="showPage")
    Modal(v-model="flag" title="审核" v-on:on-ok="submit" v-bind:loading="submitLoading")
      Form(:label-width="80")
        Form-item(label="用户姓名")
          span(v-text="name")
        Form-item(label="审核结果")
          Radio-group(v-model="audit.reviewState")
            Radio(:label="0") 待审核
            Radio(:label="1") 通过
            Radio(:label="2") 未通过
        Form-item(label="审核说明")
          Input(v-model="audit.reason" type="textarea" v-bind:rows="4" placeholder="请输入审核说明" )
</template>

<script>
  import head from 'asts/images/default.jpeg';
  import userServer from 'rs/user';
  export default {
    name: 'home',
    data() {
      return {
        loading:false,
        pageSize:10,
        pageTotal:0,
        pageCurrent:1,
        flag:false,//modal
        submitLoading:false,
        name:'',
        audit:{
          reason:'',
          reviewState:0,
          id:0,
          reviewer:"1"
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
//          {
//            title:'照片',
//            key:'userPhoto',
//            render:(h,p)=>{
//              return h('img',{
//                attrs:{
//                  src:p.row.userPhoto
//                },
//                style:{
//                  width:"30px",
//                  verticalAlign:'middle'
//                },
//                on:{
//                  error(e){
//                    e.target.src=head
//                  }
//                }
//              });
//            }
//          },
          {
            title:'采集终端ID',
            key:'terminalId'
          },
          {
            title:'操作',
            key:'toDetails',
            render:(h,p)=>{
              return h("Btn",{
                class:"action",
                props:{type:'text'},
                on:{
                  click:()=>{
                    this.flag=true;
                    this.name=p.row.userName;
                    this.audit.id=p.row.id;
                  }
                }
              },'审核');
            }
          }
        ],
        users:[]
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
        userServer.selectAll({params2:this.pageCurrent-1,params3:this.pageSize},{reviewState:0},res=>{
          this.users=res.data.content;
          this.pageTotal=res.data.total;
          this.loading=false;
        },()=>{this.loading=false})
      },
      submit(){
        this.submitLoading=true;
        userServer.audit({},this.audit,()=>{
          this.$Message.success('审核成功');
          this.submitLoading=false;
          this.flag=false;
          this.init();
        },()=>{this.submitLoading=false;this.$Message.error('审核失败');});
      },
      pageChange(p){
        this.pageCurrent=p;
        this.init();
      },
      pageSizeChange(s){
        this.pageSize=s;
        this.init();
      }
    }
  };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang='less'>
  .list-container{
    height: 100%;
  }
  .ivu-table-wrapper,.loading-container{
    /*flex-grow:1;*/
    /*overflow: auto;*/
    height: calc(~"100% - 42px");
  }
</style>
