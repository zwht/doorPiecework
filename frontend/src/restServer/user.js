import server from '@/config/server'
let userServer = server('/cfmy/user/:params1/:params2/:params3/:params4/:params5',{},{
  addUser:{
    method:'post',
    params:{
      params1:'insert'
    }
  },
  login:{
    method:'post',
    params:{
      params1:'login'
    }
  }
});
export default userServer
