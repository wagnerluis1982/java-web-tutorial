<%@tag description="Especifica o jogo" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<%-- Outras tags requeridas para funcionar --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%-- Marca no quadrado clicado um X --%>
<c:if test="${param['square'] != null}">
    <c:set target="${gameSquares}" property="${param['square']}" value="X"/>
</c:if>

<%-- O conteúdo é especificado aqui --%>
<c:set var="status" value="Próximo jogador: X" />

<div class="game">
    <div class="game-board">
        <t:Board />
    </div>
    <div class="game-info">
        <div>${status}</div>
        <ol><!-- A FAZER --></ol>
    </div>
</div>
