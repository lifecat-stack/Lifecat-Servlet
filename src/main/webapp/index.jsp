<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<html lang="en">
<head>
    <!--
    1.name+content：描述网页元信息名称
    2.http-equiv+content：HTTP协议响应头报文
    -->
    <!--描述-->
    <meta name="description" content="lifecat智能成长相册"/>
    <!--关键词-->
    <meta name="keywords" content="lifecat"/>
    <!--作者-->
    <meta name="author" content="https://github.com/kevinten10"/>
    <!--版权-->
    <meta name="copyright" content="https://github.com/kevinten10"/>
    <!--创建时间-->
    <meta name="date" content="2017-11-11 00:00:00"/>
    <!--禁止搜索引擎检索-->
    <meta name="robots" content="none"/>
    <!--？百度验证-->
    <meta name="baidu-site-verification" content="OyUb4RVdSe"/>
    <!--？渲染-->
    <meta name="renderer" content="webkit"/>
    <!--移动设备优先：禁止缩放-->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <!--兼容性-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <!--编码信息-->
    <meta http-equiv="content-type" content="text/html;charset=UTF-8"/>
    <!--中文版本语言-->
    <meta http-equiv="content-language" content="zh-CN"/>
    <!--刷新或跳转时间-->
    <!--<meta http-equiv="refresh" content="15;url=http://47.106.11.84/"/>-->
    <!--网页缓存时间：expires属性-->
    <!--页面不缓存-->
    <meta http-equiv="pragma" content="no-cache"/>

    <!--页面标签标题-->
    <title>成长相册</title>
    <!--页面标签图标-->
    <link rel="icon" href="images/webicon.png" type="image/x-icon">

    <!--引用库：jQuery-->
    <script src="js/jquery/2.0.0/jquery.min.js"></script>
    <!--引用库：bootstrap-->
    <script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap/3.3.6/bootstrap.min.css">

    <!--引用外部样式表：index.css-->
    <style type="text/css">
        @import url("css/mycss/index.css");
    </style>

</head>

<body>

<!-- 登录窗口 -->
<div id="login" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-title">
                <h1 class="text-center">登录</h1>
            </div>
            <div class="modal-body">

                <form class="form-group" action="user_login.do"
                      method="post">
                    <div class="form-group">
                        <label for="userName">账号</label> <input class="form-control"
                                                                type="text" placeholder="请输入账号" name="userName"
                                                                id="userName">
                    </div>
                    <div class="form-group">
                        <label for="userPassword">密码</label> <input class="form-control"
                                                                    placeholder="请输入密码" name="userPassword"
                                                                    id="userPassword"
                                                                    type="password">
                    </div>
                    <div class="text-right">
                        <button class="btn btn-primary" type="submit">登录</button>
                        <button class="btn btn-danger" data-dismiss="modal">取消</button>
                    </div>
                    <a href="" data-toggle="modal" data-dismiss="modal"
                       data-target="#register">还没有账号？点我注册</a>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- 注册窗口 -->
<div id="register" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <div class="modal-title">
                <h1 class="text-center">注册</h1>
            </div>
            <div class="modal-body">
                <!-- 注册表单 -->
                <form class="form-group" action="user_register.do" method="post">
                    <div class="form-group">
                        <label for="rUserName">注册账号</label> <input class="form-control"
                                                                   type="text" placeholder="请输入想注册的账号" name="rUserName"
                                                                   id="rUserName">
                    </div>
                    <div class="form-group">
                        <label for="rUserPassword1">密码</label> <input class="form-control"
                                                                      placeholder="请输入密码" name="rUserPassword1"
                                                                      id="rUserPassword1"
                                                                      type="password">
                    </div>
                    <div class="form-group">
                        <label for="rUserPassword2">确认密码</label> <input class="form-control"
                                                                        placeholder="请确认密码" name="rUserPassword2"
                                                                        id="rUserPassword2"
                                                                        type="password">
                    </div>
                    <div class="text-right">
                        <button class="btn btn-primary" type="submit">注册</button>
                        <button class="btn btn-danger" data-dismiss="modal">取消</button>
                    </div>
                    <a href="" data-toggle="modal" data-dismiss="modal"
                       data-target="#login">已有账号？点我登录</a>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- 管理员登录窗口 -->
<div id="admin" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <div class="modal-title">
                <h1 class="text-center">管理员登录</h1>
            </div>
            <div class="modal-body">
                <!-- 登录表单 -->
                <form class="form-group" action="admin_login.do" method="post">
                    <div class="form-group">
                        <label for="adminName">账号</label> <input class="form-control"
                                                                 type="text" placeholder="请输入账号" name="adminName"
                                                                 id="adminName">
                    </div>
                    <div class="form-group">
                        <label for="adminPassword">密码</label> <input class="form-control"
                                                                     placeholder="请输入密码" name="adminPassword"
                                                                     id="adminPassword"
                                                                     type="password">
                    </div>

                    <div class="text-right">
                        <button class="btn btn-primary" type="submit">登录</button>
                        <button class="btn btn-danger" data-dismiss="modal">取消</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- 体验 -->
<div id="experience" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <div class="modal-title">
                <h1 class="text-center">体验</h1>
            </div>
            <div class="modal-body">
                <label for="adminName">账号:admin</label>
                <label for="adminPassword">密码:admin</label>
                <label>请选择用户登录</label>
            </div>
        </div>
    </div>
</div>

<!-- 主界面窗口 -->
<div id="main" class="main">
    <!--页眉-->
    <div class="header">
        <div class="nav">
            <!--左侧：logo图像-->
            <div class="logo">
                <img src="images/welcomelogo.png"/>
            </div>
            <!--右侧：访问链接-->
            <div class="entry">
                <span class="state">LifeCat-记录美好时刻</span> <a
                    href="http://47.106.11.84/" target="_blank">访问官网</a>
            </div>
        </div>
    </div>

    <!--页面中心内容部分-->
    <div class="container">
        <div class="content">
            <div class="wrap">
                <!-- 页面中心文字部分 -->
                <div class="slogan"></div>

                <!-- 页面中心按钮部分 -->
                <div class="mid">
                    <div class="main-entry">
                        <a data-toggle="modal" data-target="#login" class="developer-login">
                            <span class="title">
                                <i class="developer"></i>立即登录</span><s></s> </a>
                        <a data-toggle="modal" data-target="#register" class="personal-login">
                            <span class="title">
                                <i class="developer"></i>立即注册</span> <s></s></a>
                    </div>
                    <div class="main-entry">
                        <a data-toggle="modal" data-target="#admin" class="developer-login">
                            <span class="title">
                                <i class="developer2"></i>管理员登录</span><s></s></a>
                        <a data-toggle="modal" data-target="#experience" class="personal-login">
                            <span class="title">
                                <i class="developer2"></i>立即体验</span><s></s></a>
                    </div>
                </div>
            </div>
        </div>

        <!--背景图片-->
        <div class="back">
            <div class="items">
                <div class="item item1"
                     style="background-image:url(images/background1.jpg)"></div>
                <div class="item item2"
                     style="background-image:url(images/background2.jpg)"></div>
                <div class="item item3"
                     style="background-image:url(images/background3.jpg)"></div>
            </div>
        </div>
    </div>

    <!--页脚-->
    <div class="footer">
        <div class="ownership">
            <span> &copy;2018 - <strong>成长相册-lifecat</strong> - TEN</span>
        </div>
    </div>
</div>

<!--引用外部js库：背景滚动-->
<script type="text/javascript" src="js/myjs/rollbackground.js"></script>

</body>
</html>