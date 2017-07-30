<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h3>Add Category</h3>
    <form:form action="/admin/add/category" method="post" commandName="category" role="form">
        <div class="form-group">
            <label for="categoryName"> Category name: </label>
            <input type="text" name="name" id="categoryName" placeholder="Input category name:" class="form-control">
        </div>

        <div>
            <button type="submit" class="btn btn-default btn-success">ADD</button>
        </div>
    </form:form>


    <h3>Add Brand</h3>
    <form:form action="/admin/add/brand" method="post" commandName="brand">
        <div class="form-group">
            <label for="brandName">Brand name:</label>
            <input type="text" id="brandName" class="form-control" placeholder="Input brand name:" name="name">
        </div>
        <div>
            <button type="submit" class="btn btn-default btn-success">ADD</button>
        </div>
    </form:form>

    <h3>Add product</h3>
    <form:form action="/admin/add/product" method="post" commandName="product" role="form"
               enctype="multipart/form-data">
        <div class="form-group">
            <label for="categoryNameP">Category:</label>
            <select class="form-control" name="categoryId" id="categoryNameP">
                <c:forEach items="${categoryList}" var="category">
                    <option value="${category.id}">${category.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="brandNameP"> Brand:</label>
            <select id="brandNameP" name="brandId" class="form-control">
                <c:forEach items="${brandList}" var="brand">
                    <option value="${brand.id}">${brand.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="sleeve">Sleeve type:</label>
            <input type="text" name="sleeveType" placeholder="Input sleeve type:" id="sleeve" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="colourP">Colour:</label>
            <input type="text" name="colour" placeholder="Input colour:" id="colourP" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="clothingP">Clothing type:</label>
            <input type="text" name="clothingType" id="clothingP" placeholder="Input clothing type:"
                   class="form-control"/>
        </div>
        <div class="form-group">
            <label for="currencyP">Currency</label>
            <input type="text" name="currency" id="currencyP" placeholder="Input currency" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="costP">Cost</label>
            <input type="number" name="cost" id="costP" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="quantity">Quantity</label>
            <input type="number" name="quantity" id="quantity" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="availabilityP">Availability</label>
            <input type="text" name="availability" id="availabilityP" placeholder="Input availability:" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="conditionP">Condition</label>
            <input type="text" name="condition" id="conditionP" placeholder="Input condition:" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="imageP">Upload image:</label>
            <input type="file" name="file" id="imageP" class="form-control"/>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-default btn-success">ADD</button>
        </div>
    </form:form>

    <h3><a href="/logout">Logout</a></h3>
</div>


</body>
</html>
