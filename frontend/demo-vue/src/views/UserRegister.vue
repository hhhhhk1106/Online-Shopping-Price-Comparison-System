<!-- UserRegister.vue -->

<template>
    <div>
      <UserStatus></UserStatus>
      <h3>用户注册</h3>
      <label>姓名：</label>
      <input v-model="user.name" type="text" placeholder="请输入姓名" /><br /><br />
      <label>年龄：</label>
      <input v-model="user.age" type="number" placeholder="请输入年龄" /><br /><br />
      <label>性别：</label>
      <input v-model="user.sex" type="text" placeholder="请输入性别" /><br /><br />
      <label>电话：</label>
      <input v-model="user.phone" type="text" placeholder="请输入电话" /><br /><br />
      <button @click="registerUser">注册</button>
    </div>
  </template>
  
  <script>
  export default {
    name: 'UserRegister',
    data() {
      return {
        user: {
          name: '',
          age: null,
          sex: '',
          phone: ''
        }
      };
    },
    methods: {
      registerUser() {
        if (!this.user.name || !this.user.age || !this.user.sex || !this.user.phone) {
            alert("请填写所有字段");
            return;
        }

        // 向后端发送注册请求
        this.$axios
          .post('/user_register', this.user)
          .then(response => {
            // 处理注册成功的逻辑
            console.log('注册成功', response.data);

            const role = localStorage.getItem('role');
            const userId = localStorage.getItem('id');
            if(role == 'user' && userId == 1) {
              // 管理员
              this.$router.replace({path: '/user_admin'})
              return;
            }

            localStorage.setItem("role", 'user');
            localStorage.setItem("id", response.data.data.id);
            this.$router.replace({path: '/'})
          })
          .catch(error => {
            // 处理注册失败的逻辑
            console.error('注册失败', error);
          });
      }
    }
  };
  </script>
  
  <style>
  /* 在这里添加样式 */
  </style>
  