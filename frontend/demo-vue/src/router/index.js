import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

import login from '@/views/login.vue'
import UserInfo from '@/views/UserInfo.vue'
import Home from '@/views/Home.vue';
import ProductDetail from '@/views/ProductDetail.vue';

Vue.use(Router)

export default new Router({
  routes: [
    // {
    //   path: '/',
    //   name: 'HelloWorld',
    //   component: HelloWorld
    // },
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/login',
      name: 'login',
      component: login
    },
    {
      path: '/user_info',
      name: 'UserInfo',
      component: UserInfo
    },
    {
      path: '/product/:id',
      name: 'productDetail',
      component: ProductDetail
    },
  ]
})
