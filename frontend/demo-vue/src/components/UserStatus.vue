<!-- UserStatus.vue -->

<template>
    <div class="user-status">
      <span v-if="isLoggedIn">已登录:{{ logInfo }}</span>
      <span v-else>未登录</span>
      <button v-if="isLoggedIn" @click="logout">登出</button>
      <button v-else @click="login">登录</button>
    </div>
  </template>
  
  <script>
  export default {
    name: 'UserStatus',
    data() {
      return {
        isLoggedIn: false,
        logInfo: null
      };
    },
    created() {
      // 在创建组件时检查登录状态
      this.isLoggedIn = this.checkLoginStatus();
    },
    methods: {
      checkLoginStatus() {
        // 检查 localStorage 中是否存在相关数据
        const role = localStorage.getItem('role');
        const userId = localStorage.getItem('id');

        if(role == 'user') {
          if(userId == 1) {
            this.logInfo = '管理员';
          } else {
            this.logInfo = '用户 id:'+userId;
          }
        } else if(role == 'merchant') {
          this.logInfo = '商家 id:'+userId;
        }
  
        // 如果 token 和 userId 都存在，则返回 true
        return !!role && !!userId;
      },
      logout() {
        // 清除 localStorage 中的登录信息
        localStorage.removeItem('role');
        localStorage.removeItem('id');
  
        // 跳转到登录页面
        this.$router.push('/login');//TODO: 主页
      },
      login() {
        this.$router.push('/login');
      }
    }
  };
  </script>

<style scoped>
.user-status {
  display: flex;
  align-items: center;
  justify-content: flex-end; /* 将内容居右 */
}
.user-status span {
  margin-right: 10px; /* 为已登录文字添加右边距 */
}
</style>