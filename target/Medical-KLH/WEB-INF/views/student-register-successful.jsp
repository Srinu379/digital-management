<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Success</title>
    <link rel="stylesheet" type="text/css" href="styles/success.css">
</head>
<body>
    <div class="container">
        <h1>Student Registered Successfully!</h1>
        <a href="<c:url value='e-homepage' />" class="home-link">Go Back to Home</a>
    </div>
</body>
</html>