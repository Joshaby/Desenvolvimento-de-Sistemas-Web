package br.ifpb.edu;

import java.util.List;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listaEmpresas")
public class ListaEmpresaServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {

        Banco banco = new Banco();
        List<Empresa> empresaList = banco.getEmpresaList();
        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/listaEmpresas.jsp");
        httpServletRequest.setAttribute("empresaList", banco.getEmpresaList());
        requestDispatcher.forward(httpServletRequest, httpServletResponse);
    }
}
