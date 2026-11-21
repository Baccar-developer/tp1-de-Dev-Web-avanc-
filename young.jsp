<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<jsp:useBean id="person" type="isep.lab.mvc.model.Person" scope="request" />


    <h2 >vous étes né aprés 1990 — saludations, junior visiteur!</h2>

    <table>
        <tr><th>nom</th><td><jsp:getProperty name="person" property="nom" /></td></tr>
        <tr><th>prenom</th> <td><jsp:getProperty name="person" property="prenom"  /></td></tr>
        <tr><th>date_naiss</th><td><jsp:getProperty name="person" property="date_naiss"  /></td></tr>
        <tr><th>Sex</th>       <td><jsp:getProperty name="person" property="sex"       /></td></tr>
    </table>

    <p><a href="index.html">← retourner au form</a></p>
