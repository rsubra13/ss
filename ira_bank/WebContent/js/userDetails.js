function editUser(id) {
	console.log("comes here")
	$.get("get/" + id, function(result) {
		console.log("comes out");
		console.log(result);
		
		$("#UserDetailsDialog").html(result);

		$('#UserDetailsDialog').dialog("option", "title", 'Edit User Details');

		$("#UserDetailsDialog").dialog('open');

		initializeDatePicker();
	
	});
}

function initializeDatePicker() {
	$(".datepicker1").datepicker({
		dateFormat : "yyyy-mm-dd",
		changeMonth : true,
		changeYear : true,
		showButtonPanel : true
	});
}

function resetDialog(form) {

	form.find("input").val("");
}

$(document).ready(function() {

	$('#UserDetailsDialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 800,
		buttons : {
			"Save" : function() {
				$('#userDetailsForm').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#userDetailsForm'));

			$(this).dialog('close');
		}
	});

	initializeDatePicker();
});
