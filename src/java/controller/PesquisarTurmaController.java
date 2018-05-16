package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Curso;
import model.Disciplina;
import model.Turma;

public class PesquisarTurmaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            
            int filtro = Integer.parseInt(request.getParameter("filtro"));
           
            if( filtro==1){
                int curso = Integer.parseInt(request.getParameter("curso"));
                String nomeDisciplina = request.getParameter("disciplina");
                int ano = Integer.parseInt(request.getParameter("ano"));
                int semestre = Integer.parseInt(request.getParameter("optSemestre"));
                
                if((curso == 0) && (ano == 0) && (semestre == 0) && (nomeDisciplina == null || nomeDisciplina.equals(""))){
                    //Busca sem filtros
                    request.setAttribute("turmas", Turma.obterTurmas());
                    
                }else if((curso == 0) && (ano == 0) && (semestre == 0) && (nomeDisciplina != null && !nomeDisciplina.equals(""))){
                    //Busca apenas pelo nome
                    request.setAttribute("turmas", Turma.obterTurmasPorNome(nomeDisciplina));
                    
                }else if((curso == 0) && (ano == 0) && (semestre != 0) && (nomeDisciplina == null || nomeDisciplina.equals(""))){
                    //Busca apenas pelo semestre
                    request.setAttribute("turmas", Turma.obterTurmasPorSemestre(semestre));
                    
                }else if((curso == 0) && (ano == 0) && (semestre != 0) && (nomeDisciplina != null || !nomeDisciplina.equals(""))){
                    //Busca pelo semestre e nome
                    request.setAttribute("turmas", Turma.obterTurmasPorSemestreNome(semestre, nomeDisciplina));
                    
                }else if((curso == 0) && (ano != 0) && (semestre == 0) && (nomeDisciplina == null || nomeDisciplina.equals(""))){
                    //Busca somente pelo ano
                    request.setAttribute("turmas", Turma.obterTurmasPorAno(ano));
                    
                }else if((curso == 0) && (ano != 0) && (semestre == 0) && (nomeDisciplina != null || !nomeDisciplina.equals(""))){
                    //Busca pelo ano e nome
                    request.setAttribute("turmas", Turma.obterTurmasPorAnoNome(ano, nomeDisciplina));
                    
                }else if((curso == 0) && (ano != 0) && (semestre != 0) && (nomeDisciplina == null || nomeDisciplina.equals(""))){
                    //Busca pelo ano e semestre
                    request.setAttribute("turmas", Turma.obterTurmasPorAnoSemestre(ano, semestre));
                    
                }else if((curso == 0) && (ano != 0) && (semestre != 0) && (nomeDisciplina != null || !nomeDisciplina.equals(""))){
                    //Busca pelo ano, semestre e nome
                    request.setAttribute("turmas", Turma.obterTurmasPorAnoSemestreNome(ano, semestre, nomeDisciplina));
                    
                }else if((curso != 0) && (ano == 0) && (semestre == 0) && (nomeDisciplina == null || nomeDisciplina.equals(""))){
                    //Busca apenas pelo curso
                    request.setAttribute("turmas", Turma.obterTurmasPorCurso(curso));
                    
                }else if((curso != 0) && (ano == 0) && (semestre == 0) && (nomeDisciplina != null || !nomeDisciplina.equals(""))){
                    //Busca pelo curso e nome
                    request.setAttribute("turmas", Turma.obterTurmasPorCursoNome(curso, nomeDisciplina));
                    
                }else if((curso != 0) && (ano == 0) && (semestre != 0) && (nomeDisciplina == null || nomeDisciplina.equals(""))){
                    //Busca pelo curso e semestre
                    request.setAttribute("turmas", Turma.obterTurmasPorCursoSemestre(curso, semestre));
                    
                }else if((curso != 0) && (ano == 0) && (semestre != 0) && (nomeDisciplina != null || !nomeDisciplina.equals(""))){
                    //Busca pelo curso, semestre e nome
                    request.setAttribute("turmas", Turma.obterTurmasPorCursoSemestreNome(curso, semestre, nomeDisciplina));
                    
                }else if((curso != 0) && (ano != 0) && (semestre == 0) && (nomeDisciplina == null || nomeDisciplina.equals(""))){
                    //Busca pelo curso e ano
                    request.setAttribute("turmas", Turma.obterTurmasPorCursoAno(curso, ano));
                    
                }else if((curso != 0) && (ano != 0) && (semestre == 0) && (nomeDisciplina != null || !nomeDisciplina.equals(""))){
                    //Busca pelo curso, ano e nome
                    request.setAttribute("turmas", Turma.obterTurmasPorCursoAnoNome(curso, ano, nomeDisciplina));
                    
                }else if((curso != 0) && (ano != 0) && (semestre != 0) && (nomeDisciplina == null || nomeDisciplina.equals(""))){
                    //Busca pelo curso, ano e semestre
                    request.setAttribute("turmas", Turma.obterTurmasPorCursoAnoSemestre(curso, ano, semestre));
                    
                }else{
                    //Busca utilizando todos os filtros
                    request.setAttribute("turmas", Turma.obterTurmasPorCursoAnoSemestreNome(curso, ano, semestre, nomeDisciplina));
                    
                }
                
                request.setAttribute("disciplinas", Disciplina.obterDisciplinas());
                request.setAttribute("cursos", Curso.obterCursos());
                
            }else{
                request.setAttribute("turmas", Turma.obterTurmas());
                request.setAttribute("disciplinas", Disciplina.obterDisciplinas());
                request.setAttribute("cursos", Curso.obterCursos());
            }
            RequestDispatcher janela = request.getRequestDispatcher("/pesquisarTurma.jsp");
            janela.forward(request, response);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
