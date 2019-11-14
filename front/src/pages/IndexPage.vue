<template>
    <div>
        <header><top-bar class="top-bar clear-float"></top-bar></header>
        <!-- 页面主体 左中右 布局 -->
        <main class="clear-float">
            <nav><left-navigater :class="{'left-navigater': true}" :tags="tags"></left-navigater></nav>
            <article class="article-a">
                <div  v-for="(news, i) in newsList" :key="i">
                    <tiny-article class="tiny-article" :news="news"></tiny-article>
                </div>
            </article>
            <aside>
                <edit-entrance class="edit-entrance"></edit-entrance>
                <hot-article class="hot-article" :hotArticles='hotArticles'></hot-article>
            </aside>
        </main>
    </div>
</template>

<script>
// index
// common components
import EditEntrance from '@/components/common/EditEntrance'
import HotArticle from '@/components/common/HotArticle'
import LeftNavigater from '@/components/common/LeftNavigater'
import TinyArticle from '@/components/common/TinyArticle'
import TopBar from '@/components/common/TopBar'
// CSS
import '@/assets/css/Common.css'

export default {
    name: 'IndexPage',
    components: { EditEntrance, HotArticle, LeftNavigater, TinyArticle, TopBar },
    data: function() {
        return {
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
            tags: ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'],
            hotArticles: [
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
            ]
        }
    }
}
</script>

<style>

.top-bar {
    width: 1180px; 
    margin: 0 auto;
}

.left-navigater {
    background-color: blueviolet;
}

.tiny-article {
    /* background-color: #283272; */
    margin-bottom: 5px;
}

.edit-entrance {
    background-color: #238493;
    margin-bottom: 10px;
}

.hot-article {
    background-color: #910383;
}

</style>