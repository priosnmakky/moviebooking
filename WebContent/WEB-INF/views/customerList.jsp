<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title></title>
</head>
<body>
<h1>The student list</h1>
<table border="1" cellspacing="0" cellpadding="0">
    <thead>
    <td width="213" valign="top"><p><strong>no.</strong></p></td>
    <td width="213" valign="top"><p><strong>name</strong></p></td>
    <td width="213" valign="top"><p><strong>student id</strong></p></td>
    <td width="213" valign="top"><p><strong>GPA</strong></p></td>
    </thead>
    <c:forEach items="${customer}" var="customer" varStatus="status">
        <tr>
            <td width="213" valign="top"><p><strong>${customer.getId()}</strong></p></td>
            <td width="213" valign="top"><p><strong>${customer.getUsername()}</strong></p></td>
            <td width="213" valign="top"><p><strong>${customer.getLname()}</strong></p></td>
            <td width="213" valign="top"><p><strong>${customer.getFname()}</strong></p></td>
            <td width="213" valign="top"><img src="image/${customer.image.id}"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>