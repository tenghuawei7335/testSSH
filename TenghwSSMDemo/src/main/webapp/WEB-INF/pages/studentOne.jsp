<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ZARD
  Date: 2020/5/19 0019
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript"  src="${pageContext.request.contextPath}/scripts/boot.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-3.2.0.js"></script>
<html>
<head>
    <title>student</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
</head>
<body>
<div align="center">
${pageInfo}
    <table width="200" border="1">
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>地址</th>
            <th>班级</th>
        </tr>
        <c:forEach items="${pageInfo.list}" var="student">
            <tr>
                <td><c:out value="${student.id}"/></td>
                <td><c:out value="${student.name}"/></td>
                <td><c:out value="${student.address}"/></td>
                <td><c:out value="${student.classid}"/></td>
            </tr">
        </c:forEach>
    </table>

    <a href="getAll?pageNum=${pageInfo.navigateFirstPage}&pageSize=4">第一页</a>
    <c:if test="${pageInfo.hasPreviousPage }">
        <a href="getAll?pageNum=${pageInfo.pageNum-1}&pageSize=4">上一页</a>
    </c:if>

    <c:if test="${pageInfo.hasNextPage }">
        <a href="getAll?pageNum=${pageInfo.pageNum+1}&pageSize=4">下一页</a>
    </c:if>

    <a href="getAll?pageNum=${pageInfo.navigateLastPage}&pageSize=4">最后一页</a>

    <p>当前 ${pageInfo.pageNum }页,总${pageInfo.pages }页,总 ${pageInfo.total } 条记录</p>

    <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum">
        <span><a href="${pageContext.request.contextPath}/test/getAll?pageNum=${pageNum}&pageSize=${pageInfo.pageSize}">${pageNum}</a><span>
            </c:forEach>
</div>
</body>
</html>
