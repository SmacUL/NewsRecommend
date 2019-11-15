<template>
    <div>
        <login-panel></login-panel>
        <register-panel></register-panel>
        <Test></Test>
    </div>
</template>

<script>
// port
import LoginPanel from '@/components/port/LoginPanel'
import RegisterPanel from '@/components/port/RegisterPanel'
import Test from '@/components/port/Test'
// common
// CSS
import '@/assets/css/Common.css'

export default {
    name: 'PortPage',
    components: { LoginPanel, RegisterPanel, Test }
}
</script>

<style>

</style>