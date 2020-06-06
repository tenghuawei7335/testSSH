<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<script type="text/javascript"  src="${pageContext.request.contextPath}/scripts/boot.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-3.2.0.js"></script>
<body>
<h2>Hello World!</h2>

<form action="/test/getName" method="get">
    <input type="text" name="id"/><br>
    <input type="submit" value="查询"/><br>
</form>

<form action="/test/getList" method="post">
    <input type="submit" value="提交"/><br>
</form>
<form action="/test/insertInto" method="post">
    <input type="text" name="id" placeholder="请输入id"/><br>
    <input type="text" name="name" placeholder="请输入name"/><br>
    <input type="text" name="address" placeholder="请输入地址"/><br>
    <input type="text" name="classid" placeholder="请输入纯数字编号"/><br>
    <input type="submit" value="新增"/><br>
</form>

<form action="/test/getAll" method="get">
    <input type="submit" value="所有人员信息"/><br>
</form>
<hr>

<form action="" method="post">
    <input  class="mini-textbox" name="id1" emptyText="请输入学生id"/><br>
    <input  class="mini-textbox"  name="name1" emptyText="请输入学生name"/><br>
    <input class="mini-textbox" name="address1" emptyText="请输入学生地址"/><br>
    <input  class="mini-textbox" name="classid1" emptyText="请输入学生编号"/><br><br>
    <a class="mini-button" onclick="add3">新增JSON</a><br>
</form>
<hr>

<form action="" id="formOne">
<input  class="mini-textbox" name="id" emptyText="请输入学生id"/><br>
<input  class="mini-textbox"  name="name" emptyText="请输入学生name"/><br>
<input class="mini-textbox" name="address" emptyText="请输入学生地址"/><br>
<input  class="mini-textbox" name="classid" emptyText="请输入学生编号"/><br><br>
<a class="mini-button" onclick="add2">serialize</a><br>
</form>
<hr>
<hr>
<form action="/redis/redis1" method="get">
    <input  type="text" name="key"/><br>
    <input  type="text"  name="value"/><br>
    <input  type="text" name="DBindex"/><br>
    <input type="submit" value="新增redis"/><br>
</form>
<hr>
<hr>

<form action="/redis/redis2" method="get">
    <input  type="text" name="key"/><br>
    <input  type="text" name="DBindex"/><br>
    <input type="submit" value="查询Key_value"/>
</form>
查询结果：${keyvalue}
<hr>
<hr>

<%String[] str={"1","2","3","4","5","6","7"};
 request.setAttribute("str",str);
%>
<c:forEach items="${requestScope.get('str')}" var="s"  varStatus="status">
<%--    原集合{"1","2","3","4","5","6","7"}，子集合{"2","4","6"};--%>
        <c:out value="index属性：${status.index}"></c:out>&nbsp;
        <c:out value="count属性：${status.count}"></c:out>&nbsp;
        <c:out value="first属性：${status.first }"></c:out>&nbsp;
        <c:out value="last属性：${status.last }"></c:out><br>
</c:forEach>

<%
    Date date = new Date();
    pageContext.setAttribute("d", date);
%>
<fmt:formatDate value="${d}" pattern="yyyy-MM-dd HH:mm:ss"/>

<%
    double d1 = 3.5;
    double d2 = 4.4;
    pageContext.setAttribute("d1", d1);
    pageContext.setAttribute("d2", d2);
%>
<hr>
<fmt:formatNumber value="${d1}" pattern="0.00"/><br/>
<fmt:formatNumber value="${d2}" pattern="#.##"/>
<hr>
<c:set var="str" value="blue,red,green|yellow|pink,black|white"/>
<c:forTokens var="tok" items="${pageScope.str}" begin="2" end="6"  step="2"  delims="|,">
    Color = <b><c:out value="${tok}"/></b><br>
</c:forTokens>
<jsp:useBean id="stu" class="com.company.project.pojo.Student"/>
<jsp:setProperty name="stu" property="address" value="苏州"/>
${pageScope.stu.address}<%--苏州,可简写成stu.address--%>

<script type="text/javascript">
    mini.parse();
    function add() {
        var id2=  mini.getbyName("id1").getValue().trim();
        var name2=  mini.getbyName("name1").getValue().trim();
        var address2=  mini.getbyName("address1").getValue().trim();
        var classid2=  mini.getbyName("classid1").getValue().trim();

         //data1={"id":id2,"name":name2,"address":address2,"classid":classid2};
        data1={id:id2,name:name2,address:address2,classid:classid2};//与上面等效
        $.ajax({
            url:"${pageContext.request.contextPath}/test/insertJSON",
            type:"POST",
            async:false,
           contentType:"application/json;charset=utf-8",
            data:JSON.stringify(data1),
            dataType:"text",
            success:function(result){
                if(JSON.parse(result).name){//表示该字段是否存在
                    mini.alert("新增成功！");
                }else {mini.alert("异常");}
            }, error: function(jqXHR){
                mini.alert("新增失败,发生错误:" + jqXHR.status);
            }
        });
    }

    function add3() {
        var id2=  mini.getbyName("id1").getValue().trim();
        var name2=  mini.getbyName("name1").getValue().trim();
        var address2=  mini.getbyName("address1").getValue().trim();
        var classid2=  mini.getbyName("classid1").getValue().trim();
        //data1={"id2":id2,"name2":name2,"address2":address2,"classid2":classid2};
        data1={id2:id2,name2:name2,address2:address2,classid2:classid2};//与上面等效
        alert("add3");
        $.ajax({
            url:"${pageContext.request.contextPath}/test/insertInto1",
            type:"POST",
            async:false,
            //contentType:"application/json;charset=utf-8",
            data:data1,
            dataType:"text",
            success:function(result){
                if(JSON.parse(result).name){//表示该字段是否存在
                    mini.alert("新增成功！");
                }else {mini.alert("异常");}
            }, error: function(jqXHR){
                mini.alert("新增失败,发生错误:" + jqXHR.status);
            }
        });
    }

    function add1() {
        var id2=  mini.getbyName("id1").getValue().trim();
        var name2=  mini.getbyName("name1").getValue().trim();
        var address2=  mini.getbyName("address1").getValue().trim();
        var classid2=  mini.getbyName("classid1").getValue().trim();

        //data1={"id":id2,"name":name2,"address":address2,"classid":classid2};
        data1={id:id2,name:name2,address:address2,classid:classid2};
        $.ajax({
            url:"${pageContext.request.contextPath}/test/insertJSON1",
            type:"POST",
            async:false,
            contentType:"application/json;charset=utf-8",
            data:JSON.stringify(data1),
            dataType:"text",
            success:function(result){
                if(JSON.parse(result).name){//表示该字段是否存在
                    mini.alert("新增成功！");
                }else {mini.alert("异常");}
            }, error: function(jqXHR){
                mini.alert("新增失败,发生错误:" + jqXHR.status);
            }
        });
    }


    function add2() {
     var temp= $("#formOne").serialize();
        $.ajax({
            url:"${pageContext.request.contextPath}/test/insertJSON2",
            type:"POST",
            async:false,
            data:temp,
            dataType:"text",
            success:function(result){
                if(JSON.parse(result).name){//表示该字段是否存在
                    mini.alert("新增成功！");
                }else {mini.alert("异常");}
            }, error: function(jqXHR){
                mini.alert("新增失败,发生错误:" + jqXHR.status);
            }
        });
    }

</script>
</body>
</html>
