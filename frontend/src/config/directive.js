import * as directive from '@/directives/enter'
export default {
	install:function(Vue){
   for(let k in directive){
     directive[k](Vue);
   }
	}
};
