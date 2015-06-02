
function EmployeeEditForm(){}

EmployeeEditForm.prototype.drawEditForm = function(Employee, errorMessage){

    var container = document.getElementById('container');

    $('div').remove('#depTable');
    $('div').remove('#emplTable');
    $('div').remove('#editEmp');

    var addForm = $('<div></div>').attr({'id': 'editEmp'}).css({ 'width': '400px', 'margin-left': '25%'}).appendTo(container);

    /******************Name div*****************/
    var nameDiv = $('<div></div>').addClass('form-group').appendTo(addForm);
    var nameLabel = $('<label></label>').attr({'for':'Empname'}).appendTo(nameDiv);
    $(document.createTextNode('Name:')).appendTo(nameLabel);
    var nameInput = $('<input>').attr({'name':'name', 'type' :'type', 'id': 'Empname'}).addClass('form-control').val(Employee.name).appendTo(nameDiv);
    if(!$.isEmptyObject(errorMessage)) {
        if (errorMessage[0] != null) {
            $('<p></p>').addClass('fa fa-times').css({
                'color': 'red',
                'margin-top': '5px'
            }).append(errorMessage[0]).appendTo(nameDiv);
        }
    }

    /******************Surname div*****************/
    var nameDiv = $('<div></div>').addClass('form-group').appendTo(addForm);
    var nameLabel = $('<label></label>').attr({'for':'Empsurname'}).appendTo(nameDiv);
    $(document.createTextNode('Surname:')).appendTo(nameLabel);
    var nameInput = $('<input>').attr({'name':'surname', 'type' :'type', 'id': 'Empsurname'}).addClass('form-control').val(Employee.surname).appendTo(nameDiv);
    if(!$.isEmptyObject(errorMessage)) {
        if (errorMessage[1] != null) {
            $('<p></p>').addClass('fa fa-times').css({
                'color': 'red',
                'margin-top': '5px'
            }).append(errorMessage[1]).appendTo(nameDiv);
        }
    }
    /******************Birthday div*****************/
    var nameDiv = $('<div></div>').addClass('form-group').appendTo(addForm);
    var nameLabel = $('<label></label>').attr({'for':'Empbirthday'}).appendTo(nameDiv);
    $(document.createTextNode('Birthday:')).appendTo(nameLabel);
    var nameInput = $('<input>').attr({'name':'birthday', 'type' :'type', 'id': 'Empbirthday'}).addClass('form-control').val(Employee.birthday).appendTo(nameDiv);
    if(!$.isEmptyObject(errorMessage)) {
        if (errorMessage[2] != null) {
            $('<p></p>').addClass('fa fa-times').css({
                'color': 'red',
                'margin-top': '5px'
            }).append(errorMessage[2]).appendTo(nameDiv);
        }
    }
    /******************Salary div*****************/
    var nameDiv = $('<div></div>').addClass('form-group').appendTo(addForm);
    var nameLabel = $('<label></label>').attr({'for':'Empsalary'}).appendTo(nameDiv);
    $(document.createTextNode('Salary:')).appendTo(nameLabel);
    var nameInput = $('<input>').attr({'name':'salary', 'type' :'type', 'id': 'Empsalary'}).addClass('form-control').val(Employee.salary).appendTo(nameDiv);
    if(!$.isEmptyObject(errorMessage)) {
        if (errorMessage[3] != null) {
            $('<p></p>').addClass('fa fa-times').css({
                'color': 'red',
                'margin-top': '5px'
            }).append(errorMessage[3]).appendTo(nameDiv);
        }
    }
    /******************Address div*****************/
    var nameDiv = $('<div></div>').addClass('form-group').appendTo(addForm);
    var nameLabel = $('<label></label>').attr({'for':'Empaddress'}).appendTo(nameDiv);
    $(document.createTextNode('Address:')).appendTo(nameLabel);
    var nameInput = $('<input>').attr({'name':'address', 'type' :'type', 'id': 'Empaddress'}).addClass('form-control').val(Employee.address).appendTo(nameDiv);
    if(!$.isEmptyObject(errorMessage)) {
        if (errorMessage[4] != null) {
            $('<p></p>').addClass('fa fa-times').css({
                'color': 'red',
                'margin-top': '5px'
            }).append(errorMessage[4]).appendTo(nameDiv);
        }
    }
    /******************Email div*****************/
    var nameDiv = $('<div></div>').addClass('form-group').appendTo(addForm);
    var nameLabel = $('<label></label>').attr({'for':'Empemail'}).appendTo(nameDiv);
    $(document.createTextNode('Email:')).appendTo(nameLabel);
    var nameInput = $('<input>').attr({'name':'email', 'type' :'type', 'id': 'Empemail'}).addClass('form-control').val(Employee.email).appendTo(nameDiv);
    if(!$.isEmptyObject(errorMessage)) {
        if (errorMessage[5] != null) {
            $('<p></p>').addClass('fa fa-times').css({
                'color': 'red',
                'margin-top': '5px'
            }).append(errorMessage[5]).appendTo(nameDiv);
        }
    }
    /******************Department ID div*****************/
    var nameDiv = $('<div></div>').addClass('form-group').appendTo(addForm);
    var nameLabel = $('<label></label>').attr({'for':'Empdepartment_id'}).appendTo(nameDiv);
    $(document.createTextNode('Department name:')).appendTo(nameLabel);
    var nameInput = $('<input>').attr({'name':'department_id', 'type' :'type', 'id': 'Empdepartment_id'}).addClass('form-control').val(Employee.department_id).appendTo(nameDiv);


    /******************Add button div*****************/
    var addButtonDiv= $('<div></div>').addClass('form-group').appendTo(addForm);

    var submit =$('<button></button>').bind('click', function(){
        employeeController.editEmployee(Employee.id,$('#Empname').val(),$('#Empsurname').val(),$('#Empbirthday').val()
            ,$('#Empsalary').val(),$('#Empaddress').val(),$('#Empemail').val(),Employee.department_id);
    }).css('marginRight', '10px').addClass('btn btn-primary').appendTo(addButtonDiv);
    $(document.createTextNode('Edit')).appendTo(submit);
}