<!-- PlatformAdmin.vue -->

<template>
    <div>
      <UserStatus></UserStatus>
      <button @click="addPlatform">导入平台</button>
      <PlatformList :users="userList"/>
    </div>
  </template>
  
  <script>
  import PlatformList from '@/components/PlatformList.vue';

  export default {
    components: {
      PlatformList
    },
    data() {
      return {
        userList: [],
      };
    },
    created() {
      this.fetchPlatformsAll();
    },
    methods: {
      // 获取所有平台信息
      fetchPlatformsAll() {
        this.$axios
        ({
          method: "post",
          url:'/get_all_platforms', 
        })
        .then(response => {
          this.userList = response.data;
          console.log(response.data)
        })
        .catch(error => {
          console.error('Error fetching platforms:', error);
        });
      },
      addPlatform() {
        this.$router.push({ name: 'PlatformRegister'});
      },
    },
  };
  </script>
  