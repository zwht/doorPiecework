import session from '@/config/session'
import accountServer from 'rs/account'
import router from "@/router"
export default function (callback) {
  //在这里用一个接口去请求当前token的权限，得到权限后再进行路由加载/vue实例挂载操作
  let token =session.get('token');
  callback(null);
  return
  if(!token){
    router.push({name:"login"});
    callback(null);
    return
  }
  accountServer.token({params2:session.get('token')},{},callback,()=>{router.push({name:"login"});callback(null)});
}
