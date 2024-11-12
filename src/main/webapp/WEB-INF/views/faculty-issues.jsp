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
    <link rel="stylesheet" href="<c:url value='/resources/css/issues.css' />">
</head>
<body>
    <div class="container">
        <h1><i class="fas fa-clipboard-list"></i> My Complaints Dashboard</h1>
        
        <div class="search-container">
		    <form action="search-faculty" method="GET">
		        <input type="text" name="id" placeholder="Search by Roll Number...">
		        <button type="submit"><i class="fas fa-search"></i> Search</button>
		    </form>
		</div>

        <div class="table-container">
            <table>
                <thead>
                    <tr>
                        <th>Faculty Name</th>
                        <th>Id</th>
                        <th>Department</th>
                        <th>Description</th>
                        <th>Medicine</th>
                        <th>Registered Time</th>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${not empty faculty}">
                          	<c:forEach items="${faculty}" var="faculty">
						    	<tr>
							        <td data-label="Student Name">${faculty.facultyName}</td>
							        <td data-label="Roll No">${faculty.id}</td>
							        <td data-label="Department">${faculty.department}</td>
							        <td data-label="Description">${faculty.description}</td>
							        <td data-label="Medicine">${faculty.medicine}</td>
							        <td data-label="Registered Time">${faculty.createdAt}</td>
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