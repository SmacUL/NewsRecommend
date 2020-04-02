<template>
    <div>
        <header><top-bar class="top-bar" :customer="customer"></top-bar></header>
        <main>
            <article>
                <article-main :articleMain="artMain"></article-main>
                <comment-reply-main></comment-reply-main>
            </article>
            <aside>
                <editor-brief class="editor-brief" :articleAuthor="artMain.customer" v-on:editor="jumpToCustomer"></editor-brief>
                <edit-entrance class="edit-entrance"></edit-entrance>
                <hot-article :title="page.hotTitle" :hot-articles="hotArticles"
                             v-on:refresh="refreshHot" v-on:jump="jumpToArticle"></hot-article>
            </aside>
        </main>
    </div>
</template>

<script>
    import TopBar from "../components/article/TopBar";
    import CommentReplyMain from "../components/article/CommentReplyCenter";
    import ArticleMain from "../components/article/ArticleCenter";
    import EditorBrief from "../components/common/EditorBrief";
    import EditEntrance from "../components/common/EditEntrance";
    import HotArticle from "../components/common/HotArticle";

    import Logo from '../assets/image/Logo.png'

    export default {
        name: "ArticleView",
        components: {HotArticle, EditEntrance, EditorBrief, ArticleMain, CommentReplyMain, TopBar},
        mounted: function() {
            let artId = this.$route.params.artId;
            this.$axios.get('/api/self/own')
                .then((response) => {
                    if (response.data) {
                        this.customer = response.data;
                    } else {
                        this.$router.push({path: '/port'});
                    }
                });
            this.$axios.get('/api/load/main?artId=' + artId)
                .then((response) => {
                    this.artMain = response.data;
                });
            this.$axios.get('/api/load/hot?page=' + this.page.hotPage + '&pageSize=' + this.page.hotPageSize)
                .then((response) => {
                    this.hotArticles = response.data;
                });
        },
        methods: {
            /**
             * 刷新热点新闻
             */
            refreshHot: function () {
                if (this.page.hotPage > 3) {
                    this.page.hotPage = 0;
                } else {
                    this.page.hotPage += 1;
                }
                this.$axios.get('/api/load/hot?page=' + this.page.hotPage + '&pageSize=' + this.page.hotPageSize)
                    .then((response) => {
                        this.hotArticles = response.data;
                    })
                    .catch(() => {
                        this.$message.info("抱歉, 发生了点故障");
                    });
            },

            /**
             * 跳转至文章页面
             * @param artId
             */
            jumpToArticle: function (artId) {
                this.$message.info(' ' + artId);
                let route = this.$router.resolve('/article/' + artId)
                // this.$router.push({name: '/article/', params: {artId: artId, isFresh: true}})
                // this.$router.push({name: '/article/'+ artId, params: {isFresh: true}})
                window.open(route.href, '_self');
            },

            jumpToCustomer: function (cusId) {
                this.$router.push('/self/' + cusId);
            }
        },
        data: function () {
            return {
                page: {
                    hotTitle: '热点新闻',
                    hotPage: 0,
                    hotPageSize: 6
                },
                customer: {

                },
                artMain: {

                },
                hotArticles: [
                    { artId: '1', artTitle: 'This is the template title of news', artImageUrl: Logo},
                    { artId: '2', artTitle: 'This is the template title of news', artImageUrl: ''},
                    { artId: '3', artTitle: 'This is the template title of news', artImageUrl: ''},
                    { artId: '4', artTitle: 'This is the template title of news', artImageUrl: Logo},
                    { artId: '5', artTitle: 'This is the template title of news', artImageUrl: Logo},
                    { artId: '6', artTitle: 'This is the template title of news', artImageUrl: Logo},
                ],
            }
        }
    }
</script>

<style scoped src="../assets/css/Narrow.css"></style>
<style scoped>
    .editor-brief, .edit-entrance {
        margin-bottom: 10px;
    }


</style>