import server from '@/config/server'
let deviceServer = server('/knr/device/:params1/:params2/:params3/:params4/:params5',{},{
  insert:{
    method:'post',
    params:{
      params1:'insert'
    }
  },
  update:{
    method:'post',
    params:{
      params1:'update'
    }
  },
  del:{
    method:'get',
    params:{
      params1:'delete'
    }
  },
  list:{
    method:'post',
    params:{
      params1:'page'
    }
  },
  select:{
    method:'get',
    params:{
      params1:'selectById'
    }
  }
});
export default deviceServer
