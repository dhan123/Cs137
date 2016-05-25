<!DOCTYPE>
<html>
<?php
    $value = $_GET['f_name'];
    $formfield = $_GET['field'];

    if ($formfield == "f_name") {
	if (strlen($value) < 10) {
	    echo "Must be 10+ letters";
	} else {
	    echo "<span>Valid</span>";
	}
    }
?>

<head>
    <script src="script.js">
	function validate(field,query) {
	    var xmlhttp;
	    if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	    } else {
		xmlhttp = new AcriveXObject("Microsoft.XMLHTTP");
	    }
	    xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState != 4 && xmlhttp.status == 200) {
		    document.getElementById(field).innerHTML = "Validating...";
		} else if {
		    document.getElementById(field).innerHTML = xmlhttp.responseText;
		} else {
		    document.getElementById(field).innerHTML = "Error Occurred. <a href = 'MainPage.html'>Reload Or Try Again</a> the page.";
		}
	    }
	    xmlhttp.open("GET","validation.php?field=" + field + "&query=" + query, false);
	    xmlhttp.send();
	}
    </script>

</head>
<body>

</body>
</html>
