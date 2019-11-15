<template>
    <div class="clear-float">
        <div class="avater">
            <img src="@/assets/logo.png">
        </div>
        <div class="comment">
            <div style="text-align: left; font-weight: 500; font-size: 18px;">
                <span>{{name}}</span>
                <span style="font-weight:400; font-size:16px;" v-if="replyId != -1"> 回复 </span>
                <span v-if="replyId != -1">{{replyName}}</span>
            </div>
            <div class="content">{{content}}</div>
            <div class="info">
                <span>{{time}}</span>
                <span>{{likenum}}</span>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    props: ['id', 'name', 'content', 'time', 'likenum', 'replyId', 'replyName'],
    name: 'CommonReplyItem',
    data: function() {
        return {

        }
    },
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