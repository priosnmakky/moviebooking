<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Lecturer Registration</title>
</head>
<style>
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
</style>
<body>
<p align="center">Register Lecturer </p>
<div align="center">
    <table width="200" border="1">
        <form:form  method="post" action="/user/addValidUser" commandName="user" enctype="multipart/form-data">
            <form:hidden path="id"/>
            <tr>
                <th scope="row"><form:label path="username">Name</form:label></th>
                <td>
                    <label>
                        <form:input path="username" />
                    </label>
                </td>
                <td>
                    <form:errors path="username" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <th scope="row"><form:label path="password">Salary</form:label></th>
                <td>
                    <label>
                        <form:input path="password"/>
                    </label>
                </td>
                <td>
                    <form:errors path="password" cssClass="error"/>
                </td>
            </tr>
                <tr>
                <th scope="row"><form:label path="lname">Salary</form:label></th>
                <td>
                    <label>
                        <form:input path="lname"/>
                    </label>
                </td>
                <td>
                    <form:errors path="lname" cssClass="error"/>
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
                    <input type="submit" value="register"/>
                </td>
            </tr>
        </form:form>
    </table>
</div>
<p>&nbsp;</p>
</body>

</html>