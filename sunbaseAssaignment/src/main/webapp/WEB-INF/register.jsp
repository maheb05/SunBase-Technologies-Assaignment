<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Register</title>
    <style>
        body {
        	background-color : black ;
        	color : white ;
            font-family: Arial, sans-serif;
        }

        table {
            width: 50%;
            margin: auto;
            border-collapse: collapse;
            margin-top: 20px;
            border: 1px solid transparent;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid transparent;
        }

        th {
            background-color: #3498db;
            color: #ffffff;
        }

        input[type="text"],
        input[type="email"],
        input[type="password"],
        input[type="tel"],
        select,
        input[type="date"] {
            width: 100%;
            padding: 8px;
            margin: 5px 0;
            box-sizing: border-box;
        }

        input[type="radio"] {
            margin-right: 5px;
        }

        input[type="submit"] {
            background-color: #3498db;
            color: #ffffff;
            padding: 10px;
            border: none;
            cursor: pointer;
            margin-top: 10px; /* Adjust margin as needed */
            display: block; /* Make the submit button a block element */
            margin-left: auto;
            margin-right: auto;
        }

        input[type="submit"]:hover {
            background-color: #2980b9;
        }

        .error {
            color: red;
            margin-top: 5px;
        }
    </style>
    <script>
        function validateForm() {
            var password = document.forms["registrationForm"]["password"].value;
            var confirmPassword = document.forms["registrationForm"]["confirmPassword"].value;

            if (password !== confirmPassword) {
                document.getElementById("passwordError").innerHTML = "Passwords do not matched,please check";
                return false;
            } else {
                document.getElementById("passwordError").innerHTML = "";
                return true;
            }
        }
    </script>
</head>
<body>
    <h2>Register Yourself</h2>

    <form name="registrationForm" action="${pageContext.request.contextPath}/processRegistration" method="post" onsubmit="return validateForm()">
        <table>
            <tr>
                <th>Field</th>
                <th>Value</th>
            </tr>
            <tr>
                <td>Full Name:</td>
                <td><input type="text" name="fullName" placeholder="Enter Full Name"  required></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="email" name="email" placeholder="Enter Email" required></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\W).{8,}" title="Must contain at least one digit, one lowercase letter, one uppercase letter, one special character, and be at least 8 characters long" placeholder="Enter Password" required></td>
            </tr>
            <tr>
                <td>Confirm Password:</td>
                <td><input type="password" name="confirmPassword" placeholder="Conform Password" required></td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td><input type="tel" name="phone" pattern="[0-9]{10}" title="Phone number must be 10 digits" placeholder="Enter Mobile Number" required></td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td>
                    <label><input type="radio" name="gender" value="male" required> Male</label>
                    <label><input type="radio" name="gender" value="female" required> Female</label>
                    <label><input type="radio" name="gender" value="other" required> Other</label>
                </td>
            </tr>
            <tr>
                <td>Date of Birth:</td>
                <td><input type="date" name="dob" required></td>
            </tr>
        </table>

        <span id="passwordError" class="error"></span>

        <input type="submit" value="Register">
    </form>
    
    <h3>${errorMessage }</h3>
</body>
</html>
