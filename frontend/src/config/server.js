import axios from './axios';
import session from '@/config/session'
function transformRequest(data, headersGetter) {
  var str = [];
  for (var d in data) {
    str.push(encodeURIComponent(d) + "=" + encodeURIComponent(data[d]));
  }
  return str.join("&");
}
function S(url,config,obj) {
  for(let key in obj){
    this[key] =function(p,d,c1,c2){
      let params = Object.assign({},obj[key].params,p);
      let new_url =url,str="",urlArr=new_url.split('/');
      for(let p in params){
        if(urlArr.includes(":"+p))new_url=new_url.replace(":"+p,params[p]);
        else{
          let tag =str?"&":"?";
          str+=tag+p+"="+params[p];
        }
      }
      new_url=new_url.split("/").filter(i=>i[0]!==":").join('/')+str;
      let data =Object.assign({},config,d);
      let method =obj[key].method;
      let token=session.get("token");
      return axios({
        url:new_url,
        headers: {
          'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
        },
        transformRequest : transformRequest,
        method:method,
        data:(d instanceof Array)?d:data
      }).then(c1,c2);
    };
  }
}
function server(url,config,obj){
	return new S(url,config,obj);
}
export default server;
