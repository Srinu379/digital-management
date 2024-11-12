<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>College Medical Center - Welcome</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value='/resources/css/landing-page.css' />">
</head>
<body>
    <div class="container">
        <nav>
            <img src="<c:url value='/resources/images/klh-logo.jpg' />" alt="KLH Logo" class="klh-logo">
            <div class="logo">Medical Center</div>
            <div class="nav-links">
                <a href="<c:url value='about-us' />">About Us</a>
                <a href="<c:url value='contact-us' />">Contact</a>
            </div>
        </nav>

        <div class="main-content">
            <div class="text-content">
                <h1>Welcome to<br><span class="highlight">Medical</span> Center</h1>
                <p>Your trusted healthcare partner. Access quality medical services and professional care all in one place.</p>
                <div class="auth-buttons">
                    <a href="<c:url value='register' />" class="btn btn-primary">Register</a>
                    <a href="<c:url value='login' />" class="btn btn-secondary">Staff Login</a>
                </div>
            </div>

            <div class="image-section">
                <div class="circle-bg">
                    <img src="<c:url value='/resources/images/doctor.jpg' />" 
                         alt="Professional Medical Staff" 
                         class="doctor-image">
                </div>
            </div>
        </div>
    </div>
</body>
</html>