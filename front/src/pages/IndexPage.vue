<template>
    <div>
        <header><top-bar></top-bar></header>
        <!-- 页面主体 左中右 布局 -->
        <main>
            <nav><left-navigater></left-navigater></nav>
            <article><tiny-article></tiny-article></article>
            <aside>
                <edit-entrance></edit-entrance>
                <hot-article></hot-article>
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


export default {
    name: 'IndexPage',
    components: { EditEntrance, HotArticle, LeftNavigater, TinyArticle, TopBar }
    
}
</script>

<style>

</style>