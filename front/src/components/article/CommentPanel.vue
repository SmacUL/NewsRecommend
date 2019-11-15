<template>
    <div class="comment-panel">
        <div class="comments" v-for="(comment, i) in comments" :key="i"
            v-if="i < (curPage)*pageSize && i >= (curPage-1)*pageSize">
            <comment-reply-item class="comment-reply-item" 
                :id=comment.id
                :name=comment.name :content=comment.content
                :time=comment.time :likenum=comment.likenum
                :commentId=comment.id 
                :replyId='-1' :replyName='""'>
            </comment-reply-item>
            
            <reply-panel :replys=comment.replys :commentId=comment.id>
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
            comments: [
                {
                    id: 0, 
                    name: 'user0',
                    content: 'asdfasdf', 
                    time: '2019-09-09', 
                    likenum: 23,
                    replys: [
                        {
                            id: 1,
                            name: 'user1',
                            replyId: -1,
                            replyName: '',
                            content: '3247987zkxchxzhc',
                            time: '2039-93-12',
                            likenum: 12
                        }, {
                            id: 1,
                            name: 'user1',
                            replyId: 1,
                            replyName: 'user1',
                            content: '3247987zkxchxzhc',
                            time: '2039-93-12',
                            likenum: 12
                        }, {
                            id: 1,
                            name: 'user1',
                            replyId: -1,
                            replyName: '',
                            content: '3247987zkxchxzhc',
                            time: '2039-93-12',
                            likenum: 1
                        }, {
                            id: 1,
                            name: 'user1',
                            replyId: -1,
                            replyName: '',
                            content: '3247987zkxchxzhc',
                            time: '2039-93-12',
                            likenum: 10
                        }, {
                            id: 1,
                            name: 'user1',
                            replyId: -1,
                            replyName: '',
                            content: '3247987zkxchxzhc',
                            time: '2039-93-12',
                            likenum: 1
                        }, {
                            id: 1,
                            name: 'user1',
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
        },

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