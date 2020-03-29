<template>
    <div>
        <editor-brief class="editor-brief" :articleAuthor="articleAuthor"></editor-brief>
        <edit-entrance class="edit-entrance"></edit-entrance>
        <hot-article :title="hotArticle.title" :hot-articles="hotArticle.hotArticles"></hot-article>
    </div>
</template>


<script>
    import EditEntrance from '../common/EditEntrance'
    import HotArticle from '../common/HotArticle'

    import Logo from '../../assets/image/Logo.png'
    import EditorBrief from "../common/EditorBrief";

    export default {
        name: 'RightMenu',
        components: {
            EditorBrief,
            EditEntrance, HotArticle
        },
        data: function () {
            return {
                hotArticle: {
                    title: '相关新闻',
                    hotArticles: [
                        { artId: '1', artTitle: 'This is the template title of news', artImage: Logo},
                        { artId: '2', artTitle: 'This is the template title of news', artImage: ''},
                        { artId: '3', artTitle: 'This is the template title of news', artImage: ''},
                        { artId: '4', artTitle: 'This is the template title of news', artImage: Logo},
                        { artId: '5', artTitle: 'This is the template title of news', artImage: Logo},
                        { artId: '6', artTitle: 'This is the template title of news', artImage: Logo},
                    ]
                },
                articleAuthor: {
                    cusId: 6,
                    cusName: '中国新闻网',
                    cusAvatarUrl: 'https://p3.pstatp.com/large/97d001bf3f3cba72913',
                },
            }
        }
    }
</script>

<style scoped>
    .editor-brief, .edit-entrance {
        margin-bottom: 10px;
    }
</style>