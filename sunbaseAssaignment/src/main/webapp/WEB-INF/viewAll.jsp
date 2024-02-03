<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Customer List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: black;
            color : white;
            margin: 0;
            padding: 20px;
        }
	
        h1,h2 {
            text-align: center;
            color: green;
        }

        .buttons-container {
            display: flex;
            justify-content: space-between;
            margin-bottom: 20px;
        }

        .buttons-container a,
        .buttons-container button {
            padding: 10px;
            text-decoration: none;
            background-color: blue;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .buttons-container a:hover,
        .buttons-container button:hover {
            background-color: #45a049;
        }

        .search-container {
            display: flex;
            align-items: center;
        }

        .search-container select,
        .search-container input {
            margin-left: 10px;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        table {
        	border : 2px solid;
            width: 100%;
            border-collapse: collapse;
            background-color: rgba(255, 255, 255, 0.9);
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        th, td {
        	background-color : black ;
        	color : white ;
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: black;
            color: green;
        }

        tr:hover {
            background-color: rgba(0, 128, 255, 0.1);
        }
    </style>
</head>
<body>
    <h1>Customer List</h1>
    
    <div class="buttons-container">
        <a href="${pageContext.request.contextPath}/addMember">Add Member</a>
        <div class="search-container">
            <button onclick="location.href='search'">Search by</button>
            <select id="searchOptions" onchange="changeSearchOption()">
                <option value="firstName">First Name</option>
                <option value="city">City</option>
                <option value="email">Email</option>
                <option value="phone">Phone</option>
            </select>
            <input type="text" id="searchInput" placeholder="Enter search value">
        </div>
    </div>

    <table class="members-table">
        <thead>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Street</th>
                <th>Address</th>
                <th>City</th>
                <th>State</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="customer" items="${customer}">
                <tr>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.street}</td>
                    <td>${customer.address}</td>
                    <td>${customer.city}</td>
                    <td>${customer.state}</td>
                    <td>${customer.email}</td>
                    <td>${customer.phone}</td>
                    <td>
                    <a href="${pageContext.request.contextPath}/edit/${customer.id }">&#9998;</a>
                    <a href="${pageContext.request.contextPath}/delete/${customer.id }">&#128465;</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
	<h2>${error }</h2>
	<h2>${success }</h2>
	<h2>${notdeleted }</h2>
	<h2>${deleted }</h2>
    <script>
        function changeSearchOption() {
            var selectedOption = document.getElementById("searchOptions").value;
            // You can perform additional actions based on the selected option if needed
            console.log("Selected Search Option: " + selectedOption);
        }
    </script>
</body>
</html>
