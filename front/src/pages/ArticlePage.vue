<template>
    <div>
        <header><top-bar></top-bar></header>
        <!-- 页面主体 左右 布局 -->
        <main>
            <article class="artcle-b">
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
// CSS
import '@/assets/css/Common.css'

export default {
    name: 'ArticlePage',
    components: {ArticleMain, CommentPanel, CommentReplyInput, ReplyPanel, EditorBrief,
                EditEntrance, HotArticle, TopBar}
    
}
</script>

<style>
article {
    float: left;
    width: 720px;
}
</style>