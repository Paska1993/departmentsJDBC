<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/css/departmentstyle.css" title="style" />
</head>
<body>
<div class="edit">
    <form:form name="edit" class="form-horizontal" method="post" action="department_edit.html" commandName="department">
       <%-- <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">Name: </label>
            <div class="col-sm-10">
                <input type="hidden" name="id" value="${requestScope.department.getId()}" >
                <input type="text" name="name" class="form-control" id="inputEmail3" placeholder="Name"
                        value="<c:out value="${requestScope.department.getName()}"/>"><br>
                <p style="color: brown"> <c:out value="${errorMessage}"></c:out></p>
            </div>
        </div>--%>
           <div class="form-group">
               <label  class=" col-sm-2 control-label">Name: </label>
               <div class="col-sm-10">
                   <form:input type="text" path="name" class="form-control" placeholder="name"/>
                   <font color="red"> <form:errors path="name"></form:errors></font><br/>
                   <input type="hidden" name="id" value="${requestScope.department.getId()}" >
                   <p style="color: brown"> <c:out value="${errorMessage}"></c:out></p>
               </div>
           </div>

            <div class="add">
                <input type="submit" class="btn btn-large btn-success" name="addSubmit" value="Add">
            </div>
    </form:form>
    <div class="cancel">
        <form action="index.html" method="post">
        <input type="submit" class="btn btn-large btn-info" name="addSubmit" value="Cancel">
        </form>
    </div>
</div>
</body>
</html>
