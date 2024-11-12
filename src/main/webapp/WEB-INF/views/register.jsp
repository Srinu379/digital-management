<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register - Medical Services Portal</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value='/resources/css/login.css' />">
    
    <script type="text/javascript">
        function validate() {
            let email = document.getElementById("email").value.trim();
            let userName = document.getElementById("userName").value.trim();
            let passWord = document.getElementById("passWord").value;
            let phoneNumber = document.getElementById("phoneNumber").value.trim();
            let age = document.getElementById("age").value;
            
            let emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            let phoneRegex = /^\d{10}$/;
            
            if(!emailRegex.test(email)) {
                alert("Please enter a valid email address");
                return false;
            }
            else if(userName.length < 3 || userName.length > 30) {
                alert("Your username should be between 3 and 30 characters");
                return false;
            }
            else if(passWord.length < 8) {
                alert("Your password should contain at least 8 characters");
                return false;
            }
            else if(!phoneRegex.test(phoneNumber)) {
                alert("Please enter a valid 10-digit phone number");
                return false;
            }
            else if(age < 18 || age > 120) {
                alert("Please enter a valid age between 18 and 120");
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

        <form:form action="send-otp" modelAttribute="userRegistration" onsubmit="return validate()">
            <div class="form-group">
                <form:input path="email" id="email" class="form-input" placeholder="Email"/>
                <form:errors path="email" cssClass="error"/>
                <p class="error">${userExists}</p>
            </div>
            
            <div class="form-group">
                <form:input path="userName" id="userName" class="form-input" placeholder="Username"/>
                <form:errors path="userName" cssClass="error"/>
            </div>
            
            <div class="form-group">
                <form:password path="passWord" id="passWord" class="form-input" placeholder="Password"/>
                <form:errors path="passWord" cssClass="error"/>
            </div>
            
            <div class="form-group">
                <form:input path="phoneNumber" id="phoneNumber" class="form-input" placeholder="Phone Number"/>
                <form:errors path="phoneNumber" cssClass="error"/>
            </div>
            
            <div class="form-group">
                <form:select path="gender" id="gender" class="form-input">
                    <form:option value="">Select Gender</form:option>
                    <form:option value="MALE">Male</form:option>
                    <form:option value="FEMALE">Female</form:option>
                    <form:option value="OTHER">Other</form:option>
                </form:select>
                <form:errors path="gender" cssClass="error"/>
            </div>
            
            <div class="form-group">
                <form:input path="age" type="number" id="age" class="form-input" placeholder="Age"/>
                <form:errors path="age" cssClass="error"/>
            </div>

            <button type="submit" class="login-btn">Send OTP</button>
            
            <div class="forgot-password">
                <a href="<c:url value='login' />">Already have an account? Login</a>
            </div>
        </form:form>
    </div>
</body>
</html>