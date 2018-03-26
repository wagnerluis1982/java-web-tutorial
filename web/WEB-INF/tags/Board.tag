<%@tag description="O tabuleiro do jogo" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<%-- A lista de atributos dessa tag --%>
<%@attribute name="locked" %>

<%-- Outras tags requeridas para funcionar --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%-- O conteúdo é especificado aqui --%>
<form method="post" data-locked="${locked}">
<div>
<c:forEach var="i" begin="0" end="2">
    <div class="board-row">
    <c:forEach var="j" begin="${i*3}" end="${i*3 + 2}">
        <t:Square value="${j}" />
    </c:forEach>
    </div>
</c:forEach>
</div>
</form>
