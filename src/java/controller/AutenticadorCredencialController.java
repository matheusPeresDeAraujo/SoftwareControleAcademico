
package controller;

import dao.CredencialDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Credencial;

public class AutenticadorCredencialController extends HttpServlet {
        private static final long serialVersionUID = 1L;
       
        public AutenticadorCredencialController() {
            super();
        }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession sessao = request.getSession(false);
			if(sessao!=null){
				sessao.invalidate();
				
			}
			response.sendRedirect("login.html");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                
                
            try {
                     String susuario = request.getParameter("usuario");
                     String ssenha = request.getParameter("senha");

                     Credencial cre = new Credencial();
                     cre.setUsuario(susuario);
                     cre.setSenha(ssenha);

                     CredencialDao creDAO = new CredencialDao();
                     Credencial credencial;
                     credencial = creDAO.autenticacao(cre);

                     if(credencial != null){
                             HttpSession sessao = request.getSession();
                             sessao.setAttribute("credencial", credencial);
                             //sessao.setMaxInactiveInterval(3000);

                                     request.getRequestDispatcher("index.jsp").forward(request, response);
                     }else {
                             response.sendRedirect("erroLogin.jsp");
                     }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AutenticadorCredencialController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AutenticadorCredencialController.class.getName()).log(Level.SEVERE, null, ex);
            }	
    }
}
