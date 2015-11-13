<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<head>
    <title>Customer Registration</title>
</head>
<style>

 body {
    background-color: black;
	}

    .error {
        color: #ff0000;
    }

    .errorblock {
        color: #000;
        background-color: #ffEEEE;
        border: 3px solid #ff0000;
        padding: 8px;
        margin: 16px;
    }
     table
    {
    
    color: black;
    border-radius: 15px; 
    margin-top: 100px;
   
    }
  
  .table
  {
  text-align: center;
    background-color: lightgray;
     width: 40%;
     text-align: center;
     margin-left: 30%;
     border-radius:15px;
    padding-bottom: 20px; 
/*      padding-top: 20px; */
  }
  
  td{
  text-align:  center;
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
<body>
<div class="table">

    <table  align="center" >
  					<tr>
       			<th >Showtime</th>
                <td>
                    ${date.getShowtime() }
                </td>
            </tr>
           		<tr>
       			<th >Movie</th>
                <td>
                    ${date.getMovie().getName() }
                </td>
            </tr>
            
           		<tr>
       			<th >Username</th>
                <td>
                    ${user.getUsername() }
                </td>
                
                    <c:forEach items="${date.movie.seats}" var="seat" varStatus="status">
                   
                    </tr>
            	<tr>
       			<th >seat name </th>
                <td>
                    ${seat.getName()}
                </td>
            </tr>
                   </c:forEach>
            </tr>
            	<tr>
       			<th >Total price</th>
                <td>
                    ${total}
                </td>
            </tr>
    </table>
    </div>
</div>
<p>&nbsp;</p>
    <form 
 method="post" action="/MoviesBooking/auth/logout">
   
<input type="submit"  class = "btn-custom" value="Logout"/>

</form>


</body>

</html>