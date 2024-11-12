<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password - Medical Services Portal</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value='/resources/css/forgot-password.css' />">
</head>
<body>
    <div class="container">
        <!-- Medical Icons Header -->
        <div class="medical-header">
            <div class="medical-icons">
                <div class="clipboard">
                    <div class="clipboard-content"></div>
                    <div class="clipboard-content"></div>
                    <div class="clipboard-content"></div>
                </div>
                <div class="money"></div>
                <div class="calculator"></div>
                <div class="pills">
                    <div class="pill"></div>
                    <div class="pill" style="background: #00D084;"></div>
                </div>
            </div>
        </div>

        <form action="process-forgot-password">
            <div class="form-group">
                <input type="email" 
                       id="email" 
                       name="email" 
                       class="form-input" 
                       required 
                       placeholder="Enter your email">
                
                <c:if test="${not empty userDoesNotExist}">
                    <div class="error-message">${userDoesNotExist}</div>
                </c:if>
            </div>
            
            <div class="form-group">
                <input type="password" 
                       id="password" 
                       name="password" 
                       class="form-input" 
                       required 
                       placeholder="Enter your new password">
            </div>

            <button type="submit" class="login-btn">Reset Password</button>
            
            <div class="forgot-password">
                <a href="<c:url value='/login' />">Back to Login</a>
            </div>
        </form>
    </div>
</body>
</html>