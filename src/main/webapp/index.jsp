
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>

<head>
    <title>departments</title>
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/css/style.css" title="style" />
</head>

<body>
<div class="header">
    <div align="center">
    <h1>Departments</h1>
    </div>
</div>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span2">
            <div class="list-group">
                <a class="list-group-item" href="#"><i class="fa fa-home fa-lg"></i>&nbsp; Home</a>
                <a class="list-group-item" href="employees.html"><i class="fa fa-users fa-fw"></i>&nbsp; Employees</a>
                <a class="list-group-item" href="error.jsp"><i class="fa fa-cog fa-spin"></i>&nbsp; Settings</a>
            </div>
        </div>
        <div class="span10">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th class="warning">Department name</th>
                    <th class="success">Edit</th>
                    <th class="danger">Delete</th>
                    <th class="info">Employee list</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${departments}" var="val">
                <tr>
                    <td><p><strong><c:out value="${val.getName()}"></c:out></strong></p></td>
                    <td>
                        <form action="get_chosen_department.html" method="POST">
                            <input type="submit" class="btn btn-success" value="Edit">
                            <input type="hidden" name="id" value="${val.id}">
                            <input type="hidden" name="name" value="${val.name}">
                        </form>
                    </td>
                    <td>
                        <form action="department_delete.html" method="POST">
                            <input type="submit" class="btn btn-danger" value="Delete">
                            <input type="hidden" name="id" value="${val.id}">
                            <input type="hidden" name="name" value="${val.name}">
                            <input type="hidden" name="department" value="${val}">
                        </form>
                    </td>
                    <td>
                        <form action="special_employee_list.html" method="POST">
                            <input type="submit" class="btn btn-info" value="Employee list">
                            <input type="hidden" value="${val.id}" name="id">
                        </form>
                    </td>
               </tr>
                </c:forEach>
                </tbody>
            </table>
            <form name="sample" action="/befor_add.html" method="GET">
                <input type="submit" class="btn btn-primary" value="Add">
            </form>
        </div>
    </div>
</div>
</body>
</html>