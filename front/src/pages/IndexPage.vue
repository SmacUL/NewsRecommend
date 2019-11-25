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
                    <!-- 'title', 'abstract', 'image', 'author', 'date' -->
                    <tiny-article class="tiny-article"
                                  :title="item.artTitle" :abstract="item.artAbstract" :image="item.artImage"
                                  :author="item.cusName" :date="item.artTime">
                    </tiny-article>
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
    created: function() {
        this.getLeftNavTags();
        this.getTinyArticles();
    },
    mounted: function() {
        window.addEventListener('scroll', this.scrollHandler, false);
    },
    methods: {
        /**
         * 获取左侧导航栏需要的标签
         */
        getLeftNavTags: function() {
            this.$axios.get('/api/index/tags?').then(
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
        },

        /**
         * 获取一次 tiny article 的数据
         */
        getTinyArticles: function() {
            this.$axios.get('/api/index/tiny?', {params: {tag: '综合', page: this.page, pageSize: this.pageSize}}).then(
                (response) => {
                    let articles = response.data;
                    articles.forEach(
                        (item, index, array) => {
                            let time = item['artTime'];
                            item['artTime'] = new Date(Date.parse(time)).toLocaleString();
                        }
                    );
                    this.page += 1;
                    if (this.articles.length === 0) {
                        this.articles = articles;
                    } else {
                        this.articles = this.articles.concat(articles);
                    }
                }
            ).catch(
                (response) => {
                    console.log(response)
                }
            )
        },

        /**
         * 当用户浏览到页面底部时, 弹出新的文章
         *
         * 当 main 的相对移动距离 >= main 的总高度 - (网页显示高度 - top bar 的高度) 认为浏览到底部
         * 计算距离的时候 考虑 margin
         */
        scrollHandler: function () {
            //
            let mainE = document.getElementsByTagName('main')[0];
            let topE = document.getElementsByTagName('header')[0];

            let mainEHeight = mainE.clientHeight;
            let topEHeight = topE.clientHeight;
            let browserHeight = document.documentElement.clientHeight || window.innerHeight || 0;
            let scrollHeight = document.documentElement.scrollTop || document.body.scrollTop || window.pageYOffset || 0;

            // 第一个 10 是 main 的 margin-bottom, 第二个 10 是 header 的 margin-bottom
            if (scrollHeight - 10 >= mainEHeight - (browserHeight - topEHeight - 10)) {
                // console.log(scrollHeight);
                // console.log(mainEHeight);
                // console.log(browserHeight);
                // console.log(topEHeight);
                this.getTinyArticles();
            }


        }

    },
    data: function() {
        return {
            // page: 当前用户浏览的页数
            page: 0,
            pageSize: 10,
            articles: [
                // {title:'asdfasdfasdfasdfasdfasdfasdf', abstract:'askldjfaskdjfklasjdfkajsdlfjsaddjfklasjdfklasjdfasdfd', author:'asdfd', date:'2019-09-09'},
                // {title:'asdfasdfasdfasdfasdfasdfasdf', abstract:'askldjfaskdjfklasjdfkajsdlfjsaddjfklasjdfklasjdfasdfd', author:'asdfd', date:'2019-09-09'},
                // {title:'asdfasdfasdfasdfasdfasdfasdf', abstract:'askldjfaskdjfklasjdfkajsdlfjsaddjfklasjdfklasjdfasdfd', author:'asdfd', date:'2019-09-09'},
                // {title:'asdfasdfasdfasdfasdfasdfasdf', abstract:'askldjfaskdjfklasjdfkajsdlfjsaddjfklasjdfklasjdfasdfd', author:'asdfd', date:'2019-09-09'},
                // {title:'asdfasdfasdfasdfasdfasdfasdf', abstract:'askldjfaskdjfklasjdfkajsdlfjsaddjfklasjdfklasjdfasdfd', author:'asdfd', date:'2019-09-09'},
                // {title:'asdfasdfasdfasdfasdfasdfasdf', abstract:'askldjfaskdjfklasjdfkajsdlfjsaddjfklasjdfklasjdfasdfd', author:'asdfd', date:'2019-09-09'},
                // {title:'asdfasdfasdfasdfasdfasdfasdf', abstract:'askldjfaskdjfklasjdfkajsdlfjsaddjfklasjdfklasjdfasdfd', author:'asdfd', date:'2019-09-09'},
                // {title:'asdfasdfasdfasdfasdfasdfasdf', abstract:'askldjfaskdjfklasjdfkajsdlfjsaddjfklasjdfklasjdfasdfd', author:'asdfd', date:'2019-09-09'},
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
