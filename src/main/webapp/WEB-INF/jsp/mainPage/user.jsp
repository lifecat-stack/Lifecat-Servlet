<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<!-- 个人信息栏 -->
<div class="row" status="information">
    <div class="col-md-1"></div>
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
            <c:if test="${sessionScope.userProperty.iconPath!=null}">
                <img height="140" width="140" src="${sessionScope.userProperty.iconPath}" alt="头像获取失败"/>
            </c:if>
        </div>
    </div>
    <div class="col-md-1">
    </div>
</div>

</body>
</html>
