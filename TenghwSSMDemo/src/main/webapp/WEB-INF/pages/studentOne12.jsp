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
<html>
<head>
    <title>student</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
    <style>
        #table1{
            border: 1px solid purple;
        }
        tr,th{
            border: 1px solid blue;
        }
    </style>
<%--    <c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>--%>
<%--    <script type="text/javascript" src="${path}/scripts/boot.js"></script>--%>

   <script type="text/javascript"  src="${pageContext.request.contextPath}/scripts/boot.js"></script>
<%--<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-3.2.0.js"></script>--%>
</head>
<body>
<%--<ul class="pagination">--%>
<%--    <li>--%>
<%--        <a href="${pageContext.request.contextPath}/test/getAll?page=2&pageInfo.pageSize=3" aria-label="Previous">首页</a>--%>
<%--        ${pageInfo}--%>
<%--    </li>--%>
<%--    <li><a href="${pageContext.request.contextPath}/test/getAll?page=${pageInfo.prePage}&${pageInfo.pageSize}">上一页</a></li>--%>

<%--    <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum">--%>
<%--        <li><a href="${pageContext.request.contextPath}/test/getAll?page=${pageNum}&${pageInfo.pageSize}">${pageNum}</a></li>--%>
<%--    </c:forEach>--%>

<%--    <li><a href="${pageContext.request.contextPath}/test/getAll?page=${pageInfo.nextPage}&${pageInfo.pageSize}">下一页</a></li>--%>
<%--    <li>--%>
<%--        <a href="${pageContext.request.contextPath}/test/getAll?page=${pageInfo.pages}&${pageInfo.pageSize}" aria-label="Next">尾页</a>--%>
<%--    </li>--%>
<%--</ul>--%>

<%--<ul class="pagination">--%>
<%--    <li>--%>
<%--        <a href="${pageContext.request.contextPath}/test/getAll?page=1&pageInfo.pageSize=3" aria-label="Previous">首页</a>--%>

<%--    </li>--%>
<%--    <li><a href="${pageContext.request.contextPath}/test/getAll?page=2&pageInfo.pageSize=3">第二页</a></li>--%>


<%--    <li><a href="${pageContext.request.contextPath}/test/getAll?page=3&pageInfo.pageSize=3">第三页</a></li>--%>


<%--    <li><a href="${pageContext.request.contextPath}/test/getAll?page=4&pageInfo.pageSize=3">最后一页</a></li>--%>

<%--</ul>--%>


<%--    <table id="table1">--%>
<%--        <c:forEach items="${studentAll}" var="list">--%>
<%--            <tr>--%>
<%--                <th> <c:out value="${list}"/></th>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>




<div id="datagrid1" class="mini-datagrid" style="width:100%;height:250px;"
     url="${pageContext.request.contextPath}/test/getAll"
     idField="id" allowResize="true"
     sizeList="[20,30,50,100]" pageSize="20"
     showHeader="true" title="表格面板"
     onmouseup="return datagrid1_onmouseup()">
    <div property="columns">
        <div type="indexcolumn" ></div>
        <div field="ID" width="120" headerAlign="center" allowSort="true">id编号</div>
        <div field="NAME" width="120" headerAlign="center" allowSort="true">姓名</div>
        <div field="ADDRESS" width="100" renderer="onGenderRenderer" align="center" headerAlign="center">地址</div>
        <div field="CLASSID" numberFormat="¥#,0.00" align="right" width="100" allowSort="true">班级</div>
    </div>
</div>

<script type="text/javascript" >
    mini.parse();
    var grid=mini.get("datagrid1");
    mini.alert("ffgg");
    grid.load();
    function datagrid1_onmouseup() {

    }
</script>
</body>
</html>
