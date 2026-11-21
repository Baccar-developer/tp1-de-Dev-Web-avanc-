<%@ page import="java.util.Date" %>
<%
    Date now = new Date();
    String serverIp = request.getRemoteHost();
%>
<%= now %>
<%= serverIp %>