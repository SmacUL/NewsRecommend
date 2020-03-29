<template>
    <card-panel>
        <img class="body-image" :src="logoSrc"/>
        <div class="body-title">
            <span>点击</span>
            <el-button type="text">登录</el-button>
            <span>开始书写自己的新闻</span>
        </div>
    </card-panel>
</template>

<script>
    import Logo from '../../assets/image/Pen.png'
    import CardPanel from './DarkCard'
    export default {
        name: 'EditEntrance',
        components: {CardPanel},
        data: function() {
            return {
                logoSrc: Logo
            }
        }
    }
</script>

<style scoped>

    .body-image {
        height: 50px;
    }

    .body-title .el-button >>> span {
        font-size: 16px;
        font-weight: 500;
    }

</style>
