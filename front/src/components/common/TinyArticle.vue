<template>
    <div class="tiny-article-inner">
        <el-card>
            <!-- el-card__body -->
            <div class="image">
                <img src="@/assets/logo.png">
            </div>
            <div class="tiny-art">
                <div class="title">{{news.title}}</div>
                <div class="description">{{news.abstract}}</div>
                <div class="info">
                    <span>{{news.author}}</span>
                    <span>{{news.date}}</span>
                </div>
            </div>
        </el-card>
    </div>
</template>

<script>
export default {
    props: ['news' ],
    name: 'TinyArticle',
    data: function() {
        return {

        }
    },
    methods: {

    }
}
</script>

<style>
.tiny-article-inner .el-card {
    padding: 10px;
    border: 0px;
    border-radius: 0px;
}

/* el-card__body */
.tiny-article-inner .image img {
    float: left;
    width: 27%;
    height: 120px;
    margin-right: 3%;
}

.tiny-article-inner .el-card__body {
    padding: 0px;
}

.tiny-article-inner .tiny-art {
    float: left;
    width: 70%;
    height: 120px;
    position: relative;
}

.tiny-article-inner .title {
    height: 40px;
    line-height: 40px;
    font-size: 18pt;
    overflow: hidden;
    text-align: left;
    margin-bottom: 5px;
    font-weight: 800;
}

.tiny-article-inner .description {
    height: 40px;
    line-height: 20px;
    overflow: hidden;
    text-align: left;
    color: #888888;
}

.tiny-article-inner .info {
    text-align: left;
    position: absolute;
    bottom: 0px;
    color: #888888;
}

.tiny-article-inner .info :first-child {
    font-weight: 400;
    /* font-size: 14px; */
    /* color: #299BE8 */
}

.tiny-article-inner .info :last-child {
    font-weight: 100;
}

</style>