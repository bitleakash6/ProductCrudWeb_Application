<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>
	<!-- <h1>This is a add product form</h1> -->

	<div class="container mt-3">
		<div class="col-md-6 offset-md-3">
			<h1 class="text-center mb-3">Fill the product details</h1>

			<form action="handle-product" method="post">
				<div class="form-group">
					<label for="name">Product Name</label> <input type="text"
						class="form-control" id="name" aria-describedby="emailHelp"
						name="name" placeholder="Enter the product name here">
				</div>

				<div class="form-group">
					<label for="description">Product description</label>
					<textarea class="form-control" name="description" id="description"
						rows="5" placeholder="Enter the product description"></textarea>
				</div>

				<div class="form-group">
					<label for="price">Product Price</label> <input type="text"
						class="form-control" id="price" aria-describedby="emailHelp"
						name="price" placeholder="Enter Product Price">
				</div>

				<div class="container text-center">
					<a href="http://localhost:8080/productcrudapp/"
						class="btn btn-outline-danger">Back</a>

					<button type="submit" class="btn btn-primary">Add</button>
				</div>
			</form>
		</div>
	</div>

</body>
</html>