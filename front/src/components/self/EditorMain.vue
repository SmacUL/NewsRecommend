<template>
    <dark-card>
        <div :style="note">
            <!-- 用户信息的显示板 -->
            <div class="customer">
                <!-- 头像 -->
                <div class="customer-avatar"><img :src="customer.cusAvatarUrl"></div>
                <!-- 信息 -->
                <div class="customer-info">
                    <span class="customer-info-name">{{customer.cusName}}</span>
                    <span class="customer-info-style">{{ customer.cusStyle}}</span>
                    <el-button class="follow" type="primary">+关注</el-button>
                </div>
            </div>
        </div>
    </dark-card>
</template>

<script>
    import DarkCard from '../common/DarkCard'
    export default {
        name: "EditorMain",
        // props: ['customer'],
        components: { DarkCard },
        data: function () {
            return {
                note: {
                    height: '150px',
                    width: '100%',
                    position: 'relative',
                },
                customer: {
                    cusId: 1,
                    cusName: '用户名称',
                    cusAvatarUrl: require('@/assets/logo.png'),
                    cusStyle: '这个用户很懒啥也没说',
                    cusTime: '2019-09-09',
                    cusType: 0,
                },
            }
        }
    }
</script>

<style scoped>

    .customer-avatar {
        height: 150px;
        width: 150px;
        float: left;
        margin-right: 30px;
    }

    .customer-avatar img {
        width: 100%;
    }

    .customer-info {
        height: 100px;
        margin-top: 50px;
        float: left;
        text-align: left;
    }

    .customer-info-name {
        display: block;
        line-height: 45px;
        font-size: 30px;
        font-weight: 600;
    }

    .customer-info-style {
        display: block;
        font-size: 16px;
        line-height: 25px;
    }

    .follow.el-button--primary {
        height: 28px;
        width: 60px;
        padding: 0px;
        font-size: 10pt;
        border-radius: 1px;
    }
</style>