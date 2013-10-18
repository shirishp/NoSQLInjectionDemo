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

<form method="GET" action="" id="searchForm">
    <h1>Search by name</h1>
    <table>
        <tr>
            <td><label for="name">Name:</label></td><td><input type="text" id="name" name="name" size="100"></td>
        </tr>
    </table>
</form>

<button onclick="secureSearch();">Secure Search</button>
<button onclick="insecureSearch();">Insecure Search</button>

<script type="text/javascript">
    function secureSearch() {
        var form = document.getElementById('searchForm');
        form.action = 'secure-find';
        form.submit();
    }

    function insecureSearch() {
        var form = document.getElementById('searchForm');
        form.action = 'insecure-find';
        form.submit();
    }
</script>

</body>
</html>
