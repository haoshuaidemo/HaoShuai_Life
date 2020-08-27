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
//引入axios
import Axios from "axios"

import {post,get} from './request/http'

Vue.prototype.$post=post;
Vue.prototype.$get=get;


Vue.prototype.$request=Axios.create(
    {
        //url:'',
        // method:'',
        //自动加在url前面
        baseURL:'/api',
        timeout:5000,
        //请求向服务器发送前处理参数
        transformRequest:[],
        //返回参数处理
        transformResponse:[],
        headers:{},
        // params:'',
        data:{},
        //请求是否需要凭证
        host:'127.0.0.1',
        port:8080,
        withCredentials:true
    }
)

Vue.config.productionTip = false

new Vue({
  el:'#app',
  router,
  render: h => h(App)
})
