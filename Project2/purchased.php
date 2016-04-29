<!DOCTYPE html>
<html>

<?php
	include ('testingconnectionpdo.php');
	$query =  "insert into creditcard (P_id, FirstName, LastName, Quantity, Number, Email, Address, Credit, CurrentDate, shipping) VALUES ('" . 
		$_POST["p_id"] . "','" . $_POST["f_name"] . "','" . $_POST["l_name"] . "','" . $_POST["quantity"] .
		"','" . $_POST["phone_number"] . "','" .  $_POST["email"] . "','" . $_POST["address"] . "','" .
		$_POST["creditcard"] . "','1991-01-01','" . $_POST["shipping"]. "');";

	$conn->exec($query);

?> 

	<head>
		<style>
			@font-face { font-family: Moon Flower; src: url('Moon Flower.ttf'); }
			@font-face { font-family: Moon Flower; font-weight: bold; src: url('Moon Flower Bold.ttf');}

			* {
				font-family: Verdana;
				font-size: 15px;
			}

			div{ width: 50%; height: 100%; float: left;text-align: center; font-size: 33px;font-weight: bold;}
			#img1 {
				margin-right: auto;
				margin-left: auto;
				display: block;
				width: 1250px;
				height: 400px;
				text-align: center;
				
			}
			#link {
				font-family: Moon Flower;
				color: gray;
				text-decoration: none;
				font-size: 80px;
			}
			/*body{
				background: rgba(242,246,248,1);
			}*/
			img {
				width: 200px;
			}
			h2 {
				font-size: 1.25em;
			}

		</style>

		<br></br>
		<img id="img1" src="banner.jpg" alt="hei hitler" >
		<!--
		<img id="img1" src="http://www.progressivegrocer.com/sites/default/files/styles/article-full/public/PG%20Articles/Fresh%20Foods_0.jpg?itok=bm6ELlOG" > -->
		<br></br>
		<div><a href="MainPage.html", id="link">Home</a></div>
		<div><a href="AboutUs.html", id="link">About Us</a></div>
		<br></br>
	</head>

	<body>
		Welcome <?php echo $_POST["p_id"]; ?><br>
		Your email address is: <?php echo $_POST["email"]; ?>
</body>
</html>
