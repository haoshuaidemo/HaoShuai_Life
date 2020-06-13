# blog
npm install
npm run serve
npm run build
npm run lint
#本项目是一个个人博客项目，我目前的水平很有限，所以这里主要记录了我创建搭建博客的基础知识。
#main.js是整个vue的入口，它引用App.vue,app又引用我开发的每个页面
项目结构：
    src:
        components:自己开发的页面组件
        router:路由相关
        
知识点使用：
    加载流程：项目加载的过程是index.html -> main.js -> app.vue -> index.js -> xxx.vue，如果main.js里面有钩子，会先走钩子
    router:1.创建router文件，定义具体路径2.main.js中new Vue()引入router目录
    第三方样式库：element-ui,iview安装
