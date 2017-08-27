import session from '@/config/session'
export default function (callback) {
  //在这里用一个接口去请求当前token的权限，得到权限后再进行路由加载/vue实例挂载操作
  let token =session.get('token');
  callback(null);
  return

}
