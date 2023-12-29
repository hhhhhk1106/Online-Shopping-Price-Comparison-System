<!-- MerchantRegister.vue -->

<template>
    <div>
      <h3>商家注册</h3>
      <label>名称：</label>
      <input v-model="merchant.name" type="text" placeholder="请输入名称" /><br /><br />
      <label>地址：</label>
      <input v-model="merchant.address" type="text" placeholder="请输入地址" /><br /><br />
      <button @click="registerMerchant">注册</button>
    </div>
  </template>
  
  <script>
  export default {
    name: 'MerchantRegister',
    data() {
      return {
        merchant: {
          name: '',
          address: '',
        }
      };
    },
    methods: {
      registerMerchant() {
        if (!this.merchant.name || !this.merchant.address) {
            alert("请填写所有字段");
            return;
        }
        // 向后端发送注册请求
        this.$axios
          .post('/merchant_register', this.merchant)
          .then(response => {
            // 处理注册成功的逻辑
            console.log('注册成功', response.data);
            localStorage.setItem("role", 'merchant');
            localStorage.setItem("id", response.data.data.id);
            this.$router.replace({path: '/'})
          })
          .catch(error => {
            // 处理注册失败的逻辑
            console.error('注册失败', error);
          });
      }
    }
  };
  </script>
