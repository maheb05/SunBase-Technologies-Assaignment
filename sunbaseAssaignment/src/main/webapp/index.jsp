<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Welcome</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background-color:black;
            background-image: url('your-background-image.jpg'); /* Add your background image URL here */
            background-size: cover;
            background-position: center;
            color: #ffffff;
        }

        header {
            background-color: black;
            text-align: center;
            padding: 10px;
            position: relative;
        }

        .buttons {
            position: absolute;
            top: 10px;
            right: 10px;
        }

        .buttons a {
            margin-left: 10px;
            background-color: #3498db; /* Blue color for the "button" */
            color: #ffffff;
            padding: 8px 12px;
            border: none;
            text-decoration: none; /* Remove the default underline on links */
            cursor: pointer;
            display: inline-block; /* Make the link behave like a block-level element */
            border-radius: 5px; /* Add rounded corners for a button-like appearance */
        }

        footer {
            background-color: black;
            text-align: center;
            padding: 10px;
            position: absolute;
            bottom: 0;
            width: 100%;
        }

        .container {
            padding: 20px;
        }
    </style>
</head>
<body>
    <header>
        <h2>WELCOME</h2>
        <div class="buttons">
            <a href="register">Register</a>
            <a href="login">Login</a>
        </div>
    </header>

    <div class="container">
        <!-- Your page content goes here -->

    </div>

    <footer>
        <!-- Your footer content goes here -->
    </footer>
</body>
</html>
