<template>
    <div class="comment-reply-item clear-float">
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
.comment-reply-item .avater {
    float: left;
    
}

.comment-reply-item .avater img{
    /* height: 50px; */
    /* width: 10%; */
}

.comment-reply-item .comment {
    float: left;
}

.comment-reply-item .name {
    font-weight: 800;
}
</style>