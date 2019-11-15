<template>
    <div class="edit-entrance">
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
.edit-entrance .el-card {
    border-radius: 0px;
}

.edit-entrance .el-card.is-always-shadow {
    box-shadow: none;
    background-color: #f4f5f6;
}

.edit-entrance .el-card__body {
    padding: 10px;
}

.edit-entrance .image {
    height: 70px;
}

.edit-entrance .title .el-button span {
    font-size: 16px;
    font-weight: 500;
}

</style>