<%@ page import="com.ten.bean.vo.DiaryVO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ten.service.DiaryListQueryService" %>
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
</head>

<body>
<!--header-->
<div class="navbar navbar-default">
    <div class="container">

        <!--导航条头部-->
        <div class="navbar-header">
            <!--图片Logo-->
            <a href="userhome.jsp" target="_blank" class="navbar-brand">
                <!--<img src="../../images/peopleicon.png" alt="未加载成功" height="44" width="152" style="margin-top: -13px;"/>-->
                <text id="logo-text">执子之手，与子偕老</text>
            </a>

            <!--折叠菜单的触发按钮-->
            <button data-toggle="collapse" data-target="#my-collapse"
                    type="button" class="navbar-toggle collapsed">
                <span class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
        </div>

        <!--导航条尾部信息栏-->
        <div id="my-collapse" class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <!--上传寄语-->
                <li><a href=updiary.html><span
                        class="glyphicon glyphicon-pencil"></span>
                    书写寄语</a>
                </li>

                <!--上传图片-->
                <li><a href=upimage.html><span
                        class="glyphicon glyphicon-pencil"></span>
                    记录图片</a>
                </li>

                <li><a href="#"><span>      </span></a>
                </li>
                <!-- 用户名信息 -->
                <li><a href="#" data-toggle="modal" data-target="#updatemsg"><span
                        class="glyphicon glyphicon-user"></span>
                    欢迎你
                </a>
                </li>
                <!-- 修改密码:target跳转到myModal模块 -->
                <li><a href="#" data-toggle="modal" data-target="#updatepsw"><span
                        class="glyphicon glyphicon-pencil"></span>
                    修改密码</a>
                </li>

                <li><a href="index.html"><span
                        class="glyphicon glyphicon-log-out"></span>
                    退出</a>
                </li>
            </ul>
        </div>
    </div>

    <!-- 模态框（Modal）updatepsw --修改密码 -->
    <div class="modal fade" id="updatepsw" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true">&times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel1">登录密码修改</h4>
                </div>
                <div class="modal-body">

                    <!-- form表单 修改密码信息 action=forechange -->
                    <form action="user_password_update.do" class="form col-md-12 center-block"
                          method="post">
                        <div class="form-group">
                            <h4>
                                <label for="oldPassword">原密码</label>
                            </h4>

                            <input type="text" id="oldPassword" name="oldPassword"
                                   class="form-control input-md" placeholder="请输入原密码" title="默认账号">

                        </div>
                        <div class="form-group">
                            <h4>
                                <label for="newPassword1">请输入要修改的密码</label>
                            </h4>

                            <input name="newPassword1" id="newPassword1" type="text"
                                   class="form-control input-md" placeholder="请输入你要修改的密码">

                        </div>
                        <div class="form-group">
                            <h4>
                                <label for="newPassword2">请再次输入</label>
                            </h4>

                            <input name="newPassword2" id="newPassword2" type="text"
                                   class="form-control " placeholder="请再次输入密码">

                        </div>
                        <div class="form-group">
                            <button class="btn btn-primary btn-lg btn-block">修改</button>
                        </div>
                        <input type="hidden" name="action" value="ModifyPsw">
                    </form>

                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>

            </div>
        </div>
        <!-- /.modal-content -->
    </div>


    <!-- 模态框（Modal）diary-upload --上传新日记 -->
    <div class="modal fade" id="diary-upload" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true">&times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel5">书写新日记</h4>
                </div>
                <div class="modal-body">

                    <!-- form表单 -->
                    <form action="diary_upload.do" class="form col-md-12 center-block"
                          method="post">
                        <div class="form-group">
                            <h4>
                                <label for="diaryName">日记标题</label>
                            </h4>

                            <input type="text" id="diaryName" name="diaryName"
                                   class="form-control input-md" placeholder="请输入标题" title="日记标题">

                        </div>
                        <div class="form-group">
                            <h4>
                                <label for="diaryText">日记内容</label>
                            </h4>

                            <textarea name="diaryText" id="diaryText" cols="30"
                                      rows="10" class="form-control input-md">
                                请输入日记内容
                            </textarea>
                        </div>

                        <div class="form-group">
                            <button class="btn btn-primary btn-lg btn-block">修改</button>
                        </div>
                    </form>

                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>

            </div>
        </div>
        <!-- /.modal-content -->
    </div>


    <!-- /.modal -->
    <!-- 模态框（Modal）updatemsg --添加图片 -->
    <div class="modal fade" id="updatemsg" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true">&times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">修改信息</h4>
                </div>

                <!-- 修改个人信息 -->
                <div class="modal-body">
                    <form action="user_property_update.do" class="form col-md-12 center-block"
                          method="post">
                        <div class="form-group">
                            <h5>新昵称</h5>
                            <input type="text" name="nickname" class="form-control input-lg"
                                   placeholder="" title="输入昵称">
                        </div>
                        <div class="form-group">
                            <h5>个性签名</h5>
                            <input type="text" name="signature" class="form-control input-lg"
                                   placeholder="" title="输入签名">
                        </div>
                        <div class="form-group">
                            <h5>性别</h5>
                            <input type="text" name="sex" class="form-control input-lg"
                                   placeholder="" title="输入性别">
                        </div>

                        <div class="form-group">
                            <h5>邮箱</h5>
                            <input type="text" name="email"
                                   class="form-control input-lg" placeholder="" title="输入邮箱">
                        </div>
                        <div class="form-group">
                            <h5>地址</h5>
                            <input type="text" name="location" class="form-control input-lg"
                                   placeholder="" title="你的地址">
                        </div>
                        <div class="form-group">
                            <h5>生日</h5>
                            <input type="text" name="birthday" class="form-control input-lg"
                                   placeholder="" title="输入生日">
                        </div>

                        <div class="form-group">
                            <button class="btn btn-primary btn-lg btn-block">修改</button>
                        </div>
                        <input type="hidden" name="action" value="SetMsg">
                    </form>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>

            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
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

                <li role="presentation" class=""><a href="#" status="information">个人信息</a>
                </li>

                <li role="presentation" class="active"><a href="#" status="diary-list">日记动态</a>
                </li>

                <li role="presentation" class=""><a href="#" status="image-list">图像记录</a>
                </li>

                <li role="presentation" class=""><a href="#" status="image-show">成长相册</a>
                </li>

                <li role="presentation" class=""><a href="#" status="image-class-show">智能图像分类</a>
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
                                <td>昵称:${user.user_nickname}</td>
                            </tr>
                            <tr class="msg">
                                <td>个性签名:${user.user_signature}</td>
                            </tr>
                            <tr class="msg">
                                <td>性别:${user.user_sex}</td>
                            </tr>
                            <tr class="msg">
                                <td>邮箱:${user.user_email}</td>
                            </tr>
                            <tr class="msg">
                                <td>生日:${user.user_birthday}</td>
                            </tr>
                            <tr class="msg">
                                <td>地址:${user.user_location}</td>
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
                        </table>
                    </div>

                    <div class="col-md-4">
                        <img height="140" width="140" src="images/usericon.jpg"/>
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
                        <a href="updiary.html">
                            <button id="diary-insert" class="row">新写日记
                            </button>
                        </a>
                        <button id="diary-delete" class="row">删除所选</button>
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
                                        <td id="diary_id">${diary.diaryId}</td>
                                        <td id="diary_name">${diary.diaryName}</td>
                                        <td id="diary_text">${diary.diaryText}</td>
                                        <td id="diary_date">${diary.diaryDate}</td>
                                        <td>
                                            <a href="diary_delete.do?diaryId=${diary.diaryId}">
                                                删除
                                            </a>
                                            <a href="diary_update.do?diaryId=${diary.diaryId}">
                                                修改
                                            </a>
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

<script>
    $("#delete-diary").on(
        "click",
        function (obj) {
            var tr = $(obj).parent().parent();
            var id = tr.children("td#diary_id").text();
            var name = tr.children("td#diary_name").text();
            var text = tr.children("td#diary_text").text();

            console.log("id" + id);

            // 利用ajax将数据提交到后台
            $.ajax({
                url: "diary_delete.do",
                type: 'get',
                contentType: 'charset=utf-8',
                data: {diaryId: id},
                success: function (data) {
                    layer.alert(data);
                },
                error: function (error) {
                    console.log('接口不通' + error);
                }
            });
        }
    );
</script>

</body>

</html>