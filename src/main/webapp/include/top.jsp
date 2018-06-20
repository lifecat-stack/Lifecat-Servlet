<%@ page import="com.wang.bean.dto.UserDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<%-- 页眉 导航条 --%>

<%--<script>--%>

<%--<c:if test="${not empty message}">--%>
<%--alert("${message}");--%>
<%--console.log("msg弹出");--%>
<%--</c:if>--%>
<%----%>
<%--</script>--%>

<style>
    body {
        font-family: Verdana, Arial, sans-serif;
        padding: 0;
        margin: 0;
        text-align: center;
        background: url("../img/homeback.jpg") repeat;
    }
</style>

<body>

<div class="navbar navbar-default">
    <div class="container">

        <!--导航条头部-->
        <div class="navbar-header">
            <a href="userhome.action" target="_blank" class="navbar-brand">
                <img src="../img/iconimage.png" height="44" width="152" style="margin-top: -13px;"/>
            </a>

            <!--logo-->
            <!--折叠菜单的触发按钮-->
            <button data-toggle="collapse" data-target="#my-collapse"
                    type="button" class="navbar-toggle collapsed">
                <span class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
        </div>

        <!--导航条尾部信息栏-->
        <div id="my-collapse" class="collapse navbar-collapse">
            <%
                /*
                 *  获取UserDTO
                 *  获取用户名
                 */
                String username;
                UserDTO user = (UserDTO) request.getSession().getAttribute("user");
                if (user != null) {
                    if (user.getUserName() != null) {
                        username = user.getUserName();
                    } else {
                        username = "亲爱的用户";
                    }
                } else {
                    username = "您未登录";
                }
            %>
            <ul class="nav navbar-nav navbar-right">
                <%--上传寄语--%>
                <li><a href=updiary.action><span
                        class="glyphicon glyphicon-pencil"></span>书写寄语</a>
                </li>

                <%--上传图片--%>
                <li><a href=upimage.action><span
                        class="glyphicon glyphicon-pencil"></span>记录图片</a>
                </li>

                <li><a href="#"><span>      </span></a>
                </li>
                <!-- 用户名信息 -->
                <li><a href="#" data-toggle="modal" data-target="#updatemsg"><span
                        class="glyphicon glyphicon-user"></span>
                    欢迎你 <%=username%>
                </a>
                </li>
                <!-- 修改密码:target跳转到myModal模块 -->
                <li><a href="#" data-toggle="modal" data-target="#updatepsw"><span
                        class="glyphicon glyphicon-pencil"></span>
                    修改密码</a>
                </li>

                <li><a href=../index.jsp><span
                        class="glyphicon glyphicon-log-out"></span>退出</a>
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



