<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>KLH Medical - Homepage</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/homepage.css' />">
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
</head>
<body>
    <header>
        <nav>
            <div class="logo-container">
                <img src="<c:url value='/resources/images/klh-logo.jpg' />" alt="KLH Logo" class="klh-logo">
                <div class="logo">Medical</div>
            </div>
            <label for="check" class="checkbtn">
                <i class="fas fa-bars"></i>
            </label>
            <input type="checkbox" id="check">
            <ul class="nav-menu">
                <li><a href="#overview">Overview</a></li>
                <li><a href="<c:url value='view-issues-page' />">Issues</a></li>
                <li><a href="<c:url value='update-page' />">Update</a></li>
                <li><a href="<c:url value='profile-page' />">Profile</a></li>
                <li><a href="<c:url value='/' />" class="btn-logout">Logout</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <section id="hero">
            <h1>Welcome, ${userName}</h1>
            <p>Here's your overview for today</p>
            <a href="<c:url value='get-forms' />" class="btn-cta">Register Now</a>
        </section>

        <section id="overview">
            <h2>Dashboard</h2>
            <div class="service-grid">
                <div class="service-card">
                    <i class="fas fa-clipboard-list"></i>
                    <h3>Total Issues</h3>
                    <p class="count">${totalCount}</p>
                </div>
                <div class="service-card">
                    <i class="fas fa-clock"></i>
                    <h3>Male Issues</h3>
                    <p class="count">${maleCount}</p>
                </div>
                <div class="service-card">
                    <i class="fas fa-check-circle"></i>
                    <h3>Female Issues</h3>
                    <p class="count">${femaleCount}</p>
                </div>
            </div>
        </section>

        <section id="quick-actions">
            <h2>Quick Actions</h2>
            <div class="features-grid">
                <div class="feature">
                    <a href="<c:url value='view-all-issues' />" class="btn-cta">View All Issues</a>
                </div>
                <div class="feature">
                    <a href="<c:url value='view-male-issues' />" class="btn-cta">View Male Issues</a>
                </div>
                <div class="feature">
                    <a href="<c:url value='view-medical' />" class="btn-cta">Medical Inventory</a>
                </div>
                <div class="feature">
                    <a href="<c:url value='view-female-issues' />" class="btn-cta">View Female Issues</a>
                </div>
            </div>
        </section>
    </main>
</body>
</html>