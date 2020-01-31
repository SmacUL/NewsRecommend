<template>
    <div class="float-card">
        <slot></slot>
    </div>
</template>

<script>
    export default {
        name: "FloatCard"
    }
</script>

<style scoped>
    .float-card {
        padding: 15px;
        border: 0;
        border-radius: 0;
        border-bottom: solid 1px rgba(0,0,0,.1);
        box-shadow: none;
    }

    .float-card:hover {
        box-shadow: 0 2px 12px 0 rgba(0,0,0,.1);
        background-color: #f4f5f6;
        border-bottom: none;
    }
</style>