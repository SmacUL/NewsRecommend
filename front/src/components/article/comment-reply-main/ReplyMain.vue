<template>
    <div class="reply-main">
        <div  v-for="(reply, i) in replys.slice((curPage-1)*pageSize, (curPage)*pageSize)" :key="i">
            <!-- 打印回复 -->
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
    import CommentReplyItem from "./CommentReplyItem";
    export default {
        name: "ReplyMain",
        components: {CommentReplyItem},
        props: ['replys', 'commentId', 'readyType', 'readyId'],
        methods: {
            replyHandleCurrentChange(val) {
                this.curPage = val;
                this.$emit('readyagain', -3, -3);
            },
            showReplyInput(type, id) {
                this.$emit('readyagain', type, id);
            }
        },
        data: function () {
            return {
                pageSize: 4,
                curPage: 1,

            }
        },
    }
</script>

<style scoped>

</style>