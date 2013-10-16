<%@ page import="nosql.injection.demo.model.InjectionResult" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NoSQL Injection Demo Application</title>
    <style type="text/css">
        * {
            font-family: monaco, "courier new", verdana;
        }
    </style>
</head>
<body>
    <% InjectionResult result =(InjectionResult) request.getAttribute("result");  %>
    <table class="table">
        <tr>
            <td>String Query</td><td><%= result.getStringQuery() %></td>
        </tr>
        <tr>
            <td>Database Query</td><td><%= result.getDatabaseQuery() %></td>
        </tr>
        <tr>
            <td>Result</td><td><%= result.getResult() %></td>
        </tr>
    </table>

</body>
</html>
