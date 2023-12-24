<!-- ProductDetail.vue -->

<template>
    <div>
        <h2>商品详情页</h2>
        <p>商品名称: {{ product.name }}</p>
        <p>商品ID: {{ productId }}</p>
        <p>描述: {{ product.description }}</p>
        <p>产地: {{ product.origin }}</p>
        <p>生产日期: {{ formatDate(product.production_date) }}</p>
        <p>商家: {{ product.merchant.name }}</p>
        <p>平台: {{ product.platform ? product.platform.name : '无' }}</p>
        <div>
            <h3>历史价格</h3>
            <ul>
                <li v-for="price in product.historyPrices" :key="price.id">
                {{ formatDate(price.date) }} - ￥{{ price.amount }}
                </li>
            </ul>
        </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        productId: null,
        product: null,
      };
    },
    created() {
      // 在这里从路由参数中获取商品ID
      this.productId = this.$route.params.id;
      this.$axios
        ({
          method: "post",
          url:'/shelf_item_info_by_id', 
          params:{id:this.productId}
        })
        .then(response => {
          this.product = response.data[0];
          this.product.historyPrices = [
            // 示例格式
                { id: 1, date: '2023-01-01', amount: 100 },
                { id: 2, date: '2023-02-01', amount: 90 },
                { id: 3, date: '2023-03-01', amount: 80 },
            ],
          console.log(response.data)
        })
        .catch(error => {
          console.error('Error fetching shelf items:', error);
        });
    },
    methods: {
        formatDate(dateString) {
        // 格式化日期方法，可以根据实际需求进行调整
        const options = { year: 'numeric', month: 'long', day: 'numeric' };
        return new Date(dateString).toLocaleDateString(undefined, options);
      }
    }
  };
  </script>
  