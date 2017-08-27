/**
 * Created by zhaowei on 2017/8/24.
 */
import server from '@/config/server';
let otherServer = server('/city/api/:params1/:params2/:params3/:params4/:params5',{},{
  listOrgs:{
    method:'post',
    params:{
      params1:'admin',
      params2:'userManager',
      params3:'listOrgs'
    }
  }
});
export default otherServer;


