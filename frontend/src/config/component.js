
import Loading from '@/components/common/Loading'
export default {
	install:function(Vue){
    //在这里添加全局组件
    Vue.component('Loading',Loading);
		Vue.component('Btn',{
      functional:true,
      render(h,c){
        let f =c.parent.$store.state.scope;
        if(f===0)return h("Button",c.data,c.slots().default);
      },
    });
    Vue.component('Tab',{
      functional:true,
      render(h,c){
        let f =c.parent.$store.state.scope;
        let columns =c.props.columns;
        let childrens=[],slots=c.slots();
        //这里有点坑啊。。。整了好久！
        for(let k in slots){
          childrens.push(h("template",{slot:k},slots[k]));
        }
        if(f!==0&&columns[0].type==="selection")columns.shift();
        return h("Table",c.data,childrens);
      }
    });
	}
};
