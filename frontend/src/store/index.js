import Vue from 'vue'
import Vuex from 'vuex'
import * as actions from './actions'
import * as getters from './getters'
import user from './modules/user'
import createLogger from './plugins/logger'

Vue.use(Vuex);

const debug = process.env.NODE_ENV !== 'production';

export default new Vuex.Store({
  state:{
    //根据用户类型，控制页面的展示。主要用在：大/小菜单的展示、路由访问的限制、Btn、Tab；
    scope:null,
    created:false, //判断是否已经创建了百度地图script
  },
  mutations:{
    setScope(s,n){s.scope=n},
    createMap(s){s.created=true},
    setFirst(s){s.first=false}
  },
  actions,
  getters,
  modules: {
    user
  },
  strict: debug,
  plugins: debug ? [createLogger()] : []
})
