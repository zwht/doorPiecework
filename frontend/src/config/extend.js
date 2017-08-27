import Vue from './prototype'
// import {menu} from '../router'
const ExtendVue = Vue.extend({
  //stage提示框默认加在根实例上的
	data(){
		return{
			// menu,
			stage:{
				flag:false,
				color:'',
				text:'',
				id:null
			}
		}
	}
});
export default ExtendVue;
