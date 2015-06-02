<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
  <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="/css/style.css" title="style" />
  <link rel="stylesheet" type="text/css" href="/css/addEmpl.css" title="style" />

  <script type="text/javascript" src="/js/departmentsController.js"></script>
  <script type="text/javascript" src="/js/departmentEditForm.js"></script>
  <script type="text/javascript" src="/js/employeeTable.js"></script>
  <script type="text/javascript" src="/js/departmentAddForm.js"></script>
  <script type="text/javascript" src="/js/departmentTable.js"></script>
  <script type="text/javascript" src="/js/employeeEditForm.js"></script>
  <script type="text/javascript" src="/js/employeeAddForm.js"></script>
  <script type="text/javascript" src="/js/employeeController.js"></script>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.2.1/jquery.form-validator.min.js"></script>
  <script type="text/javascript">

    var employeeController = new EmployeeController();
    var editEmployee = new EmployeeEditForm();
    var addEmployee = new EmployeeAddForm();
    var employeeTable = new EmployeeTable();
    var editDepartment = new DepartmentEditForm();
    var addDepartment = new DepartmentAddForm();
    var pageManager = new DepartmentTable();
    var departmentController = new DepartmentController();
    $(document).ready(departmentController.main());
  </script>

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
        <a class="list-group-item" href="#" onclick="departmentController.AllDepartments()"><i class="fa fa-home fa-lg"></i>&nbsp; Home</a>
        <a class="list-group-item" href="#" onclick="employeeController.getEmployees()"><i class="fa fa-users fa-fw"></i>&nbsp; Employees</a>
        <a class="list-group-item" href="error.jsp"><i class="fa fa-cog fa-spin"></i>&nbsp; Settings</a>
      </div>
    </div>
    <div id="container" class="span10">
    </div>
    </div>
  </div>
</body>
</html>
