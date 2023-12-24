<template>
  <div>
    <!-- 用户登录 -->
    <div>
      <h3>用户登录</h3>
      <div>
        <span>请输入ID：</span>
        <input type="text" v-model="userLoginForm.loginID" placeholder="请输入用户ID" />
        <button @click="userLogin">登录</button>
        <button @click="registerUser">注册新用户</button>
      </div>
      <p v-if="userLoginError" style="color: red;">{{ userLoginError }}</p>
    </div>

    <!-- 商家登录 -->
    <div>
      <h3>商家登录</h3>
      <div>
        <span>请输入ID：</span>
        <input type="text" v-model="merchantLoginForm.loginID" placeholder="请输入商家ID" />
        <button @click="merchantLogin">登录</button>
        <button @click="registerMerchant">注册新商家</button>
      </div>
      <p v-if="merchantLoginError" style="color: red;">{{ merchantLoginError }}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data() {
    return {
      userLoginForm: {
        loginID: '',
      },
      merchantLoginForm: {
          loginID: '',
      },
      userLoginError: '',
      merchantLoginError: '',
      responseResult: []
    };
  },
  methods: {
      userLogin() {
      // 获取用户输入的用户名
      const enteredLoginID = this.userLoginForm.loginID;
      this.userLoginError = '';
      // 验证输入是否为空
      if (!enteredLoginID.trim()) {
          this.userLoginError = '输入不能为空';
          return;
      }
      // 验证输入是否为正整数
      const isPositiveInteger = /^\d+$/.test(enteredLoginID);
      if (!isPositiveInteger) {
          this.userLoginError = '请输入一个正整数。';
          return;
      }
      console.log('用户登录点击，id：', enteredLoginID);
      let Param={
        id:enteredLoginID
      }
      this.$axios
        ({
          method: "post",
          url:'/user_info_by_id', 
          params:Param
        })
        .then(successResponse => {
          this.userInfo = successResponse.data;
          console.log(this.userInfo)

          if(!this.userInfo) {
            this.userLoginError = '用户不存在';
            return;
          } else {
            // 跳转
            // console.log('a')
            localStorage.setItem("role", 'user');
            localStorage.setItem("id", this.userInfo.id);
            // this.$router.replace({path: '/user_info'})
            this.$router.replace({path: '/'})
            // this.$router.push({name:'UserInfo',params: {id:this.userInfo.id}})
            // this.$router.replace({ path: '/', params: { id: userId } });
          }
        })
        .catch(failResponse => {
        })

    },
    registerUser() {
      // 实现用户注册逻辑
      console.log('注册新用户点击');
    },
    merchantLogin() {
      const enteredLoginID = this.merchantLoginForm.loginID;
      this.merchantLoginError = '';
      if (!enteredLoginID.trim()) {
          this.merchantLoginError = '输入不能为空';
          return;
      }
      const isPositiveInteger = /^\d+$/.test(enteredLoginID);
      if (!isPositiveInteger) {
          this.merchantLoginError = '请输入一个正整数。';
          return;
      }
      console.log('商家登录点击，id：', enteredLoginID);
      // console.log('商家登录点击');
    },
    registerMerchant() {
      // 实现商家注册逻辑
      console.log('注册新商家点击');
    }
  }
};
</script>
