<!-- MerchantUpdate.vue -->

<template>
    <div>
      <UserStatus></UserStatus>
      <h3>修改商家</h3>
      <p>商家ID: {{ merchant.id }}</p>
  
      <label>名称：</label>
      <input v-model="merchant.name" type="text" placeholder="请输入名称" /><br /><br />
      <label>地址：</label>
      <input v-model="merchant.address" type="text" placeholder="请输入地址" /><br /><br />
  
      <button @click="updateMerchant">保存修改</button>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        merchant: {
          name: '',
          address: '',
        }
      };
    },
    created() {
      this.fetchMerchant();
    },
    methods: {
      // 根据ID获取用户信息
      fetchMerchant() {
        this.merchant.id = this.$route.params.id;
        this.$axios
        ({
          method: "post",
          url:'/merchant_info_by_id', 
          params:{id:this.merchant.id}
        })
        .then(response => {
          this.merchant = response.data;
          // console.log(this.production_date)
        })
        .catch(error => {
          console.error('Error fetching merchant:', error);
        });
      },
  
      // 保存修改
      updateMerchant() {
        // 调用后端接口或者使用 axios 将修改后的商品信息提交到后端进行保存
        const newMerchant = {};
        newMerchant.id = this.merchant.id;
        newMerchant.name = this.merchant.name;
        newMerchant.address = this.merchant.address;
        console.log(newMerchant)

        this.$axios
        .post('/merchant_update', newMerchant)
        .then(response => {
          console.log('修改成功', response.data);
          this.$router.replace({path: '/merchant_admin'})
        })
        .catch(error => {
          console.error('Error updating merchant:', error);
          alert(response.data.message);
        });
      },

    },

  };
  </script>
  