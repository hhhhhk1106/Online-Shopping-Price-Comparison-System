<!-- MerchantAdmin.vue -->

<template>
    <div>
      <UserStatus></UserStatus>
      <button @click="addMerchant">导入商家</button>
      <MerchantList :users="userList"/>
    </div>
  </template>
  
  <script>
  import MerchantList from '@/components/MerchantList.vue';

  export default {
    components: {
        MerchantList
    },
    data() {
      return {
        userList: [],
      };
    },
    created() {
      this.fetchMerchantsAll();
    },
    methods: {
      // 获取所有用户信息
      fetchMerchantsAll() {
        this.$axios
        ({
          method: "post",
          url:'/merchant_all', 
        })
        .then(response => {
          this.userList = response.data;
          console.log(response.data)
        })
        .catch(error => {
          console.error('Error fetching merchants:', error);
        });
      },
      addMerchant() {
        this.$router.push({ name: 'MerchantRegister'});
      },
    },
  };
  </script>
  