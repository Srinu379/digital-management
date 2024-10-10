<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Medicine Successful</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/update-medicine-successful.css' />">
</head>
<body>
    <div class="container">
        <div class="success-card">
            <div class="success-icon">&#10004;</div>
            <h1>Update Successful</h1>
            <p>The medicine supply has been successfully updated.</p>
            <div class="details">
                <p><strong>Product ID:</strong> ${productId}</p>
                <p><strong>Quantity Updated:</strong> ${quantity}</p>
            </div>
            <a href="<c:url value='e-homepage' />" class="btn-back">Back to Dashboard</a>
        </div>
    </div>
</body>
</html>