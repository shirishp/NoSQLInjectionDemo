<%@ page import="nosql.injection.demo.model.InjectionResult" %>
<%@ page import="com.mongodb.DBCursor" %>
<%@ page import="com.mongodb.DBObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NoSQL Injection Demo Application</title>
    <style type="text/css">
        * {
            font-family: monaco, "courier new", verdana;
        }
        .underline-style{
            text-decoration: underline
        }
        .center
        {
            text-align:center
        }
    </style>
</head>
<body>
    <% InjectionResult result =(InjectionResult) request.getAttribute("result");  %>
    <% DBCursor r;  %>
    <table class="table">
        <tr>
            <th class="underline-style">String Query</th>
        </tr>
        <tr><td class="center"><%= result.getStringQuery() %></td></tr>
        <tr>
            <th class="underline-style">Database Query</th>
        </tr>
        <tr><td class="center"><%= result.getDatabaseQuery() %></td></tr>
        <tr>
           <th class="underline-style">Result</th>
        </tr>
        <% r=result.getResult(); %>
        <tr><table border="2" width="600"><tr><th>ID</th><th>First Name</th><th>Surname</th><th>Address</th></tr>
        <% try {
            while(r.hasNext()){ %>
                <tr>
                    <% DBObject person = r.next(); %>
                    <td class="center"><%= person.get("_id")%></td>
                    <td class="center"><%= person.get("name")%></td>
                    <td class="center"><%= person.get("surname")%></td>
                    <td class="center"><%= person.get("address")%></td>
                </tr>
            <%}
        }
        catch(Exception e){
         } %>
    </table></tr>
    </table>

</body>
</html>
