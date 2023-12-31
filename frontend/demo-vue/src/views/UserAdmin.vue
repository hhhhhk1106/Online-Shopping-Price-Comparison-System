<!-- UserAdmin.vue -->

<template>
    <div>
      <UserStatus></UserStatus>
      <button @click="addUser">导入用户</button>
      <UserList :users="userList"/>
    </div>
  </template>
  
  <script>
  import UserList from '@/components/UserList.vue';

  export default {
    components: {
        UserList
    },
    data() {
      return {
        userList: [],
      };
    },
    created() {
      this.fetchUsersAll();
    },
    methods: {
      // 获取所有用户信息
      fetchUsersAll() {
        this.$axios
        ({
          method: "post",
          url:'/user_all', 
        })
        .then(response => {
          this.userList = response.data;
          console.log(response.data)
        })
        .catch(error => {
          console.error('Error fetching shelf items:', error);
        });
      },
      addUser() {
        this.$router.push({ name: 'UserRegister'});
      },
      // goToUserDetail(productId) {
      //   // 跳转到商品详情页
      //   this.$router.push({ name: 'productDetail', params: { id: productId } });
      // }
    },
  };
  </script>
  