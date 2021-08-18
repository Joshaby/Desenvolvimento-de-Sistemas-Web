<%--
  Created by IntelliJ IDEA.
  User: jose
  Date: 8/17/21
  Time: 8:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="br.edu.ifpb.Empresa" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <%
                List<Empresa> empresaList = (List<Empresa>) request.getAttribute("empresaList");
                for (Empresa empresa : empresaList) {
            %>
            <li><%= empresa.getNome() %></li>
            <%
                }
            %>
        </ul>
        <button class="button" onclick="goBack()">Voltar</button>
    </div>
</body>
</html>
