<template>
    <div>
        <header><top-bar class="top-bar"></top-bar></header>
        <!-- 页面主体 左中右 布局 -->
        <main>
            <nav>
                <left-navigater :class="{'left-navigater': true}"
                                :tags="tags" :secondaryTags="secondaryTags" :showLast="true"></left-navigater>
            </nav>
            <article class="article-a">
                <div  v-for="(item, i) in articles" :key="i">
                    <tiny-article class="tiny-article" :item="item"></tiny-article>
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
    created: function () {
        this.getLeftNavtags();
    },

    methods: {
        /**
         * 获取左侧导航栏需要的标签
         */
        getLeftNavtags: function() {
            this.$axios.get('/api/index/tags').then(
                (response) => {
                    let border = 10;
                    this.tags = response.data.slice(0, border);
                    this.tags.push('更多');
                    this.secondaryTags = response.data.slice(border);
                    console.log(response.data)
                }
            ).catch(
                (response) => {
                    console.log(response)
                }
            )
        }
    },
    data: function() {
        return {
            articles: [
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
            secondaryTags: ['a', 'jj', 'ee', 'eek', 'e', 'kko','sd'],
            hotArticles: [
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
            ]
        }
    },

}
</script>

<style>

.tiny-article {
    margin-bottom: 10px;
}

.edit-entrance {
    background-color: #238493;
    margin-bottom: 10px;
}

.hot-article {
    background-color: #910383;
}

</style>
