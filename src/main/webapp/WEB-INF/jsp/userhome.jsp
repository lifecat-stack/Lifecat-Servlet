<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<%@include file="include/header.jsp" %>

<script>
    var userId = '${user.userId}';
    if (userId == null) {
        userId = 1;
    }
</script>

<%@include file="include/top.jsp" %>

<!-- top-页面状态栏 -->
<div id="top-container" class="container">
    <div class="jumbotron " status="user-property">
        <text class="top-text">个人信息</text>
        <p>守护TA的成长</p>
    </div>
    <div class="jumbotron " status="diary-list">
        <text class="top-text">日记动态</text>
        <p>送给未来的TA</p>
    </div>
    <div class="jumbotron " status="image-list">
        <text class="top-text">图像记录</text>
        <p>记录美好时刻</p>
    </div>
    <div class="jumbotron " status="image-show">
        <text class="top-text">成长相册</text>
        <p>记录美好时刻</p>
    </div>
    <div class="jumbotron " status="image-class-show">
        <text class="top-text">智能图像分类</text>
        <p>通过图像处理算法，为相册进行整理</p>
    </div>
</div>

<!-- 主界面栏 -->
<div class="container">
    <div class="row">
        <!--左侧切换栏-->
        <div class="col-md-2  dataType">
            <ul class="nav nav-pills nav-stacked">
                <li role="presentation" class="">
                    <a href="#" status="user-property" id="get-user-page">个人信息</a>
                </li>
                <li role="presentation" class="">
                    <a href="#" status="diary-list" id="get-diary-page">日记动态</a>
                </li>
                <li role="presentation" class="">
                    <a href="#" status="image-list" id="get-image-page">图像记录</a>
                </li>
                <li role="presentation" class="">
                    <a href="#" status="image-show" id="get-album-page">成长相册</a>
                </li>
                <li role="presentation" class="">
                    <a href="#" status="image-class-show" id="get-classify-page">智能图像分类</a>
                </li>
            </ul>
        </div>
        <!-- right-主页面栏 -->
        <div class="col-md-10 dataType">
            <div id="home-tap-div" class="col-lg-12 content-div show"></div>
        </div>
    </div>
</div>

<%@include file="include/footer.jsp" %>

