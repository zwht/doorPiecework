<template lang='jade'>
  .no_found
    h1 Not Found
    p The requested URL&nbsp;
      span(v-text="$route.fullPath")
      span  was not found on this server.
</template>

<script>
/**
 *  noFound情况：
 *  1.乱输入的url，router中没有，则进入万能匹配，加载noFound组件
 *  2.用户权限导致的，如果他不是用户，则除了login，其他的任何url都是404,是用户，则进入权限判断流程
 *  针对上述权限，Router的应对方案：
 *  1.动态加载路由，一开始只加载登陆和404，然后根据用户的登陆信息动态的添加、删除路由。（逻辑可行，但是vue-router好像支持不到位）
 *  2.一开始加载所有路由，通过路由钩子函数做权限判断，然后跳转到404页面（缺点：url会被改变为指定的router-path）
 *  3.在根组件中进行权限判断，结合万能匹配路由*，来进行展示（就这种吧）
 * */
export default {
  created(){
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang='less'>
.no_found{
  color: #000;
  padding: 10px;
  h1{
    font-size: 2rem;
    font-weight: 600;
    padding-bottom: 10px;
  }
  p{
    font-size: 1rem;
  }
}
</style>
