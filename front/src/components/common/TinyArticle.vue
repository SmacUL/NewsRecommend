<template>
    <div class="tiny-article">
        <el-card>
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
.tiny-article .el-card {
    padding: 10px;
    border: 0px;
    border-radius: 0px;
}

.tiny-article .el-card.is-always-shadow {
    border-bottom: solid 1px rgba(0,0,0,.1);
    box-shadow: none;
}

.tiny-article .el-card.is-always-shadow:hover {
    box-shadow: 0 2px 12px 0 rgba(0,0,0,.1);
}

.tiny-article .image img {
    float: left;
    width: 27%;
    height: 120px;
    margin-right: 3%;
}

.tiny-article .el-card__body {
    padding: 0px;
}

.tiny-article .tiny-art {
    float: left;
    width: 70%;
    height: 120px;
    position: relative;
}

.tiny-article .title {
    height: 40px;
    line-height: 40px;
    font-size: 18pt;
    overflow: hidden;
    text-align: left;
    margin-bottom: 5px;
    font-weight: 800;
}

.tiny-article .description {
    height: 40px;
    line-height: 20px;
    overflow: hidden;
    text-align: left;
    color: #888888;
}

.tiny-article .info {
    text-align: left;
    font-size: 14px;
    position: absolute;
    bottom: 0px;
    color: #888888;
}

.tiny-article .info :first-child {
    font-weight: 400;
}

.tiny-article .info :last-child {
    font-weight: 100;
}

</style>