<template>
    <div class="achievement-panel">
        <div class="follower-followee">
            <div class="follow" >
                <span class="follow-num">22</span>
                <span class="follow-tip">关注了</span>
            </div>
            <div  class="follow">
                <span class="follow-num">1000</span>
                <span class="follow-tip">粉丝</span>
            </div>
        </div>
        <hr>
        <h2>个人成就</h2>
        <div class="achievement">
            <i class="el-icon-edit icon"></i>
            <span>发表了</span>
            <span class="achievement-num"> 2 </span>
            <span>篇文章</span>
        </div>
        <div class="achievement">
            <i class="el-icon-star-on icon"></i>
            <span>总结获得了</span>
            <span class="achievement-num">2222</span>
            <span>次点赞 </span>
        </div>

    </div>
</template>

<script>
export default {
    name: 'AchievementPanel'
}
</script>

<style scoped>
    .achievement-panel {
        padding: 15px;
        height: 200px;
        background: #f4f5f6;
    }

    .follower-followee {
        display: flex;
    }

    .follow {
        flex: 1;
    }

    .follow-num {
        display: block;
        font-size: 20px;
        font-weight: 500;
    }

    .follow-tip {
        display: block;
    }

    h2 {
        margin: 10px 0px;
    }

    .icon {
        margin-right: 10px
    }

    .achievement {
        text-align: left;
    }

    .achievement-num {
        font-size: 20px;
        font-weight: 500;
    }


</style>
