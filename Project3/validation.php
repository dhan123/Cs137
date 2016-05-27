<!DOCTYPE html>
<html>
<?php

    session_start();
    if(isset($_POST)) {
	if (empty($_POST['f_name'])) {
	    $_SESSION['errors']['f_name'] = 'First Name is missing';
	}
	if (empty($_POST['email'])) {
	    $_SESSION['errors']['email'] = 'Email is missing';
	}
?>

<head>
    <script src="script.js">
	var data = {};
	$(document).ready(function() {
	    $('input[type="submit"]').on('click',function() {
		resetErrors();
		var url = 'purchased.php';
		$.each($('form input, form select'), function(i,v) {
		    if (v.type !== 'submit') {
			data[v.name] = v.value;
		    }
		});
	    $.ajax({
		dataType: 'json',
		type: 'POST',
		url: url,
		data: data,
		succes: function(resp) {
		    if (resp === true) {
			$('form').submit();
			return false;
		    } else {
			$.each(resp, function(i,v) {
			    console.log(i + " => " + v);
			    var msg = '<label class = "error" for = "' + i + '">' + v + '</label>';
			    $('input[name="' + i + '"], select[name="' + i + '"]').addClass('inputTxtError').after(msg);
			});
			var keys = Object.keys(resp);
			$('input[name="' + i + '"]').focus();
		    }
		    return false;
		},
		error: function() {
		    console.log('there was a problem checking the fields');
		}
	    });
	    return flase;
	});
    });

    function resetErrors() {
	$('form input, form select').removeClass('inputTxtError');
	$('label.error').remove();
    }

    </script>

    <style>
	.error {
	    color: #ff0000;
	    font-size: 12px;
	    margin-top: 5px;
	    margin-bottom: 0;
	}
	
	.inputTxtError {
	    border: 1px solid #ff0000;
	    color: #0e0e0e;
	}
    </style>


</head>
<body>


</body>
</html>
