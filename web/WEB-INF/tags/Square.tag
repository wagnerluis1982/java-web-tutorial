<%@tag description="Cada quadrado do tabuleiro" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<%-- A lista de atributos dessa tag --%>
<%@attribute name="value" %>

<%-- O conteúdo é especificado aqui --%>
<button class="square" name="square" value="${value}">
    ${value}
</button>
