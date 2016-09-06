<%--
  Created by IntelliJ IDEA.
  User: heshichao
  Date: 16-8-31
  Time: 下午5:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="//cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>

    <script>
        $(document).ready(function (e) {
            $.post("/test", function (data) {
                alert(data);
            });
        });
    </script>
</head>
<body>
${currentUser}
<button class="heshichao">ssss</button>
</body>
</html>
