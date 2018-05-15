package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Menu</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <a href=\"PesquisarCursoController\">Manter Cursos</a> </br>\n");
      out.write("        <a href=\"PesquisarDisciplinaController?filtro=0\">Manter Disciplinas</a> </br>\n");
      out.write("        <a href=\"PesquisarProfessorController\">Manter Professores</a> </br>\n");
      out.write("        <a href=\"PesquisarAlunoController\">Manter Alunos</a> </br>\n");
      out.write("        <a href=\"PesquisarTurmaController\">Manter Turmas</a><br/>\n");
      out.write("        ---<br/>\n");
      out.write("        <a href=\"PesquisarMatrizCurricularController?acao=prepararOperacao\">Consultar Matriz Curricular</a> <br />\n");
      out.write("        <a href=\"PesquisarProfessorPorCursoController?acao=prepararOperacao\"> Consultar Professores Vinculados a cada Curso</a> <br />\n");
      out.write("        <a href=\"PesquisarNotaFrequenciaController?acao=prepararOperacao\"> Manter Nota e Frequência</a> <br />\n");
      out.write("        <a href=\"\"> Calcular Resultado de Rendimento do Aluno</a> <br />\n");
      out.write("        --- Relatórios ---<br/>\n");
      out.write("        <a href=\"ReatorioCursosController?acao=prepararOperacao\">Relatório de Cursos</a></br>\n");
      out.write("        <a href=\"RelatorioProfessorController?acao=prepararOperacao\">Relatório de Professores Por Titulação</a></br>\n");
      out.write("        <a href=\"RelatorioDisciplinaPorCursoController?acao=prepararOperacao\">Relatório de Disciplina Por Cursos</a></br>\n");
      out.write("        <a href=\"RelatorioAlunoAnoSemestreController?acao=prepararOperacao\">Relatório de Aluno Ano/Semestre</a></br>\n");
      out.write("        <a href=\"RelatorioDiarioDeClasseController?acao=prepararOperacao\">Diário de Classe</a></br>\n");
      out.write("        <a href=\"ReatorioHistoricoAlunoController?acao=prepararOperacao\">Historico</a></br>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
