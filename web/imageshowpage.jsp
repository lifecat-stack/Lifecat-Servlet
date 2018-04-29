<%@ page import="com.wang.bean.Image" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wang.model.GetImgModel" %>
<%@ page import="static com.wang.db.HOST.ip" %>
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
                    <%--获取图片链接--%>
                    <%
                        User user = (User) request.getSession().getAttribute("User");
                        int id = user.getId();
                        ArrayList<Image> images = null;
                        /* 若当期有用户登录 */
                        if (user != null && !user.getName().equals("admin")) {
                            GetImgModel model = new GetImgModel();
                            images = model.getImages(id);
                        }
                        /* 若无用户登录，添加3条默认图片 */
                        if (images == null) {
                            images = new ArrayList<>();
                            for (int i = 0; i < 3; i++) {
                                Image no_image = new Image();
                                no_image.setImagename("成长相册" + i);
                                no_image.setImagedescription("美好的午后，记录美好的时刻" + i);
                                no_image.setImagedate("2018-" + i);
                                no_image.setImagepath("http://"+ip+":8080/lifecatweb/upimage/image" + i + ".jpg");
                                images.add(no_image);
                            }
                        }
                    %>
                    <table>
                        <%
                            /* 循环打印图片信息 */
                            for (Image image : images) {
                        %>
                        <tr class="row">
                            <td class="col-md-3"></td>
                            <td class="col-md-3"><span><img src=<%=image.getImagepath()%>
                                                                    height="100" width="100"
                                                            style="margin-top: 20px;"/> </span>
                            </td>
                            <td class="col-md-6">
                                <span><%=image.getImagename() + ":"%></span>
                                <span><%=image.getImagedescription()%></span>
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
