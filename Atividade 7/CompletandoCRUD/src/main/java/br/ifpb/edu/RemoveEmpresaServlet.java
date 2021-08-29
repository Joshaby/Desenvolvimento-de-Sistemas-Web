package br.ifpb.edu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/removeEmpresa")
public class RemoveEmpresaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {

        String paramId = httpServletRequest.getParameter("id");
        Integer id = Integer.parseInt(paramId);
        System.out.println(id);
        Banco banco = new Banco();
        banco.removeEmpresa(id);
        httpServletResponse.sendRedirect("listaEmpresas");
    }
}
