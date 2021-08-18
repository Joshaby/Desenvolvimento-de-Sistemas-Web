<!DOCTYPE html>
<%
    String nome = (String) request.getAttribute("nome");
    System.out.println(nome);
%>
<html lang="pt-br" >
<head>
    <meta charset="UTF-8" >
    <title>Nova empresa</title>
    <link rel="stylesheet" href="css/stylesheet.css" >
    <script src="goBack.js"></script>
</head>
<body>
    <div class="mainDiv">
        <p>Empresa <%= (nome) %> cadastrada com sucesso!</p>
        <button class="button" onclick="goBack()">Voltar</button>
    </div>
</body>
</html>