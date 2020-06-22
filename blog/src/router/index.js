import Vue from 'vue'
import VueRouter from "vue-router";
import HelloWorld from "@/components/HelloWorld";
import index from "@/components/index"
import Header from "@/components/managePage/Header";
import Home from "@/components/managePage/Home";
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
        },
        {   path:'/Header',
            name:'Header',
            component: Header
        },
        {   path:'/Home',
            name:'Home',
            component: Home
        }
    ]
})

export default router;
