<%@ page import="com.wang.bean.dto.DiaryDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.wang.service.DiaryListQueryService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <!--编码信息-->
    <meta http-equiv="content-type" content="text/html;charset=UTF-8"/>
    <!--引用库：bootstrap-->
    <script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap/3.3.6/bootstrap.min.css">
    <!--引用库：jQuery-->
    <script src="js/jquery/2.0.0/jquery.min.js"></script>
    <!--引用库：mycss-->
    <link rel="stylesheet" href="css/mycss/header.css">
    <link rel="stylesheet" href="css/mycss/homePage.css">
    <link rel="stylesheet" href="css/mycss/footer.css">
    <!--引用库：myjs-->
    <script src="js/myjs/bordertap.js"></script>
    <script src="js/myjs/rollbackground.js"></script>
    <script src="js/myjs/toptap.js"></script>
    <!--引入库：layer-->
    <script src="js/layer/layer.js"></script>
    <!--引入库：标题栏layer-->
    <script src="js/myjs/navLayerButton.js"></script>
</head>

<!--启动时：发送刷新请求-->
<script>
    window.onload = function () {
        // 利用ajax将数据提交到后台
        $.ajax({
            url: "diary_list_query.do",
            type: 'get',
            contentType: 'charset=utf-8',
            data: {"userId": 1},
            success: function () {
                layer.msg("刷新成功");
            },
            error: function (error) {
                layer.msg('接口不通' + error);
            }
        });
    }
</script>

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
                        欢迎你
                    </a>
                </li>
                <!-- 修改密码:target跳转到myModal模块 -->
                <li>
                    <a id="nav-password-button" href="#">
                        <span class="glyphicon glyphicon-pencil"></span>
                        修改密码
                    </a>
                </li>
                <li>
                    <a href="index.html">
                        <span class="glyphicon glyphicon-log-out"></span>
                        退出
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>

<!--homePage-->

<!-- top-页面状态栏 -->
<div id="top-container" class="container">
    <div class="jumbotron " status="information">
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
                    <a href="#" status="information">个人信息</a>
                </li>

                <li role="presentation" class="active">
                    <a href="#" status="diary-list">日记动态</a>
                </li>

                <li role="presentation" class="">
                    <a href="#" status="image-list">图像记录</a>
                </li>

                <li role="presentation" class="">
                    <a href="#" status="image-show">成长相册</a>
                </li>

                <li role="presentation" class="">
                    <a href="#" status="image-class-show">智能图像分类</a>
                </li>

            </ul>
        </div>

        <!-- right-主页面栏 -->
        <div class="col-md-10 dataType">

            <!-- 个人信息栏 -->
            <div class="row" status="information">

                <div class="col-md-1">
                </div>

                <div class="col-md-10">
                    <div class="col-md-4">
                        <h3>个人信息</h3>
                        <table>

                            <tr class="msg">
                                <td>昵称:${sessionScope.userProperty.nickname}</td>
                            </tr>
                            <tr class="msg">
                                <td>个性签名:${sessionScope.userProperty.signature}</td>
                            </tr>
                            <tr class="msg">
                                <td>性别:${sessionScope.userProperty.sex}</td>
                            </tr>
                            <tr class="msg">
                                <td>邮箱:${sessionScope.userProperty.email}</td>
                            </tr>
                            <tr class="msg">
                                <td>生日:${sessionScope.userProperty.birthday}</td>
                            </tr>
                            <tr class="msg">
                                <td>地址:${sessionScope.userProperty.location}</td>
                            </tr>
                        </table>
                    </div>

                    <div class="col-md-4">
                        <h3>成长格言:</h3>
                        <table>
                            <tr class="bigmsg">
                                <td>路漫漫其修远兮，</td>
                            </tr>
                            <tr class="bigmsg">
                                <td>吾将上下而求索。</td>
                            </tr>
                            <tr class="bigmsg">
                                <td>爱子心无尽，</td>
                            </tr>
                            <tr class="bigmsg">
                                <td>归家喜及辰。</td>
                            </tr>
                        </table>
                    </div>

                    <div class="col-md-4">
                        <img height="140" width="140" src=${sessionScope.userProperty.iconPath} alt="用户未登录"/>
                    </div>
                </div>

                <div class="col-md-1">
                </div>

            </div>


            <!-- 日记栏 -->
            <div class="row" status="diary-list">

                <!-- 搜索框 -->
                <div class="row">
                    <div class="col-lg-6 col-lg-offset-6">
                        <form method="post" action="search.do">
                            <select class="col-lg-3 search-form">
                                <option value="1">序号</option>
                                <option value="2">标题</option>
                                <option value="3">作者</option>
                                <option value="4">日期</option>
                            </select>
                            <input id="search-text" type="text" class="col-lg-5  search-form"
                                   placeholder="请输入要查询的内容"
                                   name="keyword">
                            <button class="btn-default col-lg-3  search-form" type="submit">搜索日记</button>
                        </form>
                    </div>
                </div>

                <!-- /.row -->
                <div class="row">
                    <div class="col-md-1">
                        <form method="get" action="diary_list_query.do">
                            <button type="submit">刷新</button>
                        </form>
                        <button id="diary-insert" class="row">
                            新写日记
                        </button>
                        <button id="diary-delete" class="row">
                            删除所选
                        </button>
                        <form method="get" action="diary_all_delete.do">
                            <button id="diary-delete-all" class="row">删除全部</button>
                        </form>
                    </div>

                    <div class="col-md-11">
                        <div id="diary-form">
                            <table>
                                <th style="width: 5%">√</th>
                                <th style="width: 5%">序号</th>
                                <th style="width: 15%">标题</th>
                                <th style="width: 20%">内容</th>
                                <%--<th style="width: 15%">作者</th>--%>
                                <th style="width: 15%">日期</th>
                                <th style="width: 10%">操作</th>
                                <%--<th style="width: 15%">访问量</th>--%>
                                <c:forEach items="${sessionScope.diaryList}" var="diary">
                                    <tr>
                                        <td><input type="checkbox" name="checkAll" title="选项"/></td>
                                        <td class="diary-id">${diary.diaryId}</td>
                                        <td class="diary-name">${diary.diaryName}</td>
                                        <td class="diary-text">${diary.diaryText}</td>
                                        <td>${diary.diaryDate}</td>
                                        <td>
                                            <button name="diary-delete">
                                                删除
                                            </button>
                                            <button name="diary-update">
                                                修改
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>

                    <div class="col-md-1">
                    </div>
                </div>

                <!--换页功能-->
                <div class="row">
                    <div class="col-lg-1"></div>
                    <div class="col-lg-4">
                        <a id="diary-page-1" class="col-lg-1">1</a>
                        <a id="diary-page-2" class="col-lg-1">2</a>
                        <a id="diary-page-3" class="col-lg-1">3</a>
                        <a id="diary-page-4" class="col-lg-1">4</a>
                    </div>
                </div>
            </div>


            <!-- 相册栏 -->
            <div class="row" status="image-list">

                <div class="row">
                    <div class="col-md-1">
                    </div>

                    <div class="col-md-10">

                        <table>
                            <tr class="row">

                                <td class="col-md-3">
                                    <img src='images/usericon.jpg' height=200 width=200
                                         style="margin-top: 20px;"/>
                                </td>

                            </tr>
                        </table>
                    </div>

                    <div class="col-md-1">
                    </div>
                </div>
            </div>

        </div>
    </div>

