<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@page import="com.wang.bean.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="static com.wang.constant.HOST.*" %>
<%@ page import="com.wang.service.impl.ServiceFactory" %>
<%@ page import="com.wang.bean.dto.DiariesDTO" %>
<%@ page import="com.wang.bean.dto.DiaryDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.wang.util.DateTimeUtil" %>
<%@ page import="com.wang.bean.dto.ImageDTO" %>
<%@ page import="com.wang.constant.Directory" %>
<%@ page import="com.wang.bean.dto.UserPropertyDTO" %>

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

<%--<script type="text/javascript">--%>
<%--window.onload = function (theUrl)//用window的onload事件，窗体加载完毕的时候--%>
<%--{--%>
<%--document.URL = "image_list_query.do"--%>
<%--}--%>
<%--</script>--%>

<%
    // 从session中获取user信息
    UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
    Integer userId = userDTO.getUserId();
    String userName = userDTO.getUserName();

    DateTimeUtil time = DateTimeUtil.getInstance();
%>

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

                        <%
                            UserPropertyDTO userPropertyDTO = null;

                            userPropertyDTO = (UserPropertyDTO) request.getSession().getAttribute("userProperty");

                            if (userPropertyDTO == null) {
                                userPropertyDTO = new UserPropertyDTO
                                        .Builder(userId)
                                        .nickname("lifecat")
                                        .signature("lifecat is my love")
                                        .sex("man")
                                        .email("wshten@gmail.com")
                                        .birthday("1997-01-01")
                                        .location("wuxi china")
                                        .iconPath(Directory.DEFAULT_IMAGE_PATH)
                                        .build();
                            }
                        %>
                        <table>
                            <tr class="msg">
                                <span>昵称: <%=userPropertyDTO.getNickname()%> </span>
                            </tr>
                            <br>
                            <tr class="msg">
                                <span>个性签名: <%=userPropertyDTO.getSignature()%> </span>
                            </tr>
                            <tr class="msg">
                                <span>性别: <%=userPropertyDTO.getSex()%> </span>
                            </tr>
                            <tr class="msg">
                                <span>邮箱: <%=userPropertyDTO.getEmail()%> </span>
                            </tr>
                            <br>
                            <tr class="msg">
                                <span>生日: <%=userPropertyDTO.getBirthday()%>  </span>
                            </tr>
                            <br>
                            <tr class="msg">
                                <span>地址: <%=userPropertyDTO.getLocation()%>  </span>
                            </tr>
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
                        <img height="140" width="140" src=<%=userPropertyDTO.getIconPath()%>>
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
                        <%
                            // 获取日记集
                            List<DiaryDTO> diaries = null;

                            diaries = (List<DiaryDTO>) request.getSession().getAttribute("diaryList");

                            // 获取diaries失败
                            if (diaries == null) {
                                diaries = new ArrayList<>(10);
                                for (int i = 1; i < 10; i++) {
                                    DiaryDTO defaultDiary = new DiaryDTO
                                            .Builder(0)
                                            .diaryName("我的第" + i + "篇成长寄语")
                                            .diaryText("爱子心无尽，归家喜及辰")
                                            .diaryDate(time.getCurrentTime())
                                            .build();
                                    diaries.add(defaultDiary);
                                }
                            }
                        %>
                        <table>
                            <%
                                /* 循环打印日记信息 */
                                for (DiaryDTO diary : diaries) {
                            %>
                            <tr class="msg">
                                <td>
                                    <span><%=diary.getDiaryName() + ":"%></span>
                                </td>
                                <td>
                                    <span><%="日记内容:" + diary.getDiaryText()%></span>
                                </td>
                                <td>
                                    <span><%="发表时间:" + diary.getDiaryDate()%></span>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                            <tr class="row">
                            <span><a href="#">1</a>&nbsp;&nbsp;
                            <a href="#">2</a>&nbsp;&nbsp;
                            <a href="#">3</a>&nbsp;&nbsp;
                            <a href="#">...</a> </span>
                            </tr>
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
                        <%
                            // 获取图片集
                            List<ImageDTO> images = null;

                            images = (List<ImageDTO>) request.getSession().getAttribute("imageList");

                            // 获取images失败
                            if (images == null) {
                                images = new ArrayList<>(10);
                                for (int i = 0; i < 4; i++) {
                                    ImageDTO defaultImage = new ImageDTO
                                            .Builder(0, Directory.DEFAULT_IMAGE_PATH, time.getCurrentTime())
                                            .imageClassId(0)
                                            .imageText("美好的时刻，记录在lifecat")
                                            .build();
                                    images.add(defaultImage);
                                }
                            }
                        %>
                        <table>
                            <tr class="row">
                                <%
                                    /*  循环打印demo图片img
                                     *  倒叙:最新上传的图片最前展示
                                     *  日志:demo_image_path打印demo图片链接
                                     */
                                    for (ImageDTO image : images) {

                                %>

                                <td class="col-md-3"><span><img src=<%=image.getImagePath()%>
                                                                        height="200" width="200"
                                                                style="margin-top: 20px;"/> </span>
                                </td>
                                <%
                                    }
                                %>
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