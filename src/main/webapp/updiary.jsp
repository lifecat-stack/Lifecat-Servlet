<%--
  Created by IntelliJ IDEA.
  User: 59682
  Date: 2018/4/20
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>
<%@include file="include/header.jsp"%>
<%@include file="include/top.jsp"%>

<%-- 上传照片 --%>

<div class="container">
	<div class="table-responsive">
		<h2>书写成长寄语</h2>
		<form method="post" id="editForm" action="diary_upload.do">
			<div class="form-group">
				<textarea class="form-control" rows="1"  name="diaryName"
					id="diaryname">name...</textarea>
			</div>
			<div class="form-group">
				<textarea class="form-control" rows="10"  name="diaryText"
					id="diarydescription">description...</textarea>
			</div>
			<button type="submit" class="btn btn-primary btn-md btn-block">提交</button>
		</form>
	</div>
</div>


<%@include file="include/footer.jsp"%>
