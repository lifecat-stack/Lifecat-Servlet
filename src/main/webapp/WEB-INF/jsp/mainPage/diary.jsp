<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8"/>

    <link rel="stylesheet" href="/servlet/css/bootstrap/3.3.6/bootstrap.min.css">
    <link rel="stylesheet" href="/servlet/css/fore/style.css">
    <link rel="stylesheet" href="/servlet/css/mycss/homePage.css">

    <script src="/servlet/js/jquery/2.0.0/jquery.min.js"></script>
    <script src="/servlet/js/bootstrap/3.3.6/bootstrap.min.js"></script>
</head>
<body>
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

    <div class="row">
        <div class="col-md-1">
            <form method="get" action="diary_list_query.do">
                <button type="submit">刷新</button>
            </form>
            <button id="diary-insert" class="row">
                新写日记
            </button>
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
                    <c:forEach items="${sessionScope.diaryList}" begin="0" end="10" var="diary">
                        <tr>
                            <td><input type="checkbox" name="checkAll" title="选项"/></td>
                            <td class="diary-id">${diary.diaryId}</td>
                            <td class="diary-name">${diary.diaryName}</td>
                            <td class="diary-text">${diary.diaryText}</td>
                            <td>${diary.diaryDate}</td>
                            <td>
                                <a href="#" name="diary-delete">
                                    删除
                                </a>
                                <a href="#" name="diary-update">
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
</body>
<script>
    // 日记删除
    $(document).on('click', "a[name='diary-delete']", function () {
        var tr = $(this).parent().parent();
        var id = tr.children("td[class='diary-id']").text();

        console.log("id:" + id);
        var ii = layer.load();
        $.ajax({
            url: "diary_delete.do",
            type: 'get',
            contentType: 'charset=utf-8',
            data: {diaryId: id},
            success: function () {
                layer.close(ii);
                layer.msg("删除成功");
                setTimeout(function () {
                    window.location.reload()
                }, 1000)
            },
            error: function (error) {
                layer.close(ii);
                layer.msg("删除失败");
                console.log('接口不通' + error);
            }
        });
    });

    // 新写日记
    $(document).on('click', "#diary-insert", function () {
        layer.open({
            type: 2,
            title: 'diary日记',
            maxmin: true,
            shadeClose: true, //点击遮罩关闭层
            area: ['800px', '520px'],
            content: 'layerform/diaryUpload.html'
        });
    });

    // 日记更新-button
    $(document).on('click', "a[name='diary-update']", function () {
        var tr = $(this).parent().parent();
        var id = tr.children("td[class='diary-id']").text();
        var name = tr.children("td[class='diary-name']").text();
        var text = tr.children("td[class='diary-text']").text();

        console.log("当前修改日记 id:" + id + " name:" + name + " text:" + text);

        layer.open({
            type: 2,
            title: '修改日记',
            maxmin: true,
            shadeClose: true, //点击遮罩关闭层
            area: ['800px', '520px'],
            content: 'layerform/diaryUpdate.html?id=' + id + "&name=" + name + "&text=" + text
        });
    });
</script>
</html>
