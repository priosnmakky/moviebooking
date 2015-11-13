<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title></title>
</head>
<body>
<h1>The Media list</h1>
<form  method="post" action="/media/findBykey">
    <input type="text" name="keyword" value="">
    <input type="submit" value="find"/>
</form>
<form  method="post" action="/MoviesBooking/theatre/addtheatre">
   
    <input type="submit" value="addBrach"/>
</form>

<table border="1" cellspacing="0" cellpadding="0">
    <thead>
    <td width="213" valign="top"><p><strong>ID</strong></p></td>

    <td width="213" valign="top"><p><strong>Number</strong></p></td>
   
    
    </thead>
    <c:forEach items="${theatre}" var="theatre" varStatus="status">
        <tr>
            <td width="213" valign="top"><p><strong>${theatre.getId()}</strong></p></td>
          
            <td width="213" valign="top"><p><strong>${theatre.getNumber()}</strong></p></td>
          
            <c:choose>
<c:when test="${sessionScope.userSession.role ==1}">
    
</c:when>
<c:otherwise>
      <td width="213" valign="top"><p><strong><a href="/MoviesBooking/theatre/update/${theatre.getId()}">Update</a> </strong></p></td>
		<td width="213" valign="top"><p><strong><a href="/MoviesBooking/theatre/delete/${theatre.getId()}">Delete</a> </strong></p></td>
		<td width="213" valign="top"><p><strong><a href="/MoviesBooking/theatre/select/${theatre.getId()}">select</a> </strong></p></td>
</c:otherwise>
</c:choose>
            <td width="213" valign="top"><p><strong><a href="/media/mediaDetail?id=${media.getId()}">ADD CART</a> </strong></p></td>
            <td width="213" valign="top"><img src="image/${movie.image.id}"></td>
        </tr>
    </c:forEach>
</table>
    </form>
</body>
</html>