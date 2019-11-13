<template>
    <div>
        <header><top-bar class="top-bar"></top-bar></header>
        <!-- 页面主体 左中右 布局 -->
        <main class="clear-float">
            <nav><left-navigater :class="{'left-navigater': true}"></left-navigater></nav>
            <article><tiny-article class="tiny-article"></tiny-article></article>
            <aside>
                <edit-entrance class="edit-entrance"></edit-entrance>
                <hot-article class="hot-article"></hot-article>
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
    components: { EditEntrance, HotArticle, LeftNavigater, TinyArticle, TopBar }
    
}
</script>

<style>

.left-navigater {
    background-color: blueviolet;
}

.tiny-article {
    background-color: #283272;
}

.top-bar {
    background-color:#899289;
}

.edit-entrance {
    background-color: #238493;
}

.hot-article {
    background-color: #910383;
}

</style>