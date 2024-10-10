<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Medical Form</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/book-form.css' />">
</head>
<body>
    <div class="login-container">
        <h2><i class="fas fa-laptop-code"></i>Medical Form</h2>
      <form action="process-medical-form" method="post">
	    
	    <label for="userName">Medicine Name:</label>
	    <input type="text" id="MedicineName" name="MedicineName">  
	    
	    <label for="description">Quantity:</label>
	    <input type="text" id="quantity" name="quantity">
	    
	     <label for="description">Description:</label>
	    <textarea id="description" name="description"></textarea>
	    
	    <input type="submit" value="Submit">
	</form>
    </div>
</body>
</html>