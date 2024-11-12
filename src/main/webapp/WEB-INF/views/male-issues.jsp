<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Complaints Dashboard</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="<c:url value='/resources/css/male-issues.css' />">
</head>
<body>
    <div class="container">
        <h1><i class="fas fa-clipboard-list"></i> My Complaints Dashboard</h1>

        <div class="tabs">
            <div class="tab active">All Male Complaints</div>
        </div>

        <div class="table-container">
            <table>
                <thead>
                    <tr>
                        <th>NAME</th>
                        <th>ROLL NO/ID</th>
                        <th>DEPARTMENT</th>
                        <th>DESCRIPTION</th>
                        <th>MEDICINE</th>
                        <th>REGISTERED TIME</th>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${not empty students || not empty faculty || not empty staff}">
                            <c:forEach items="${students}" var="student">
                                <tr>
                                    <td data-label="Name">${student.studentName}</td>
                                    <td data-label="Roll No">${student.rollNo}</td>
                                    <td data-label="Department">${student.department}</td>
                                    <td data-label="Description">${student.description}</td>
                                    <td data-label="Medicine">${student.medicine}</td>
                                    <td data-label="Registered Time">${student.createdAt}</td>
                                </tr>
                            </c:forEach>
                            <c:forEach items="${faculty}" var="faculty">
                                <tr>
                                    <td data-label="Name">${faculty.facultyName}</td>
                                    <td data-label="ID">${faculty.id}</td>
                                    <td data-label="Department">${faculty.department}</td>
                                    <td data-label="Description">${faculty.description}</td>
                                    <td data-label="Medicine">${faculty.medicine}</td>
                                    <td data-label="Registered Time">${faculty.createdAt}</td>
                                </tr>
                            </c:forEach>
                            <c:forEach items="${staff}" var="staff">
                                <tr>
                                    <td data-label="Name">${staff.facultyName}</td>
                                    <td data-label="ID">${staff.id}</td>
                                    <td data-label="Department">${staff.department}</td>
                                    <td data-label="Description">${staff.description}</td>
                                    <td data-label="Medicine">${staff.medicine}</td>
                                    <td data-label="Registered Time">${staff.createdAt}</td>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td colspan="6" class="no-complaints">No Complaints</td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>