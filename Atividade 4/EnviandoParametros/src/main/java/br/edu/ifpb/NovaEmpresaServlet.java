package br.edu.ifpb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet para cadastro de Empresas
 * @author José Henrique
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {

        System.out.println("Cadsatrando nova empresa");
        PrintWriter printWriter = httpServletResponse.getWriter();
        String empresa = httpServletRequest.getParameter("empresa");
        printWriter.println("<html><body>Empresa " + empresa +" cadastrada com sucesso</body></html>");
    }
}
