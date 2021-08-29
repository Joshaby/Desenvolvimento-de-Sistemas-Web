package br.ifpb.edu;

import java.util.Date;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {

        System.out.println("Alterando empresa");
        String nomeEmpresa = httpServletRequest.getParameter("nome");
        String paramDataEmpresa = httpServletRequest.getParameter("data");
        String paramId = httpServletRequest.getParameter("id");
        Integer id = Integer.parseInt(paramId);
        Date dataAbertura = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dataAbertura = simpleDateFormat.parse(paramDataEmpresa);
        }
        catch (ParseException e) {
            throw new ServletException(e);
        }
        Banco banco = new Banco();
        Empresa empresa = banco.buscaEmpresaPelaId(id);
        empresa.setNome(nomeEmpresa);
        empresa.setDataAbertura(dataAbertura);
        httpServletResponse.sendRedirect("listaEmpresas");
    }
}
