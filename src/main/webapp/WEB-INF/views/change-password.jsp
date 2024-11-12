<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Change Password</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value='/resources/css/change-password.css' />">
</head>
<body>
    <div class="container">
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

        <form action="process-change-password" method="POST" style="margin-top: 40px;">
            <div class="form-group">
                <input type="text" id="email" name="email" class="form-input" placeholder="Email" required>
            </div>
            <div class="form-group">
                <input type="password" id="passWord" name="passWord" class="form-input" placeholder="Current Password" required>
            </div>
            <div class="form-group">
                <input type="password" id="newPassword" name="newPassword" class="form-input" placeholder="New Password" required>
            </div>
            <div class="form-group">
                <input type="password" id="confirmPassword" name="confirmPassword" class="form-input" placeholder="Confirm New Password" required>
            </div>
            <button type="submit" class="login-btn">Change Password</button>
            
            <div class="back-link">
                <a href="<c:url value='profile-page' />">Back to Dashboard</a>
            </div>
        </form>
    </div>
</body>
</html>