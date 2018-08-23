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
            <button id="diary-delete" class="row">
                删除所选
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
                    <c:forEach items="${sessionScope.diaryList}" var="diary">
                        <tr>
                            <td><input type="checkbox" name="checkAll" title="选项"/></td>
                            <td class="diary-id">${diary.diaryId}</td>
                            <td class="diary-name">${diary.diaryName}</td>
                            <td class="diary-text">${diary.diaryText}</td>
                            <td>${diary.diaryDate}</td>
                            <td>
                                <button name="diary-delete">
                                    删除
                                </button>
                                <button name="diary-update">
                                    修改
                                </button>
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
</html>
