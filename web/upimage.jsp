<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>

<%@include file="include/header.jsp" %>
<%@include file="include/top.jsp" %>

<%-- 上传照片 --%>

<div class="container">
    <div class="table-responsive">
        <h2>编辑照片描述</h2>
        <form method="post" id="editForm" action="service/UpImg" enctype="multipart/form-data">
            <div class="form-group">
                <textarea  rows="1" class="form-control" name="imagename"
                          id="name">name...</textarea>
            </div>
            <div class="form-group">
                <textarea  rows="3" class="form-control" name="imagedescription"
                          id="description">description...</textarea>
            </div>
            <div class="form-group">
                <input type="file" class="form-control" name="image"
                          id="image">
            </div>
            <input type="hidden" name="action" value="UpImg">
            <button type="submit" class="btn btn-primary btn-md btn-block">提交</button>
        </form>
    </div>
</div>


<%@include file="include/footer.jsp" %>