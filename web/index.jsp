<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- Tags requeridas para a página funcionar --%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%-- O conteúdo da página começa aqui --%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Jogo da Velha</title>
        <link rel="stylesheet" href="game.css"/>
    </head>
    <body>
        <t:Game />
    </body>
</html>