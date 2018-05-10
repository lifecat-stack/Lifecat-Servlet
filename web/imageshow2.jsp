<%@ page import="com.wang.bean.Image" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wang.model.GetImgModel" %>
<%@ page import="static com.wang.util.HOST.ip" %>
<%@ page import="java.util.logging.Logger" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>

<style>
    body {
        font-family: Verdana, Arial, sans-serif;
        padding: 0;
        margin: 0;
        font-size: 20px;
        text-align: center;
        background: #000 url("img/back.jpg") repeat;
        color: #656565;
    }

    p {
        margin: 0;
    }

    img {
        border: none;
    }

    a {
        text-decoration: none;
    }

    ul, ol, dl, dt, dd, li {
        margin: 0;
        padding: 0;
        list-style: none;
    }

    /*页面包含框*/
    #wrap {
        width: 880px;
        margin: 0 auto;
        text-align: left;
    }

    #nav{
        height: 38px;
        border-bottom: 6px solid;
    }
    /*主体信息包含框*/
    #main {
        overflow: inherit;
        border: 6px solid;
        border-top: none;
        background: #0f0f0f;
    }

    #side_menu {
        float: left;
        padding: 22px 12px 12px 12px;
        width: 170px;
        margin-top: 2em;
    }

    #side_menu div {
        padding: 4px;
        margin: 2px auto;
        float: left;
        position: relative;
    }

    #side_menu a {
        border: solid 2px #bbb;
    }

    #side_menu img {
        border: solid 3px #efefef;
        width: 170px;
        height: 170px;
    }

    #side_menu span {
        position: absolute;
        right: 12px;
        bottom: 10px;
        padding: 2px 4px;
        color: #eee;
        background: #444;
        filter: alpha(opacity=60);
        -moz-opacity: 0.6;
        opacity: 0.6;
    }

    #content {
        float: left;
        width: 650px;
        padding: 12px 8px 6px 8px;
    }

    #content h3 {
        padding: 0;
        margin: 0;
        font-size: 40px;
        text-align: center;
        color: #00aaee;
    }

    .gallery {
        position: relative;
        padding-top: 8px;
        width: 100%;
    }

    #thumbs {
        width: 205px;
        float: right;
    }

    #thumbs a {
        float: right;
        margin: 1px 0 3px 10px;
        width: 50px;
        height: 50px;
        border: 2px solid #FFF;
    }

    #thumbs a img {
        width: 50px;
        height: 50px;
    }

    #thumbs a:hover {
        border-color: #8A8A8A;
    }

    #thumbs a:hover img, #thumbs a:active img {
        position: absolute;
        width: 450px;
        height: 320px;
        right: 196px;
        top: 8px;
        padding: 2px;
        border: 2px solid #8A8A8A;
    }

</style>

<script type="text/javascript">
    function change_div(id) {
        if (id === 'part1') {
            document.getElementById("part1").style.display = 'block';
            document.getElementById("part2").style.display = 'none';
            document.getElementById("part3").style.display = 'none';
        }
        else if (id === 'part2') {
            document.getElementById("part2").style.display = 'block';
            document.getElementById("part1").style.display = 'none';
            document.getElementById("part3").style.display = 'none';
        } else if (id === 'part3') {
            document.getElementById("part3").style.display = 'block';
            document.getElementById("part1").style.display = 'none';
            document.getElementById("part2").style.display = 'none';
        } else {
            document.getElementById("part1").style.display = 'block';
            document.getElementById("part2").style.display = 'block';
            document.getElementById("part3").style.display = 'block';
        }
    }
</script>

<body>
<div id="nav">
    <ul>
        <li><a class="selected" href="userhome.jsp">首页</a></li>
        <li><a class="selected" href="imageshow.jsp">相册</a></li>
    </ul>
</div>

<!-- 图片的展示栏 -->
<div id="wrap">
    <div id="main">
        <%--侧栏信息包含框--%>
        <div id="side_menu">
            <div>
                <a href="#">
                    <img src="pics/1/class.jpg" alt="人物" onclick="change_div('part1')">
                </a>
                <span>人物</span>
            </div>
            <div>
                <a href="#">
                    <img src="pics/2/class.jpg" alt="风景" onclick="change_div('part2')">
                </a>
                <span>风景</span>
            </div>
            <div>
                <a href="#">
                    <img src="pics/3/class.jpg" alt="考试" onclick="change_div('part3')">
                </a>
                <span>考试</span>
            </div>
        </div>
        <%--照片显示区域--%>
        <div id="content">
            <%--照片分类标题--%>
            <h3>相册智能分类</h3>
            <%--缩略图包含框--%>
            <div class="gallery" id="part1">
                <%
                    //获取图片在服务器上的路径
                    String[] paths1 = new GetImgModel().getCategoryImages(1);
                %>

                <%
                    /** 倒叙循环打印图片img
                     *  倒叙:最新上传的图片最前展示
                     *  日志:image_path打印图片链接
                     */
                    for (int i = paths1.length - 1; i > 2; i -= 3) {
                        Logger logger = Logger.getLogger("path1-images");
                        logger.info(paths1[i]);
                        logger.info(paths1[i - 1]);
                        logger.info(paths1[i - 2]);
                %>
                <span id="thumbs">
                    <a href="#"><img src=<%=paths1[i]%> title="1" alt="1"/></a>
                    <a href="#"><img src=<%=paths1[i-1]%> title="2" alt="2"/></a>
                    <a href="#"><img src=<%=paths1[i-2]%> title="3" alt="3"/></a>
                </span>
                <%
                    }
                %>
            </div>

            <%--缩略图包含框--%>
            <div class="gallery" id="part2">
                <%
                    //获取图片在服务器上的路径
                    String[] paths2 = new GetImgModel().getCategoryImages(2);
                %>

                <%
                    /** 倒叙循环打印图片img
                     *  倒叙:最新上传的图片最前展示
                     *  日志:image_path打印图片链接
                     */
                    for (int i = paths2.length - 1; i > 2; i -= 3) {
                        Logger logger = Logger.getLogger("path2-images");
                        logger.info(paths2[i]);
                        logger.info(paths2[i - 1]);
                        logger.info(paths2[i - 2]);
                %>
                <span id="thumbs">
                    <a href="#"><img src=<%=paths2[i]%> title="1" alt="1"/></a>
                    <a href="#"><img src=<%=paths2[i-1]%> title="2" alt="2"/></a>
                    <a href="#"><img src=<%=paths2[i-2]%> title="3" alt="3"/></a>
                </span>
                <%
                    }
                %>
            </div>

            <%--缩略图包含框--%>
            <div class="gallery" id="part3">
                <%
                    //获取图片在服务器上的路径
                    String[] paths3 = new GetImgModel().getCategoryImages(3);
                %>

                <%
                    /** 倒叙循环打印图片img
                     *  倒叙:最新上传的图片最前展示
                     *  日志:image_path打印图片链接
                     */
                    for (int i = paths3.length - 1; i > 2; i -= 3) {
                        Logger logger = Logger.getLogger("path3-images");
                        logger.info(paths3[i]);
                        logger.info(paths3[i - 1]);
                        logger.info(paths3[i - 2]);
                %>
                <span id="thumbs">
                    <a href="#"><img src=<%=paths3[i]%> title="1" alt="1"/></a>
                    <a href="#"><img src=<%=paths3[i-1]%> title="2" alt="2"/></a>
                    <a href="#"><img src=<%=paths3[i-2]%> title="3" alt="3"/></a>
                </span>
                <%
                    }
                %>
            </div>
        </div>
    </div>
</div>

</body>

</html>