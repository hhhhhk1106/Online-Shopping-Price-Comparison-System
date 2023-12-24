<!-- Home.vue -->

<template>
    <div>
        <UserStatus></UserStatus>
      <h1>商品搜索</h1>
      <input v-model="searchKeyword" placeholder="输入关键词" />
      <button @click="searchProducts">搜索</button>
  
      <ProductList :products="productList" @productClick="goToProductDetail" />
    </div>
  </template>
  
  <script>
  import ProductList from '@/components/ProductList.vue'; // 根据实际路径调整
  
  export default {
    components: {
        ProductList  // 注册 ProductList 组件
    },
    data() {
      return {
        searchKeyword: '',
        productList: [],
      };
    },
    methods: {
      searchProducts() {
        // TODO:
        this.$axios
        ({
          method: "post",
          url:'/shelf_item_info_by_keyword', 
          params:{keyword:this.searchKeyword}
        })
        .then(response => {
          this.productList = response.data;
          console.log(response.data)
        })
        .catch(error => {
          console.error('Error fetching shelf items:', error);
        });
        // this.productList = this.fetchProductList(this.searchKeyword);
      },
      goToProductDetail(productId) {
        // 跳转到商品详情页，假设有一个名为 goToDetailPage 的方法
        // 你需要根据实际情况处理路由跳转
        this.$router.push({ name: 'productDetail', params: { id: productId } });
      }
    }
  };
  </script>
  