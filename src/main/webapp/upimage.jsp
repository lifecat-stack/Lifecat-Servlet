<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>

<%@include file="include/header.jsp" %>
<%@include file="include/top.jsp" %>
<script>
    function showPreview(obj) {
        var str=obj.value;
        document.getElementById(upimage).innerHTML="<img src='"+str+"'/>";
    }

</script>

<%-- 上传照片 --%>

<div class="container">
    <div class="table-responsive">
        <h2>编辑照片描述</h2>
        <form method="post" id="editForm" action="upimage.do" enctype="multipart/form-data">
            <div class="form-group">
                <input type="file" class="form-control" name="image"
                       id="upimage" onchange="showPreview()">
            </div>
            <button type="submit" class="btn btn-primary btn-md btn-block">提交</button>
        </form>

        <div>
            <img src="http://localhost:8080/lifecatweb/getimg.do" alt=""/>
        </div>
    </div>
</div>


<%@include file="include/footer.jsp" %>