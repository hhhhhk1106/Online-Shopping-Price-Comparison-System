<!-- MerchantInfo.vue -->

<template>
    <div>
      <UserStatus></UserStatus>
      <h2>Merchant Information</h2>
      <div v-if="merchantInfo">
        <p>ID: {{ merchantInfo.id }}</p>
        <p>Name: {{ merchantInfo.name }}</p>
        <p>Address: {{ merchantInfo.address }}</p>
      </div>
      <p v-if="userLoginError" style="color: red;">{{ userLoginError }}</p>
      <!-- <h2>拥有的商品列表：</h2> -->
      <ProductList :products="productList" @productClick="goToProductDetail" />

    </div>
  </template>
  
<script>
import UserStatus from '@/components/UserStatus.vue';
import ProductList from '@/components/ProductList.vue';

export default {
    name: 'MerchantInfo',
    components: {
        UserStatus,
        ProductList
    },
    data() {
      return {
        merchantInfo: null,
        userLoginError: '',
        productList: [],
      };
    },
    created() {
      // 在组件创建时，获取用户信息
        this.isLoggedIn = this.checkLoginStatus();
        // 如果已登录，获取用户信息
        if (this.isLoggedIn) {
            this.fetchUserInfo();
            this.fetchShelfItems();
        }
    },
    methods: {
        checkLoginStatus() {
            const role = localStorage.getItem('role');
            const userId = localStorage.getItem('id');
            // 如果 token 和 userId 都存在，则返回 true
            return !!role && !!userId;
        },
        fetchUserInfo() {
            const userId = localStorage.getItem('id');
    
            this.$axios
            ({
                method: "post",
                url:'/merchant_info_by_id', 
                params:{ id: userId }
            })
            .then(successResponse => {
                this.merchantInfo = successResponse.data;
    
                if (!this.merchantInfo) {
                this.userLoginError = '用户不存在';
                }
            })
            .catch(error => {
                console.error('获取用户信息失败', error);
                this.userLoginError = '获取用户信息失败';
            });
        },
        fetchShelfItems() {
          const userId = localStorage.getItem('id');
          this.$axios
          ({
            method: "post",
            url:'/shelf_item_info_by_merchant_id', 
            params:{id:userId}
          })
          .then(response => {
            this.productList = response.data;
            console.log(response.data)
          })
          .catch(error => {
            console.error('Error fetching shelf items:', error);
          });
        },
        goToProductDetail(productId) {
          this.$router.push({ name: 'productDetail', params: { id: productId } });
        }
    }
};
</script>
  