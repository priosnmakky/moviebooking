<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

 <style>
    body {
    background-color: black;
	}
      table
    {
    
    color: black;
    border-radius: 15px; 
    margin-top: 100px;
    text-align: center;
    background-color: lightgray;
     width: 100%;
    }
    
    .city {
    float: left;
    margin: 5px;
    padding: 15px;
    width: 500px;
    height: 500px;
    background-color: lightgray;
    border: 1px solid black;
} 

 .btn-custom {
  background-color: hsl(14, 74%, 27%) !important;
  background-repeat: repeat-x;
  filter: progid:DXImageTransform.Microsoft.gradient(startColorstr="#e9896c", endColorstr="#772911");
  background-image: -khtml-gradient(linear, left top, left bottom, from(#e9896c), to(#772911));
  background-image: -moz-linear-gradient(top, #e9896c, #772911);
  background-image: -ms-linear-gradient(top, #e9896c, #772911);
  background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #e9896c), color-stop(100%, #772911));
  background-image: -webkit-linear-gradient(top, #e9896c, #772911);
  background-image: -o-linear-gradient(top, #e9896c, #772911);
  background-image: linear-gradient(#e9896c, #772911);
  border-color: #772911 #772911 hsl(14, 74%, 17%);
  color: #fff !important;
  text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.66);
  -webkit-font-smoothing: antialiased;
}
    
    </style>
    <title></title>
</head>
<body>
<h1>The Media list</h1>
<form  method="post" action="/media/findBykey">
    <input type="text" name="keyword" value="">
    <input type="submit" value="find"/>
</form>
<form  method="post" action="/MoviesBooking/seat/addSeat">
   
    <input type="submit" value="addseat"/>
</form>

< <style>
    body {
    background-color: black;
	}
      table
    {
    
    color: black;
    border-radius: 15px; 
    margin-top: 100px;
    text-align: center;
    background-color: lightgray;
     width: 100%;
    }
    
    .city {
    float: left;
    margin: 5px;
    padding: 15px;
    width: 500px;
    height: 500px;
    background-color: lightgray;
    border: 1px solid black;
} 

 .btn-custom {
  background-color: hsl(14, 74%, 27%) !important;
  background-repeat: repeat-x;
  filter: progid:DXImageTransform.Microsoft.gradient(startColorstr="#e9896c", endColorstr="#772911");
  background-image: -khtml-gradient(linear, left top, left bottom, from(#e9896c), to(#772911));
  background-image: -moz-linear-gradient(top, #e9896c, #772911);
  background-image: -ms-linear-gradient(top, #e9896c, #772911);
  background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #e9896c), color-stop(100%, #772911));
  background-image: -webkit-linear-gradient(top, #e9896c, #772911);
  background-image: -o-linear-gradient(top, #e9896c, #772911);
  background-image: linear-gradient(#e9896c, #772911);
  border-color: #772911 #772911 hsl(14, 74%, 17%);
  color: #fff !important;
  text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.66);
  -webkit-font-smoothing: antialiased;
}
    
    </style>
    </head>
<body>
  <div class="table">

    <table  align="center" >
        <thead>
    <td width="213" valign="top"><p><strong>ID</strong></p></td>
    <td width="213" valign="top"><p><strong>Name movie</strong></p></td>
    
    </thead>
    <c:forEach items="${seat}" var="seat" varStatus="status">
        <tr>
            <td width="213" valign="top"><p><strong>${seat.getId()}</strong></p></td>
            <td width="213" valign="top"><p><strong>${seat.getName()}</strong></p></td>
          	<td width="213" valign="top"><p><strong><a href="/MoviesBooking/seat/delete/${seat.getId()}">DELETE</a> </strong></p></td>
            <c:choose>
<c:when test="${sessionScope.userSession.role ==1}">
    
</c:when>
<c:otherwise>
     
   
</c:otherwise>
</c:choose>
            
        </tr>
     </c:forEach>
    
    
    </table>
    </div>
    
    <form 
 method="post" action="/MoviesBooking/auth/logout">
   
<input type="submit"  class = "btn-custom" value="Logout"/>

</form>

<form 
 method="post" action="/MoviesBooking/date/list">
   
<input type="submit"  class = "btn-custom" value="DateList"/>

</form>
</body>
</html>