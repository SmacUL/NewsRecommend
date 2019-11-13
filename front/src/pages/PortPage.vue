<template>
    <div>
        <login-panel></login-panel>
        <register-panel></register-panel>
    </div>
</template>

<script>
// port
import LoginPanel from '@/components/port/LoginPanel'
import RegisterPanel from '@/components/port/RegisterPanel'
// common
// CSS
import '@/assets/css/Common.css'

export default {
    name: 'PortPage',
    components: { LoginPanel, RegisterPanel }
}
</script>

<style>

</style>