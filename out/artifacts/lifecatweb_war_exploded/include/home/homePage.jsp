<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@page import="com.wang.bean.*" %>
<%@ page import="com.wang.model.GetMsgModel" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wang.model.GetDiaryModel" %>
<%@ page import="com.wang.model.GetImgModel" %>
<%@ page import="static com.wang.db.HOST.*" %>

<script>
    $(function () {

        $("div[status]").hide();
        $("div[status=usermsg-show]").show();
        console.log("运行隐藏和显示表格");

        $("a[status]").click(function () {
            var status = $(this).attr("status");
            console.log(status);
            $("div[status]").hide();
            $("div[status=" + status + "]").show();
            //由于双引号没加，造成编译错误
            $("div.dataType li").removeClass("active");
            $(this).parent("li").addClass("active");
        });

    });
</script>

<style>
    .msg {
        background: #f8f8f8;
        color: #000000;
        cursor: text;
        font-family: "arial", serif;
        font-size: 15pt;
        padding: 2px
    }

    .bigmsg {
        background: #f8f8f8;
        color: #FF0000;
        cursor: text;
        font-family: "arial", serif;
        font-size: 40px;
        padding: 5px
    }
</style>


<!-- top-页面状态栏 -->
<div class="container">
    <div class="jumbotron " status="information">
        <h1>成长信息</h1>
        <p>守护TA的成长</p>
    </div>
    <div class="jumbotron " status="no_diary-show">
        <h1>成长寄语</h1>
        <p>送给未来的TA</p>
    </div>
    <div class="jumbotron " status="image-show">
        <h1>成长相册</h1>
        <p>记录美好时刻</p>
    </div>
</div>

