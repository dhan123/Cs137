<html>
<head>
	<title> PHP test </title>
</head>
<body>
	<?php echo 
#	print_r($_GET);
	'Hello ' . htmlspecialchars($_GET["name"]) . '!';
	?>
</body>
</html>
