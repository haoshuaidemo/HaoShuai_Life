<template>
    <div class="header">
        <!-- 折叠按钮 -->
        <div class="collapse-btn" @click="collapseChage">
            <i class="el-icon-menu"></i>
        </div>
        <div class="logo">{{title}}</div>
        <div class="header-right">
            <div class="header-user-con">
                <!-- <marquee onMouseOver="this.start()" style="font-size:18px;padding-bottom:4px;width:100px;" scrollamount="1">{{getlev}}</marquee> -->
                <div style="font-size:18px;padding-bottom:4px;width:60px;">{{getlev}}</div>
                <!-- 全屏显示 -->
                <div class="btn-fullscreen" @click="handleFullScreen">
                    <el-tooltip effect="dark" :content="fullscreen?`取消全屏`:`全屏`" placement="bottom">
                        <i class="el-icon-rank"></i>
                    </el-tooltip>
                </div>
                <!-- 消息中心 -->
                <div class="btn-bell">
                    <el-tooltip effect="dark" :content="message?`有${message}条未读消息`:`消息中心`" placement="bottom">
                        <router-link to="/tabs">
                            <i class="el-icon-bell"></i>
                        </router-link>
                    </el-tooltip>
                    <span class="btn-bell-badge" v-if="message"></span>
                </div>
                <!-- 用户头像 -->
                <div class="user-avator"><img src="static/img/img.jpg"></div>
                <!-- 用户名下拉菜单 -->
                <el-dropdown class="user-name" trigger="click" @command="handleCommand">
                    <span class="el-dropdown-link">
                        {{username}} <i class="el-icon-caret-bottom"></i>
                    </span>

                    <el-dropdown-menu slot="dropdown">

                        <a  href="https://github.com/merciqiao" target="_blank">
                            <el-dropdown-item>关于作者</el-dropdown-item>
                        </a>
                        <a href="https://github.com/merciqiao/merciqiao-vue" target="_blank">
                            <el-dropdown-item>项目仓库</el-dropdown-item>
                        </a>
                        <a href="/zanzhu" target="_blank">
                            <el-dropdown-item style="color:orange;">赞助作者</el-dropdown-item>
                        </a>
                        <el-dropdown-item divided  command="changeZh">切换中文</el-dropdown-item>
                        <el-dropdown-item command="changeEn">切换英文</el-dropdown-item>
                        <el-dropdown-item divided  command="loginout">退出登录</el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
            </div>
        </div>
    </div>

</template>

<script>
    import bus from './bus';
    export default {
        name: "Header",
        data(){
            return{
                collapse: false,
                fullscreen: false,
                name: 'merciqiao',
                title:'后台管理系统',
                lev:'青铜级',
                message: 2
            }
        },
        computed:{
            username(){
                // let username = this.$common.getSessionStorage('username');
                let username = '';
                return username ? username : this.name;
            },
            getlev(){

                // let levList = this.$common.getSessionStorage('lev',true);
                let levList = '';
                let lev='';
                if(levList){
                    for(var i=0;i<levList.length;i++){
                        lev+=levList[i].roleName;
                    }
                }

                return lev ? lev : this.lev;
            }
        },
        methods:{

        },
        mounted(){
            if(document.body.clientWidth < 1366){
                this.collapseChage();
            }
        }
    }
</script>

<style scoped>
    .header {
        position: relative;
        box-sizing: border-box;
        width: 100%;
        height: 70px;
        font-size: 22px;
        color: #fff;
    }
    .collapse-btn{
        float: left;
        padding: 0 21px;
        cursor: pointer;
        line-height: 70px;
    }

</style>
