<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="message" align="center">
  <br><p style="color: brown; font-size: 22px"><c:out value="${requestScope.errorMessage}"></c:out></p>
</div>
<div class="error">
  <p><a href = "index.html"><img src="http://cache.lego.com/r/www/-/media/portal%20v2010/errors/404%20mainstage%20image.jpg?l.r2=1953967734" alt="error" style="
    margin-left: 15%;
    margin-top: 0px;
    width: 1100px;
"></a></p>
</div>
</body>
</html>
