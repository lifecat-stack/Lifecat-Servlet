<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<head>
    <!--编码信息-->
    <meta http-equiv="content-type" content="text/html;charset=UTF-8"/>
    <!--引用库：bootstrap-->
    <script src="../../js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../../css/bootstrap/3.3.6/bootstrap.min.css">
    <!--引用库：jQuery-->
    <script src="../../js/jquery/2.0.0/jquery.min.js"></script>
</head>

<body>

<!-- 图片的展示栏 -->
<div class="container">
    <div class="table-responsive" status="image-show">
        <!-- 相册栏 -->
        <div class="row">
            <div class="row">
                <div class="col-md-1">
                    <form method="get" action="image_list_query.do">
                        <button type="submit">
                            刷新
                        </button>
                    </form>
                    <a href="../old_page/upimage.html">
                        <button class="row">
                            上传图片
                        </button>
                    </a>
                    <button class="row">删除所选</button>
                    <button class="row">删除全部</button>
                </div>
                <div class="col-md-11">
                    <span>
                        <h2>
                            <a href="imageshow2.jsp">
                                智能图像分类
                            </a>
                        </h2>
                    </span>

                    <table>
                        <thead class="row">
                        <th class="col-lg-1">√</th>
                        <th class="col-lg-1">图片序号</th>
                        <th class="col-lg-2">图片标题</th>
                        <th class="col-lg-2">修改时间</th>
                        <th class="col-lg-2">图片类别</th>
                        <th class="col-lg-4">图片展示</th>
                        </thead>
                        <tbody>
                        <c:forEach items="${sessionScope.imageList}" var="image">
                            <tr>
                                <td>
                                    <input type="checkbox">
                                </td>
                                <td>
                                        ${image.imageId}
                                </td>
                                <td>
                                        ${image.imageText}
                                </td>
                                <td>
                                        ${image.imageDate}
                                </td>
                                <td>
                                        ${image.imageClassId}
                                </td>
                                <td>
                                    <img src="${image.imagePath}" height="200" width="200" style="margin-top: 2px;"/>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>