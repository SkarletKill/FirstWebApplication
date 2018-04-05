<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Java servlet</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <script type="text/javascript" src="placeholder.js"></script>
</head>
<body>
<form method="post" action="servlet" id="slick-login">
    <label>Имя:</label><input type="text" value = '<c:out value="${requestScope.oldname}"/>' name="name" class="placeholder" placeholder="Your_name">
    <label>Логин:</label><input type="text" value = '<c:out value="${requestScope.oldlogin}"/>' name="login" class="placeholder" placeholder="YourLogin">
    <label>E-mail:</label><input type="email" value = '<c:out value="${requestScope.oldemail}"/>' name="email" class="placeholder" placeholder="admin@example.com">
    <!--Name<input type="text" name="firstName">-->
    <!--Surname<input type="text" name="secondName">-->
    <input type="submit" value="Send">
</form>
</body>
</html>