<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:url value="/novaEmpresa" var = "linkServletNovaEmpresa"/>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/stylesheet.css">
    <title>Cadastro</title>
</head>
<body>
    <div class="mainDiv">
        <h1>Empresas</h1>
        <form action="${linkServletNovaEmpresa}" method="post">
            <p>
                <span>Nome: </span>
                <input type="text" name="nome" />
            </p>
            <p>
                <span>Data abertura: </span>
                <input type="text" name="data" />
            </p>
            <button class="sendButton" type="submit">Enviar</button>
        </form>
        <p class="centerButton">
            <a href="http://localhost:8080/listaEmpresas"><button class="button">Ver empresas</button></a>
        </p>
    </div>
</body>
</html>