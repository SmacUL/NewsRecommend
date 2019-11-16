<template>
    <div>
        <header><top-bar class="top-bar"></top-bar></header>
        <!-- 页面主体 左中右 布局 -->
        <main>
            <nav>
                <left-navigater :class="{'left-navigater': true}" :tags="tags"></left-navigater>
            </nav>
            <article class="article-a">
                <div  v-for="(news, i) in newsList" :key="i">
                    <tiny-article class="tiny-article" :news="news"></tiny-article>
                </div>
            </article>
            <aside>
                <hot-article class="hot-article" :hotArticles='hotArticles'></hot-article>
            </aside>
        </main>
    </div>
</template>

<script>
// search
// common
import HotArticle from '@/components/common/HotArticle'
import LeftNavigater from '@/components/common/LeftNavigater'
import TinyArticle from '@/components/common/TinyArticle'
import TopBar from '@/components/common/TopBar'
// CSS
import '@/assets/css/Common.css'

export default {
    name: 'SearchPage',
    components: { HotArticle, LeftNavigater, TinyArticle, TopBar },
    data: function () {
        return {
            tags: ['综合', '文章', '用户'],
            hotArticles: [
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
            ],
            newsList: [
                {title:'asdfasdfasdfasdfasdfasdfasdf', abstract:'askldjfaskdjfklasjdfkajsdlfjsaddjfklasjdfklasjdfasdfd', author:'asdfd', date:'2019-09-09'},
                {title:'asdfasdfasdfasdfasdfasdfasdf', abstract:'askldjfaskdjfklasjdfkajsdlfjsaddjfklasjdfklasjdfasdfd', author:'asdfd', date:'2019-09-09'},
                {title:'asdfasdfasdfasdfasdfasdfasdf', abstract:'askldjfaskdjfklasjdfkajsdlfjsaddjfklasjdfklasjdfasdfd', author:'asdfd', date:'2019-09-09'},
                {title:'asdfasdfasdfasdfasdfasdfasdf', abstract:'askldjfaskdjfklasjdfkajsdlfjsaddjfklasjdfklasjdfasdfd', author:'asdfd', date:'2019-09-09'},
                {title:'asdfasdfasdfasdfasdfasdfasdf', abstract:'askldjfaskdjfklasjdfkajsdlfjsaddjfklasjdfklasjdfasdfd', author:'asdfd', date:'2019-09-09'},
                {title:'asdfasdfasdfasdfasdfasdfasdf', abstract:'askldjfaskdjfklasjdfkajsdlfjsaddjfklasjdfklasjdfasdfd', author:'asdfd', date:'2019-09-09'},
                {title:'asdfasdfasdfasdfasdfasdfasdf', abstract:'askldjfaskdjfklasjdfkajsdlfjsaddjfklasjdfklasjdfasdfd', author:'asdfd', date:'2019-09-09'},
                {title:'asdfasdfasdfasdfasdfasdfasdf', abstract:'askldjfaskdjfklasjdfkajsdlfjsaddjfklasjdfklasjdfasdfd', author:'asdfd', date:'2019-09-09'},
            ],
        }
    }
}
</script>

<style>

</style>
