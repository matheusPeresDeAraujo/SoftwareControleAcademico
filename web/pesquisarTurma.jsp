<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Documento sem título</title>
    </head>
    <body>
        <h1>PESQUISAR TURMA</h1>
        <form action="PesquisarTurmaController?filtro=1" method="post">
            <table>
                <tr>
                    <td>Curso:</td>
                    <td>
                        <select id="curso" name="curso">
                                <option value="0" selected>Todos</option>
                                <c:forEach items="${cursos}" var="curso">
                                    <option value="${curso.codCurso}" <c:if test="${cursoFiltro==curso.codCurso}">selected</c:if>>
                                        ${curso.nome}
                                    </option>
                                </c:forEach>
                        </select>
                    </td>
                    <td>Ano:</td>
                    <td>
                        <jsp:useBean id="data" class="java.util.Date"/>  
                        <select name="ano" >  
                                <option name="ano" value="0" selected>Todos</option>
                            <c:forEach var="cont" begin="2006" end="${data.year + 1900}">  
                                <option name="ano" value="<c:out value="${cont}"/>"><c:out value="${cont}"/></option>  
                            </c:forEach>  
                        </select>   
                    </td>
                    <td>Semestre:</td>
                    <td>
                        <select name="optSemestre">
                            <option name="optSemestre" value="0" selected>Todos</option>
                            <option name="optSemestre" value="1" >1</option>
                            <option name="optSemestre" value="2" >2</option>
                           
                         </select>
                    </td>
                    <td>Nome da Disciplina:</td><td><input type="text" id="nomeDisciplina" name="disciplina" value="${nomeFiltro}"</td>
                    <td><input type="submit" value="Pesquisar"></td>
                </tr>
            </table>
        </form>
        <form action="ManterTurmaController?acao=prepararOperacao&operacao=Incluir" method="post">
            <table border>
                <tr>
                    <td>CODIGO</td><td>DISCIPLINA</td><td>PROFESSOR</td><td colspan="3">AÇÕES</td>
                </tr>
                <c:forEach items="${turmas}" var="turma">
                    <tr>
                        <td><c:out value="${turma.codTurma}" /></td>
                        <td><c:out value="${turma.disciplina.nome}" /></td>
                        <td><c:out value="${turma.professor.nome}" /></td>
                        <td><a href="ManterTurmaController?acao=prepararOperacao&operacao=Editar&codTurma=<c:out value="${turma.codTurma}"/>">Editar</a></td>
                        <td><a href="ManterHorariosController?acao=prepararOperacao&codTurma=<c:out value="${turma.codTurma}"/>">Editar Horários</a></td>
                        <td><a href="ManterTurmaController?acao=prepararOperacao&operacao=Excluir&codTurma=<c:out value="${turma.codTurma}"/>">Excluir</a></td>
                    </tr>
                </c:forEach>
                <tr>
                    <td><input type="button" name="btnVoltar" value="Voltar" onclick="javascript:history.back(-1)" /></td><td colspan="4"></td>
                    <td><input type="submit" name="btnIncluir" value="Incluir" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>