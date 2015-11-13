<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title></title>
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
    width: 400px;
    height: auto;
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

	.pic-size{
		width: 300px;
		height: 300px;
		margin:0 auto;
	}
    
    </style>
    
</head>
<body>
<h1>The Movie List</h1>


     <c:choose>
<c:when test="${user.getRole() ==1}">
<form  method="post" action="/MoviesBooking/movie/addMovie">
<input type="submit" value="addMovie"/>
</form>
</c:when>
<c:otherwise>
      
</c:otherwise>
</c:choose>



<h1></h1>
 <c:forEach items="${movie}" var="movie" varStatus="status">
<div class="city">
	<div class="pic-size">
		<img src="/MoviesBooking/movie/image/${movie.image.id}"/>
	</div>
 <h2>Name : </h2> ${movie.getName()}<br>
  <h2>Duration : </h2> ${movie.getDuration()}<br>
  <h2>Release Date </h2> ${movie.getReleaseDate()}<br>
  <h2>Genres : </h2> ${movie.getGenres()}<br>
  <h2>Director : </h2> ${movie.getDirector()}<br>
  <h2>Cast : </h2> ${movie.getAntor()}<br>
  <h2>Synopsis : </h2> ${movie.getSynopsis()}<br>
	
      <c:choose>
<c:when test="${user.getRole() ==1}">
   <a href="/MoviesBooking/movie/update/${movie.getId()}">Update</a>
	<a href="/MoviesBooking/movie/delete/${movie.getId()}">Delete</a> 
	<td width="213" valign="top"><p><strong><a href="/MoviesBooking/seat/list/">AddSaet</a> 
          
          
</c:when>
<c:otherwise>
      <a href="/MoviesBooking/booking/select/${movie.getId()}">booking</a> 
</c:otherwise>
</c:choose>
   
</div>

 </c:forEach>



   
</body>
</html>