<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Medicine Inventory Dashboard</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="<c:url value='/resources/css/medical.css' />">
</head>
<body>
    <div class="container">
        <main class="main-content">
            <div class="header">
			    <h1 class="page-title">Medicine Inventory</h1>
			    <form action="<c:url value='search-medicine'/>" method="GET">
			        <input type="search" name="query" class="search-bar" placeholder="Search medicines...">
			    </form>
			</div>

            <div class="tabs">
                <div class="tab active">Current Stock</div>
                <div class="tab">Low Stock</div>
            </div>

            <div class="appointments-table">
                <table>
                    <thead>
                        <tr>
                            <th>MEDICINE ID</th>
                            <th>MEDICINE NAME</th>
                            <th>QUANTITY</th>
                            <th>DESCRIPTION</th>
                            <th>EXPIRY DATE</th>
                            <th>REGISTERED TIME</th>
                            <th>STATUS</th>
                            <th>ACTION</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:choose>
                            <c:when test="${not empty medicines}">
                                <c:forEach items="${medicines}" var="medicine">
                                    <tr>
                                        <td>${medicine.id}</td>
                                        <td>${medicine.medicineName}</td>
                                        <td>
                                            <span class="status-badge ${medicine.quantity < 20 ? 'status-due' : 'status-completed'}">
                                                ${medicine.quantity}
                                            </span>
                                        </td>
                                        <td>${medicine.description}</td>
                                        <td>${medicine.expiryDate}</td>
                                        <td>${medicine.createdAt}</td>
                                        <td>
                                            <span class="status-badge ${medicine.quantity < 20 ? 'status-due' : 'status-ongoing'}">
                                                ${medicine.quantity < 20 ? 'Low Stock' : 'In Stock'}
                                            </span>
                                        </td>
                                        <td>
                                            <form action="<c:url value='delete-medicine?id="${medicine.id}"'/>" 
                                                  onsubmit="return confirm('Are you sure you want to delete this medicine?');">
                                                <input type="hidden" name="id" value="${medicine.id}">
                                                <button type="submit" class="delete-btn">
                                                    <i class="fas fa-trash-alt"></i>
                                                </button>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td colspan="8" class="no-data">No Medicines Available</td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                    </tbody>
                </table>
            </div>
        </main>
    </div>
</body>
</html>