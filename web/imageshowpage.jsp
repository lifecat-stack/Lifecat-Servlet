<%@ page import="com.wang.bean.Image" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wang.model.GetImgModel" %>
<%@ page import="static com.wang.util.HOST.ip" %>
<%@ page import="java.util.logging.Logger" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<%@include file="include/header.jsp" %>
<%@include file="include/top.jsp" %>

<!-- 图片的展示栏 -->
<div class="container">
    <div class="table-responsive" status="image-show">
        <!-- 相册栏 -->
        <div class="row">
            <div class="row">
                <div class="col-md-1">
                </div>
                <div class="col-md-11">
                    <h2>成长相册:</h2>

                    <%
                        //获取图片在服务器上的路径
                        String[] paths = new GetImgModel().getImages();
                    %>
                    <table>
                        <%
                            /* 倒叙循环打印图片img
                            *  倒叙:最新上传的图片最前展示
                            *  日志:image_path打印图片链接
                            */
                            for (int i = paths.length - 1; i > 3; i -= 4) {
                                Logger logger=Logger.getLogger("image_path");
                                logger.info(paths[i]);
                                logger.info(paths[i-1]);
                                logger.info(paths[i-2]);
                                logger.info(paths[i-3]);
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
            </div>
        </div>
    </div>
</div>


<%@include file="include/footer.jsp" %>
