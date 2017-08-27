<template lang='jade'>
.LoginCom
  main
    Form(:model="form" ref='form' v-bind:rules="rules")
      Form-item(prop="loginName")
        Input(type='text' v-model="form.loginName" placeholder='邮箱' v-on:keydown.enter.native="login")
          div(slot="prepend")
            Icon(type="person")
      Form-item(prop="password")
        Input(type='password' v-model="form.password" v-on:keydown.enter.native="login")
          div(slot="prepend")
            Icon(type="locked")
      Form-item
        Checkbox(v-model="save") 记住密码
        Button(@click="login" type="primary" v-bind:loading="loading" long) 登录
        //Button(@click="register" type="ghost" long style="margin-left:0;margin-top:10px") 注册
</template>

<script>
import userServer from 'rs/user'
import session from '@/config/session'
import md5 from "md5"
//console.log(md5("123456"))
export default {
	name: 'LoginCom',
	data() {
    const validatePsd=(rule,value,callback) =>{
      if(value==='')callback('请输入密码');
      if(value.length<6)callback('密码应该是6位数以上，请检查');
      if(this.loginError)callback('用户名或密码错误！');
      callback()
    }
    const validateUserName =(rule,value,callback)=>{
      if(value==='')callback('请填写用户名');
      //if(!(/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(value)||/^[a-zA-Z0-9_]{4,19}$/.test(value)))callback('用户名支持6~20位的邮箱/数字/字母/下划线');
      if(this.loginError)callback('');
      callback();
    }
    return {
			title: '',
      save:true,
      loginError:false,
      form:{
        loginName:'',
        password:''
      },
      loading:false,
      rules: {
        loginName: [
          { validator: validateUserName, trigger: 'blur' }
        ],
        password: [
          { validator: validatePsd,trigger: 'blur' }
        ]
      }
		};
	},
  created() {
    this.form.loginName=session.get('user')||"";
    this.form.password=session.get('psd')||"";
	},
	directives: {

	},
	computed: {

	},
	filters: {
	},
	methods: {
    login(){
      this.$refs.form.validate(f=>{

        if(f){
          this.loading=true;
          let obj = {
            userName:this.form.loginName,
            //passWord:md5(this.form.password)
            passWord:this.form.password
          }
          userServer.login({},obj,(res)=>{

            this.loading=false;
            if(res.code!=200){
              this.$Message.error('用户名或密码错误！');
              this.loginError=true;
              this.$refs.form.validate();
              this.loginError=false;
              return;
            }
            this.$Message.success('登录成功！');
            if(this.save){
              session.set('user',this.form.loginName,"2 hours")
              session.set('psd',this.form.password,"2 hours");
            }
            session.set('userName',res.data.userName,"2 hours")
            session.set('access_token',res.data.token,"2 hours");

            let scope = res.data.roleType;
            this.$store.commit('setScope',scope);
            this.$router.push('message');
          },()=>{this.loading=false;});
        }
      });
    },
    register(){
      this.$router.push({name:'register'});
    }
	}
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang='less'>
.LoginCom{
  width:100%;
  height:100%;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #f8f8f9;
  main{
    padding-top: 80px;
    background: url(@logo_url) no-repeat center 15px;
    min-width: 240px;
    margin-top: -80px;
  }
}
</style>
