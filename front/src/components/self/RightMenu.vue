<template>
    <div>
        <div class="achievement-panel">
            <div class="follower-followee">
                <div class="follow" >
                    <span class="follow-num">{{info.followNum}}</span>
                    <span class="follow-tip">关注了</span>
                </div>
                <div  class="follow">
                    <span class="follow-num">{{info.fanNum}}</span>
                    <span class="follow-tip">粉丝</span>
                </div>
            </div>
            <hr>
            <h2>个人成就</h2>
            <div class="achievement">
                <i class="el-icon-star-on icon"></i>
                <span>阅读了</span>
                <span class="achievement-num">{{info.readNum}}</span>
                <span>篇文章 </span>
            </div>
            <div class="achievement">
                <i class="el-icon-edit icon"></i>
                <span>发表了</span>
                <span class="achievement-num">{{info.artEditNum}}</span>
                <span>篇文章</span>
            </div>
            <div class="achievement">
                <i class="el-icon-star-on icon"></i>
                <span>编辑了</span>
                <span class="achievement-num">{{info.comEditNum + info.repEditNum}}</span>
                <span>次评论 </span>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "RightMenu",
        props: ["info"],


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
        margin-right: 5px;
        margin-left: 5px;
    }
</style>