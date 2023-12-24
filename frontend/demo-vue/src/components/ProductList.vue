<!-- ProductList.vue -->

<template>
    <div>
      <h2>商品列表</h2>
      <ul class="product-list">
        <li class="product-item" v-for="product in products" :key="product.id" @click="handleProductClick(product.id)">
          <div>
          <strong>{{ product.name }}</strong>
          <p>描述: {{ product.description }}</p>
          <p>产地: {{ product.origin }}</p>
          <p>生产日期: {{ formatDate(product.production_date) }}</p>
          <p>商家: {{ product.merchant.name }}</p>
          <p>平台: {{ product.platform ? product.platform.name : 'N/A' }}</p>
        </div>
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      products: {
        type: Array,
        default: () => []
      }
    },
    methods: {
      handleProductClick(productId) {
        // 当点击商品时，触发 productClick 事件
        this.$emit('productClick', productId);
      },
      formatDate(dateString) {
        // 格式化日期方法，可以根据实际需求进行调整
        const options = { year: 'numeric', month: 'long', day: 'numeric' };
        return new Date(dateString).toLocaleDateString(undefined, options);
      }
    }
  };
  </script>
  
  <style scoped>
.product-list {
  list-style: none;
  padding: 0;
}

.product-item {
  border: 1px solid #ddd;
  margin-bottom: 10px;
  padding: 10px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.product-item:hover {
  background-color: #f5f5f5;
}

.product-item div {
  max-width: 400px; /* Adjust the maximum width as needed */
}

.product-description {
  color: #555;
}

.product-info {
  margin-top: 5px;
  color: #888;
}
</style>