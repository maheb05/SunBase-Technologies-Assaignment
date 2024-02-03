<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>edit</title>
    <style>
        body {
            background-color: black;
            color: white;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: black;
            color: white;
        }

        input {
            color: black;
            background-color: white;
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            color: white;
            background-color: blue;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: green;
        }

        h2 {
            color: green;
        }
    </style>
</head>
<body>
    <h2>Edit Details</h2>

    <form action="${pageContext.request.contextPath}/updateDetails" method="post">
        <input type="hidden" name="id" value="${id }">
        
        <table>
            <tr>
                <th><label for="firstName">First Name:</label></th>
                <td><input type="text" id="firstName" name="firstName" value="${firstName}"></td>
            </tr>
            <tr>
                <th><label for="lastName">Last Name:</label></th>
                <td><input type="text" id="lastName" name="lastName" value="${lastName}"></td>
            </tr>
            <tr>
                <th><label for="street">Street:</label></th>
                <td><input type="text" id="street" name="street" value="${street}"></td>
            </tr>
            <tr>
                <th><label for="address">Address:</label></th>
                <td><input type="text" id="address" name="address" value="${address}"></td>
            </tr>
            <tr>
                <th><label for="city">City:</label></th>
                <td><input type="text" id="city" name="city" value="${city}"></td>
            </tr>
            <tr>
                <th><label for="state">State:</label></th>
                <td><input type="text" id="state" name="state" value="${state}"></td>
            </tr>
            <tr>
                <th><label for="email">Email:</label></th>
                <td><input type="email" id="email" name="email" value="${email}"></td>
            </tr>
            <tr>
                <th><label for="phone">Phone:</label></th>
                <td><input type="tel" id="phone" name="phone" value="${phone}"></td>
            </tr>

            <tr>
                <th></th>
                <td><input type="submit" value="Update Details"></td>
            </tr>
        </table>
    </form>
</body>
</html>
