<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>KLH Medical Center - Contact Us</title>
	<link rel="stylesheet" href="<c:url value='/resources/css/contact-us.css' />">
	</head>	
<body>
<div class="container">
<div class="contact-wrapper">
<!-- Left Column - Contact Info -->
<div class="contact-info">
<h1>CONTACT US</h1>
<div class="description">
<p>KLH Medical Center has been providing excellent healthcare services and sick room management for our college community. Our dedicated staff is available 24/7 to assist students with their medical needs.</p>
</div>
<div class="contact-details">
<div class="detail-item">
<h2>Email:</h2>
<p>2210030391@klh.edu.in</p>
<p>2210030150@klh.edu.in</p>
</div>
<div class="detail-item">
<h2>Medical Center Location:</h2>
<p>KL UNIVERSITY HYDERABAD</p>
<p>AZIZ NAGAR, GROUND FLOOR</p>
</div>
</div>
<div class="expectations-card">
<h2>
<svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
<path d="M22 12h-4l-3 9L9 3l-3 9H2"/>
</svg> What to Expect When Contacting Us </h2>
<ul>
<li>Immediate response for medical queries</li>
<li>Professional consultation with qualified staff</li>
<li>Detailed follow-up care instructions via email</li>
</ul>
</div>
</div>

<!-- Right Column - Contact Form -->
<div class="contact-form">
<h2>Submit Your Query</h2>
<form action="<%= request.getContextPath() %>/submitQuery" method="post"> <!-- Action for form submission -->
<div class="form-row">
<div class="form-group">
<label for="firstName">First Name <span class="required">*</span></label>
<input type="text" id="firstName" name="firstName" required>
</div>
<div class="form-group">
<label for="lastName">Last Name <span class="required">*</span></label>
<input type="text" id="lastName" name="lastName" required>
</div>
</div>

<div class="form-group">
<label for="email">Email Address <span class="required">*</span></label>
<input type="email" id="email" name="email" required>
</div>

<div class="form-group">
<label for="phone">Phone Number</label>
<input type="tel" id="phone" name="phone">
</div>

<div class="form-group">
<label for="queryType">Nature of Query <span class="required">*</span></label>
<select id="queryType" name="queryType" required>
<option value="">Select a category</option>
<option value="appointment">Schedule Appointment</option>
<option value="other">Other Query</option>
</select>
</div>

<div class="form-group">
<label for="message">Message <span class="required">*</span></label>
<textarea id="message" name="message" rows="4" required></textarea>
</div>

<button type="submit" class="submit-btn">Submit Query</button>
</form>
</div>

</div> <!-- End of contact-wrapper -->
</div> <!-- End of container -->
</body>
</html>