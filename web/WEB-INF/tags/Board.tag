<%@tag description="O tabuleiro do jogo" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<%-- A lista de atributos dessa tag --%>
<%@attribute name="locked" %>

<%-- Outras tags requeridas para funcionar --%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%-- O conteúdo é especificado aqui --%>
<form method="post" data-locked="${locked}">
<div>
    <div class="board-row">
        <t:Square value="0" />
        <t:Square value="1" />
        <t:Square value="2" />
    </div>
    <div class="board-row">
        <t:Square value="3" />
        <t:Square value="4" />
        <t:Square value="5" />
    </div>
    <div class="board-row">
        <t:Square value="6" />
        <t:Square value="7" />
        <t:Square value="8" />
    </div>
</div>
</form>
