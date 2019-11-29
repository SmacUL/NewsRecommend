<template>
    <div class="clear-float">
        <div class="image">
            <img src="@/assets/image/Logo.png"/>
        </div>
        <div class="search">
            <el-input v-model="message" placeholder="请输入内容"></el-input>
            <el-button type="primary" @click="searchArticles">搜索</el-button>
        </div>
        <div class="manage">
            <el-button type="text">登录</el-button>
            <el-button type="text">注册</el-button>
        </div>
    </div>
</template>

<script>
export default {
    name: 'TopBar',
    props: ['message'],

    methods: {
        searchArticles: function () {
            this.$emit('search', this.message);
        }
    },
    data: function() {
        return {
            // message: ''
        }
    }
}
</script>

<style>
/* .top-bar {
    padding: 10px 0px 10px 0px;
} */

.top-bar .image {
    float: left; 
    height: 40px;
    margin-top: 5px;
}

.top-bar .image img {
    height: 30px;
    width: 130px;
}

.top-bar .search {
    width: 400px; 
    float: left; 
    margin-left: 20%;
}

.top-bar .search .el-input {
    width: 300px;
    float: left;
}

.top-bar .search .el-input__inner {
    border-radius: 5px 0px 0px 5px;
    line-height: unset;
}

.top-bar .search .el-button {
    float: left; 
    border-radius: 0px 5px 5px 0px;
}

.top-bar .manage {
    float: right;
}

.top-bar .manage .el-button {
    font-size: 18px;
}

</style>
