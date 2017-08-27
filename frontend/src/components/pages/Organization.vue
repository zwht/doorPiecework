/**
* 组织机构管理
* Created by zhaowei on 2017/8/24.
*/

<template>
  <div class="Organization">
    <Loading v-show="loading"></Loading>
    <Table border :columns="tableHeard" :data="tableData" v-show="!loading"></Table>
    <Page :total="total" :current="current" :page-size="pageSize"
          show-total show-elevator show-sizer
          v-on:on-change="pageChange" v-on:on-page-size-change="pageSizeChange"
    ></Page>
  </div>
</template>

<script>
  import organizationServer from 'rs/organizationServer';
  import otherServer from 'rs/otherServer';
  export default {
    name: 'Organization',
    data () {
      return {

        tableHeard: [
          {
            title: '机构名称',
            render: (h, params) => {
              return h('span',params.row.org.name);
            }
          },
          {
            title: '类型',
            render: (h, params) => {
              return h('span',params.row.orgtype.name);
            }
          },
          {
            title: '社会统一信用代码',
            render: (h, params) => {
              return h('span',params.row.org.value);
            }
          },
          {
            title: '地址',
            render: (h, params) => {
              return h('span',params.row.org.address);
            }

          },
          {
            title: '归属行政区',
            render: (h, params) => {
              return h('span',params.row.admindivision);
            }

          },
          {
            title: '联系人',
            render: (h, params) => {
              return h('span',params.row.org.attn);
            }
          },
          {
            title: '联系电话',
            render: (h, params) => {
              return h('span',params.row.org.phone);
            }
          },
          {
            title: 'Logo',
            render: (h, params) => {
              return h('img',
                {
                  attrs: {
                    src: "http://192.168.1.43:81/"+params.row.org.logo
                  },
                  style: {
                    width: '100%'
                  }
                },""
                );
            }
          },
          {
            title: '操作',
            key: 'action',
            width: 150,
            align: 'center',
            render: (h, params) => {
              return h('div', [
                h('Button', {
                  props: {
                    type: 'primary',
                    size: 'small'
                  },
                  style: {
                    marginRight: '5px'
                  },
                  on: {
                    click: () => {
                      this.show(params.index)
                    }
                  }
                }, '查看'),
                h('Button', {
                  props: {
                    type: 'info',
                    size: 'small'
                  },
                  on: {
                    click: () => {
                      this.remove(params.index)
                    }
                  }
                }, '编辑')
              ]);
            }
          }
        ],
        tableData: [
          {
            name: '王小明',
            age: 18,
            address: '北京市朝阳区芍药居'
          },
          {
            name: '张小刚',
            age: 25,
            address: '北京市海淀区西二旗'
          },
          {
            name: '李小红',
            age: 30,
            address: '上海市浦东新区世纪大道'
          },
          {
            name: '周小伟',
            age: 26,
            address: '深圳市南山区深南大道'
          }
        ],
        total:0,
        current:1,
        pageSize:10,
        loading:true
      }
    },
    created: function () {
      this.$route.query;
      if(this.$route.query.current) this.current=this.$route.query.current;
      if(this.$route.query.pageSize) this.current=this.$route.query.pageSize;

      this.getTableData();

    },
    methods: {
      pageChange (current){
        this.current=current;
        this.getTableData();

      },
      pageSizeChange (pageSize){
        this.current=1;
        this.pageSize=pageSize;
        this.getTableData();
      },
      getTableData (){
        let that = this;
        that.loading=true;
        this.$router.push('organization?current='+this.current+"&pageSize="+this.pageSize);

        organizationServer.listOrgs({}, {
          pageIndex: this.current,
          pageSize: this.pageSize
        }, function (response) {
          that.tableData = response.data;
          that.total=response.total;
          that.loading=false;
        }, function (err) {
          that.loading=false;
        })
      }
    }

  }
</script>

<style rel="stylesheet/less" type="text/css">
  .Organization {

  }
</style>
