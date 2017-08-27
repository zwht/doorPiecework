import server from '@/config/server'
let userServer = server('/knr/user/:params1/:params2/:params3/:params4/:params5',{},{
  addUser:{
    method:'post',
    params:{
      params1:'insert'
    }
  },
  select:{
    method:'get',
    params:{
      params1:'selectById'
    }
  },
  audit:{
    method:'post',
    params:{
      params1:'reviewUserById'
    }
  },
  selectAll:{
    method:'post',
    params:{
      params1:'selectAll'
    }
  }
});
export default userServer
