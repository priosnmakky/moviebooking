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
<form  method="post" action="/MoviesBooking/date/find">
    <input type="text" name="keyword" value="">
    <input type="submit" value="find"/>
</form>
<form  method="post" action="/MoviesBooking/date/addDate">
   
    <input type="submit" value="addDate"/>
</form>

<table border="1" cellspacing="0" cellpadding="0">
    <thead>
    <td width="213" valign="top"><p><strong>ID</strong></p></td>
    <td width="213" valign="top"><p><strong>Name movie</strong></p></td>
    <td width="213" valign="top"><p><strong>Duration</strong></p></td>
   
    </thead>
    <c:forEach items="${date}" var="date" varStatus="status">
        <tr>
            <td width="213" valign="top"><p><strong>${date.getId()}</strong></p></td>
            <td width="213" valign="top"><p><strong>${date.getShowTime()}</strong></p></td>
            <td width="213" valign="top"><p><strong>${date.getEndTime()}</strong></p></td>
            <td width="213" valign="top"><p><strong>${date.getReleaseDate()}</strong></p></td>
            
            <c:choose>
<c:when test="${sessionScope.userSession.role ==1}">
    
</c:when>
<c:otherwise>
      <td width="213" valign="top"><p><strong><a href="/MoviesBooking/movie/update/${movie.getId()}">Update</a> </strong></p></td>
		<td width="213" valign="top"><p><strong><a href="/MoviesBooking/movie/delete/${movie.getId()}">Delete</a> </strong></p></td>
</c:otherwise>
</c:choose>
            <td width="213" valign="top"><p><strong><a href="/movie/select?id=${movie.getId()}">ADD Date</a> </strong></p></td>
            <td width="213" valign="top"><img src="image/${movie.image.id}"></td>
        </tr>
    </c:forEach>
</table>
    </form>
  <form method="post" action="/MoviesBooking/auth/logout">
   
<input type="submit"  class = "btn-custom" value="Logout"/>

</form>
</body>
</html>