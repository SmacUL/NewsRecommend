<template>
    <div>
        <header>
            <top-bar class="top-bar"></top-bar>
        </header>
        <!-- 页面主体 左右 布局 -->
        <main>
            <article class="article-b">
                <article-main :articleMain="articleMain"></article-main>
                <comment-reply-input :heightKey=true style='width: 100%'></comment-reply-input>
                <comment-panel></comment-panel>
            </article>
            <aside>
                <editor-brief class="editor-brief" :articleAuthor='articleAuthor' @editor="jumpToCustomer" @jump="jumpToArticle">
                </editor-brief>
                <edit-entrance class="edit-entrance"></edit-entrance>
                <hot-article class="hot-article" :hotArticles='hotArticles' :title="'相关阅读'"
                             @refresh="getHotArticles" @jump="dumpToArticle">
                </hot-article>
            </aside>
        </main>
    </div>
</template>

<script>
// article
import ArticleMain from '@/components/article/ArticleMain'
import CommentPanel from '@/components/article/CommentPanel'
import CommentReplyInput from '@/components/article/CommentReplyInput'
import EditorBrief from '@/components/article/EditorBrief'
// common
import EditEntrance from '@/components/common/EditEntrance'
import HotArticle from '@/components/common/HotArticle'
import TopBar from '@/components/common/TopBar'
// CSS
import '@/assets/css/Common.css'

export default {
    name: 'ArticlePage',
    components: {ArticleMain, CommentPanel, CommentReplyInput, EditorBrief,
                EditEntrance, HotArticle, TopBar},
    created: function() {
        this.getArticleMain();
    },
    methods: {

        /**
         * 获取文章的主体内容
         */
        getArticleMain: function() {
            // alert(this.$route.params.artid);
            this.$axios.get('/api/article/main', {params: {id: this.$route.params.artid}}).then(
                (response) => {
                    this.articleMain = response.data;
                    window.scrollTo(0, 0);
                    // console.log(response.data);
                    this.getHotArticles();
                    this.getAuthorInfo();
                }
            ).catch(
                (response) => {
                    console.log(response.data);
                }
            )
        },

        /**
         * 获取文章作者信息以及相关文章内容
         */
        getAuthorInfo: function() {
            this.$axios.get('/api/article/author', {params: {artId: this.$route.params.artid, pageSize: '4'}}).then(
                (response) => {
                    this.articleAuthor = response.data;
                    // console.log(response.data);
                }
            ).catch(
                (response) => {
                    console.log(response.data);
                }
            )
        },

        /**
         * 跳转到指定 id 的文章页面
         *
         * @Param: artId
         */
        jumpToArticle: function(artId) {
            let routeData = this.$router.resolve({ name: 'ArticlePage', params: {'artid': artId.toString()} });
            window.open(routeData.href, '_blank');
        },

        jumpToCustomer: function(cusId) {
            let routeData = this.$router.resolve({ name: 'SelfPage', params: {'type': 'cus', 'id': cusId.toString()} });
            window.open(routeData.href, '_blank');
        },

        /**
         * 提供右侧的热点文章
         */
        getHotArticles: function() {
            this.$axios.get('/api/article/hot?',
                {params: {tag: this.articleMain.artTag, page: this.hotPage, pageSize: this.hotPageSize}}).then(
                (response) => {
                    console.log(response.data);
                    this.hotArticles =  response.data;
                    this.hotPage += 1;
                }
            ).catch(
                (response) => {
                    console.log(response)
                }
            )
        },
    },
    data: function() {
        return {

            hotPage: 0,
            hotPageSize: 6,

            hotArticles: [
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
            ],
            articleAuthor: {
                cusId: 6,
                cusName: '中国新闻网',
                cusAvatarUrl: 'https://p3.pstatp.com/large/97d001bf3f3cba72913',
                hotArticles: [
                    {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                    {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                    {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                    {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                ]
            },
            // recentArticles: [
            //     {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
            //     {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
            //     {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
            //     {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
            // ],
            articleMain: {
                artId: 4,
                artTitle: "上海公安机关：外媒报道的所谓“中国特工”王立强系涉案在逃人员",
                artContent: "<p>新华社上海11月23日电 记者从上海市公安局静安分局获悉，澳大利亚《悉尼先驱晨报》报道的所谓“…护照和香港永久居民身份证均系伪造证件。</p><p>目前，公安机关对此案正在进一步调查中。</p>",
                artTag: "综合",
                artLikeNum: 0,
                artDislikeNum: 0,
                artTime: '2019-11-25T10:05:44.000+0000',
                cusName: '国际在线'
            }

        }
    }
    
}
</script>

<style>
/* .top-bar {
    width: 1180px; 
    position: fixed;
    left: -590px;
    margin-left: 50%;
} */

.editor-brief {
    margin-bottom: 10px;
}

.edit-entrance {
    margin-bottom: 10px;
}


</style>
