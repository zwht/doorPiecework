/**
* 权限管理
* Created by zhaowei on 2017/8/23.
*/
<template>
    <div class="Role">
      <div class="btn">
        <Button type="info" @click="modal1 = true">添加角色</Button>
      </div>
      <Modal class="addRole" v-model="modal1" title="添加角色" @on-ok="save" @on-cancel="cancel">
        <div class="item">
          <lable>角色名称:</lable>
          <Input v-model="name" placeholder="请输入角色名称" style="width: 300px"/>
        </div>
        <div class="item">
          <lable>角色描述:</lable>
          <Input v-model="description" placeholder="请输入角色描述" style="width: 300px"/>
        </div>
      </Modal>
      <Table height="200" :columns="columns1" :data="data2"></Table>
    </div>
</template>

<script>
    export default {
        name: 'Role',
      data () {
        return {
          msg: 'hello',
          modal1: false,
          columns1: [
            {
              title: '角色名称',
              key: 'name'
            },
            {
              title: '创建时间',
              key: 'createTime'
            },
            {
              title: '角色描述',
              key: 'des'
            },
            {
              title: '操作',
              key: 'fun'
            }
          ],
          data2: [
            {
              name: '习大大',
              createTime:"2017-05-02",
              des: '角色描述',
              fun:"删除"
            },
            {
              name: '习大大',
              createTime:"2017-05-02",
              des: '角色描述',
              fun:"删除"
            },
            {
              name: '习大大',
              createTime:"2017-05-02",
              des: '角色描述',
              fun:"删除"
            }
          ]
        }
      },
      methods: {
        save () {

          this.$Message.info('点击了确定');
        },
        cancel () {
          this.$Message.info('点击了取消');
        }
      }
    }
</script>

<style  scoped lang='less'>
    .Role {
      .btn{text-align: right;padding: 10px 20px}
    }
    .addRole{
      .item{padding: 5px 0}
    }
</style>
