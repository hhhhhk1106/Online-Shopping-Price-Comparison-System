<!-- ItemAdmin.vue -->

<template>
    <div>
      <UserStatus></UserStatus>
      <button @click="addItem">导入商品原型</button>
      <ItemList :users="itemList"/>
    </div>
  </template>
  
  <script>
  import ItemList from '@/components/ItemList.vue';

  export default {
    components: {
      ItemList
    },
    data() {
      return {
        itemList: [],
      };
    },
    created() {
      this.fetchItemsAll();
    },
    methods: {
      // 获取所有
      fetchItemsAll() {
        this.$axios
        ({
          method: "post",
          url:'/get_all_items', 
        })
        .then(response => {
          this.itemList = response.data;
          console.log(response.data)
        })
        .catch(error => {
          console.error('Error fetching items:', error);
        });
      },
      addItem() {
        this.$router.push({ name: 'ItemRegister'});
      },
    },
  };
  </script>
  