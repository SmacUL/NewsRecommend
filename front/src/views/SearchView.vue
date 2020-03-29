<template>
    <div>
        <header><top-bar class="top-bar"></top-bar></header>
        <main>
            <article>
                <tiny-center></tiny-center>
            </article>
            <aside>
                <!--<right-menu></right-menu>-->
                <edit-entrance class="edit-entrance"></edit-entrance>
                <hot-article :title="hotArticle.title" :hot-articles="hotArticle.hotArticles" v-on:refresh="refreshHot"></hot-article>
            </aside>
        </main>
    </div>
</template>

<script>
    import TopBar from "../components/search/TopBar";
    import TinyCenter from "../components/search/TinyCenter";
    import EditEntrance from "../components/common/EditEntrance";
    import HotArticle from "../components/common/HotArticle";
    // import RightMenu from "../components/index/RightMenu";

    import Logo from '../assets/image/Logo.png'

    export default {
        name: "SearchView",
        components: {HotArticle, EditEntrance, TinyCenter, TopBar},
        methods: {
            refreshHot: function () {
                this.hotArticle.page += 1;
                this.getHotArts();
            }
        },
        data: function () {
            return {
                hotArticle: {
                    page: 0,
                    pageSize: 6,
                    title: '热点新闻',
                    hotArticles: [
                        { artId: '1', artTitle: 'This is the template title of news', artImageUrl: Logo},
                        { artId: '2', artTitle: 'This is the template title of news', artImageUrl: ''},
                        { artId: '3', artTitle: 'This is the template title of news', artImageUrl: ''},
                        { artId: '4', artTitle: 'This is the template title of news', artImageUrl: Logo},
                        { artId: '5', artTitle: 'This is the template title of news', artImageUrl: Logo},
                        { artId: '6', artTitle: 'This is the template title of news', artImageUrl: Logo},
                    ]
                },
            }
        }
    }
</script>

<style scoped src="../assets/css/Narrow.css"></style>
<style scoped>
    .edit-entrance {
        margin-bottom: 10px;
    }

</style>