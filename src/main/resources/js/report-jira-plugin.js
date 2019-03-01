function showMessage() {
    alert( 'Привет всем присутствующим!' );
}

function getData() {
    AJS.$.ajax (
        {
            url :  "http://localhost:2990/jira/rest/report/1.0/message/name" ,
            type :  "POST" ,
            success :  function () {
                alert ("QWE");
            }
    });
}



function testPost(form) {
        // var data = getFormDataAsJSON(form);
        var elems = form.elements;
        var salaryValue = form.salary.value;
        var closedClockFixValue = form.closedClockFix.value;
        var rollingHoursValue = form.rollingHours.value;
        var MyForm = JSON.stringify({"salary":salaryValue,"closedClockFix":closedClockFixValue,"rollingHours":rollingHoursValue});
        console.log(MyForm);
        $.ajax(
            {
                url: "http://localhost:2990/jira/rest/report/1.0/message/name",
                type: "POST",
                data: MyForm,
                dataType: "json",
                contentType : "application/json"
            }).done(function( data ) {
            for (var elem in data){
                if (data.hasOwnProperty(elem)) {
                    // alert("Key is " + elem + ", value is" + data[elem]);
                    var salary;
                    var closedClockFix;
                    var rollingHours;
                    var norma;
                    var primary
                    if(elem === 'salary'){
                        salary = Number(data[elem]);
                        $("#" + elem).html(data[elem]);
                    }
                    if(elem === 'closedClockFix'){
                        closedClockFix = Number(data[elem]);
                        $("#" + elem).html(data[elem]);
                    }
                    if(elem === 'rollingHours'){
                        rollingHours = Number(data[elem]);
                        $("#" + elem).html(data[elem]);
                    }
                    if(salary!==undefined && closedClockFix!==undefined && rollingHours!==undefined){
                        norma = Number(salary*0.5)
                        $("#norma").html(norma);
                        primary = Number((salary*0.5)+closedClockFix-rollingHours)
                        $("#primary").html(primary);
                    }

                }
            }
        });
}

function handleData(data) {
    alert(data);
    //do some stuff
}

// $(document).ready(function() {
//
//     $("#buttonSave").click(function(){
//
//         alert("Hello World!")
//
//     })
//
// });