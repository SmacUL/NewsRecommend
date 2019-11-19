<template>
    <div class="show-panel">
<!--        <div style="background-image: url('@/assets/image/selfbackground.jpg');">-->
        <div :style="note">
        </div>
    </div>
</template>

<script>
export default {
    name: 'ShowPanel',
    data: function () {
        return {
            note: {
                backgroundImage: "url(" + require("@/assets/image/selfbackground.jpg") + ") ",
                backgroundPosition: "center center",
                backgroundRepeat: "no-repeat",
                backgroundSize: "cover",
                height: '300px',
            },
        }
    }
}
</script>

<style>
    /*.hhhh {*/
    /*    background-image: url(" + require('../../assets/image/selfbackground.jpg') + ");*/
    /*    height: 300px;*/
    /*}*/

</style>
