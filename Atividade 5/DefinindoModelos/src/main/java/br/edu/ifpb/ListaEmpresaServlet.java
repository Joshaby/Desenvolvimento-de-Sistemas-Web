package br.edu.ifpb;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listaEmpresas")
public class ListaEmpresaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {

        Banco banco = new Banco();
        List<Empresa> empresaList = banco.getEmpresaList();
        PrintWriter printWriter = httpServletResponse.getWriter();
        printWriter.println("<html><body>");
        printWriter.println("<p>Empresas disponíveis</p>");
        printWriter.println("<ul>");
        empresaList.forEach(empresa -> printWriter.println("<li>" + empresa.getNome() + "</li>"));
        printWriter.println("</ul>");
        printWriter.println("</body></html>");
    }
}
