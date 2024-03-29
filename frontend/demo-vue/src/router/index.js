import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
// 用户
import login from '@/views/login.vue'
import UserInfo from '@/views/UserInfo.vue'
import UserRegister from '@/views/UserRegister.vue'
import UserUpdate from '@/views/UserUpdate.vue';
import UserAdmin from '@/views/UserAdmin.vue'
// 商家
import MerchantInfo from '@/views/MerchantInfo.vue'
import MerchantRegister from '@/views/MerchantRegister.vue'
import MerchantUpdate from '@/views/MerchantUpdate.vue';
import MerchantAdmin from '@/views/MerchantAdmin.vue'
// 主页
import Home from '@/views/Home.vue';
import Search from '@/views/Search.vue';
// 商品
import ProductDetail from '@/views/ProductDetail.vue';
import ShelfItemRegister from '@/views/ShelfItemRegister.vue';
import ShelfItemUpdate from '@/views/ShelfItemUpdate.vue';
import ShelfItemAdmin from '@/views/ShelfItemAdmin.vue';
// 平台
import PlatformRegister from '@/views/PlatformRegister.vue'
import PlatformUpdate from '@/views/PlatformUpdate.vue';
import PlatformAdmin from '@/views/PlatformAdmin.vue'
// 商品原型
import ItemRegister from '@/views/ItemRegister.vue'
import ItemUpdate from '@/views/ItemUpdate.vue';
import ItemAdmin from '@/views/ItemAdmin.vue'

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
      path: '/user_register',
      name: 'UserRegister',
      component: UserRegister
    },
    {
      path: '/user_update/:id',
      name: 'UserUpdate',
      component: UserUpdate
    },
    {
      path: '/user_admin',
      name: 'UserAdmin',
      component: UserAdmin
    },

    {
      path: '/merchant_info',
      name: 'MerchantInfo',
      component: MerchantInfo
    },
    {
      path: '/merchant_register',
      name: 'MerchantRegister',
      component: MerchantRegister
    },
    {
      path: '/merchant_update/:id',
      name: 'MerchantUpdate',
      component: MerchantUpdate
    },
    {
      path: '/merchant_admin',
      name: 'MerchantAdmin',
      component: MerchantAdmin
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

    {
      path: '/platform_register',
      name: 'PlatformRegister',
      component: PlatformRegister
    },
    {
      path: '/platform_update/:id',
      name: 'PlatformUpdate',
      component: PlatformUpdate
    },
    {
      path: '/platform_admin',
      name: 'PlatformAdmin',
      component: PlatformAdmin
    },

    {
      path: '/item_register',
      name: 'ItemRegister',
      component: ItemRegister
    },
    {
      path: '/item_update/:id',
      name: 'ItemUpdate',
      component: ItemUpdate
    },
    {
      path: '/item_admin',
      name: 'ItemAdmin',
      component: ItemAdmin
    },
  ]
})
