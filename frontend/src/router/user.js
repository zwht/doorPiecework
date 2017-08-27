import Index from '@/components/user/Index'
export default [
  {
    path: '/',
    name: "login",
    component:Index,
    meta: {
      name: "index"
    }
  },
  {
    path: '*',
    name: "noFound",
    component: (resolve) => {
      require(['cmpts/common/NoFound'], resolve);
    },
    meta: {
      name: "noFound"
    }
  }
  // {
  //   path: '/register',
  //   name: "register",
  //   component: (resolve) => {
  //     require(['@/components/user/register'], resolve);
  //   },
  //   meta: {
  //     name: "register"
  //   }
  // }
];
