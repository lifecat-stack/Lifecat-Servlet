<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8"/>

    <link rel="stylesheet" href="/lifecatweb/css/bootstrap/3.3.6/bootstrap.min.css">
    <link rel="stylesheet" href="/lifecatweb/css/fore/style.css">
    <link rel="stylesheet" href="/lifecatweb/css/mycss/homePage.css">

    <script src="/lifecatweb/js/jquery/2.0.0/jquery.min.js"></script>
    <script src="/lifecatweb/js/bootstrap/3.3.6/bootstrap.min.js"></script>
</head>
<body>
<!-- 图片的展示栏 -->
<div class="container">
    <!-- 相册栏 -->
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <c:forEach items="${sessionScope.imageList}" var="image" begin="0" end="2">
                <img src="${image.imagePath}" height="140" width="140" style="margin-top: 2px;"/>
                <img src="${image.imagePath}" height="140" width="140" style="margin-top: 2px;"/>
                <img src="${image.imagePath}" height="140" width="140" style="margin-top: 2px;"/>
                <img src="${image.imagePath}" height="140" width="140" style="margin-top: 2px;"/>
                <br>
            </c:forEach>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>
</body>
</html>
