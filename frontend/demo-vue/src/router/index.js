import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

import login from '@/views/login.vue'
import UserInfo from '@/views/UserInfo.vue'
import MerchantInfo from '@/views/MerchantInfo.vue'
import UserRegister from '@/views/UserRegister.vue'
import MerchantRegister from '@/views/MerchantRegister.vue'
import Home from '@/views/Home.vue';
import Search from '@/views/Search.vue';
import ProductDetail from '@/views/ProductDetail.vue';
import ShelfItemRegister from '@/views/ShelfItemRegister.vue';
import ShelfItemUpdate from '@/views/ShelfItemUpdate.vue';
import ShelfItemAdmin from '@/views/ShelfItemAdmin.vue';

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
      path: '/search/:keyword',
      name: 'Search',
      component: Search
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
      path: '/merchant_info',
      name: 'MerchantInfo',
      component: MerchantInfo
    },
    {
      path: '/user_register',
      name: 'UserRegister',
      component: UserRegister
    },
    {
      path: '/merchant_register',
      name: 'MerchantRegister',
      component: MerchantRegister
    },
    {
      path: '/product/:id',
      name: 'productDetail',
      component: ProductDetail
    },
    {
      path: '/shelf_item_register',
      name: 'ShelfItemRegister',
      component: ShelfItemRegister
    },
    {
      path: '/shelf_item_update/:id',
      name: 'ShelfItemUpdate',
      component: ShelfItemUpdate
    },
    {
      path: '/shelf_item_admin',
      name: 'ShelfItemAdmin',
      component: ShelfItemAdmin
    },
  ]
})
