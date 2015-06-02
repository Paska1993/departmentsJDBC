function DepartmentController(){}

DepartmentController.prototype.main = function(){
    departmentController.AllDepartments();
}

DepartmentController.prototype.AllDepartments = function(){
    $.ajax({
        type: "POST",
        url: "department.action",
        contentType: 'application/json',
        success: function(data) {
            console.log(data);
            new DepartmentList(data);
        }, error: function(data){
            console.log("error");
        }
    });
};

DepartmentController.prototype.deleteDep = function(id, name){
    var deptId = id;
    var depName = name;
    console.log(deptId);
    $.ajax({
        type: "POST",
        url: "deleteDepartment.action",
        data: JSON.stringify({id: deptId, name : depName}),
        contentType: 'application/json',
        success: function(data) {
            console.log(data);
            pageManager.deleteRow(data);
        }
    });
};

DepartmentController.prototype.addDepartment =function(name){
    if($.isEmptyObject(name)){
        addDepartment.drawAddForm('Department name is required');
    }
    $.ajax({
        type: "POST",
        url: "addDepartment.action",
        data: JSON.stringify({name: name}),
        dataType : "json",
        contentType: 'application/json',
        success: function(data) {
            pageManager.drawDepartTable(data);
        },error: function(){
            alert('error')
        }
    });
}

DepartmentController.prototype.editDepartment =function(id, name){
    if($.isEmptyObject(name)){
        editDepartment.drawEditForm(new Department(name, id), 'Department name is required');
    }
    else {
        $.ajax({
            type: "POST",
            url: "editDepartment.action",
            data: JSON.stringify({id: id, name: name}),
            dataType: "json",
            contentType: 'application/json',
            success: function (data) {
                pageManager.drawDepartTable(data);
            }, error: function () {
                alert('error')
            }
        });
    }
}