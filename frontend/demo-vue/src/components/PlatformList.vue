<!-- PlatformList.vue -->

<template>
    <div>
      <h2>平台列表</h2>
      <ul class="product-list">
        <li class="product-item" v-for="user in users" :key="user.id">
          <div>
          <strong>ID: {{ user.id }}</strong>
          <p>Name: {{ user.name }}</p>
          <button @click="updatePlatform(user.id)">修改</button>
          <button @click="deletePlatform(user.id)">删除</button>
        </div>
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      users: {
        type: Array,
        default: () => []
      }
    },
    methods: {
      updatePlatform(userId) {
        console.log("update:", userId);
        this.$router.push({ name: 'PlatformUpdate', params: { id: userId } });
      },
      deletePlatform(userId) {
        console.log("delete:", userId);
        const userConfirmed = window.confirm('确定删除该平台及相关商品？');
        if (userConfirmed) {
          // this.deleteItem();
          console.log('用户确认');
          this.$axios
          ({
            method: "post",
            url:'/platform_delete_by_id', 
            params:{id:userId}
          })
          .then(response => {
            if(response.data>0) {
              window.location.reload();
            } else {
              alert('删除失败')
            }
          })
          .catch(error => {
            console.error('Error fetching platforms:', error);
          });
        } else {
          // 取消
          console.log('用户取消');
        }
      },
    }
  };
  </script>
  
  <style scoped>
.product-list {
  list-style: none;
  padding: 0;
}

.product-item {
  border: 1px solid #ddd;
  margin-bottom: 10px;
  padding: 10px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.product-item:hover {
  background-color: #f5f5f5;
}

.product-item div {
  max-width: 400px; /* Adjust the maximum width as needed */
}

.product-description {
  color: #555;
}

.product-info {
  margin-top: 5px;
  color: #888;
}
</style>