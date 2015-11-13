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
    <tr><td colspan="2"> <h1>Add Movie </h1></td></tr>
         <form:form  method="post" action="/MoviesBooking/movie/addValidMovie" commandName = "movie" enctype="multipart/form-data">
            <form:hidden path="id"/>
            <tr>
                <th scope="row"><form:label path="name">Name Movie: </form:label></th>
                <td>
                    <label>
                        <form:input path="name" />
                    </label>
                </td>
                <td>
                    <form:errors path="name" cssClass="error"/>
                </td>
            </tr>
            
            <tr>
                <th scope="row"><form:label path="duration">duration: </form:label></th>
                <td>
                    <label>
                        <form:input path="duration" />
                    </label>
                </td>
                <td>
                    <form:errors path="duration" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <th scope="row"><form:label path="releaseDate">releaseDate</form:label></th>
                <td>
                    <label>
                        <form:input path="releaseDate"/>
                    </label>
                </td>
                <td>
                    <form:errors path="releaseDate" cssClass="error"/>
                </td>
            </tr>
      <tr>
                <th scope="row"><form:label path="Genres">Genres: </form:label></th>
                <td>
                    <label>
                        <form:input path="Genres" />
                    </label>
                </td>
                <td>
                    <form:errors path="Genres" cssClass="error"/>
                </td>
            </tr>


				      <tr>
                <th scope="row"><form:label path="director">Genres: </form:label></th>
                <td>
                    <label>
                        <form:input path="director" />
                    </label>
                </td>
                <td>
                    <form:errors path="director" cssClass="error"/>
                </td>
            </tr>

			  <tr>
                <th scope="row"><form:label path="antor">antor: </form:label></th>
                <td>
                    <label>
                        <form:input path="antor" />
                    </label>
                </td>
                <td>
                    <form:errors path="antor" cssClass="error"/>
                </td>
            </tr>
			  <tr>
                <th scope="row"><form:label path="synopsis">synopsis: </form:label></th>
                <td>
                    <label>
                        <form:input path="synopsis" />
                    </label>
                </td>
                <td>
                    <form:errors path="synopsis" cssClass="error"/>
                </td>
            </tr>
            
            
            <tr>
                <th scope="row"><form:label path="image">images</form:label></th>
                <td>
                    <label>
                        <input type="file" name="file" id="file"/>
                    </label>
                </td>
                <td>
                    <form:errors path="image" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Add Movie"/>
                </td>
            </tr>

        </form:form>
    </table>
    </div>
</div>
<p>&nbsp;</p>
</body>

</html>