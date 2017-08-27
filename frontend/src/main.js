//vue 全家桶+iView
import Vue from './config/prototype'
import router from './router'
import iView from 'iview'
// import './config/axios'
//样式
import "@/assets/css/my-theme.less"
import "@/assets/css/common.less"
//配置config
import componentConfig from './config/component'
import ExtendVue from './config/extend'
//vuex
import store from './store'
//run-beforeMount
import run from './config/run'
//directive
import directive from './config/directive'
//安装插件/config
Vue.use(directive);
Vue.use(iView);
Vue.use(componentConfig);
Vue.config.productionTip=false;//阻止vue启动时的提示
window.Vue =Vue;
// Vue.use(protoConfig(vm));
//类似于angular的run？？？
run(function (scope) {
  //如果token错误或者不存在
  if(scope!==null)store.commit('setScope',scope);
  //根实例
  let vm =new ExtendVue({
    store,
    router:router
  });
  vm.$mount('#app');
});

