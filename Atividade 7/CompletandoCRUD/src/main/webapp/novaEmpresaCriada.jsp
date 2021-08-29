<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br" >
<head>
    <meta charset="UTF-8" >
    <title>Nova empresa</title>
    <link rel="stylesheet" href="css/stylesheet.css" >
    <script src="goBack.js"></script>
</head>
<body>
<div class="mainDiv">
    <c:if test="${not empty nome}">
        <p>Empresa ${ nome } cadastrada com sucesso!</p>
    </c:if>
    <c:if test="${empty nome}">
        <p>Nenhuma empresa cadastrada!</p>
    </c:if>
    <button class="button" onclick="goBack()">Voltar</button>
    </div>
</body>
</html>