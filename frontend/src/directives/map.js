import store from '@/store'
export default function (Vue) {
  Vue.directive("map",{
    //参数示例：{callback:markerMoveFn}
    inserted(el,bind){
      Vue.mapCallback=function () {
        bind.value.callback(el);
      };
      if(!store.state.created){
        let script =document.createElement("script");
        script.src = "http://api.map.baidu.com/api?v=2.0&ak=fFkP18McnPGCZFESZWbEMHNW6Bksre5n&callback=Vue.mapCallback()";
        document.body.appendChild(script);
        store.commit("createMap");
        return
      }
      Vue.mapCallback();
    }
  });
}












