import axios from 'axios';
import {Message} from 'iview';
import session from '@/config/session';

/*添加请求拦截器*/
window.getToken=false;
axios.interceptors.request.use(function(request){

  let time=new Date()-1;
  let token = session.get('access_token');
  let tokenTime=session.get("tokenTime");

  if(tokenTime&&tokenTime<time+1000*60*15&&!getToken){
    getToken=true;
    axios.post('cfmy/user/refreshToken', {
      token:session.get('access_token')
    })
      .then(function (response) {
        if(response.code == 200){
          session.set('access_token',response.data.token,"2 hours");
          session.set("tokenTime",(new Date()-0)+1000*60*30,"2 hours");
        }
        getToken=false;
      })
      .catch(function (error) {
        getToken=false;
      });
  }
  if(tokenTime&&tokenTime<time){
    alert("token 过期，重新登录");
  }

  /*在发送请求之前做某事*/
  if(token)request.headers.Authorization=token;
  request.headers['Content-Type']='application/x-www-form-urlencoded';
  return request;
},function(error){
  /*请求错误时做些事*/
  return Promise.reject(error);
});

/*添加响应拦截器*/
axios.interceptors.response.use(function(response){
  /*对响应数据做些事*/
  if(response.data.code==412){
    alert("token 过期，重新登录");
  }
  return response.data;
},function(error){
  let status =error.response.status;
  switch (status){
    case 404:
      Message.error('请求地址不存在');
      break;
    case 401:
      Message.error('请求未授权，请重新登录');
      break;
    case 500:
      Message.error('后端服务器出现错误');
      break;
    default:
      Message.error('请求出错啦！');
      break;
  }
  /*请求错误时做些事*/
  return Promise.reject(error);
});
export default axios;
