<template>
    <div class="comment-reply-item-inner clear-float">
        <div class="avater">
            <img src="@/assets/logo.png">
        </div>
        <div class="comment">
            <div class="name">asdfds</div>
            <div class="content">asdfasdfasdfasdfasdfasdfsadfasdf</div>
            <div class="info">
                <span>2019-09-02</span>
                <span>33</span>
                <!-- <el-button> -->
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'CommonReplyItem',
    data: function() {
        return {

        }
    },
}
</script>

<style>
.comment-reply-item-inner .avater {
    float: left;
    
}

.comment-reply-item-inner .avater img{
    /* height: 50px; */
    /* width: 10%; */
}

.comment-reply-item-inner .comment {
    float: left;
}

.comment-reply-item-inner .name {
    font-weight: 800;
}
</style>