</div>

<!--footer-->

<div class="footer">
    <div class="foot">
        &copy;2018 - <strong>成长相册-lifecat</strong> - JN University
    </div>
</div>

<!--引用外部js库：jQuery-->
<script src="js/t19ctgxcrlxxxxxxxx.js"></script>

</body>

<!--diary栏操作-->
<script>
    // 日记删除
    $("button[name='diary-delete']").on(
        "click",
        function (obj) {
            // 弹出loading框
            var ii = layer.load();

            var tr = $(this).parent().parent();
            var id = tr.children("td[class='diary-id']").text();
            var name = tr.children("td#diary_name").text();
            var text = tr.children("td#diary_text").text();

            console.log("id" + id);

            // 利用ajax将数据提交到后台
            $.ajax({
                url: "diary_delete.do",
                type: 'get',
                contentType: 'charset=utf-8',
                data: {diaryId: id},
                success: function () {
                    layer.close(ii);
                    layer.msg("删除成功");
                    setTimeout(function () {
                        window.location.reload()
                    },1000)
                },
                error: function (error) {
                    layer.close(ii);
                    layer.msg("删除失败");
                    console.log('接口不通' + error);
                }
            });


        }
    );

    // 新写日记
    $("#diary-insert").on('click', function () {
        layer.open({
            type: 2,
            title: 'diary日记',
            maxmin: true,
            shadeClose: true, //点击遮罩关闭层
            area: ['800px', '520px'],
            content: 'layerform/diaryUpload.html'
        });
    });

    // 日记更新-button
    $("button[name='diary-update']").on('click', function () {
        var tr = $(this).parent().parent();
        var id = tr.children("td[class='diary-id']").text();
        var name = tr.children("td[class='diary-name']").text();
        var text = tr.children("td[class='diary-text']").text();

        console.log("当前修改日记 id:" + id + " name:" + name + " text:" + text);

        layer.open({
            type: 2,
            title: '修改日记',
            maxmin: true,
            shadeClose: true, //点击遮罩关闭层
            area: ['800px', '520px'],
            content: 'layerform/diaryUpdate.html?id=' + id + "&name=" + name + "&text=" + text
        });
    });
</script>

<!--Nav栏layer-->
<script>
    // “书写寄语”
    $("#nav-diary-button").on('click', function () {
        layer.open({
            type: 2,
            title: '书写日记',
            maxmin: true,
            shadeClose: true, //点击遮罩关闭层
            area: ['800px', '520px'],
            content: 'layerform/diaryUpload.html'
        });
    });

    // “上传图片”
    $("#nav-image-button").on('click', function () {
        layer.open({
            type: 2,
            title: '选择图片',
            maxmin: true,
            shadeClose: true, //点击遮罩关闭层
            area: ['800px', '520px'],
            content: 'layerform/imageUpload.html'
        });
    });

    // 用户资料更新
    $("#nav-property-button").on('click', function () {
        layer.open({
            type: 2,
            title: '填写资料',
            maxmin: true,
            shadeClose: true, //点击遮罩关闭层
            area: ['800px', '520px'],
            content: 'layerform/propertyModify.html'
        });
    });

    // 密码更新
    $("#nav-password-button").on('click', function () {
        layer.open({
            type: 2,
            title: '修改密码',
            maxmin: true,
            shadeClose: true, //点击遮罩关闭层
            area: ['800px', '520px'],
            content: 'layerform/passwordModify.html'
        });
    });
</script>

</html>