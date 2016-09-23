<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    <c:if test="${empty sessionInfo}">
        请登录
    </c:if>
    <c:if test="${!empty sessionInfo}">
        <a href="/question">问卷管理</a>
    </c:if>

</body>
</html>