<!-- left-页面切换栏 -->
<div class="container">
    <div class="row">
        <div class="col-md-2  dataType">
            <ul class="nav nav-pills nav-stacked">
                <li class="" role="presentation"><a href="#"
                                                    status="information">成长信息</a>
                </li>

                <li role="presentation" class="active"><a href="#"
                                                          status="no_diary-show">成长寄语</a>
                </li>

                <li role="presentation" class=""><a href="#"
                                                    status="image-show">成长相册</a>
                </li>

            </ul>
        </div>

        <!-- 获取UserMsg对象 -->

        <!-- right-主页面栏 -->
        <div class="col-md-9 dataType">
            <%
                /* 获取用户ID */
                int id = 0;
                User user = (User) request.getSession().getAttribute("User");
                if (user != null) {
                    id = user.getId();
                }
            %>

            <!-- 个人信息栏 -->
            <div class="row" status="information">
                <div class="col-md-3">


                </div>
                <div class="col-md-3">
                    <h2>信息:</h2>

                    <table>
                        <%
                            UserMsg usermsg;
                            /* 若当期有用户登录 */
                            if (user != null && !user.getName().equals("admin")) {
                                GetMsgModel model = new GetMsgModel();
                                usermsg = model.getUserMsg(id);
                            }
                            /* 若无用户登录，默认信息 */
                            else {
                                usermsg = new UserMsg();
                                usermsg.setNickname("admin");
                                usermsg.setSex("man");
                                usermsg.setAge("21");
                                usermsg.setBirthday("1997");
                                usermsg.setEmail("wshten@gmail.com");
                            }
                        %>
                        <tr class="msg">
                            <span>昵称: <%=usermsg.getNickname() %> </span>
                        </tr>
                        <br>
                        <tr class="msg">
                            <span>性别: <%=usermsg.getSex() %></span>
                        </tr>
                        <br>
                        <tr class="msg">
                            <span>年龄: <%=usermsg.getAge() %> </span>
                        </tr>
                        <br>
                        <tr class="msg">
                            <span>生日: <%=usermsg.getBirthday() %> </span>
                        </tr>
                        <br>
                        <tr class="msg">
                            <span>邮箱: <%=usermsg.getEmail() %> </span>
                        </tr>
                        <br>
                        <br>

                    </table>
                </div>

                <div class="col-md-3">
                    <h2>成长格言:</h2>

                    <table>
                        <tr class="bigmsg">
                            <span>路漫漫其修远兮，</span>
                        </tr>
                        <br>
                        <tr class="bigmsg">
                            <span>吾将上下而求索。</span>
                        </tr>

                    </table>
                </div>

                <div class="col-md-3">
                    <img height="140" width="140" src="img/headicon.jpg">
                </div>

            </div>


            <!-- 日记栏 -->
            <div class="row" status="no_diary-show">

                <%--<!-- 搜索框 -->--%>
                <%--<div class="row">--%>
                <%--<div class="col-lg-4 col-lg-offset-8">--%>
                <%--<form action="service/Search" method="post">--%>
                <%--<div class="input-group">--%>
                <%--<input type="text" class="form-control" placeholder="请输入要查询的内容 "--%>
                <%--name="keyword" value="${param.keyword}"> <span--%>
                <%--class="input-group-btn">--%>
                <%--<button class="btn btn-default" type="submit">搜索</button> </span>--%>
                <%--</div>--%>
                <%--<!-- /input-group -->--%>
                <%--</form>--%>
                <%--</div>--%>
                <%--<!-- /.col-lg-6 -->--%>
                <%--</div>--%>

                <!-- /.row -->
                <div class="row">
                    <div class="col-md-3">

                    </div>

                    <div class="col-md-9">
                        <h2>成长日记:</h2>
                        <%--获取日记链接--%>
                        <%
                            ArrayList<Diary> diaries;
                            /* 若当期有用户登录 */
                            if (user != null && !user.getName().equals("admin")) {
                                GetDiaryModel model = new GetDiaryModel();
                                diaries = model.getDiaries(id);
                            }
                            /* 若无用户登录，添加3条默认信息 */
                            else {
                                diaries = new ArrayList<>();
                                for (int i = 0; i < 5; i++) {
                                    Diary no_diary = new Diary();
                                    no_diary.setName("成长寄语" + i);
                                    no_diary.setDescription("美好的午后，写下成长的寄语" + i);
                                    no_diary.setDate("2018-" + i);
                                    no_diary.setPath(host_userhome);
                                    diaries.add(no_diary);
                                }
                            }
                        %>
                        <table>
                            <%
                                /* 循环打印日记信息 */
                                for (Diary diary : diaries) {
                            %>
                            <tr class="msg">
                                <td>
                                    <span><a href=<%=diary.getPath()%>><%=diary.getName() + ":"%></a></span>
                                </td>
                                <td>
                                    <span><%=diary.getDescription()%></span>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                            <%--<% %>--%>
                            <%--<tr class="row">--%>
                            <%--<span><a href="#">1</a>&nbsp;&nbsp;--%>
                            <%--<a href="#">2</a>&nbsp;&nbsp;--%>
                            <%--<a href="#">3</a>&nbsp;&nbsp;--%>
                            <%--<a href="#">...</a> </span>--%>
                            <%--</tr>--%>
                            <%--<% %>--%>
                        </table>
                    </div>
                </div>
            </div>


            <!-- 相册栏 -->
            <div class="row" status="image-show">
                <div class="row">
                    <div class="col-md-1">

                    </div>
                    <div class="col-md-11">
                        <a href=imageshowpage.jsp><h2>成长相册:</h2></a>
                        <%--获取图片链接--%>
                        <%
                            ArrayList<Image> images = null;
                            /* 若当期有用户登录 */
                            if (user != null && !user.getName().equals("admin")) {
                                GetImgModel model = new GetImgModel();
                                images = model.getImages(id);
                            }
                            /* 若无用户登录，添加3条默认图片 */
                            if (images == null) {
                                images = new ArrayList<>();
                                for (int i = 0; i < 3; i++) {
                                    Image no_image = new Image();
                                    no_image.setImagename("成长相册" + i);
                                    no_image.setImagedescription("美好的午后，记录美好的时刻" + i);
                                    no_image.setImagedate("2018-" + i);
                                    no_image.setImagepath("http://"+ip+":8080/lifecatweb/upimage/image" + i + ".jpg");
                                    images.add(no_image);
                                }
                            }
                        %>
                        <table>
                            <%
                                /* 循环打印图片信息 */
                                for (Image image : images) {
                            %>
                            <tr class="row">
                                <td class="col-md-3"></td>
                                <td class="col-md-3"><span><img src=<%=image.getImagepath()%>
                                                                        height="100" width="100"
                                                                style="margin-top: 20px;"/> </span>
                                </td>
                                <td class="col-md-6">
                                    <span><%=image.getImagename() + ":"%></span>
                                    <span><%=image.getImagedescription()%></span>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>