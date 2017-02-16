<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Home page</title>
</head>
<body>
<h1>Home page</h1>
<p>${message}</p>

<form:form method="POST" action="${pageContext.request.contextPath}/user/search" >
    <table>
        <tr>
            <td>Enter user name:</td>
            <td><input type = "text" name="name" /></td>
            <td><input type="submit" value="Search" /><a href="${pageContext.request.contextPath}/user/search"></a></td>
        </tr>
    </table>
</form:form>
<a href="${pageContext.request.contextPath}/user/add">Add new user</a><br/>
<a href="${pageContext.request.contextPath}/user/list">User list</a><br/>

</body>
</html>
