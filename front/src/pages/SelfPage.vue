<template>
    <div>
        <header><top-bar class="top-bar" style="width: 1020px;margin-left: 50%;left: -510px;"></top-bar></header>
        <section style="width: 1020px;">
            <show-panel  :customer="customer"></show-panel>
        </section>
        <!-- 页面主体 左右 布局 -->
        <main class="clear-float" style="width: 1020px;margin-top: 20px;">
            <article class="article-b" style="width: 710px;">
                <div v-for="(item, i) in articles" :key="i" style="margin-bottom: 10px;">
                    <tiny-article class="tiny-article"  :item="item">

                    </tiny-article>
                </div>
            </article>
            <aside :style="asideStyle" style="margin-left: 740px;">
                <achievement-panel></achievement-panel>
            </aside>
        </main>
    </div>
</template>

<script>
// self
import AchievementPanel from '@/components/self/AchievementPanel'
import ShowPanel from '@/components/self/ShowPanel'
// common
import TinyArticle from '@/components/common/TinyArticle'
import TopBar from '@/components/common/TopBar'
// CSS
import '@/assets/css/Common.css'

export default {
    name: 'SelfPage',
    components: { AchievementPanel, ShowPanel, TinyArticle, TopBar },
    created: function() {
        this.getCustomerInfo();
    },
    mounted: function() {
        window.addEventListener('scroll', this.scrollHandler, false);
    },
    methods: {
        getCustomerInfo: function() {
            this.$axios.get('/api/self/' + this.$route.params.type, {params: {id: this.$route.params.id}}).then(
                (response) => {
                    console.log(response.data);
                    let customer = response.data;
                    for (let attr in customer) {
                        if (customer[attr] === null) {
                            customer[attr] = '这家伙很懒, 啥也没写';
                        }
                    }
                    this.customer = customer;
                }
            ).catch(
                (response) => {
                    console.log(response);
                }
            )
        },

        scrollHandler: function () {
            let scrollDis = document.documentElement.scrollTop || document.body.scrollTop || window.pageYOffset || 0;
            if (scrollDis > 320) {
                this.asideStyle = 'margin-top: 10px';
            } else {
                this.asideStyle = 'position: static;';
            }
            // console.log(document.documentElement.clientHeight);
        }
    },
    data: function () {
        return {

            param: '',
            // asideStyle 不要动
            asideStyle: 'position: static',

            // customer
            customer: {
                cusId: 1,
                cusName: '示例',
                cusEmail: '1234@dd.com',
                cusPhone: '12345678901',
                cusAddress: 'djdj-sjsj-wkw',
                cusAvatarUrl: '',
                cusStyle: 'this is a test account',
                cusGender: 0,
                cusTime: '2019-09-09',
                cusType: 0,
            }
        }
    },

}
</script>

<style>
article {
    float: left;
    width: 720px;
}
</style>
