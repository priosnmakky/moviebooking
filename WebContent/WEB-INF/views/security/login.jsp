<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <style type="text/css">
    body {
    background-color: black;
	}
    #login-error{
    color: red;
    }
    td
    {
    text-align: center;
    }
    table
    {
    text-align: center;
    background-color: lightgray;
    color: black;
    border-radius: 15px; 
    margin-top: 100px;
    width: 50%;
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


   <form action="/MoviesBooking/j_spring_security_check" method="post" >
<table align="center" >
<tr>
    <td><h1>Login</h1></td>
    </tr>
    <tr>
    <td> 
    <p>
	<label for="j_username">Username</label>
     <input id="j_username" name="j_username" type="text" />
    </p>
    </td>
    </tr>
    <tr>
    <td> 
    <p>
	  <label for="j_password">Password</label>
      <input id="j_password" name="j_password" type="password" />
    </p>
    </td>
    </tr>
    <tr>
    <td>
    <div id="login-error">${error}</div>
    </td>
    </tr>
    <tr>
	<td>
	
	<input  type="submit" class ="btn-custom" value="Login"/>
	</td>
	</tr>
	<tr>
	<td>
	<h1><a href="/MoviesBooking/Customer/register">Register</a></h1>
	</td>
</tr>
</table>
</form>


</body>
</html>