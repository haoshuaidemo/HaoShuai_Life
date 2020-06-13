import Vue from 'vue'
import App from './App.vue'
//引入vue-router
import router from './router'
//引入element ui
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
Vue.use(ElementUI)
//引入iview
import iView from 'iview'
import 'iview/dist/styles/iview.css'
Vue.use(iView)

Vue.config.productionTip = false

new Vue({
  el:'#app',
  router,
  render: h => h(App)
})
