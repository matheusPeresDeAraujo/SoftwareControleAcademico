<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body>
        <table>
        <tr>
        <td <c:if test="${!sessionScope.credencial.acesso.equals('SECRETARIA')}"> hidden</c:if>>
            <a href='PesquisarCursoController'>Manter Cursos</a>
        </td>
        </tr>
        <tr>
        <td <c:if test="${!sessionScope.credencial.acesso.equals('SECRETARIA')}"> hidden</c:if>>
            <a href="PesquisarDisciplinaController?filtro=0">Manter Disciplinas</a>
        </td>
        </tr>
        <tr>
        <td <c:if test="${!sessionScope.credencial.acesso.equals('SECRETARIA')}"> hidden</c:if>>
            <a href="PesquisarProfessorController">Manter Professores</a>
        </td>
        </tr>
        <tr>
        <td <c:if test="${!sessionScope.credencial.acesso.equals('SECRETARIA') && !sessionScope.credencial.acesso.equals('ALUNO')}"> hidden</c:if>>
            <a href="PesquisarAlunoController">Manter Alunos</a>
        </td>
        </tr>
        <tr>
        <td <c:if test="${!sessionScope.credencial.acesso.equals('SECRETARIA')}"> hidden</c:if>>
            <a href="PesquisarTurmaController?filtro=0">Manter Turmas</a><br/>
        </td>
        </tr>
        <tr>
        <td <c:if test="${!sessionScope.credencial.acesso.equals('ALUNO')}"> hidden</c:if>>
            <a href="PesquisarMatrizCurricularController?acao=prepararOperacao">Consultar Matriz Curricular</a>
        </td>
        </tr>
        <tr>
        <td <c:if test="${!sessionScope.credencial.acesso.equals('ALUNO')}"> hidden</c:if>>
            <a href="PesquisarProfessorPorCursoController?acao=prepararOperacao"> Consultar Professores Vinculados a cada Curso</a>
        </td>
        </tr>
        <tr>
        <td <c:if test="${!sessionScope.credencial.acesso.equals('PROFESSOR')}"> hidden</c:if>>
            <a href="PesquisarNotaFrequenciaController?acao=prepararOperacao"> Manter Nota e Frequência</a>
        </td>
        </tr>
        <tr>
        <td <c:if test="${!sessionScope.credencial.acesso.equals('SECRETARIA')}"> hidden</c:if>>
            <a href=""> Calcular Resultado de Rendimento do Aluno</a>
        </td>
        </tr>
        <tr>
        <td <c:if test="${!sessionScope.credencial.acesso.equals('SECRETARIA')}"> hidden</c:if>>
            <a href="ReatorioCursosController?acao=prepararOperacao">Relatório de Cursos</a>
        </td>
        </tr>
        <tr>
        <td <c:if test="${!sessionScope.credencial.acesso.equals('SECRETARIA')}"> hidden</c:if>>
            <a href="RelatorioProfessorController?acao=prepararOperacao">Relatório de Professores Por Titulação</a>
        </td>
        </tr>
        <tr>
        <td <c:if test="${!sessionScope.credencial.acesso.equals('SECRETARIA')}"> hidden</c:if>>
            <a href="RelatorioDisciplinaPorCursoController?acao=prepararOperacao">Relatório de Disciplina Por Cursos</a>
        </td>
        </tr>
        <tr>
        <td <c:if test="${!sessionScope.credencial.acesso.equals('SECRETARIA')}"> hidden</c:if>>
            <a href="RelatorioAlunoAnoSemestreController?acao=prepararOperacao">Relatório de Aluno Ano/Semestre</a>
        </td>
        </tr>
        <tr>
        <td <c:if test="${!sessionScope.credencial.acesso.equals('SECRETARIA')}"> hidden</c:if>>
            <a href="RelatorioDiarioDeClasseController?acao=prepararOperacao">Diário de Classe</a>
        </td>
        </tr>
        <tr>
        <td <c:if test="${!sessionScope.credencial.acesso.equals('SECRETARIA')}"> hidden</c:if>>
            <a href="ReatorioHistoricoAlunoController?acao=prepararOperacao">Historico</a>
        </td>
        </tr>
        </table>
    </body>
</html>
