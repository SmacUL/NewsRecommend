<template>
    <div class="comment-reply">
        <div>
            <comment-reply-item></comment-reply-item>
        </div>
        
    </div>
</template>

<script>
import CommentReplyItem from '@/components/article/CommentReplyItem'

export default {
    name: 'CommentReply',
    components: {CommentReplyItem, },
}
</script>

<style>

</style>