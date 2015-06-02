function DepartmentEditForm(){}

DepartmentEditForm.prototype.drawEditForm = function(Department, error){

    var container = document.getElementById('container');

    $('div').remove('#depTable');
    $('div').remove('#emplTable');
    $('div').remove('#editEmp');

    var addForm = $('<div></div>').attr('id', 'editEmp').css({ 'width': '400px', 'margin-left': '25%'}).appendTo(container);
    /******************Name div*****************/
    var nameDiv = $('<div></div>').addClass('form-group').appendTo(addForm);

    var nameLabel = $('<label></label>').attr({'for':'Ename'}).appendTo(nameDiv);
    $(document.createTextNode('Department name:')).appendTo(nameLabel);
    $('<input>').attr({'name':'name', 'type' :'type', 'id': 'Ename'}).addClass('form-control').val(Department.name).appendTo(nameDiv);
    if(error != null) {
        $('<p></p>').addClass('fa fa-times').css({'color': 'red', 'margin-top': '5px'}).append(error).appendTo(nameDiv);
    }
    /******************Add button div*****************/
    var addButtonDiv= $('<div></div>').addClass('form-group').appendTo(addForm);

    var submit =$('<button></button>').bind('click', function(){
        departmentController.editDepartment(Department.id, $('#Ename').val());
    }).css('marginRight', '10px').addClass('btn btn-primary').appendTo(addButtonDiv);
    $(document.createTextNode('Edit')).appendTo(submit);
}
