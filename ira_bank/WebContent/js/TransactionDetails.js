function editTrans(id) {
	console.log("comes here")
	$.get("get/" + id, function(result) {
		console.log("comes out");
		console.log(result);
		
		$("#TransactionDetailsDialog").html(result);

		$('#TransactionDetailsDialog').dialog("option", "title", 'Edit User Details');

		$("#TransactionDetailsDialog").dialog('open');

		initializeDatePicker();
	
	});
}

function initializeDatePicker() {
	$(".datepicker").datepicker({
		dateFormat : "mm-dd-yyyy",
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
				$('#TransactionDetailsForm').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#TransactionDetailsForm'));

			$(this).dialog('close');
		}
	});

	initializeDatePicker();
});
