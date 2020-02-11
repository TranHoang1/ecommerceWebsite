<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><dec:title default="Trang chủ" /></title>

<link rel="stylesheet"
	href="<c:url value='/template/web/bootstrap/css/bootstrap.min.css'/>"
	type="text/css" media="all" />
<link href="<c:url value='/template/web/css/style.css'/>"
	rel="stylesheet" type="text/css" media="all" />

</head>
<body>
	<%@include file="/common/web/header.jsp"%>

	<div class="container">
		<dec:body />
	</div>

	<%@include file="/common/web/footer.jsp"%>
	<script type="text/javascript"
		src="<c:url value ='/template/web/jquery/jquery.min.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value ='/template/web/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
</body>
</html>