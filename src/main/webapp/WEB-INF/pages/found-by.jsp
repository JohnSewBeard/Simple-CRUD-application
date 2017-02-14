<?xml version="1.0" encoding="UTF-8" ?>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Search results</title>
</head>
<body>
<h1>Search results</h1>
<p>${message}</p>

<c:if test="${success}">
    <table border="1px" cellpadding="0" cellspacing="0" >
        <thead>
        <tr>
            <th width="10%">id</th>
            <th width="15%">name</th>
            <th width="10%">age</th>
            <th width="10%">isAdmin</th>
            <th width="15%">createdDate</th>
            <th width="10%">actions</th>
        </tr>
        </thead>
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.isAdmin}</td>
            <td>${user.createdDate}</td>
            <td>
                <a href="${pageContext.request.contextPath}/user/edit/${user.id}">Edit</a><br/>
                <a href="${pageContext.request.contextPath}/user/delete/${user.id}">Delete</a><br/>
            </td>
        </tr>
    </table>
</c:if>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>

</body>
</html>
