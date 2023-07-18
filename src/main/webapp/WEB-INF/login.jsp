<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Job Portal</title>
    <style>
        /* CSS Reset */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        /* Global Styles */
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            background-color: #f5f5f5;
        }

        nav {
            background-color: #007bff;
            padding: 10px;
            display: flex;
            justify-content: flex-end;
        }

        nav a {
            color: #fff;
            text-decoration: none;
            margin-right: 20px;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }

        .job {
            background-color: #fff;
            padding: 20px;
            margin-bottom: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .job h2 {
            margin-top: 0;
            margin-bottom: 10px;
        }

        .job p {
            margin: 0;
        }

        .login-form, .register-form {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            display: none;
        }

        .login-form h2, .register-form h2 {
            margin-top: 0;
            margin-bottom: 20px;
        }

        .login-form label, .register-form label {
            display: block;
            margin-bottom: 5px;
        }

        .login-form input, .register-form input {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
        }

        .login-form button, .register-form button {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .error {
            color: red;
            margin-top: 10px;
        }

        /* Media Query for Responsive Design */
        @media (max-width: 600px) {
            nav {
                justify-content: center;
            }
        }
    </style>
    <script>
        function showLoginForm() {
            document.querySelector(".login-form").style.display = "block";
            document.querySelector(".register-form").style.display = "none";
        }

        function showRegisterForm() {
            document.querySelector(".login-form").style.display = "none";
            document.querySelector(".register-form").style.display = "block";
        }
    </script>
</head>
<body>
<nav>
    <a href="/">Home</a>
    <a href="#" onclick="showLoginForm()">Login</a>
    <a href="#" onclick="showRegisterForm()">Register</a>
    <!-- Add more navigation links if needed -->
</nav>

<div class="container">
    <h1>Welcome to the Jobs Portal</h1>
    <!-- Your jobs content here -->
    <!-- For demonstration purposes, let's display some job information -->
    <div class="job">
        <h2>Job Title 1</h2>
        <p>Job Description 1</p>
    </div>
    <div class="job">
        <h2>Job Title 2</h2>
        <p>Job Description 2</p>
    </div>
    <div class="job">
        <h2>Job Title 1</h2>
        <p>Job Description 1</p>
    </div>
    <div class="job">
        <h2>Job Title 2</h2>
        <p>Job Description 2</p>
    </div>
    <div class="job">
        <h2>Job Title 1</h2>
        <p>Job Description 1</p>
    </div>
    <div class="job">
        <h2>Job Title 2</h2>
        <p>Job Description 2</p>
    </div>
    <!-- Add more jobs as needed -->
</div>

<!-- Login form -->
<div class="login-form">
    <h2>Login</h2>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <div>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${loginUser.email}" required>
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" value="${loginUser.password}" required>
        </div>
        <button type="submit">Login</button>
    </form>
    <c:if test="${not empty error}">
        <p class="error">${error}</p>
    </c:if>
</div>

<!-- Register form -->
<div class="register-form">
    <h2>Register</h2>
    <form action="${pageContext.request.contextPath}/register" method="post">
        <div>
            <label for="fullName">Full Name:</label>
            <input type="text" id="fullName" name="fullName" value="${newUser.fullName}" required>
        </div>
        <div>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${newUser.email}" required>
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" value="${newUser.password}" required>
        </div>
        <button type="submit">Register</button>
    </form>
    <c:if test="${not empty error}">
        <p class="error">${error}</p>
    </c:if>
</div>
</body>
</html>
