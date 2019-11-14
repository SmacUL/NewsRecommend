<template>
    <div>
        <header><top-bar></top-bar></header>
        <section><achievement-panel></achievement-panel></section>
        <!-- 页面主体 左右 布局 -->
        <main>
            <article class="article-b"><tiny-article></tiny-article></article>
            <aside><show-panel></show-panel></aside>
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
    components: { AchievementPanel, ShowPanel, TinyArticle, TopBar }
}
</script>

<style>
article {
    float: left;
    width: 720px;
}
</style>