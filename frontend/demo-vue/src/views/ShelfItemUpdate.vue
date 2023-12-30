<!-- ShelfItemUpdate.vue -->

<template>
    <div>
      <h3>修改商品</h3>
      <p>商品ID: {{ item.id }}</p>
      <p>商品原型: {{ item.item.name }}</p>
      <p>平台: {{ item.platform.name }}</p>
  
      <label>名称：</label>
      <input v-model="item.name" type="text" placeholder="请输入名称" /><br /><br />
  
      <label>描述：</label>
      <input v-model="item.description" type="text" placeholder="请输入描述" /><br /><br />
  
      <label>产地：</label>
      <input v-model="item.origin" type="text" placeholder="请输入产地" /><br /><br />
  
      <label>生产日期：</label>
      <input v-model="production_date" type="date" placeholder="请输入生产日期" /><br /><br />
  
      <button @click="updateItem">保存修改</button>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        item: {
          id: null,
          item_id: null,
          item: {
            name: null,
          },
          platform_id: null,
          platform: {
            name: null,
          },
          merchant_id: null,
          name: null,
          description: null,
          origin: null,
          production_date: null,
        },
        production_date: null,
      };
    },
    methods: {
      // 根据商品ID获取商品信息
      fetchItemDetails() {
        this.item.id = this.$route.params.id;
        this.$axios
        ({
          method: "post",
          url:'/shelf_item_info_by_id', 
          params:{id:this.item.id}
        })
        .then(response => {
          this.item = response.data[0];
          this.production_date = this.formatDate(this.item.production_date);
          console.log(this.production_date)
        })
        .catch(error => {
          console.error('Error fetching shelf items:', error);
        });
      },
  
      // 保存修改
      updateItem() {
        // 调用后端接口或者使用 axios 将修改后的商品信息提交到后端进行保存
        const newItem = {};
        newItem.id = this.item.id;
        newItem.item_id = this.item.item_id;
        newItem.platform_id = this.item.platform_id;
        newItem.merchant_id = this.item.merchant_id;
        newItem.name = this.item.name;
        newItem.description = this.item.description;
        newItem.origin = this.item.origin;
        newItem.production_date = this.production_date;

        this.$axios
        .post('/shelf_item_update', newItem)
        .then(response => {
          console.log('注册成功', response.data);
          // this.$router.replace({path: '/merchant_info'})
          this.$router.push({ name: 'productDetail', params: { id: newItem.id } });
        })
        .catch(error => {
          console.error('Error updating item:', error);
          alert(response.data.message);
        });
      },
      formatDate(dateString) {
        const dateFormatter = new Intl.DateTimeFormat('en-US', {year: 'numeric',month: '2-digit',day: '2-digit'});
        // const options = { year: 'numeric', month: 'long', day: 'numeric' };
        const formattedDate = new Date(dateString).toLocaleDateString(undefined, dateFormatter);
        const formattedDateNew = formattedDate.replace('/', '-').replace('/', '-');
        return formattedDateNew;
      },
    },
    created() {
      // 在页面创建时调用 fetchItemDetails 方法，获取商品详情
      this.fetchItemDetails();
    },
  };
  </script>
  