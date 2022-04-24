import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AboutView from '../views/AboutView.vue'
import Product from "@/views/Product";
import ProductDetail from "@/views/ProductDetail";

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/product',
    name: 'product',
    component: Product
  },
  {
    path: '/about',
    name: 'about',
    component: AboutView
  },
  {
    path: '/detail/:id',
    name: 'ProductDetail',
    component: ProductDetail
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
