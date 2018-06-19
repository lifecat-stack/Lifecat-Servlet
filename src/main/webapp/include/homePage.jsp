<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@page import="com.wang.bean.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="static com.wang.constant.HOST.*" %>

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
            <%-- 个人信息栏 --%>
            <div class="row" status="information">
                <div class="col-md-1">

                </div>
                <div class="col-md-10">
                    <div class="col-md-4">
                        <h2>个人信息:</h2>

                        <table>
                            <tr class="msg">
                                <span>昵称:  </span>
                            </tr>
                            <br>
                            <tr class="msg">
                                <span>性别: </span>
                            </tr>
                            <br>
                            <tr class="msg">
                                <span>年龄:  </span>
                            </tr>
                            <br>
                            <tr class="msg">
                                <span>生日:  </span>
                            </tr>
                            <br>
                            <tr class="msg">
                                <span>邮箱:  </span>
                            </tr>
                            <br>
                            <br>

                        </table>
                    </div>

                    <div class="col-md-4">
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

                    <div class="col-md-4">
                        <img height="140" width="140" src="../img/usericon.jpg">
                    </div>
                </div>
                <div class="col-md-1">

                </div>

            </div>


            <!-- 日记栏 -->
            <div class="row" status="no_diary-show">

                <%--<!-- 搜索框 -->--%>
                <%--<div class="row">--%>
                <%--<div class="col-lg-4 col-lg-offset-8">--%>
                <%--<com.wang.filter.form action="com.wang.service/Search" method="post">--%>
                <%--<div class="input-group">--%>
                <%--<input type="text" class="com.wang.filter.form-control" placeholder="请输入要查询的内容 "--%>
                <%--name="keyword" value="${param.keyword}"> <span--%>
                <%--class="input-group-btn">--%>
                <%--<button class="btn btn-default" type="submit">搜索</button> </span>--%>
                <%--</div>--%>
                <%--<!-- /input-group -->--%>
                <%--</com.wang.filter.form>--%>
                <%--</div>--%>
                <%--<!-- /.col-lg-6 -->--%>
                <%--</div>--%>

                <!-- /.row -->
                <div class="row">
                    <div class="col-md-1">

                    </div>

                    <div class="col-md-10">
                        <h2>成长日记:</h2>
                        <%--获取日记链接--%>
                        <%
                            ArrayList<Diary> diaries;
                            /* 若当期有用户登录 */
                            if (user != null && !user.getName().equals("admin")) {
                                GetDiaryModel DAOManager = new GetDiaryModel();
                                diaries = DAOManager.getDiaries(id);
                            }
                            /* 若无用户登录，添加3条默认信息 */
                            else {
                                diaries = new ArrayList<>();
                                for (int i = 0; i < 5; i++) {
                                    Diary no_diary = new Diary();
                                    no_diary.setName("成长寄语" + i);
                                    no_diary.setDescription("美好的午后，写下成长的寄语" + i);
                                    no_diary.setDate("2018-" + i);
                                    no_diary.setPath(page_userhome);
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
                    <div class="col-md-1">

                    </div>
                </div>
            </div>


            <!-- 相册栏 -->
            <div class="row" status="image-show">
                <div class="row">
                    <div class="col-md-1">

                    </div>
                    <div class="col-md-10">
                        <a href=imageshow.action><h2>成长相册:</h2></a>
                        <%--获取图片链接--%>
                        <%
                            //获取demo图片在服务器上的路径
                            String[] paths = new GetImgModel().getDemoImages();
                        %>
                        <table>
                            <%
                                /*  循环打印demo图片img
                                 *  倒叙:最新上传的图片最前展示
                                 *  日志:demo_image_path打印demo图片链接
                                 */
                                for (int i = paths.length - 1; i > 3; i -= 4) {
                                    Logger logger = Logger.getLogger("demo_image_path");
                                    logger.info(paths[i]);
                                    logger.info(paths[i - 1]);
                                    logger.info(paths[i - 2]);
                                    logger.info(paths[i - 3]);
                            %>
                            <tr class="row">
                                <td class="col-md-3"><span><img src=<%=paths[i]%>
                                                                        height="200" width="200"
                                                                style="margin-top: 20px;"/> </span>
                                </td>
                                <td class="col-md-3"><span><img src=<%=paths[i-1]%>
                                                                        height="200" width="200"
                                                                style="margin-top: 20px;"/> </span>
                                </td>
                                <td class="col-md-3"><span><img src=<%=paths[i-2]%>
                                                                        height="200" width="200"
                                                                style="margin-top: 20px;"/> </span>
                                </td>
                                <td class="col-md-3"><span><img src=<%=paths[i-3]%>
                                                                        height="200" width="200"
                                                                style="margin-top: 20px;"/> </span>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                        </table>
                    </div>
                    <div class="col-md-1">

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>