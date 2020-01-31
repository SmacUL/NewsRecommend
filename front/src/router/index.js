import Vue from 'vue'
import VueRouter from 'vue-router'
// import Home from '../views/Home.vue'


import IndexView from '../views/IndexView'
import SearchView from '../views/SearchView'
import ArticleView from "../views/ArticleView"
import SelfView from '../views/SelfView'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'IndexView',
    component: IndexView
  },
  {
    path: '/index',
    name: 'IndexView',
    component: IndexView
  },
  {
    path: '/search',
    name: 'SearchView',
    component: SearchView
  },
  {
    path: '/article',
    name: 'ArticleView',
    component: ArticleView
  },
  {
    path: '/self',
    name: 'SelfView',
    component: SelfView
  }

  // {
  //   path: '/about',
  //   name: 'about',
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  // }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
