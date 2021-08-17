package br.edu.ifpb;

import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {

        System.out.println("Cadastrando nova empresa");
        String nome = httpServletRequest.getParameter("nome");
        Empresa empresa = new Empresa(nome);
        Banco banco = new Banco();
        banco.adiciona(empresa);
        PrintWriter printWriter = httpServletResponse.getWriter();
        printWriter.println("<html><body>Empresa " + nome + " cadastrada com sucesso!</body></html>");
    }
}
