<%@tag description="Especifica o jogo" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<%-- Outras tags requeridas para funcionar --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%-- O conteúdo é especificado aqui --%>
<c:choose>
    <c:when test="${game.winner == ' '}">
        <c:set var="status" value="Próximo jogador: ${game.turn}" />
    </c:when>
    <c:when test="${game.winner == '-'}">
        <c:set var="status" value="Empate Técnico" />
    </c:when>
    <c:otherwise>
        <c:set var="status" value="Vencedor: ${game.winner}" />
    </c:otherwise>
</c:choose>

<div class="game">
    <div class="game-board">
        <t:Board locked="${game.winner != ' '}" />
    </div>
    <div class="game-info">
        <div>${status}</div>
        <form action="<c:url value="/time-travel"/>" method="post">
        <ol>
            <li><button name="step" value="0" data-selected="${game.stepNumber == 0}">Ir para início do jogo</button></li>
            <c:forEach var="move" begin="1" end="${game.historySize - 1}">
                <li><button name="step" value="${move}" data-selected="${game.stepNumber == move}">Ir para movimento #${move}</button></li>
            </c:forEach>
        </ol>
        </form>
        <c:if test="${game.historySize > 1}">
            <div><a href="?restart=true">Reiniciar jogo</a></div>
        </c:if>
    </div>
</div>
