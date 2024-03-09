<%--
  Created by IntelliJ IDEA.
  User: general9k
  Date: 01.03.2024
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<img width="800px" height="500px" src="${pageContext.request.contextPath}/images/users/42.jpg" alt="User image"/>
<form action="/registration" method="post" enctype="multipart/form-data">
    <label for="username"> Name:
        <input type="text" name="name" id="username">
    </label>
    <br>
    <label for="birthday"> Birthday:
        <input type="date" name="birthday" id="birthday">
    </label>
    <br>
    <label for="imageId"> Image:
        <input type="file" name="image" id="imageId">
    </label>
    <br>
    <label for="email"> Email:
        <input type="text" name="email" id="email">
    </label>
    <br>
    <label for="password"> Password:
        <input type="password" name="password" id="password">
    </label>
    <br>
    <label for="role">
        <select name="role" id="role">
            <c:forEach var="role" items="${requestScope.roles}">
                <option value="${role}">${role}_role</option>
            </c:forEach>
        </select>
    </label>
    <br>
    <c:forEach var="gender" items="${requestScope.genders}">
        <label for="gender">
            <input type="radio" name="gender" id="gender" value="${gender}"> ${gender}
        </label>
        <br>
    </c:forEach>
    <button type="submit">Send</button>

    <c:if test="${not empty requestScope.errors}">
        <div style="color: red">
            <c:forEach var="error" items="${requestScope.errors}">
                <span>${error.message}</span><br>
            </c:forEach>
        </div>
    </c:if>

</form>
</body>
</html>
