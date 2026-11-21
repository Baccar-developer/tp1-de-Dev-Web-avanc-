<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:useBean id="P" class="isep.lab1.bean.Person" scope="request"/>
<jsp:setProperty name="P" property="*"/>

<html>
    <head>
        <title>bean</title>
    </head>
<body>
    <label>nom: </label>
    <jsp:getProperty name="P" property="nom"/><br>

    <label>prenom: </label>
    <jsp:getProperty name="P" property="prenom"/><br>

    <label>date_naissance: </label>
    <jsp:getProperty name="P" property="date_naiss"/><br>

    <label>sex: </label>
    <jsp:getProperty name="P" property="sex"/><br>
</body>
</html>