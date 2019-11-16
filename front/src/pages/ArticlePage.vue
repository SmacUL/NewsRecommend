<template>
    <div>
        <header>
            <top-bar class="top-bar"></top-bar>
        </header>
        <!-- 页面主体 左右 布局 -->
        <main>
            <article class="article-b">
                <article-main :article=article :editor=editor></article-main>
                <comment-reply-input style='width: 100%'></comment-reply-input>
                <comment-panel></comment-panel>
            </article>
            <aside>
                <editor-brief class="editor-brief" :recentArticles=recentArticles :editor=editor></editor-brief>
                <edit-entrance class="edit-entrance"></edit-entrance>
                <hot-article class="hot-article" :hotArticles='hotArticles'></hot-article>
            </aside>
        </main>
    </div>
</template>

<script>
// article
import ArticleMain from '@/components/article/ArticleMain'
import CommentPanel from '@/components/article/CommentPanel'
import CommentReplyInput from '@/components/article/CommentReplyInput'
// import ReplyPanel from '@/components/article/ReplyPanel'
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
    data: function() {
        return {
            hotArticles: [
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
            ],
            editor: {
                id: 6,
                name: '中国新闻网', 
                avaterUrl: 'https://p3.pstatp.com/large/97d001bf3f3cba72913',
            },
            recentArticles: [
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
                {title: 'asdfjasjdfkljakldjlfkasjlkdfjlakjflkajflkasjklfjkasldfj'},
            ],
            article: {
                id: 0, 
                title: '各国美食云集第二届进博会', 
                abstract: '11月6日，参观者在第二届进博会上品尝各国美食。在国家会展中心(上海)举行的第二届中国国际进口博览会，吸引了来自150多个国家和地区的3000多家企业签约参展。其中，各国美食云集的食品馆深受参观者青睐。巨型金枪鱼吸引参观者。参观者在第二届进博会上品尝各国美食。',
                content: '<img src="http://p3.pstatp.com/large/pgc-image/Rh1h9Oy4vRcB6U" img_width="550" img_height="366" alt="各国美食云集第二届进博会" inline="0"><p>11月6日，参观者在第二届进博会上品尝各国美食。在国家会展中心(上海)举行的第二届中国国际进口博览会，吸引了来自150多个国家和地区的3000多家企业签约参展。其中，各国美食云集的食品馆深受参观者青睐。</p><img src="http://p3.pstatp.com/large/pgc-image/Rh1h9PB6EFaAo7" img_width="550" img_height="366" alt="各国美食云集第二届进博会" inline="0"><p>巨型金枪鱼吸引参观者。</p><img src="http://p1.pstatp.com/large/pgc-image/Rh1h9PMEzPme1T" img_width="550" img_height="366" alt="各国美食云集第二届进博会" inline="0"><p>参观者在第二届进博会上品尝各国美食。</p><img src="http://p9.pstatp.com/large/pgc-image/Rh1h9PX4tbjTOO" img_width="550" img_height="343" alt="各国美食云集第二届进博会" inline="0"><p>产自俄罗斯的帝王蟹吸引参观者。</p><img src="http://p1.pstatp.com/large/pgc-image/Rh1h9Ph4Uvtkb" img_width="550" img_height="366" alt="各国美食云集第二届进博会" inline="0"><p>参观者在第二届进博会上选购各国美食。（中新社记者 汤彦俊 摄）</p>',
                tag: '国际',
                likeNum: 0,
                dislikeNum: 0,
                time: '2019-11-06 15:24:40',
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