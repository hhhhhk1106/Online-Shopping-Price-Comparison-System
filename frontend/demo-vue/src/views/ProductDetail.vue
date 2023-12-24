<!-- ProductDetail.vue -->

<template>
    <div>
      <h2>商品详情页</h2>
      <p>商品ID: {{ productId }}</p>
      <!-- 在这里展示商品的其他详细信息 -->
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        productId: null
      };
    },
    created() {
      // 在这里从路由参数中获取商品ID
      this.productId = this.$route.params.id;
    }
  };
  </script>
  