<template lang='jade'>
  .loading-container
    Spin.loading(fix)
      Icon(type="load-c" size=40 class="demo-spin-icon-load")
      div Loading
</template>

<script>
export default {
  data() {
    return {
    }
  },
  created() {
  },
  directives: {
  },
  computed: {
  },
  filters: {
  },
  methods: {
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang='less'>
  .demo-spin-icon-load{
    animation: ani-demo-spin 1s linear infinite;
  }
  @keyframes ani-demo-spin {
    from { transform: rotate(0deg);}
    50%  { transform: rotate(180deg);}
    to   { transform: rotate(360deg);}
  }

</style>
