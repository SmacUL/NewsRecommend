<template>
    <div>
        <!-- This is article page.
        <article-main></article-main> -->
        <header><top-bar></top-bar></header>
        <!-- 页面主体 左右 布局 -->
        <main>
            <article>
                <article-main></article-main>
                <comment-reply-input></comment-reply-input>
                <comment-panel></comment-panel>
            </article>
            <aside>
                <editor-brief></editor-brief>
                <edit-entrance></edit-entrance>
                <hot-article></hot-article>
            </aside>
        </main>
    </div>
</template>

<script>
// article
import ArticleMain from '@/components/article/ArticleMain'
import CommentPanel from '@/components/article/CommentPanel'
import CommentReplyInput from '@/components/article/CommentReplyInput'
import ReplyPanel from '@/components/article/ReplyPanel'
import EditorBrief from '@/components/article/EditorBrief'
// common
import EditEntrance from '@/components/common/EditEntrance'
import HotArticle from '@/components/common/HotArticle'
import TopBar from '@/components/common/TopBar'

export default {
    name: 'ArticlePage',
    components: {ArticleMain, CommentPanel, CommentReplyInput, ReplyPanel, EditorBrief,
                EditEntrance, HotArticle, TopBar}
    
}
</script>

<style>

</style>