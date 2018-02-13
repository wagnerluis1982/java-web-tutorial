<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<%-- Tags requeridas para a página funcionar --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%-- O conteúdo da página começa aqui --%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Jogo da Velha</title>
        <link rel="stylesheet" href="<c:url value="/game.css"/>" />
    </head>
    <body>
        <t:Game />
    </body>
</html>
