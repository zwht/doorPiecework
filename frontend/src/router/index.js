import Vue from 'vue';
import Router from 'vue-router';

import user from './user';
import allRoutes from './route'
Vue.use(Router);
//路由在这里配置，以后文件多了，还可以拆分然后在合并
var appRoute = [
  {
    path: '/app',
    // name: 'app',
    component: (resolve) => {
      require(['@/components/App'], resolve);
    },
    meta: {
      name: "app"
    },
    redirect:{name:'home'},
    children: [].concat(allRoutes)
  }
]


let routes = appRoute.concat(user);
let router = new Router({
  routes
});
// //router 钩子：判断是否有权限
// router.beforeEach((t,f,n)=>{
//   if(t.fullPath==="/"){n();return}
//   let scope =store.state.scope;
//   let rule =t.meta.rule;
//   let flag =rule?rule.includes(scope):true;
//   if(flag)n();else n({name:"noFound"});
// });
//根据权限过滤路由(有bug,vue-router不够完善)
// function filterRouter(arr,target,scope) {
//   arr.forEach(l=>{
//     let flag =l.meta.rule?l.meta.rule.includes(scope):true;
//     if(flag){
//       let f = l.children?!l.children.length:true;//没有子路由
//       if(f)target.push(l);
//       else{
//         let a =l.children;
//         l.children=[];
//         filterRouter(a,l.children,scope);
//         target.push(l);
//       }
//     }
//   });
//   return target;
// }
// function getRouter(scope) {
//     store.commit('setScope',scope);
//     let array = filterRouter(appRoute,[],scope);
//     router.addRoutes(array);
//     let routes = router.options.routes;
//     routes.splice(0,routes.length);
//     routes.splice(0,0,...array,...user);//no_found 要放在最后
//   console.log('get-router-success');
// }
export default router;
// export {getRouter}

