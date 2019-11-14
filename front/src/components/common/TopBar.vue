<template>
    <div class="clear-float top-bar-inner">
        <div class="image">
            <img src="@/assets/image/Logo.png"/>
        </div>
        <div class="search">
            <el-input v-model="input" placeholder="请输入内容"></el-input>
            <el-button type="primary">搜索</el-button>
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
    data: function() {
        return {
            input: ''
        }
    }
}
</script>

<style>
.top-bar-inner {
    padding: 10px 0px 10px 0px;
    margin: 0 auto;
}

.top-bar-inner .image {
    float: left; 
    height: 40px;
    margin-top: 5px;
}

.top-bar-inner .image img {
    height: 30px;
    width: 140px;
}

.top-bar-inner .search {
    width: 400px; 
    float: left; 
    margin-left: 20%;
}

.top-bar-inner .search .el-input {
    width: 300px;
    float: left;
}

.top-bar-inner .search .el-input__inner {
    border-radius: 5px 0px 0px 5px;
}

.top-bar-inner .search .el-button {
    float: left; 
    border-radius: 0px 5px 5px 0px;
}

.top-bar-inner .manage {
    float: right;
}

.top-bar-inner .manage .el-button {
    font-size: 18px;
}

</style>