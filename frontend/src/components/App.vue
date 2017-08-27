<template>
  <div class="layout" :class="{'layout-hide-text': spanLeft < 4}">
    <Row type="flex" v-if="!noFound">
      <i-col :span="spanLeft" class="layout-menu-left">
        <div class="layout-logo-left">
          <img :src="logoPng" alt="">
        </div>
        <Menu active-name="1" theme="dark" width="auto">

          <router-link  :name="index" v-for='(item,index) in menu' :key='item.path' :to='item' tag='li'
                        class="ivu-menu-item" >
            <Icon :type="item.meta.icon" :size="iconSize"></Icon>
            <span class="layout-text" v-text='item.meta.name'></span>
          </router-link>
        </Menu>
      </i-col>
      <i-col :span="spanRight" id="ivu-col">
        <div class="layout-header">
          <i-button type="text" @click="toggleClick">
            <Icon type="navicon" size="32"></Icon>
          </i-button>
          <Dropdown style=" float: right; margin: 20px;" placement="bottom-end">
            <a href="javascript:void(0)">
               <span v-text="userName"></span>
              <Icon type="arrow-down-b"></Icon>
            </a>
            <Dropdown-menu slot="list">
              <Dropdown-item>个人资料</Dropdown-item>
              <Dropdown-item>退出</Dropdown-item>
            </Dropdown-menu>
          </Dropdown>
        </div>
        <div id="container">
          <router-view :style="{'min-height':minHeight+'px'}"></router-view>
          <div class="layout-copy">
            2011-2016 &copy; TalkingData
          </div>
        </div>
      </i-col>
    </Row>
    <noFound v-if="noFound"></noFound>
  </div>
</template>
<script>
  import logoPng from 'asts/images/commons/logo01.png'
  import session from '@/config/session'
  export default {
    data () {
      return {
        logoPng:logoPng,
        spanLeft: 4,
        spanRight: 20,
        minHeight:600,
        userName:"",
        noFound:'',
        menu: [],
      }
    },
    computed: {
      iconSize () {
        return this.spanLeft === 4 ? 14 : 24;
      }
    },
    created() {
      let that = this;
      let scope =that.$store.state.scope;
      //得到主菜单menu
      function getMenu(routes, type) {
        routes.forEach(function (item) {
          if (item.meta[type]){
            let rule=item.meta.rule;
            if(rule&&!rule.includes(scope))return;
            that[type].push(item);
          }
          if (item.children) getMenu(item.children, type);
        });
      }
      getMenu(this.$router.options.routes, 'menu');

      function getHeight() {
        var o = document.getElementById("app");
        that.minHeight= o.offsetHeight-103;
      }
      getHeight();

      this.userName=session.get("use")?session.get("use"):"用户名";
    },
    methods: {
      toggleClick () {
        if (this.spanLeft === 4) {
          this.spanLeft = 1;
          this.spanRight = 23;
        } else {
          this.spanLeft = 4;
          this.spanRight = 20;
        }
      }
    }
  }
</script>
<style scoped>
  .layout{
    height: 100%;
    border: 1px solid #d7dde4;
    background: #f5f7f9;
    position: relative;
    border-radius: 4px;
    overflow: hidden;
  }
  #ivu-col{ height: 100%; padding-top: 60px;}
  .layout-header{ position: absolute; left: 0; top:0; width: 100%;
    box-shadow: 0 0 6px rgba(0,0,0,0.7); z-index: 100;
  }
  #container{ height: 100%; position: relative;
    overflow-y: auto; padding: 15px;
  }
  .ivu-row-flex{ height: 100%;}
  .layout-breadcrumb{
    padding: 10px 15px 0;
  }
  .layout-content{
    min-height: 200px;
    margin: 15px;
    overflow: hidden;
    background: #fff;
    border-radius: 4px;
  }
  .layout-content-main{
    padding: 10px;
  }
  .layout-copy{
    text-align: center;
    height: 40px; line-height: 40px;
    color: #9ea7b4;
  }
  .layout-menu-left{
    background: #464c5b;
  }
  .layout-header{
    height: 60px;
    background: #fff;
    box-shadow: 0 1px 1px rgba(0,0,0,.1);
  }
  .layout-logo-left{
    position: absolute; top: 0; left: 0; width: 100%;
    z-index: 10;
    text-align: center;
    height: 60px;
    background: #5b6270;
    border-radius: 3px;
  }
  .layout-logo-left img{ height: 100%;}
  .layout-ceiling-main a{
    color: #9ba7b5;
  }
  .layout-hide-text .layout-text{
    display: none;
  }
  .ivu-btn{padding: 13px 15px;}
  .ivu-col{
    transition: width .2s ease-in-out;
  }
  .router-link-active,.router-link-active:hover{
    color: #2d8cf0 !important;
    border-right: 2px solid #2d8cf0;background: #363e4f !important;
  }
  .layout-menu-left{ padding-top: 60px; position: relative;}
  .layout-menu-left>ul{ overflow-y: auto; height: 100%;}

</style>
