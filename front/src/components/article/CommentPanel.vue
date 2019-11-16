<template>
    <div class="comment-panel">
        <div class="comments" v-for="(comment, i) in comments" :key="i"
            v-if="i < (curPage)*pageSize && i >= (curPage-1)*pageSize">
            <comment-reply-item class="comment-reply-item" 
                @ready="showReplyInput"
                :id=comment.id
                :name=comment.name :content=comment.content
                :time=comment.time :likenum=comment.likenum
                :commentId=comment.id 
                :replyId='-2' :replyName='""'
                :readyType=readyType :readyId=readyId
                >
            </comment-reply-item>
            
            <reply-panel @readyagain="showReplyInput"
                :replys=comment.replys :commentId=comment.id
                :readyType=readyType :readyId=readyId>
            </reply-panel>

        </div>
        <el-pagination v-if="comments.length > 4"
            background
            layout="prev, pager, next"
            @current-change="commentHandleCurrentChange"
            :page-size="pageSize"
            :current-page="curPage"
            :total="comments.length"
            >
        </el-pagination>
    </div>
</template>

<script>
import CommentReplyItem from '@/components/article/CommentReplyItem'
import ReplyPanel from '@/components/article/ReplyPanel'

export default {
    name: 'CommentPanel',
    components: {CommentReplyItem, ReplyPanel},
    data: function() {
        return {
            pageSize: 4,
            curPage: 1,
            replypageSize: 4,
            replyCurPage: 1,

            readyType: -3,
            readyId: -3,

            comments: [
                {
                    id: 0, // 评论 id
                    name: 'user0',
                    content: 'asdfasdf', 
                    time: '2019-09-09', 
                    likenum: 23,
                    replys: [
                        {
                            id: 1, // 回复 id
                            name: 'user1',
                            replyId: -1,
                            replyName: '',
                            content: '3247987zkxchxzhc',
                            time: '2039-93-12',
                            likenum: 12
                        }, {
                            id: 122,
                            name: 'user1',
                            replyId: 1,
                            replyName: 'user1',
                            content: '3247987zkxchxzhc',
                            time: '2039-93-12',
                            likenum: 12
                        }, {
                            id: 14,
                            name: 'user1',
                            replyId: -1,
                            replyName: '',
                            content: '3247987zkxchxzhc',
                            time: '2039-93-12',
                            likenum: 1
                        }, {
                            id: 156,
                            name: 'user1',
                            replyId: -1,
                            replyName: '',
                            content: '3247987zkxchxzhc',
                            time: '2039-93-12',
                            likenum: 10
                        }, {
                            id: 1123,
                            name: 'user1',
                            replyId: -1,
                            replyName: '',
                            content: '3247987zkxchxzhc',
                            time: '2039-93-12',
                            likenum: 1
                        }, {
                            id: 156,
                            name: 'user2',
                            replyId: -1,
                            replyName: '',
                            content: '3247987zkxchxzhc',
                            time: '2039-93-12',
                            likenum: 10
                        }
                    ]
                }, {
                    id: 4, 
                    name: 'user4',
                    content: 'asdfasdf', 
                    time: '2019-09-09', 
                    likenum: 78,
                    replys: []
                }, {
                    id: 9, 
                    name: 'user9',
                    content: 'asdfasdf', 
                    time: '2019-09-09', 
                    likenum: 78,
                    replys: []
                }, {
                    id: 12, 
                    name: 'user12',
                    content: 'asdfasdf', 
                    time: '2019-09-09', 
                    likenum: 78,
                    replys: []
                }, {
                    id: 19, 
                    name: 'user19',
                    content: 'asdfasdf', 
                    time: '2019-09-09', 
                    likenum: 78,
                    replys: []
                }, {
                    id: 20, 
                    name: 'user20',
                    content: 'asdfasdf', 
                    time: '2019-09-09', 
                    likenum: 78,
                    replys: []
                }
            ]
        }
    },
    methods: {
        commentHandleCurrentChange(val) {
            this.curPage = val;
            this.readyType = -3;
            this.readyId = -3;
        },
        showReplyInput(type, id) {
            this.readyType = type;
            this.readyId = id;
        }

    }
}
</script>

<style>
.comment-panel .comments {
    margin-bottom: 10px;
}

.comment-panel .replys {
    margin-left: 10%;
    margin-bottom: 5px;
}
</style>