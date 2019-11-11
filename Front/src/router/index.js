import Vue from 'vue'
import Router from 'vue-router'
// 主页面
import ArticlePage from '@/pages/ArticlePage'
import IndexPage from '@/pages/IndexPage'
import PortPage from '@/pages/PortPage'
import SearchPage from '@/pages/SearchPage'
import SelfPage from '@/pages/SelfPage'

Vue.use(Router)

export default new Router({
    routes: [
        {
            path: '/',
            alias: '/index',
            name: 'IndexPage',
            component: IndexPage
        },
        {
            path: '/index',
            name: 'IndexPage', 
            component: IndexPage,
        },
        {
            path: '/article',
            name: 'ArticlePage', 
            component: ArticlePage,
        },
        {
            path: '/port',
            name: 'PortPage', 
            component: PortPage,
        },
        {
            path: '/search',
            name: 'SearchPage', 
            component: SearchPage,
        },
        {
            path: '/self',
            name: 'SelfPage', 
            component: SelfPage,
        },
    ]
})
