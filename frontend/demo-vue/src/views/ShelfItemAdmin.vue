<!-- ShelfItemAdmin.vue -->

<template>
    <div>
      <UserStatus></UserStatus>
      <button @click="addItem">导入商品</button>
      <ProductList :products="productList" @productClick="goToProductDetail" />
    </div>
  </template>
  
  <script>
  import ProductList from '@/components/ProductList.vue'; // 根据实际路径调整

  export default {
    components: {
        ProductList
    },
    data() {
      return {
        productList: [],
      };
    },
    created() {
      this.fetchItemsAll();
    },
    methods: {
      // 获取所有商品信息
      fetchItemsAll() {
        this.$axios
        ({
          method: "post",
          url:'/shelf_item_all', 
        })
        .then(response => {
          this.productList = response.data;
          console.log(response.data)
        })
        .catch(error => {
          console.error('Error fetching shelf items:', error);
        });
      },
      addItem() {
        this.$router.push({ name: 'ShelfItemRegister'});
      },
      goToProductDetail(productId) {
        // 跳转到商品详情页
        this.$router.push({ name: 'productDetail', params: { id: productId } });
      }
    },
  };
  </script>
  