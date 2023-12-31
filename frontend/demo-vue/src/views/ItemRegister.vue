<!-- ItemRegister.vue -->

<template>
    <div>
      <UserStatus></UserStatus>
      <h3>商品原型注册</h3>
      <label>名称：</label>
      <input v-model="item.name" type="text" placeholder="请输入名称" /><br /><br />
      <label>种类：</label>
      <input v-model="item.category" type="text" placeholder="请输入种类" /><br /><br />
      <button @click="registerItem">注册</button>
    </div>
  </template>
  
  <script>
  export default {
    name: 'ItemRegister',
    data() {
      return {
        item: {
          name: '',
          category: '',
        }
      };
    },
    methods: {
      registerItem() {
        if (!this.item.name || !this.item.category) {
            alert("请填写所有字段");
            return;
        }
        // 向后端发送注册请求
        this.$axios
          .post('/item_register', this.item)
          .then(response => {
            // 处理注册成功的逻辑
            console.log('注册成功', response.data);

            const role = localStorage.getItem('role');
            const userId = localStorage.getItem('id');
            if(role == 'user' && userId == 1) {
              // 管理员
              this.$router.replace({path: '/item_admin'})
              return;
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
