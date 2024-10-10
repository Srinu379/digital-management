<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Our Services - Computer Hardware Service</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/services.css' />">
</head>
<body>
    <header>
        <nav>
            <div class="logo">Klh Medical</div>
            <ul>
                <li><a href="<c:url value='e-homepage' />">Home</a></li>
                <li><a href="<c:url value='view-all-issues' />">Issues</a></li>
                <li><a href="<c:url value='profile-page' />">Profile</a></li>
                <li><a href="<c:url value='/' />" class="btn-logout">Logout</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <section class="hero">
            <h1>Registration</h1>
            <p>Register all the information at a speed</p>
        </section>

        <section class="services-grid">
            <div class="service-card">
                <h2>Student Registration</h2>
                <a href="<c:url value='student-register-form' />" class="btn-book">Register Now</a>
            </div>
            <div class="service-card">
                <h2>Medical Registration</h2>
                <a href="<c:url value='medical-register-form'/>" class="btn-book">Register Now</a>
            </div>
        </section>
        
        <section class="cta">
            <h2>Need a service not listed here?</h2>
            <p>Contact us for custom solutions tailored to your specific needs.</p>
            <a href="<c:url value='/contact-us' />" class="btn-contact">Contact Us</a>
        </section>
    </main>
</body>
</html>