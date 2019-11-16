<template>
    <div class="replys">
        <div  v-for="(reply, i) in replys" :key="i"
            v-if="i < (curPage)*pageSize && i >= (curPage-1)*pageSize">
            <comment-reply-item class="comment-reply-item" 
                @ready="showReplyInput"
                :id=reply.id
                :name=reply.name :content=reply.content
                :time=reply.time :likenum=reply.likenum
                :commentId=commentId 
                :replyId=reply.replyId :replyName=reply.replyName
                :readyType=readyType :readyId=readyId>
            </comment-reply-item>

        </div>
        <el-pagination v-if="replys.length > pageSize"
            small
            layout="prev, pager, next"
            @current-change="replyHandleCurrentChange"
            :page-size="pageSize"
            :current-page="curPage"
            :total="replys.length"
            >
        </el-pagination>
    </div>
</template>

<script>
import CommentReplyItem from '@/components/article/CommentReplyItem'
export default {
    props: ['replys', 'commentId', 'readyType', 'readyId'],
    components: {CommentReplyItem},
    name: 'ReplyPanel',
    data: function () {
        return {
            pageSize: 4,
            curPage: 1,

        }
    },
    methods: {
        replyHandleCurrentChange(val) {
            this.curPage = val;
            this.$emit('readyagain', -3, -3);
        },
        showReplyInput(type, id) {
            this.$emit('readyagain', type, id);
        }
    }
}
</script>

<style>

</style>