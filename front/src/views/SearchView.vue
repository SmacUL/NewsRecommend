<template>
    <div>
        <header><top-bar class="top-bar"></top-bar></header>
        <main>
            <article>
                <tiny-center></tiny-center>
            </article>
            <aside>
                <right-menu></right-menu>
            </aside>
        </main>
    </div>
</template>

<script>
    import TopBar from "../components/search/TopBar";
    import TinyCenter from "../components/search/TinyCenter";
    import RightMenu from "../components/index/RightMenu";

    export default {
        name: "SearchView",
        components: {RightMenu, TinyCenter, TopBar}
    }
</script>

<style scoped src="../assets/css/Narrow.css"></style>
<style scoped>


</style>