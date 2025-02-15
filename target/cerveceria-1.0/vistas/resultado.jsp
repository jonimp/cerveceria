<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" type="text/css" href="/css/estilo.css">
        <link rel="icon" type="image/x-icon" href="/img/favicon.ico">
        <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico">
        <title>Cervecería Spring Web MVC</title>
    </head>
    <body>
        <h1>
            Marcas de cerveza ${colorElegido} recomendadas
        </h1>
        <c:forEach var="cerveza" items="${cervezas}" >
            <p>
                Pruebe: ${cerveza.marca} <br>
               
                <img src="${pageContext.request.contextPath}/img/${cerveza.foto}" alt="${cerveza.marca}">
            </p>
        </c:forEach>
    </body>
</html>

