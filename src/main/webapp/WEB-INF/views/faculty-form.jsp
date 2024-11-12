<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Faculty Issue Form</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/book-form.css' />">
</head>
<body>
    <div class="login-container">
        <h2><i class="fas fa-laptop-code"></i> Faculty Medical Issue</h2>
        <form:form action="process-faculty-form" modelAttribute="facultyIssue">
            <label for="FacultyName">Faculty Name:</label>
            <form:input path="FacultyName" required="required" />  
            
            <label for="id">Id :</label>
            <form:input path="id" required="required" />  
            
            <label for="department">Department:</label>
            <form:input path="department" required="required" /> 
            
            <label for="Gender">Gender:</label>
            <form:input path="gender" required="required" /> 
            
            <label for="description">Description:</label>
            <form:textarea path="description" required="required" />
            
            <div id="medicineContainer">
                <label for="medicines[0]">Medicines:</label>
                <form:select path="medicines[0]" class="medicine-select" required="required">
                <option value="">Select a medicine</option>
                    <c:forEach items="${medicines}" var="medicine">
                        <option value="${medicine.medicineName}">${medicine.medicineName}</option>
                    </c:forEach>
                </form:select>
            </div>
            <c:if test="${not empty notAvailable}">
            <p class="error-message">${notAvailable}</p>
            </c:if>
            <button type="button" id="addMedicine">Add Another Medicine</button>
            
            <input type="submit" value="Submit">
        </form:form>
    </div>

    <script>
        let medicineCount = 1;
        
        document.getElementById('addMedicine').addEventListener('click', function() {
            const container = document.getElementById('medicineContainer');
            const newSelect = document.createElement('div');
            newSelect.innerHTML = `
                <select name="medicines[${medicineCount}]" class="medicine-select" required="required">
                    <option value="">Select a medicine</option>
                    <c:forEach items="${medicines}" var="medicine">
                        <option value="${medicine.medicineName}">${medicine.medicineName}</option>
                    </c:forEach>
                </select>
            `;
            container.appendChild(newSelect);
            medicineCount++;
        });
    </script>
</body>
</html>