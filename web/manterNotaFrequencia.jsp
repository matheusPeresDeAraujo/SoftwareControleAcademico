<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Notas e Frequência</title>
    </head>
    <body>
        <h1>MANTER NOTAS E FREQUÊNCIA</h1>
        <table>
            <tr>
                <td>Professor:</td><td colspan="3">${turma.professor.nome}</td>
            </tr>
            <tr>
                <td>Disciplina:</td><td colspan="3">${turma.disciplina.nome}</td>
            </tr>
            <tr>
                <td>Ano:</td><td>${turma.ano}</td><td>Semestre:</td><td>${turma.semestre}</td>
            </tr>
            <tr>
                <td>Sala:</td><td>${turma.numSala}</td>
            </tr>
            <tr>
                <td>Horário:</td>
                <td>Quinta-feira</td><td>15:30</td>
                <td>Quinta-feira</td><td>15:30</td>
            </tr>
        </table>

        <table border>
            <tr>
                <td>MATRÍCULA</td><td>NOME DO ALUNO</td><td>FALTAS</td><td>NOTA 1</td><td>NOTA 2</td><td>NOTA 3</td><td>PROVA FINAL</td><td>MEDIA</td><td>NOTA FINAL</td><td>RESULTADO FINAL</td><td>AÇÃO</td>
            </tr>
            <c:forEach items="${avaliacoes}" var="avaliacao">
                <tr>
                    <td>${avaliacao.aluno.matricula}</td>
                    <td>${avaliacao.aluno.nome}</td>
                    <td>${avaliacao.numFaltas}</td>
                    <td>${avaliacao.nota1}</td>
                    <td>${avaliacao.nota2}</td>
                    <td>${avaliacao.nota3}</td>
                    <td>${avaliacao.notaProvaFinal}</td>
                    <td>${(avaliacao.nota1 + avaliacao.nota2 + avaliacao.nota3)/3}</td>
                    <td>
                        <c:if test="${((avaliacao.nota1 + avaliacao.nota2 + avaliacao.nota3)/3) ge avaliacao.notaProvaFinal}">${((avaliacao.nota1 + avaliacao.nota2 + avaliacao.nota3)/3)}</c:if>
                        <c:if test="${((avaliacao.nota1 + avaliacao.nota2 + avaliacao.nota3)/3) < avaliacao.notaProvaFinal}">60</c:if>
                        </td>
                        <td>
                        <c:if test="${not empty(avaliacao.nota1) and not empty(avaliacao.nota2)}">    
                            <c:if test="${avaliacao.notaProvaFinal eq 0 or empty(avaliacao.notaProvaFinal)}">
                                <c:if test="${((avaliacao.nota1 + avaliacao.nota2 + avaliacao.nota3)/3) ge 60}">APROVADO</c:if>
                                <c:if test="${((avaliacao.nota1 + avaliacao.nota2 + avaliacao.nota3)/3) < 40}">REPROVADO</c:if>
                                <c:if test="${((avaliacao.nota1 + avaliacao.nota2 + avaliacao.nota3)/3) < 60 and ((avaliacao.nota1 + avaliacao.nota2 + avaliacao.nota3)/3) ge 40}">PROVA FINAL</c:if>
                            </c:if>
                            <c:if test="${avaliacao.notaProvaFinal > 0}">
                                <c:if test="${avaliacao.notaProvaFinal ge 60}">APROVADO</c:if>
                                <c:if test="${avaliacao.notaProvaFinal < 60}">REPROVADO</c:if>
                            </c:if>
                        </c:if>
                    </td>
                    <td>
                        <a href="ManterAlunoNotaFrequenciaController?codTurma=${avaliacao.turma.codTurma}&matricula=${avaliacao.aluno.matricula}&acao=prepararOperacao">Alterar</a>
                    </td>

                </tr>
            </c:forEach>
            <tr>
                <td>
                    <input type="button" value="Voltar" onclick="javascript:window.location.assign('PesquisarNotaFrequenciaController?acao=prepararOperacao')">
                </td>
                <td colspan="9">
                </td>

            </tr>

        </table>
    </body>
</html>