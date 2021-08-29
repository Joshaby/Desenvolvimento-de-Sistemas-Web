package br.ifpb.edu;

import java.util.Date;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
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
        String data = httpServletRequest.getParameter("data");
        Empresa empresa = new Empresa();
        if (!nome.isEmpty() && !data.isEmpty()) {
            empresa.setNome(nome);
            Date dataEmpresa = null;
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dataEmpresa = simpleDateFormat.parse(data);
            }
            catch (ParseException e) {
                throw new ServletException(e);
            }
            empresa.setDataAbertura(dataEmpresa);
            Banco banco = new Banco();
            banco.adiciona(empresa);
        }
        httpServletRequest.setAttribute("nome", empresa.getNome());
        httpServletResponse.sendRedirect("listaEmpresas");
//        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/listaEmpresas");
//        httpServletRequest.setAttribute("nome", empresa.getNome());
//        requestDispatcher.forward(httpServletRequest, httpServletResponse);
    }
}
