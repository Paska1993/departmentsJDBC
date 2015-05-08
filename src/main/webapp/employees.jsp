<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
          <a class="list-group-item" href="/index.html"><i class="fa fa-home fa-fw"></i>&nbsp; Home</a>
          <a class="list-group-item" href="#"><i class="fa fa-users fa-lg"></i>&nbsp; Employees</a>
          <a class="list-group-item" href="error.jsp"><i class="fa fa-cog fa-spin"></i>&nbsp; Settings</a>
        </div>
    </div>
    <div class="span10">
      <table class="table table-bordered">
        <thead>
        <tr>
          <th class="warning">Name</th>
          <th class="warning">Surname</th>
          <th class="warning">Birthday</th>
          <th class="warning">Salary</th>
          <th class="warning">Address</th>
          <th class="warning">Email</th>
          <th class="success">Edit</th>
          <th class="danger">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${employees}" var="var">
          <tr>
            <td><p><c:out value="${var.getName()}"></c:out></p></td>
            <td><p><c:out value="${var.getSurname()}"></c:out></p></td>
            <td><p><c:out value="${var.getSalary()}"></c:out></p></td>
            <td><p><c:out value="${var.getAddress()}"></c:out></p></td>
           <%-- <td><p><c:out value="${var.getBirthday()}"></c:out></p></td>--%>
            <td><p><fmt:formatDate pattern="yyyy-MM-dd" value="${var.getBirthday()}"></fmt:formatDate></p></td>
            <td><p><c:out value="${var.getEmail()}"></c:out></p></td>
            <td>
              <form action="employee_id.html" method="post">
              <input type="submit" name="edit" class="btn btn-success" value="Edit">
                <input type="hidden" name="id" value="${var.getId()}">
              </form>
            </td>
            <td>
              <form action="delete_employee.html" method="POST">
                <input type="submit" name="delete" class="btn btn-danger" value="Delete">
                <input type="hidden" name="id" value="${var.getId()}">
              </form>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
      <form action="add_form.html" method="GET">
        <input type="submit" name="edit" class="btn btn-success" value="Add">
      </form>
    </div>
  </div>
</div>
</body>
</html>
