function EmployeeAddForm(){}

EmployeeAddForm.prototype.drawAddEmployeeForm = function(department){

    var container = document.getElementById('container');

    var modal = $('<div></div>').attr({'id':'addEmployeeModal', 'tabindex':'-1', 'role': 'dialog',
        'aria-hidden': 'true'}).addClass('modal fade').appendTo(container);
    var dialog = $('<div></div>').addClass('modal-dialog').appendTo(modal);
    var content = $('<div></div>').addClass('modal-content').appendTo(dialog);
    var header = $('<div></div>').addClass('modal-header').appendTo(content);
    var button = $('<button></button>').attr({'type':'button', 'data-dismiss': 'modal',
        'aria-label' :'Close'}).addClass('close').appendTo(header);
    $('<span></span>').attr('aria-hidden','true').appendTo(button);
    $(document.createTextNode('x')).appendTo(button);

    var label = $('<h4></h4>').addClass('modal-title');
    $(document.createTextNode('Employee')).appendTo(header);

    var body = $('<div></div>').addClass('modal-body').appendTo(content);
    var depForm = $('<form></form>').attr({'id': 'EmployeeAddForm'}).addClass('form-horizontal').appendTo(body);

                        /***********Name***********/

    var formGroup = $('<div></div>').addClass('form-group').appendTo(depForm);
    var name = $('<label></label>').addClass('col-xs-3 control-label').append('Name:').appendTo(formGroup);
   /* $(document.createTextNode('Name:')).appendTo(name);*/
    var input = $('<div></div>').attr('id', 'inputName').addClass('col-xs-7').appendTo(formGroup);
    $('<input>').attr({'type':'text', 'name':'name', 'id': 'name'}).addClass('form-control').appendTo(input);

                        /***********Surname***********/
    var formGroup = $('<div></div>').addClass('form-group').appendTo(depForm);
    var name = $('<label></label>').addClass('col-xs-3 control-label').append('Surname:').appendTo(formGroup);
    var input = $('<div></div>').attr('id', 'inputSurname').addClass('col-xs-7').appendTo(formGroup);
    $('<input>').attr({'type':'text', 'id': 'surname'}).addClass('form-control').appendTo(input);

                        /***********Birthday***********/
    var formGroup = $('<div></div>').addClass('form-group').appendTo(depForm);
    var name = $('<label></label>').addClass('col-xs-3 control-label').appendTo(formGroup);
    $(document.createTextNode('Birthday:')).appendTo(name);
    var input = $('<div></div>').attr('id', 'inputBirthday').addClass('col-xs-7').appendTo(formGroup);
    $('<input>').attr({'type':'text', 'id': 'birthday'}).addClass('form-control').appendTo(input);

                        /***********Salary***********/
    var formGroup = $('<div></div>').addClass('form-group').appendTo(depForm);
    var name = $('<label></label>').addClass('col-xs-3 control-label').appendTo(formGroup);
    $(document.createTextNode('Salary:')).appendTo(name);
    var input = $('<div></div>').attr('id', 'inputSalary').addClass('col-xs-7').appendTo(formGroup);
    $('<input>').attr({'type':'text', 'id': 'salary'}).addClass('form-control').appendTo(input);

                        /***********Address***********/
    var formGroup = $('<div></div>').addClass('form-group').appendTo(depForm);
    var name = $('<label></label>').addClass('col-xs-3 control-label').appendTo(formGroup);
    $(document.createTextNode('Address:')).appendTo(name);
    var input = $('<div></div>').attr('id', 'inputAddress').addClass('col-xs-7').appendTo(formGroup);
    $('<input>').attr({'type':'text', 'id': 'address'}).addClass('form-control').appendTo(input);

                        /***********Email***********/
    var formGroup = $('<div></div>').addClass('form-group').appendTo(depForm);
    var name = $('<label></label>').addClass('col-xs-3 control-label').appendTo(formGroup);
    $(document.createTextNode('Email:')).appendTo(name);
    var input = $('<div></div>').attr('id', 'inputEmail').addClass('col-xs-7').appendTo(formGroup);
    $('<input>').attr({'type':'text', 'id': 'email'}).addClass('form-control').appendTo(input);

                        /***********Department ID***********/
    var formGroup = $('<div></div>').addClass('form-group').appendTo(depForm);
    var name = $('<label></label>').addClass('col-xs-3 control-label').appendTo(formGroup);
    $(document.createTextNode('Department:')).appendTo(name);

    var input = $('<div></div>').addClass('col-xs-7').appendTo(formGroup);
    var select = $('<select></select>').attr('id','department_id').addClass('form-control').attr('data-style','btn-success').appendTo(input);
    for(var i =0; i<department.length; i++){
        var option = $('<option></op>').val(department[i].id).appendTo(select);
        $(document.createTextNode(department[i].name)).appendTo(option);
    }

    var formGroup = $('<div></div>').addClass('form-group').appendTo(depForm);
    var buttons = $('<div></div>').addClass('col-xs-7 col-xs-offset-7').appendTo(formGroup);
    var submit =$('<button></button>').attr({'type':'button','data-dismiss': 'modal'}).bind('click', function(){
        employeeController.addEmployee($('#name').val(),$('#surname').val(),$('#birthday').val()
            ,$('#salary').val(),$('#address').val(),$('#email').val(),$('#department_id').val())
        addEmployee.deleteFields();
    }).css('marginRight', '10px').addClass('btn btn-primary').appendTo(buttons);
    $(document.createTextNode('Add')).appendTo(submit);
    var cancel =$('<button></button>').attr({'type':'button', 'data-dismiss': 'modal'}).addClass('btn btn-default').appendTo(buttons);
    $(document.createTextNode('Cancel')).appendTo(cancel);
}

EmployeeAddForm.prototype.deleteFields = function(){

    var input = document.getElementById('inputName');
    $(document.getElementById('name').remove());
    $('<input>').attr({'type':'text', 'name':'name', 'id': 'name'}).addClass('form-control').appendTo(input);

    var input = document.getElementById('inputSurname');
    $(document.getElementById('surname').remove());
    $('<input>').attr({'type':'text', 'name':'name', 'id': 'surname'}).addClass('form-control').appendTo(input);

    var input = document.getElementById('inputBirthday');
    $(document.getElementById('birthday').remove());
    $('<input>').attr({'type':'text', 'name':'name', 'id': 'birthday'}).addClass('form-control').appendTo(input);

    var input = document.getElementById('inputSalary');
    $(document.getElementById('salary').remove());
    $('<input>').attr({'type':'text', 'name':'name', 'id': 'salary'}).addClass('form-control').appendTo(input);

    var input = document.getElementById('inputEmail');
    $(document.getElementById('email').remove());
    $('<input>').attr({'type':'text', 'name':'name', 'id': 'email'}).addClass('form-control').appendTo(input);

    var input = document.getElementById('inputAddress');
    $(document.getElementById('address').remove());
    $('<input>').attr({'type':'text', 'name':'name', 'id': 'address'}).addClass('form-control').appendTo(input);
}
