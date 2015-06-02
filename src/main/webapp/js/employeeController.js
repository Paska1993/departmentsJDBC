function EmployeeController(){}

EmployeeController.prototype.addEmployee = function(name, surname, birthday, salary, address, email, department_id){
    $.ajax({
        type: "POST",
        url: "addEmployee.action",
        data: JSON.stringify({address: address, birthday: birthday, email: email, name: name, salary: salary,
            surname: surname, department_id: department_id}),
        contentType: 'application/json',
        success: function(data) {
            console.log(data);
            employeeTable.drawEmplTable(data);
        }
    });
};

function validateEmail(email) {
    var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    return re.test(email);
}

function isValidDate(str){

    if(str=="" || str==null){return false;}
    var m = str.match(/(\d{4})-(\d{2})-(\d{2})/);
    if( m === null || typeof m !== 'object'){return false;}
    if (typeof m !== 'object' && m !== null && m.size!==3){return false;}

    var ret = true;
    var thisYear = new Date().getFullYear();
    var minYear = 1950;

    if( (m[1].length < 4) || m[1] < minYear || m[1] > thisYear){ret = false;}
    if( (m[1].length < 2) || m[2] < 1 || m[2] > 12){ret = false;}
    if( (m[1].length < 2) || m[3] < 1 || m[3] > 31){ret = false;}

    return ret;
}

EmployeeController.prototype.editEmployee = function(id, name, surname, birthday, salary, address, email, department_id){

    var errorMessage = [];
    if($.isEmptyObject(name)){
        errorMessage[0] = 'Name is required';
    }if($.isEmptyObject(surname)){
        errorMessage[1] = 'Surame is required';
    }if($.isEmptyObject(birthday)){
        errorMessage[2] = 'Birthday is empty';
    }if(isValidDate(birthday)){
        errorMessage[2] = 'Bad date format';
    }if($.isEmptyObject(salary)){
        errorMessage[3] = 'Salary is empty';
    }if(!$.isNumeric(salary)){
        errorMessage[3] = 'Salary is not correct';
    }if($.isEmptyObject(address)){
        errorMessage[4] = 'Address is required';
    }if($.isEmptyObject(email)){
        errorMessage[5] = 'Email is required';
    }if(!validateEmail(email)){
        errorMessage[5] = 'Bad email';
    }
    if(errorMessage.length > 0){
        editEmployee.drawEditForm(new Employee(id,name,surname,birthday,salary,address,email,department_id),errorMessage);
    } else {
        $.ajax({
            type: "POST",
            url: "editEmployees.action",
            data: JSON.stringify({
                id: id, name: name, surname: surname, birthday: birthday, salary: salary,
                address: address, email: email, department_id: department_id
            }),
            contentType: 'application/json',
            success: function (data) {
                console.log(data);
                employeeTable.drawEmplTable(data);
            }
        });
    }
};

EmployeeController.prototype.deleteEmployee = function(id){
    $.ajax({
        type: "POST",
        url: "deleteEmployee.action",
        data: JSON.stringify({id: id}),
        contentType: 'application/json',
        success: function(data) {
            console.log(data);
            pageManager.deleteRow(data);
        }
    });
};

EmployeeController.prototype.getEmployees = function(){
    $.ajax({
        type: "POST",
        url: "employees.action",
        contentType: 'application/json',
        success: function(data) {
            employeeTable.drawEmplTable(data);
        },
        error: function(data){
            console.log("error");
        }
    });
};

EmployeeController.prototype.getEmployeesList = function(){
    $.ajax({
        type: "POST",
        url: "employeeList.action",
        contentType: 'application/json',
        success: function(data) {
            console.log(data);
            addEmployee.drawAddEmployeeForm(data);
        },
        error: function(data){
            console.log("error");
        }
    });
};

EmployeeController.prototype.getEmployeesByDepartment = function(id){
    $.ajax({
        type: "POST",
        url: "employeesByDepartment.action",
        contentType: 'application/json',
        data: JSON.stringify({id: id}),
        success: function(data) {
            employeeTable.drawEmplTable(data);
        },
        error: function(data){
            console.log("error");
        }
    });
};
