<!-- ItemUpdate.vue -->

<template>
    <div>
      <UserStatus></UserStatus>
      <h3>修改商品原型</h3>
      <p>ID: {{ item.id }}</p>
  
      <label>名称：</label>
      <input v-model="item.name" type="text" placeholder="请输入名称" /><br /><br />
      <label>种类：</label>
      <input v-model="item.category" type="text" placeholder="请输入种类" /><br /><br />
  
      <button @click="updateItem">保存修改</button>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        item: {
          name: '',
          category: '',
        }
      };
    },
    created() {
      this.fetchItem();
    },
    methods: {
      // 根据ID获取用户信息
      fetchItem() {
        this.item.id = this.$route.params.id;
        this.$axios
        ({
          method: "post",
          url:'/item_info_by_id', 
          params:{id:this.item.id}
        })
        .then(response => {
          this.item = response.data;
        })
        .catch(error => {
          console.error('Error fetching item:', error);
        });
      },
  
      // 保存修改
      updateItem() {
        // 调用后端接口或者使用 axios 将修改后的商品信息提交到后端进行保存
        const newItem = {};
        newItem.id = this.item.id;
        newItem.name = this.item.name;
        newItem.category = this.item.category;
        console.log(newItem)

        this.$axios
        .post('/item_update', newItem)
        .then(response => {
          console.log('修改成功', response.data);
          this.$router.replace({path: '/item_admin'})
        })
        .catch(error => {
          console.error('Error updating item:', error);
          alert(response.data.message);
        });
      },

    },

  };
  </script>
  