<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8"/>
    <link rel="stylesheet" href="/servlet/css/bootstrap/3.3.6/bootstrap.min.css">
    <link rel="stylesheet" href="/servlet/css/fore/style.css">
    <link rel="stylesheet" href="/servlet/css/mycss/homePage.css">
    <link rel="stylesheet" href="/servlet/css/mycss/class.css">
    <script src="/servlet/js/jquery/2.0.0/jquery.min.js"></script>
    <script src="/servlet/js/bootstrap/3.3.6/bootstrap.min.js"></script>
</head>
<script type="text/javascript">
    function change_div(id) {
        if (id === 1) {
            $("#part1").addClass("show").removeClass("hide");
            $("#part2").removeClass("show").addClass("hide");
            $("#part3").removeClass("show").addClass("hide");
        }
        else if (id === 2) {
            $("#part2").addClass("show").removeClass("hide");
            $("#part1").removeClass("show").addClass("hide");
            $("#part3").removeClass("show").addClass("hide");
        }
        else if (id === 3) {
            $("#part3").addClass("show").removeClass("hide");
            $("#part1").removeClass("show").addClass("hide");
            $("#part2").removeClass("show").addClass("hide");
        }
    }
</script>
<body>
<!-- 图片的展示栏 -->
<div id="wrap">
    <div id="main">
        <div id="side_menu">
            <div>
                <a href="#" onclick="change_div(1)">
                    <img src="/servlet/pics/1/class.jpg" alt="人物">
                </a>
                <span>人物</span>
            </div>
            <div>
                <a href="#" onclick="change_div(2)">
                    <img src="/servlet/pics/2/class.jpg" alt="风景">
                </a>
                <span>风景</span>
            </div>
            <div>
                <a href="#" onclick="change_div(3)">
                    <img src="/servlet/pics/3/class.jpg" alt="考试">
                </a>
                <span>考试</span>
            </div>
        </div>

        <div id="content">

            <div class="gallery show" id="part1">
                <c:forEach items="${sessionScope.AlbumClassList[0].imageClassList}" var="image" begin="0" end="29">
                    <img src="${image.imagePath}" height="100" width="100" style="margin-top: 2px;"/>
                </c:forEach>
            </div>

            <div class="gallery hide" id="part2">
                <c:forEach items="${sessionScope.AlbumClassList[1].imageClassList}" var="image" begin="0" end="29">
                    <img src="${image.imagePath}" height="100" width="100" style="margin-top: 2px;"/>
                </c:forEach>
            </div>

            <div class="gallery hide" id="part3">
                <c:forEach items="${sessionScope.AlbumClassList[2].imageClassList}" var="image" begin="0" end="29">
                    <img src="${image.imagePath}" height="100" width="100" style="margin-top: 2px;"/>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

</body>
</html>
