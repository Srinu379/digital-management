<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Medical Services Portal</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value='/resources/css/login.css' />">
    <script type="text/javascript">
        function validate() {
            let email = document.getElementById("email").value.trim();
            let passWord = document.getElementById("passWord").value;
            let emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

            if(!emailRegex.test(email)) 
            {
                alert("Please enter a valid email address");
                return false;
            }
            else if(passWord.length < 8) 
            {
                alert("Your password should contain atleast 8 characters");
                return false;
            }
            return true;
        }
    </script>
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

        <form:form action="process-login?user=user" modelAttribute="userLogin" onsubmit="return validate()">
            <div class="form-group">
                <form:input path="email" id="email" class="form-input" placeholder="Email"/>
                <form:errors path="email" cssClass="error"/>
            </div>
            
            <div class="form-group">
                <form:password path="passWord" id="passWord" class="form-input" placeholder="Password"/>
                <form:errors path="passWord" cssClass="error"/>
            </div>

            <c:if test="${not empty errorMessage}">
                <div class="error-message">${errorMessage}</div>
            </c:if>

            <button type="submit" class="login-btn">Login</button>
            
            <div class="forgot-password">
                <a href="<c:url value='forgot-password' />">Forgot Password?</a>
            </div>
        </form:form>
    </div>
</body>
</html>