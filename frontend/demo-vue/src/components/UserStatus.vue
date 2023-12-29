<!-- UserStatus.vue -->

<template>
  <div class="user-status">
    <div class="links">
      <router-link to="/">主页</router-link>
      <router-link v-if="role_user" to="/user_info">个人信息</router-link>
      <router-link v-if="role_merchant" to="/merchant_info">商家信息</router-link>
    </div>
    
    <div class="user-info">
      <span v-if="isLoggedIn">已登录:{{ logInfo }}</span>
      <span v-else>未登录</span>
      <button v-if="isLoggedIn" @click="logout">登出</button>
      <button v-else @click="login">登录</button>
      <!-- <button v-if="isLoggedIn" @click="showInfo">个人信息</button> -->
    </div>
  </div>
</template>
  
  <script>
  export default {
    name: 'UserStatus',
    data() {
      return {
        isLoggedIn: false,
        logInfo: null,
        role_user: false,
        role_merchant: false,
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
          this.role_user = true;
          this.role_merchant = false;
          if(userId == 1) {
            this.logInfo = '管理员';
          } else {
            this.logInfo = '用户 id:'+userId;
          }
        } else if(role == 'merchant') {
          this.logInfo = '商家 id:'+userId;
          this.role_user = false;
          this.role_merchant = true;
        }
  
        // 如果 token 和 userId 都存在，则返回 true
        return !!role && !!userId;
      },
      logout() {
        // 清除 localStorage 中的登录信息
        localStorage.removeItem('role');
        localStorage.removeItem('id');
  
        // 跳转到主页
        // this.$router.replace('/');
        if (this.$route.path !== '/') {
          // 如果不是当前路由，则触发导航
          this.$router.push('/');
        } else {
          // 刷新
          this.$router.go(0);
        }
      },
      login() {
        this.$router.push('/login');
      },
      // showInfo() {
      //   this.$router.push('/user_info');
      // },
    }
  };
  </script>

<style scoped>
.user-status {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.links {
  order: -1; /* 将 links 放到最左边 */
}
</style>