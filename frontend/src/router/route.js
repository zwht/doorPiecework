import message from 'cmpts/pages/Message';
import policy from 'cmpts/pages/Policy';
import product from 'cmpts/pages/Product';
import loan from 'cmpts/pages/Loan';
import recruitment from 'cmpts/pages/Recruitment';
import insurance from 'cmpts/pages/Insurance';
import village from 'cmpts/pages/Village';
import credit from 'cmpts/pages/Credit';
import collection from 'cmpts/pages/Collection';
import award from 'cmpts/pages/Award';


import role from 'cmpts/pages/Role';
import user from 'cmpts/pages/User';

export default [
  {
    path:'/message',
    component:message,
    name:"message",
    meta: {
      name: "消息通知",
      icon:'email-unread',
      menu:true
    }
  },

  {
    path:'/policy',
    component:policy,
    name:"policy",
    meta: {
      name: "政策资讯",
      icon:'star',
      menu:true
    }
  },
  {
    path:'/product',
    component:product,
    name:"product",
    meta: {
      name: "贷款产品",
      icon:'social-codepen',
      menu:true
    }
  },
  {
    path:'/loan',
    component:loan,
    name:"loan",
    meta: {
      name: "贷款服务",
      icon:'social-bitcoin',
      menu:true
    }
  },

  {
    path:'/recruitment',
    component:recruitment,
    name:"recruitment",
    meta: {
      name: "招工信息",
      icon:'android-hand',
      menu:true
    }
  },
  {
    path:'/insurance',
    component:insurance,
    name:"insurance",
    meta: {
      name: "保险产品",
      icon:'ios-briefcase',
      menu:true
    }
  },
  {
    path:'/village',
    component:village,
    name:"village",
    meta: {
      name: "村务信息",
      icon:'ios-list',
      menu:true
    }
  },
  {
    path:'/credit',
    component:credit,
    name:"credit",
    meta: {
      name: "信用指标",
      icon:'ios-speedometer',
      menu:true
    }
  },
  {
    path:'/collection',
    component:collection,
    name:"collection",
    meta: {
      name: "信息采集",
      icon:'ios-world',
      menu:true
    }
  },
  {
    path:'/award',
    component:award,
    name:"award",
    meta: {
      name: "奖补申请审核",
      icon:'ios-rose',
      menu:true
    }
  },

  {
    path:"/role",
    component:role,
    name:"role",
    meta: {
      name: "角色管理",
      icon:'lock-combination',
      menu:true
    }
  },
  {
    path:"/user",
    component:user,
    name:"user",
    meta: {
      name: "用户管理",
      icon:'person-stalker',
      menu:true
    }
  }
];
