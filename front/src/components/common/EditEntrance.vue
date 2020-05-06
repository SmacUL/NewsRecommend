<template>
    <card-panel>
        <img class="body-image" :src="logoSrc"/>
        <div class="body-title">
            <!--<span>点击</span>-->
            <el-button type="text" @click="jumpToEdit">点击</el-button>
            <span>开始书写自己的新闻</span>
        </div>
    </card-panel>
</template>

<script>
    import Logo from '../../assets/image/Pen.png'
    import CardPanel from './DarkCard'
    import {jumpInNewPage} from "../../util/PageJump";
    export default {
        name: 'EditEntrance',
        components: {CardPanel},
        methods: {
            jumpToEdit: function () {
                jumpInNewPage('/edit');
            }
        },
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
