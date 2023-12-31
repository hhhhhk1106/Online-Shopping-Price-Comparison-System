<!-- ShelfItemUpdate.vue -->

<template>
    <div>
      <UserStatus></UserStatus>
      <h3>修改用户</h3>
      <p>用户ID: {{ user.id }}</p>
      <!-- <p>商品原型: {{ item.item.name }}</p> -->
      <!-- <p>平台: {{ item.platform.name }}</p> -->
  
      <label>姓名：</label>
      <input v-model="user.name" type="text" placeholder="请输入姓名" /><br /><br />
  
      <label>年龄：</label>
      <input v-model="user.age" type="number" placeholder="请输入年龄" /><br /><br />
  
      <label>性别：</label>
      <input v-model="user.sex" type="text" placeholder="请输入性别" /><br /><br />
  
      <label>电话：</label>
      <input v-model="user.phone" type="text" placeholder="请输入电话" /><br /><br />
  
      <button @click="updateUser">保存修改</button>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        user: {
          id: null,
          name: '',
          age: null,
          sex: '',
          phone: ''
        }
      };
    },
    created() {
      this.fetchUser();
    },
    methods: {
      // 根据ID获取用户信息
      fetchUser() {
        this.user.id = this.$route.params.id;
        this.$axios
        ({
          method: "post",
          url:'/user_info_by_id', 
          params:{id:this.user.id}
        })
        .then(response => {
          this.user = response.data;
          // console.log(this.production_date)
        })
        .catch(error => {
          console.error('Error fetching user:', error);
        });
      },
  
      // 保存修改
      updateUser() {
        // 调用后端接口或者使用 axios 将修改后的商品信息提交到后端进行保存
        const newUser = {};
        newUser.id = this.user.id;
        newUser.name = this.user.name;
        newUser.age = this.user.age;
        newUser.sex = this.user.sex;
        newUser.phone = this.user.phone;
        console.log(newUser)

        this.$axios
        .post('/user_update', newUser)
        .then(response => {
          console.log('修改成功', response.data);
          this.$router.replace({path: '/user_admin'})
        })
        .catch(error => {
          console.error('Error updating user:', error);
          alert(response.data.message);
        });
      },

    },

  };
  </script>
  