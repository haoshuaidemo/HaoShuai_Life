import Vue from 'vue'
import VueRouter from "vue-router";
import HelloWorld from "@/components/HelloWorld";
import index from "@/components/index"
Vue.use(VueRouter)

const router=new VueRouter({
    mode:'history',
    routes:[
        {   path:'/',
            name:'index',
            component: index
        },
        {   path:'/helloword',
            name:'helloword',
            component: HelloWorld
        }
    ]
})

export default router;
