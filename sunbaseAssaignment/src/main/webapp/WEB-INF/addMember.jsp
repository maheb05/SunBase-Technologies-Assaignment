<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            color: white;
            background-color: black;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
        }

        h2 {
            text-align: center;
            color: green;
        }

        form {
            background-color: black;
            color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 600px;
            margin: auto;
            margin-top: 20px; /* Adjust the top margin as needed */
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        .form-group {
            display: flex;
            flex-wrap: wrap;
            gap: 16px;
            margin-bottom: 16px;
        }

        .form-group label,
        .form-group input,
        .form-group select {
            width: 48%;
            box-sizing: border-box;
        }

        .form-group input,
        .form-group select {
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            width: 100%;
            background-color: blue;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: green;
        }
    </style>
</head>
<body>
    <h2>Add Customer</h2>
    <form action="${pageContext.request.contextPath}/memberAdd" method="post">
        <div class="form-group">
            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" name="firstName" placeholder="Enter First Name" required>

            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" name="lastName" placeholder="Enter Last Name" required>
        </div>

        <div class="form-group">
            <label for="street">Street:</label>
            <input type="text" id="street" name="street" placeholder="Enter Street Name" required>

            <label for="address">Address:</label>
            <input type="text" id="address" name="address" placeholder="Enter Address" required>
        </div>

        <div class="form-group">
            <label for="city">City:</label>
            <input type="text" id="city" name="city" placeholder="Enter City" required>

            <label for="state">State:</label>
            <input type="text" id="state" name="state" placeholder="Enter State" required>
        </div>

        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" placeholder="Enter Email" required>

            <label for="phone">Phone:</label>
            <input type="tel" id="phone" name="phone" placeholder="Enter Phone Number" required>
        </div>

        <input type="submit" value="Add">
    </form>

    <h2>${wrong}</h2>
</body>
</html>
