<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ZARD
  Date: 2020/5/19 0019
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>student</title>
    <style>
        #table1{
            border: 1px solid purple;
        }
        tr,th{
            border: 1px solid blue;
        }
    </style>
</head>
<body>
<table id="table1">
    <c:forEach items="${studentList}" var="list">
        <tr>
    <c:forEach items="${list}" var="map">

        <th> <c:out value="${map.key}"/></th>
        <th><c:out value="${map.value}"/></th>

    </c:forEach>
        </tr>
</c:forEach>
</table>
</body>
</html>
