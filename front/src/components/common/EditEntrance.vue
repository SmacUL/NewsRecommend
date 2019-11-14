<template>
    <div class="edit-entrance-inner">
        <el-card>
            <img class="image" src="@/assets/logo.png"/>
            <div class="title">
                <span>点击</span>
                <el-button type="text">登录</el-button>
                <span>开始书写自己的新闻</span>
            </div>
        </el-card>
    </div>
</template>

<script>
export default {
    name: 'EditEntrance'
}
</script>

<style>
.edit-entrance-inner .el-card {
    border-radius: 0px;
}

.edit-entrance-inner .el-card__body {
    padding: 10px;
}

.edit-entrance-inner .image {
    height: 70px;
}

.edit-entrance-inner .title .el-button span {
    font-size: 12pt;
}

</style>