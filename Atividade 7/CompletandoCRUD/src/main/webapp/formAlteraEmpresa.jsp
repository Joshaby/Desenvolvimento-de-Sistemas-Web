<%--
  Created by IntelliJ IDEA.
  User: jose
  Date: 8/29/21
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:url value="/alteraEmpresa" var = "linkServletNovaEmpresa"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar</title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" type="text/css" href="css/stylesheet.css"/>
    <script src="goBack.js"></script>
</head>
<body>
    <div class="mainDiv">
        <h1>Empresas</h1>
        <form action="${linkServletNovaEmpresa}" method="post">
            <p>
                <span>Nome: </span>
                <input type="text" name="nome" value="${empresa.nome}"/>
            </p>
            <p>
                <span>Data abertura: </span>
                <input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" />" />
            </p>
            <input type="hidden" name="id" value="${empresa.id}"/>
            <button class="sendButton" type="submit">Enviar</button>
        </form>
        <p class="centerButton">
            <button class="button" onclick="goBack()">Voltar</button>
        </p>
    </div>
</body>
</html>
