<template lang='jade'>
</template>

<script>
import session from '@/config/session'
export default {
	name: 'IndexCom',
  created:function () {
    var userid=session.get("userId");

    this.$router.push({ name: 'message', params: { userId: 999 }});
  }
};
</script>

<style scoped lang='less'>
</style>
