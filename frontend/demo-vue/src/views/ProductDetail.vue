<!-- ProductDetail.vue -->

<template>
    <div>
      <UserStatus></UserStatus>
        <h2>商品详情页</h2>
        <p>商品名称: {{ product.name }}</p>
        <p>商品ID: {{ productId }}</p>
        <p>描述: {{ product.description? product.description : '无' }}</p>
        <p>产地: {{ product.origin? product.origin : '无' }}</p>
        <p>生产日期: {{ formatDate(product.production_date) }}</p>
        <p>商家: {{ product.merchant.name? product.merchant.name : '无' }}</p>
        <p>平台: {{ product.platform ? product.platform.name : '无' }}</p>
        <button v-if="role_merchant" @click="shelfItemUpdate">修改商品</button>
        <div>
            <h3>历史价格</h3>
            <ul>
                <li v-for="price in product.historyPrices" :key="price.id">
                {{ formatDate(price.date) }} - ￥{{ price.amount }}
                </li>
            </ul>
            <button v-if="role_merchant" @click="priceUpdate">修改价格*</button>
        </div>
    </div>
  </template>
  
  <script>
import UserStatus from '@/components/UserStatus.vue';

  export default {
    components: {
        UserStatus
    },
    data() {
      return {
        productId: null,
        product: {
          merchant_id: null,
          merchant:{}
        },
        role_merchant: false,

      };
    },
    mounted() {
      // this.checkMerchant();
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

          const role = localStorage.getItem('role');
          const userId = localStorage.getItem('id');
          if(role == 'merchant' && userId == this.product.merchant_id) {
            this.role_merchant = true;
          } else if(role == 'user' && userId == 1) {
            // 管理员
            this.role_merchant = true;
          }

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
      },
      shelfItemUpdate() {
        // this.$router.push('/shelf_item_update');
        this.$router.push({ name: 'ShelfItemUpdate', params: { id: this.productId } });
      },
      priceUpdate() {
        this.$router.push('/');
      }
    }
  };
  </script>
  