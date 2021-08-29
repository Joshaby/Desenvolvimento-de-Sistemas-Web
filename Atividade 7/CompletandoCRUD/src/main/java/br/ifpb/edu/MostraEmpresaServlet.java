package br.ifpb.edu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mostraEmpresa")
public class MostraEmpresaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {

        String paramId = httpServletRequest.getParameter("id");
        Integer id = Integer.parseInt(paramId);
        Banco banco = new Banco();
        Empresa empresa = banco.buscaEmpresaPelaId(id);
        System.out.println(empresa.getNome());
        httpServletRequest.setAttribute("empresa", empresa);
        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/formAlteraEmpresa.jsp");
        requestDispatcher.forward(httpServletRequest, httpServletResponse);
    }
}
