<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Klh View Page</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/issue.css' />">
</head>
<body>
    <header>
        <nav>
            <div class="logo-container">
                <img src="<c:url value='/resources/images/klh-logo.jpg' />" alt="KLH Logo" class="klh-logo">
                <div class="logo">Medical</div>
            </div>
            <ul>
                <li><a href="<c:url value='e-homepage' />">Home</a></li>
                <li><a href="<c:url value='update-page' />">Update</a></li>
                <li><a href="<c:url value='profile-page' />">Profile</a></li>
                <li><a href="<c:url value='/' />" class="btn-logout">Logout</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <section class="hero">
            <h1>Medical Dashboard</h1>
            <p>Register all the information at a speed</p>
        </section>

        <section class="services-grid">
            <div class="service-card">
                <h2>View Student Issues</h2>
                <a href="<c:url value='view-student-issues' />" class="btn-book">View now</a>
            </div>
            <div class="service-card">
                <h2>View Faculty Issues</h2>
                <a href="<c:url value='view-faculty-issues' />" class="btn-book">View now</a>
            </div>
            <div class="service-card">
                <h2>View Non-Teaching-Staff</h2>
                <a href="<c:url value='view-non-teaching-staff-issues'/>" class="btn-book">View now</a>
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