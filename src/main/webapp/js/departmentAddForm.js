function DepartmentAddForm(){}

DepartmentAddForm.prototype.drawAddForm = function(error){

    var container = document.getElementById('container');

    var modal = $('<div></div>').attr({'id':'addModal', 'tabindex':'-1', 'role': 'dialog',
        'aria-hidden': 'true'}).addClass('modal fade').appendTo(container);
    var dialog = $('<div></div>').addClass('modal-dialog').appendTo(modal);
    var content = $('<div></div>').addClass('modal-content').appendTo(dialog);
    var header = $('<div></div>').addClass('modal-header').appendTo(content);
    var button = $('<button></button>').attr({'type':'button', 'data-dismiss': 'modal',
        'aria-label' :'Close'}).addClass('close').appendTo(header);
    $('<span></span>').attr('aria-hidden','true').appendTo(button);
    $(document.createTextNode('x')).appendTo(button);

    var label = $('<h4></h4>').addClass('modal-title');
    $(document.createTextNode('Department')).appendTo(header);

    var body = $('<div></div>').addClass('modal-body').appendTo(content);
    var depForm = $('<form></form>').attr({'id': 'DepartmentAddForm'}).addClass('form-horizontal').appendTo(body);
    var formGroup = $('<div></div>').addClass('form-group').appendTo(depForm);
    var name = $('<label></label>').addClass('col-xs-5 control-label').appendTo(formGroup);
    $(document.createTextNode('Department name:')).appendTo(name);
    var input = $('<div></div>').addClass('col-xs-5').appendTo(formGroup);
    $('<input>').attr({'type':'text', 'name':'name', 'id': 'name'}).addClass('form-control').appendTo(input);

    if(error != null) {
        $('<p></p>').addClass('fa fa-times').css({'color': 'red'}).append(error).appendTo(input);
    }

    var formGroup = $('<div></div>').addClass('form-group').appendTo(depForm);
    var buttons = $('<div></div>').addClass('col-xs-7 col-xs-offset-7').appendTo(formGroup);

    var submit =$('<button></button>').attr({'type':'button','data-dismiss': 'modal'}).bind('click', function(){
        departmentController.addDepartment($('#name').val());
        $(document.getElementById('name').remove());
        $('<input>').attr({'type':'text', 'name':'name', 'id': 'name'}).addClass('form-control').appendTo(input);
    }).css('marginRight', '10px').addClass('btn btn-primary').appendTo(buttons);
    $(document.createTextNode('Add')).appendTo(submit);
    var cancel =$('<button></button>').attr({'type':'button', 'data-dismiss': 'modal'}).addClass('btn btn-default').appendTo(buttons);
    $(document.createTextNode('Cancel')).appendTo(cancel);
}
