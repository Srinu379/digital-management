<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>College Medical Center - Welcome</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/landing-page.css' />">
</head>
<body>
    <div class="container">
        <header>
            <h1>College Medical Center</h1>
            <p>Your health, our priority</p>
        </header>

        <main>
            <section class="auth-options">
                <div class="auth-card">
                    <h2>New User</h2>
                    <p>Register for our online services.</p>
                    <a href="<c:url value='register' />" class="btn btn-secondary">Register</a>
                </div>

                <div class="auth-card">
                    <h2>Staff Login</h2>
                    <p>For authorized medical personnel only.</p>
                    <a href="<c:url value='login' />" class="btn btn-tertiary">Staff Portal</a>
                </div>
            </section>
        </main>
    </div>
</body>
</html>