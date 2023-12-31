<!-- ShelfItemRegister.vue -->

<template>
    <div>
      <UserStatus></UserStatus>
      <h3>发布商品</h3>
      <label>商品原型：</label>
      <select v-model="item.item_id" required>
        <option :value="null" disabled selected>请选择商品原型</option>
        <option v-for="item in items" :key="item.id" :value="item.id">
          {{ item.name }}
        </option>
      </select><br /><br />
      
      <label>平台：</label>
      <select v-model="item.platform_id" required>
        <option :value="null" disabled selected>请选择平台</option>
        <option v-for="platform in platforms" :key="platform.id" :value="platform.id">
          {{ platform.name }}
        </option>
      </select><br /><br />
      <label v-if="role_admin">商家：</label>
      <input v-if="role_admin" v-model="item.merchant_id" type="number" placeholder="请输入商家id" /><br v-if="role_admin"/><br v-if="role_admin"/>
      <label>名称：</label>
      <input v-model="item.name" type="text" placeholder="请输入名称" /><br /><br />
      <label>描述：</label>
      <input v-model="item.description" type="text" placeholder="请输入描述" /><br /><br />
      <label>产地：</label>
      <input v-model="item.origin" type="text" placeholder="请输入产地" /><br /><br />
      <label>生产日期：</label>
      <input v-model="item.production_date" type="date" placeholder="请输入生产日期" /><br /><br />
      <label>价格：</label>
      <input v-model="item.price" type="text" pattern="\d+(\.\d{1,2})?" placeholder="请输入价格" required/><br /><br />

      <button @click="registerItem">发布</button>
    </div>
  </template>
  
  <script>
  export default {
    name: 'ShelfItemRegister',
    data() {
      return {
        items: [],
        platforms: [],
        item: {
          item_id: null,
          merchant_id: null,
          platform_id: null,
          name: '',
          description: '',
          origin: '',
          production_date: '',
          price: null,
        },
        role_admin: false,

      };
    },
    mounted() {
      // 在组件挂载时从后端获取平台数据
      this.fetchItems();
      this.fetchPlatforms();
    },
    created() {
      const role = localStorage.getItem('role');
      const userId = localStorage.getItem('id');
      if(role == 'user' && userId == 1) {
        this.role_admin = true;
      }
    },
    methods: {
      fetchItems() {
        this.$axios.post('/get_all_items')
          .then(response => {
            this.items = response.data;
            // console.log(this.items)
          })
          .catch(error => {
            console.error('Error fetching items:', error);
          });
      },
      fetchPlatforms() {
        this.$axios.post('/get_all_platforms')
          .then(response => {
            this.platforms = response.data;
            // console.log(this.platforms)
          })
          .catch(error => {
            console.error('Error fetching platforms:', error);
          });
      },
      registerItem() {
        if(this.item.merchant_id == null) {
          const userId = localStorage.getItem('id');
          this.item.merchant_id = userId;
        }

        console.log(this.item);

        if (!this.item.item_id || !this.item.platform_id || !this.item.name || !this.item.description
              || !this.item.origin || !this.item.production_date || !this.item.price) {
            alert("请填写所有字段");
            return;
        }

        // 向后端发送注册请求
        this.$axios
          .post('/shelf_item_register', this.item)
          .then(response => {
            if(response.data.code==200) {
              console.log('注册成功', response.data);
              if(this.role_admin) {
                this.$router.replace({path: '/shelf_item_admin'})
              } else {
                this.$router.replace({path: '/merchant_info'})
              }
            } else {
              console.log(response.data.message);
              alert(response.data.message);
            }
            
          })
          .catch(error => {
            // 处理注册失败的逻辑
            console.error('注册失败', error);
          });
      }
    }
  };
  </script>
  
  <style>
  /* 在这里添加样式 */
  </style>
  