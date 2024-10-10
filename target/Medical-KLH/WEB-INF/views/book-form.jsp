<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Issue Form</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/book-form.css' />">
</head>
<body>
    <div class="login-container">
        <h2><i class="fas fa-laptop-code"></i> Student Medical Issue</h2>
      <form action="process-student-form" method="post">
	    
	    <label for="userName">Student Name:</label>
	    <input type="text" id="studentName" name="studentName">  
	    
	    <label for="rollNo">Roll No:</label>
	    <input type="text" id="rollNo" name="rollNo">  
	    
	    <label for="department">Department:</label>
	    <input type="text" id="department" name="department"> 
	    
	    <label for="department">Gender:</label>
	    <input type="text" id="gender" name="gender"> 
	    
	    <label for="description">Description:</label>
	    <textarea id="description" name="description"></textarea>
	    
	    <label for="medicine">Medicine:</label>
	    <input type="text" id="medicine" name="medicine">
	    
	    <input type="submit" value="Submit">
	</form>
    </div>
</body>
</html>