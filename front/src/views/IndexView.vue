<template>
    <div>
        <header>
            <top-bar class="top-bar"></top-bar>
        </header>

        <main>
            <nav>
                <left-menu></left-menu>
            </nav>
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
    import TopBar from '../components/index/TopBar'
    import LeftMenu from '../components/index/LeftMenu'
    import RightMenu from '../components/index/RightMenu'
    import TinyCenter from "../components/index/TinyCenter"

    export default {
        name: 'IndexView',
        components: {TinyCenter, TopBar, LeftMenu, RightMenu},
        data: function () {
            return {

            }
        }
    }
</script>


<style scoped src="../assets/css/Normal.css"></style>
<style scoped>

</style>