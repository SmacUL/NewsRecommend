<template>
    <float-card class="float-card clear-float">
        <div class="image" v-if="tinyArticle.artImageUrl !== ''">
            <img :src="tinyArticle.artImageUrl" >
        </div>
        <div class="word" :class="[wideSwitch ? tinyArt : tinyArtWide]">
            <div class="title" @click="jumpToArticle(tinyArticle.artId)">{{ tinyArticle.artTitle }}</div>
            <!--<div>adsfasfdasdf</div>-->
            <div class="info">
                <span class="type">{{ tinyArticle.artType}}</span>
                <span class="customer" @click="jumpToCustomer(tinyArticle.customer.cusId)">{{ tinyArticle.customer.cusName }}</span>
                <span>{{ date(tinyArticle.artTime) }}</span>
            </div>
        </div>
    </float-card>
</template>

<script>

    import FloatCard from "./FloatCard";
    import {transUTCtoLocal} from "../../util/TimeHandler";
    export default {
        name: "TinyArticle",
        props: ['tinyArticle'],
        components: {FloatCard},
        computed: {
            wideSwitch: function () {
                return this.tinyArticle.artImageUrl !== '';
            },

        },
        methods: {
            jumpToArticle: function (artId) {
                this.$emit('jump', artId);
            },

            jumpToCustomer: function (cusId) {
                this.$emit('editor', cusId);
            },
            date: function (time) {
                return transUTCtoLocal(time);
            }
        },
        data: function() {
            return {
                tinyArt: 'tiny-art',
                tinyArtWide: 'tiny-art-wide',
            }
        },
    }
</script>

<style scoped>

    .float-card {
        margin-bottom: 15px;
    }

    .image img {
        float: left;
        width: 27%;
        height: 120px;
        margin-right: 3%;
    }

    .word {
        float: left;
        height: 120px;
        position: relative;
    }

    .tiny-art {
        width: 70%;
    }

    .tiny-art-wide {
        width: 100%;
    }

    .title {
        height: 60px;
        line-height: 30px;
        font-size: 18pt;
        overflow: hidden;
        text-align: left;
        margin-bottom: 5px;
        font-weight: 800;
    }

    .title:hover {
        color: #339999;
        cursor: pointer;
    }

    .description {
        height: 20px;
        line-height: 20px;
        overflow: hidden;
        text-align: left;
        color: #888888;
    }

    .info {
        text-align: left;
        font-size: 14px;
        position: absolute;
        bottom: 0;
        color: #888888;
    }

    .info .type {
        margin-right: 10px;
        border: 1px;
        border-style: solid;
        border-radius: 3px;
        color: darkred;
    }

    .info :first-child {
        font-weight: 400;
    }

    .customer {
        margin-right: 10px;
    }

    .customer:hover {
        color: #339999;
        cursor: pointer;
    }
</style>