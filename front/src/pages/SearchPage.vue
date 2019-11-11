<template>
    <div>
        <header><top-bar></top-bar></header>
        <!-- 页面主体 左中右 布局 -->
        <main>
            <nav><left-navigater></left-navigater></nav>
            <article><tiny-article></tiny-article></article>
            <aside>
                <hot-article></hot-article>
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

export default {
    name: 'SearchPage',
    components: { HotArticle, LeftNavigater, TinyArticle, TopBar }
}
</script>

<style>

</style>