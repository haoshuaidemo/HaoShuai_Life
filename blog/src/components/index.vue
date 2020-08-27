<template>
    <div class="index-container">
        <div class="header">
            <el-carousel class="image-lunbo" :interval="3000" arrow="always">
                <el-carousel-item  v-for="item in images" :key="item.id">
                    <el-image class="lunbo-singleImage" :src="item.imagePath" fit="fill"></el-image>
                    <div class="title-motto">
                        <h1>{{title}}</h1>
                        <h2>{{motto}}</h2>
                    </div>
                    <el-image class="header-portrait" :src="require('../assets/images/'+portraitImage+'.jpg')"></el-image>
                </el-carousel-item>
            </el-carousel>
        </div>
        <div class="body">
            <div class="body-navbar">
                <el-menu  class="body-menu" mode="horizontal">
                    <el-menu-item index="1">首页</el-menu-item>
                    <el-menu-item index="2">留言本</el-menu-item>
                    <el-menu-item index="3">关于郝帅</el-menu-item>
                    <el-menu-item index="4">博客时间</el-menu-item>
                </el-menu>
                <el-menu class="body-menu-login" mode="horizontal">
                    <el-menu-item index="1">登录</el-menu-item>
                    <el-menu-item index="2">注册</el-menu-item>
                </el-menu>
            </div>
            <div  class="body-left" >
                <div class="body-left-context" v-for="item in bodyContextList" :key="item.id">
                    <div class="article-images" >
                        <el-image class="article-image" :src="require('../assets/images/'+item.articlePhotoPath+'.jpg')"></el-image>
                    </div>
                    <div class="article-header">
                        <div class="article-header-guodu">
                            <div class="article-header-type">
                                <a class="article-header-type-a">{{item.type}}</a>
                            </div>
                            <div class="article-header-title">
                                <a style="color: black">{{item.title}}</a>
                            </div>
                        </div>
                    </div>
                    <div class="article-body">
                        <Card class="article-body-card">
                            <p>{{item.articleContext}}</p>
                        </Card>
                    </div>
                    <div class="article-footer">
                        <div class="article-footer-guodu">
                            <div class="article-footer-date">
                                <i class="el-icon-date"></i>
                                <a style="color: black">{{item.date}}</a>
                            </div>
                            <div class="article-footer-comment">
                                <i class="el-icon-chat-dot-round"></i>
                                <a style="color: black">{{item.comment}}</a>
                            </div>
                            <div class="article-footer-view">
                                <i class="el-icon-view"></i>
                                <a style="color: black">{{item.view}}</a>
                            </div>
                            <div class="article-footer-star">
                                <i class="el-icon-star-off"></i>
                                <a style="color: black">{{item.star}}</a>
                            </div>
                            <div class="article-footer-read">
                                <a style="color: black">阅读全文</a>
                                <i class="el-icon-caret-right"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="body-right">
                <div class="body-right-guodu">
                    <div class="body-right-personal">
                        <el-image class="personal-image" :src="require('../assets/images/'+personalInfo.image+'.jpg')"></el-image>
                        <a class="personal-motto">{{personalInfo.metto}}</a>
                        <el-divider></el-divider>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer">
            <div class="footer-context">
                <p class="footer-contest-font">COPYRIGHT © 2020 郝帅的个人博客. ALL RIGHTS RESERVED</p>
                <p class="footer-contest-font">备案号</p>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "index",
        data() {
            return {
                title: '郝帅的个人博客',
                motto: '一个在互联网浪潮中苟且偷生的人',
                //轮播图
                images: [
                    {id: 1, imagePath: require("../assets/images/1.jpg")},
                    {id: 2, imagePath: require("../assets/images/3.jpg")},
                    {id: 3, imagePath: require('../assets/images/4.jpg')},
                ],
                portraitImage: '10',
                articleImage: '10',
                bodyContextList: [
                    {
                        star: '423',
                        view: '19',
                        comment: '19',
                        date: '2020年06月04日',
                        articlePhotoPath: '10',
                        title: '中国的崛起',
                        type: '日记本',
                        articleContext: '我们技术的房价二建法规IE违法及违法加我IE飞机为二级分为接机服务if将诶分解房间诶房间诶房间诶见我们技术的房价二建法规IE违法及违法加我IE飞机为二级分为接机服务if将诶分解房间诶房间诶房间诶见我们技术的房价二建法规IE违法及违法加我IE飞机为二级分为接机服务if将诶分解房间诶房间诶房间诶见'
                    },
                    {articlePhotoPath: '10', title: '大国崛起', type: '日记本'},
                ],
                personalInfo: {
                    image: '11',
                    metto: '博士，非博学之士；讲师，讲所学所知。糊涂一生，平凡半世，惟愿淡泊，以度此生。'
                },
                pojo:{
                    id:'111',
                    username:'2324',
                    password:'234'
                }
            }

        },
        created() {
            //post
            this.$post('/postParams',this.pojo)
            //get
            this.$get('/getParam?param=123')
        }
    }
