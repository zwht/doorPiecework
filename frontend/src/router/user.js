import Login from '@/components/user/Login'
export default [
  {
    path: '/',
    name: "login",
    component:Login,
    meta: {
      name: "login"
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
