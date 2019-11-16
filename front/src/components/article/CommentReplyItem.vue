<template>
    <div class="clear-float">
        <div class="avater">
            <img src="@/assets/logo.png">
        </div>
        <div class="comment">
            <div style="text-align: left; font-weight: 500; font-size: 18px;">
                <span>{{name}}</span>
                <span style="font-weight:400; font-size:16px;" v-if="replyId >= 0"> 回复 </span>
                <span v-if="replyId >= 0">{{replyName}}</span>
            </div>
            <div class="content">{{content}}</div>
            <div class="info">
                <span>{{time}}</span>
                <span>{{likenum}}</span>
                <el-button type="text" @click="replyMessage()">
                    <span v-show="showResult">收起</span>
                    <span v-show="!showResult">评论</span>
                </el-button>
            </div>
        </div>
        <comment-reply-input v-if="showResult"></comment-reply-input>
    </div>
</template>

<script>
import CommentReplyInput from '@/components/article/CommentReplyInput'

export default {
    props: ['id', 'name', 'content', 'time', 'likenum', 'replyId', 'replyName', 
            'readyType', 'readyId'],
    name: 'CommonReplyItem',
    components: {CommentReplyInput},
    data: function() {
        return {
            readyReplyId: -1,
        }
    },
    computed: {
        showResult: function() {
            return (this.readyId == this.id && this.replyId == this.readyType)
        },
    },
    methods: {
        replyMessage() {
            // 取消 提示的出现和 输入框 绑定在一起,
            // 只有当输入框出现了, 点击按钮, 提示才可以回复
            if (this.showResult) {
                this.showTip= '取消';
                this.$emit('ready', -3, -3);
                return;
            }

            this.$emit('ready', this.replyId, this.id);
        }
    }
}
</script>

<style>
.comment-reply-item .avater {
    float: left;
    margin-right: 3%;
    width: 7%;
}

.comment-reply-item .avater img{
    width: 100%;
}

.comment-reply-item .comment {
    float: left;
    width: 90%;
}

.comment-reply-item .name {
    font-size: 20px;
    font-weight: 600;
    text-align: left;
    margin-bottom: 5px;
    float: left;
}

.comment-reply-item .reply {
    float: left;
}

.comment-reply-item .content {
    font-size: 16px;
    line-height: 20px;
    text-align: left;
    word-wrap: break-word;
}

.comment-reply-item .info {
    font-size: 14px;
    color: #888888;
    text-align: left;
}
</style>