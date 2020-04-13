import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import ElementUI from 'element-ui'
// import VueBlu from 'vue-blu'
import locale from 'element-ui/lib/locale/lang/zh-CN'
import './styles.scss'
// import 'vue-blu/dist/css/vue-blu.min.css'
import router from './router'

Vue.use(ElementUI, { locale });
// Vue.use(VueBlu);

Vue.config.productionTip = false;

new Vue({
  router,
  render: h => h(App)
}).$mount('#app');