</script>

<style scoped>
    .header{
        height: 250px;
        width: 100%;
        position: relative;
    }
    .body{
        width: 90%;
        min-height: 900px;
        position: relative;
        left:5%;
    }
    .footer{
        background-color: #212529;
        height: 150px;
        position: relative;
    }
    .el-carousel__item h3 {
        color: #475669;
        font-size: 14px;
        opacity: 0.75;
        line-height: 200px;
        margin: 0;
    }
    .image-lunbo{
        height:250px;
        width: 100%;
    }
    .lunbo-singleImage{
        width: 100%;
        height: 250px;
    }
    .title-motto{
        color:#FFFFFF;
        align-content: center;
        height: 200px;
        position: absolute;
        top: 40%;
        left: 40%;
    }
    .header-portrait{
        position: absolute;
        width: 100px;
        height: 100px;
        top:20%;
        left:10%;
        border-radius:5px
    }
    .body-menu{
        position: absolute;
        right: 20%;
    }
    .body-menu-login{
        position: absolute;
        right: 0%;
    }
    .body-navbar{
        height: 60px;
    }
    .body-left {
        width: 60%;
        min-height: 700px;
        margin: 2%;
        position: absolute;
    }
    /*文章块*/
    .body-left-context{
        background-color: white;
        width: 100%;
        min-height: 200px;
        margin: 10px;
        position: relative;
    }
    /*文章模块具体内容*/
    .article-images{
        width: 30%;
        height: 145px;
        position: absolute;
    }
    .article-image{
        width: 200px;
        height: 145px;
    }
    .article-header{
        width: 70%;
        height: 25%;
        position: absolute;
        right: 0px;
    }
    .article-header-guodu{
        position: absolute;
        width: 100%;
    }
    .article-header-type {
        position: relative;
        left: 10px;
        width: 20%;
        height: 35px;
        margin: 5px;
        font-size: 15px;

    }
    .article-header-type-a{
        position: relative;
        top: 2px;
        display: inline-block;
        margin-right: 5px;
        padding: 4px 6px 3px;
        border-radius: 0;
        background-color: #00a2ff;
        vertical-align: baseline;
        text-align: center;
        white-space: nowrap;
        font-size: 15px;
        color: white;
        line-height: 18px;
        width: 100%;
    }
    .article-header-title{
        background-color: white;
        position: relative;
        left: 25%;
        top:-35px;
        width: 30%;
        height:30px;
        font-size: 21px;
        font-family: "Microsoft YaHei";
    }
    .article-body{
        width: 70%;
        height: 50%;
        position: absolute;
        top:25%;
        right: 0px;
    }
    articel_body-container-p{
        width: 100%;
        height: 100px;
    }
    .article-footer{
        background-color: white;
        width: 100%;
        height: 25%;
        position: absolute;
        bottom: 0px;
    }
    .article-footer-guodu{
        position:relative;
        width: 100%;
        height: 30px;
        top:20px;
        font-size: 15px;
    }
    .article-footer-date{
        position: absolute;
        left: 5%;
    }
    .article-footer-comment{
        position: absolute;
        left: 25%;
    }
    .article-footer-view{
        position: absolute;
        left: 31%;
    }
    .article-footer-star{
        position: absolute;
        left: 37%;
    }
    .article-footer-read{
        position: absolute;
        right: 0px;
    }
    /*右侧*/
    .body-right{
        width:30%;
        min-height: 700px;
        margin: 2%;

        position: absolute;
        right: 0px;
    }
    .body-right-guodu{
        position: relative;
        width: 100%;
        min-height: 500px;
        background-color: whitesmoke;
    }
    .body-right-personal{
        position: absolute;
        width: 90%;
        height: 200px;
        background-color: white;
        margin: 10px 5% 10px 5%;
    }
    .personal-image{
        height: 100px;
    }
    .personal-motto{
        font-size: 15px;
        position: relative;
        top:20px;
        color: black;
    }

    /*尾部*/
    .footer-context{
        /*align-content: center;*/
        position: absolute;
        top:50%;
        left: 35%;
    }
    .footer-contest-font{
        font-size: 15px;
        color: #8E8E8E;
    }
</style>
