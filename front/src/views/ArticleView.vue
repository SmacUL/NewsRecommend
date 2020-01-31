<template>
    <div>
        <header><top-bar class="top-bar"></top-bar></header>
        <main>
            <article>
                <!--<main-panel></main-panel>-->
                <article-main></article-main>
                <comment-reply-main></comment-reply-main>
            </article>
            <aside>
                <right-menu></right-menu>
            </aside>
        </main>
    </div>
</template>

<script>
    import TopBar from "../components/article/TopBar";
    import RightMenu from "../components/article/RightMenu";
    import CommentReplyMain from "../components/article/CommentReplyCenter";
    import ArticleMain from "../components/article/ArticleCenter";
    // import MainPanel from "../components/article/MainPanel";
    export default {
        name: "ArticleView",
        // components: {MainPanel, RightMenu, TopBar}
        components: {ArticleMain, CommentReplyMain, RightMenu, TopBar}
    }
</script>

<style scoped src="../assets/css/Narrow.css"></style>
<style scoped>

</style>