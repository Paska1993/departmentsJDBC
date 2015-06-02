/*********Department model********/
function Department(name,id) {
    this.name = name;
    this.id = id;
}

/*********Department List model********/

function DepartmentList(arr){
    this.list = arr ||  [];
    pageManager.drawDepartTable(this.list);
}

DepartmentList.prototype.add=  function(item){
    var index = this.list.length;
    this.list[index] = item;
    this.length = this.list.length;
    return index;
};

DepartmentList.prototype.delete=  function(index){
    this.list[index].remove();
    this.length = this.list.length;
    return index;
};

DepartmentList.prototype.get=  function(index){
    return this.list[index];
};
/****************end*******************/

function DepartmentTable() {}

DepartmentTable.prototype.drawDepartTable = function(data) {
    var container = document.getElementById('container');

    $('div').remove('#depTable');
    $('div').remove('#emplTable');
    $('div').remove('#editEmp');

    var depTable = $('<div></div>').attr('id','depTable').appendTo(container);
    var departmentTable = $('<table></table>').attr({'class':'table table-bordered', 'id': 'Deptable'}).appendTo(depTable);
    for(var i = 0; i < data.length; i++){
        var row = $('<tr></tr>').prop('id', data[i].id).appendTo(departmentTable);
        for (var j = 0; j < 4; j++) {
            var column = $('<td></td>').appendTo(row);
            if (j == 0) {
                $(document.createTextNode(data[i].name)).appendTo(column);
            }else if(j == 1){
                var editButton = $('<button></button>').bind('click',
                    new Department(data[i].name, data[i].id), function(event){
                        editDepartment.drawEditForm(event.data, null);
                        /***********************/
                }).addClass('btn btn-success').appendTo(column);
                $(document.createTextNode('Edit')).appendTo(editButton);
            }else if(j == 2){
                var deleteButton = $('<button></button>').prop('id','delete').bind('click',
                    new Department(data[i].name, data[i].id) , function(event){
                    console.log(event.data.name);
                        departmentController.deleteDep(event.data.id, event.data.name);
                }).addClass('btn btn-danger').appendTo(column);
                $(document.createTextNode('Delete')).appendTo(deleteButton);
            }else if(j == 3){
                var listButton = $('<button></button>').bind('click',new Department(data[i].name, data[i].id) , function (event){
                    employeeController.getEmployeesByDepartment(event.data.id);
                }).addClass('btn btn-info').appendTo(column);
                $(document.createTextNode('Employee`s')).appendTo(listButton);
            }
        }
    }
    var add = $('<button></button>').attr({'data-target':'#addModal','data-toggle': 'modal'}).bind('click', function(){
        addDepartment.drawAddForm(null);
    }).addClass('btn btn-success').appendTo(depTable);
    $(document.createTextNode('Add')).appendTo(add);
}

DepartmentTable.prototype.deleteRow = function(index){
    var id = '#'+index;
    console.log(id);
    $(id).remove();
}

DepartmentTable.prototype.addRow = function(data){

    var table = document.getElementById('#Deptable');

    var row = $('<tr></tr>').prop('id', data.id).appendTo(table);
    for (var j = 0; j < 4; j++) {
        var column = $('<td></td>').appendTo(row);
        if (j == 0) {
            $(document.createTextNode(data.name)).appendTo(column);
        }else if(j == 1){
            var editButton = $('<button></button>').addClass('btn btn-success').appendTo(column);
            $(document.createTextNode('Edit')).appendTo(editButton);
        }else if(j == 2){
            var deleteButton = $('<button></button>').prop('id','delete').bind('click', new Department(data.name, data.id) , function(event){
                console.log(event.data.name);
                pageManager.deleteDep(event.data.id, event.data.name);
            }).addClass('btn btn-danger').appendTo(column);
            $(document.createTextNode('Delete')).appendTo(deleteButton);
        }else if(j == 3){
            var listButton = $('<button></button>').addClass('btn btn-info').appendTo(column);
            $(document.createTextNode('Employee`s')).appendTo(listButton);
        }
    }

}
