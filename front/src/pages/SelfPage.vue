<template>
    <div>
        <header><top-bar class="top-bar" style="width: 1020px;margin-left: 50%;left: -510px;"></top-bar></header>
        <section style="width: 1020px;"><show-panel></show-panel></section>
        <!-- 页面主体 左右 布局 -->
        <main class="clear-float" style="width: 1020px;margin-top: 20px;">
            <article class="article-b" style="width: 710px;">
                <div v-for="(item, i) in articles" :key="i" style="margin-bottom: 10px;">
                    <tiny-article class="tiny-article"  :item="item">

                    </tiny-article>
                </div>
            </article>
            <aside :style="asideStyle" style="margin-left: 740px;">
                <achievement-panel></achievement-panel>
            </aside>
        </main>
    </div>
</template>

<script>
// self
import AchievementPanel from '@/components/self/AchievementPanel'
import ShowPanel from '@/components/self/ShowPanel'
// common
import TinyArticle from '@/components/common/TinyArticle'
import TopBar from '@/components/common/TopBar'
// CSS
import '@/assets/css/Common.css'

export default {
    name: 'SelfPage',
    components: { AchievementPanel, ShowPanel, TinyArticle, TopBar },
    mounted: function() {
        window.addEventListener('scroll', this.scrollHandler, true);
    },
    data: function () {
        return {
            asideStyle: 'position: static',
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
        }
    },
    methods: {
        scrollHandler: function () {
            var scrollDis = document.documentElement.scrollTop || document.body.scrollTop || window.pageYOffset || 0;
            if (scrollDis > 320) {
                this.asideStyle = 'margin-top: 10px';
            } else {
                this.asideStyle = 'position: static;';
            }
            // console.log(document.documentElement.clientHeight);
        }
    }
}
</script>

<style>
article {
    float: left;
    width: 720px;
}
</style>
