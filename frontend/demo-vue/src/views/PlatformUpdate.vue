<!-- PlatformUpdate.vue -->

<template>
    <div>
      <UserStatus></UserStatus>
      <h3>修改平台</h3>
      <p>平台ID: {{ platform.id }}</p>
  
      <label>名称：</label>
      <input v-model="platform.name" type="text" placeholder="请输入名称" /><br /><br />
  
      <button @click="updatePlatform">保存修改</button>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        platform: {
          name: '',
          address: '',
        }
      };
    },
    created() {
      this.fetchPlatform();
    },
    methods: {
      // 根据ID获取用户信息
      fetchPlatform() {
        this.platform.id = this.$route.params.id;
        this.$axios
        ({
          method: "post",
          url:'/platform_info_by_id', 
          params:{id:this.platform.id}
        })
        .then(response => {
          this.platform = response.data;
          // console.log(this.production_date)
        })
        .catch(error => {
          console.error('Error fetching platform:', error);
        });
      },
  
      // 保存修改
      updatePlatform() {
        // 调用后端接口或者使用 axios 将修改后的商品信息提交到后端进行保存
        const newPlatform = {};
        newPlatform.id = this.platform.id;
        newPlatform.name = this.platform.name;
        console.log(newPlatform)

        this.$axios
        .post('/platform_update', newPlatform)
        .then(response => {
          console.log('修改成功', response.data);
          this.$router.replace({path: '/platform_admin'})
        })
        .catch(error => {
          console.error('Error updating platform:', error);
          alert(response.data.message);
        });
      },

    },

  };
  </script>
  