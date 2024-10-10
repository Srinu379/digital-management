<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Update Medicine Supply</title>
  <link rel="stylesheet" href="<c:url value='/resources/css/update-quantity.css' />">
</head>
<body>
  <div class="container">
    <div class="header">
      <h1>Update Medicine Supply</h1>
    </div>

    <div class="form-container">
      <form action="update-medicine-quantity" method="POST">
        <div class="form-group">
          <label for="productId">Product ID</label>
          <input type="text" id="productId" name="id" required placeholder="Enter Product ID">
        </div>

        <div class="form-group">
          <label for="quantity">Update Quantity:</label>
          <input type="number" id="quantity" name="quantity" required placeholder="Enter Quantity">
        </div>

        <div class="form-group">
          <button type="submit" class="btn-submit">Update Supply</button>
        </div>
      </form>
    </div>
  </div>
</body>
</html>