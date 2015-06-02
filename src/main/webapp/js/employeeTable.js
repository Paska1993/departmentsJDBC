
function Employee(id, name, surname,birthday, salary, address, email, department_id){
    this.id= id;
    this.name=name;
    this.surname=surname;
    this.birthday= birthday;
    this.salary= salary;
    this.address =address;
    this.email =email;
    this.department_id= department_id;
}

function EmployeeTable(){}

EmployeeTable.prototype.drawEmplTable = function(employees){
    var container = document.getElementById('container');

    /*clean page*/
    $('div').remove('#depTable');
    $('div').remove('#emplTable');
    $('div').remove('#editEmp');

    var emplTable = $('<div></div>').attr('id','emplTable').appendTo(container);

    var tbl = $('<table></table>').addClass('table table-bordered').appendTo(emplTable);
    for (var i = 0; i < employees.length; i++) {

        var row = $('<tr></tr>').prop('id', employees[i].id).appendTo(tbl);

        for (var j = 0; j < 8; j++) {
            var column = $('<td></td>').appendTo(row);
            if(j==0) {
                $(document.createTextNode(employees[i].name)).appendTo(column);
            }else if(j == 1){
                $(document.createTextNode(employees[i].surname)).appendTo(column);
            }else if(j == 2){
                $(document.createTextNode(employees[i].birthday)).appendTo(column);
            }else if(j == 3){
                $(document.createTextNode(employees[i].salary)).appendTo(column);
            }else if(j == 4){
                $(document.createTextNode(employees[i].address)).appendTo(column);
            }else if(j == 5){
                $(document.createTextNode(employees[i].email)).appendTo(column);
            }else if(j == 6){
                console.log(employees[i].department_id);
                var editButton = $('<button></button>').bind('click', new Employee(employees[i].id, employees[i].name, employees[i].surname,
                    employees[i].birthday, employees[i].salary, employees[i].address, employees[i].email, employees[i].department_id), function(event){
                        editEmployee.drawEditForm(event.data, null);
                    }).addClass('btn btn-success').appendTo(column);
                $(document.createTextNode('Edit')).appendTo(editButton);
            }else if(j == 7){
                var deleteButton = $('<button></button>').prop('id','delete').bind('click',
                    {id : employees[i].id} , function(event){
                        console.log(event.data.id);
                        employeeController.deleteEmployee(event.data.id);
                    }).addClass('btn btn-danger').appendTo(column);
                $(document.createTextNode('Delete')).appendTo(deleteButton);
            }
        }
    }
    var add = $('<button></button>').attr({'data-target':'#addEmployeeModal','data-toggle': 'modal'}).bind('click', function(){
        employeeController.getEmployeesList();
    }).addClass('btn btn-success').appendTo(emplTable);
    $(document.createTextNode('Add')).appendTo(add);
}

EmployeeTable.prototype.deleteRow = function(index){
    var id = '#'+index;
    console.log(id);
    $(id).remove();
}

