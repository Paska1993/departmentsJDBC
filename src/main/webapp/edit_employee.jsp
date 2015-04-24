<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="/css/employeestyle.css" title="style" />
</head>
<body>
<div class="errorMessage">
  <p style="color: brown">
    <c:forEach items="${requestScope.errorMessage}" var="error">
      <c:out value="${error.getMessage()}"></c:out><br>
    </c:forEach></p>
</div>
<div class="edit">
  <form name="edit" class="form-horizontal" method="post" action="update_employee.html">
    <div class="form-group">
      <label  class="col-sm-2 control-label">Name: </label>
      <div class="col-sm-10">
        <input type="text" name="name" class="form-control"  placeholder="Name"
               value="<c:out value="${requestScope.employee.getName()}"></c:out>">
      </div>
    </div>
    <div class="form-group">
      <label  class="col-sm-2 control-label">Surname: </label>
      <div class="col-sm-10">
        <input type="text" name="surname" class="form-control"  placeholder="Surname"
               value="<c:out value="${requestScope.employee.getSurname()}"></c:out>">
      </div>
    </div>
    <div class="form-group">
      <label  class=" col-sm-2 control-label">Birthday: </label>
      <div class="col-sm-10">
        <input type="text" name="birthday" class="form-control" placeholder="Date of birth in format YYYY-MM-DD"
               value="<c:out value="${requestScope.employee.getBirthday()}"></c:out>">
      </div>
    </div>
    <div class="form-group">
      <label  class="col-sm-2 control-label">Salary: </label>
      <div class="col-sm-10">
        <input type="text" name="salary" class="form-control" placeholder="0.0"
               value="<c:out value="${requestScope.employee.getSalary()}"></c:out>">
        <p style="color: brown; font-size: 16px"><c:out value="${requestScope.salaryError}"></c:out></p>
      </div>
    </div>
    <div class="form-group">
      <label  class="col-sm-2 control-label">Address: </label>
      <div class="col-sm-10">
        <input type="text" name="address" class="form-control" placeholder="Address"
               value="<c:out value="${requestScope.employee.getAddress()}"></c:out>">
      </div>
    </div>
    <div class="form-group">
      <label  class="col-sm-2 control-label">Email: </label>
      <div class="col-sm-10">
        <input type="text" name="email" class="form-control" placeholder="email"
               value="<c:out value="${requestScope.employee.getEmail()}"></c:out>">
        <p style="color: brown; font-size: 16px"><c:out value="${requestScope.sameEmailError}"></c:out></p>
        <p style="color: brown; font-size: 16px"><c:out value="${requestScope.emailFormatError}"></c:out></p>
      </div>
    </div>
    <div class="form-group">
      <label  class="col-sm-2 control-label">ID: </label>
      <div class="col-sm-10">
        <select class="form-control" name="department_id">
          <c:forEach items="${requestScope.departments}" var="dep">
            <option value="${dep.getId()}">
              <c:out value="${dep.getName()}"></c:out>
            </option>
          </c:forEach>
        </select>
      </div>
    </div>
    <div class="add">
      <input type="submit" class="btn btn-large btn-success" name="addSubmit" value="Edit">
      <input type="hidden" name="id" value="${requestScope.employee.getId()}">
    </div>
  </form>
  <div class="cancel">
    <form action="employees.html" method="post">
      <input type="submit" class="btn btn-large btn-info" name="addSubmit" value="Cancel">
    </form>
  </div>
</div>
</body>
</html>
