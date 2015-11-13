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
</style>
<body>
<div class="table">

    <table  align="center" >
    <tr><td colspan="2"> <h1>Register Customer </h1></td></tr>
        <form:form  method="post" action="/MoviesBooking/seat/addValidSeat" commandName = "seat" >
            <form:hidden path="id"/>
            <tr>
                <th scope="row"><form:label path="name">Name Seat: </form:label></th>
                <td>
                    <label>
                        <form:input path="name" />
                    </label>
                </td>
                <td>
                    <form:errors path="name" cssClass="error"/>
                </td>
            </tr>
             <th scope="row"><form:label path="price">price: </form:label></th>
                <td>
                    <label>
                        <form:input path="price" />
                    </label>
                </td>
                <td>
                    <form:errors path="price" cssClass="error"/>
                </td>
            </tr>
            
            <tr>
                <td colspan="2">
                    <input type="submit" value="Add Seat"/>
                </td>
            </tr>
        </form:form>
    </table>
    </div>
</div>
<p>&nbsp;</p>
</body>

</html>