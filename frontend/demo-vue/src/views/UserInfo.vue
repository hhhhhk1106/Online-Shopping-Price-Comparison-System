<!-- UserInfo.vue -->

<template>
    <div>
      <UserStatus></UserStatus>
      <h2>User Information</h2>
      <div v-if="userInfo">
        <p>ID: {{ userInfo.id }}</p>
        <p>Name: {{ userInfo.name }}</p>
        <p>Age: {{ userInfo.age }}</p>
        <p>Sex: {{ userInfo.sex }}</p>
        <p>Phone: {{ userInfo.phone }}</p>
        <!-- 显示其他用户信息... -->
      </div>
      <p v-if="userLoginError" style="color: red;">{{ userLoginError }}</p>
    </div>
  </template>
  
<script>
import UserStatus from '@/components/UserStatus.vue';

export default {
    name: 'UserInfo',
    components: {
        UserStatus
    },
    data() {
      return {
        userInfo: null,
        userLoginError: ''
      };
    },
    created() {
      // 在组件创建时，获取用户信息
    //   this.fetchUserInfo();
        this.isLoggedIn = this.checkLoginStatus();

        // 如果已登录，获取用户信息
        if (this.isLoggedIn) {
            this.fetchUserInfo();
        }
    },
    methods: {
        checkLoginStatus() {
        // 检查 localStorage 中是否存在相关数据
            const role = localStorage.getItem('role');
            const userId = localStorage.getItem('id');
            // console.log(role,userId)

            // 如果 token 和 userId 都存在，则返回 true
            return !!role && !!userId;
        },
        fetchUserInfo() {
            // 假设你从路由参数中获取到用户ID
            // const userId = this.$route.params.id;
            // console.log(userId)
            const userId = localStorage.getItem('id');
    
            this.$axios
            //   .post('/user_info_by_id', params:{ id: userId })
            ({
                method: "post",
                url:'/user_info_by_id', 
                params:{ id: userId }
            })
            .then(successResponse => {
                this.userInfo = successResponse.data;
    
                if (!this.userInfo) {
                this.userLoginError = '用户不存在';
                }
            })
            .catch(error => {
                console.error('获取用户信息失败', error);
                this.userLoginError = '获取用户信息失败';
            });
        }
    }
};
</script>
  