<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<style>
    body {
        font-family: Verdana, Arial, sans-serif;
        padding: 0;
        margin: 0;
        text-align: center;
    }
</style>

<body>

<!--header-->
<div class="navbar navbar-default">
    <div class="container">

        <!--导航条头部-->
        <div class="navbar-header">
            <!--图片Logo-->
            <a href="http://47.106.11.84" target="_blank" class="navbar-brand">
                <!--<img src="images/peopleicon.png" alt="未加载成功" height="44" width="152" style="margin-top: -13px;"/>-->
                <text id="logo-text">执子之手，与子偕老</text>
            </a>
        </div>

        <!--导航条尾部信息栏-->
        <div id="my-collapse" class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <!--上传寄语-->
                <li>
                    <a id="nav-diary-button" href="#">
                        <span class="glyphicon glyphicon-pencil"></span>
                        书写寄语
                    </a>
                </li>
                <!--上传图片-->
                <li>
                    <a id="nav-image-button" href="#">
                        <span class="glyphicon glyphicon-pencil"></span>
                        记录图片
                    </a>
                </li>
                <li>
                    <a href="#"><span></span></a>
                </li>
                <!-- 用户名信息 -->
                <li>
                    <a id="nav-property-button" href="#">
                        <span class="glyphicon glyphicon-user"></span>
                        欢迎你 ${user.userName}
                    </a>
                </li>
                <li>
                    <a id="nav-password-button" href="#">
                        <span class="glyphicon glyphicon-pencil"></span>
                        修改密码
                    </a>
                </li>
                <li>
                    <a href="/servlet/index.jsp">
                        <span class="glyphicon glyphicon-log-out"></span>
                        退出
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>
