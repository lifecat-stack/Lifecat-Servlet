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
<style>
    body {
        font-family: Verdana, Arial, sans-serif;
        padding: 0;
        margin: 0;
        font-size: 20px;
        text-align: center;
        background: #000 url("../img/homeback.jpg") repeat;
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

</body>
</html>
