<%--
  Created by IntelliJ IDEA.
  User: jose
  Date: 8/17/21
  Time: 8:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Empresas</title>
    <link rel="stylesheet" href="css/stylesheet.css">
    <script src="goBack.js"></script>
</head>
<body>
    <div class="mainDiv">
        <p>Empresas disponíveis</p>
        <ul>
            <c:forEach items = "${empresaList}" var = "empresa">
                <li>${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/></li>
            </c:forEach>
        </ul>
        <button class="button" onclick="goBack()">Voltar</button>
    </div>
</body>
</html>
