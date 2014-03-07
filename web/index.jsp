<%-- 
    Document   : index
    Created on : Dec 24, 2009, 2:32:36 PM
    Author     : root
--%>

<%@page import="bangnaLibrary.BBranch"%>
<%@page import="bangnaLibrary.ComboDB"%>
<%@page import="bangnaLibrary.Config1"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
String path_config="";
Config1 config1 = new Config1();
ComboDB combodb = new ComboDB(config1);
BBranch branch = new BBranch();
path_config = config1.compName;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table>
            <tr><td>Server Name</td><td><% out.print(config1.compName); %></td></tr>
            <tr><td>path_config</td><td><% out.print(path_config); %></td></tr>
            <tr><td>config1.host</td><td><% out.print(config1.host); %></td></tr>
            <tr><td>config1.passDB</td><td><% out.print(config1.passDB); %></td></tr>
            <tr><td>config1.database</td><td><% out.print(config1.database); %></td></tr>
        </table>
    </body>
</html>
