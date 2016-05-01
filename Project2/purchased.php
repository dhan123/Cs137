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
			#div1{
				width: 33%;
			}
			#div2{
				text-align: left;
				width: 33%;
				font-size: 20px;
				font-weight: normal;
			}
			h1{
				font-size: 24px;
				font-weight: bold;
			}
			p{
				padding-left: 5em;
			}
			#ty{
				font-weight: bold;
				font-size: 34px;
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
		<br></br><br></br><br></br>
		<br></br>
		<div id="div1"><br></br></div>
		<div id="div2">

		<text id="ty">Thank You For Your Order!</text><hr><br>
			<p style="font-size:18px;">
				The details of your order are listed below. <br>
				Please purchase from us again!
			</p>
			<br></br>
			<h1>Order:</h1> 
			<p style="font-size:24px;">
			Product ID: 
			<?php echo $_POST["p_id"] . " - ";
	            $myquery = "SELECT name FROM product WHERE P_Id = '" . $_POST["p_id"] . "';" ;
                $name = $conn->query($myquery);
                $result = $name->fetch(PDO::FETCH_ASSOC);
                echo $result['name'] . "<br>";
			?>
			Quantity: 
			<?php echo $_POST["quantity"] ?>
			<br>
			Total Price: $
			<?php
	            $myquery = "SELECT price FROM product WHERE P_Id = '" . $_POST["p_id"] . "';" ;
                $price = $conn->query($myquery);
                $result = $price->fetch(PDO::FETCH_ASSOC);
			 	echo $_POST["quantity"] * $result['price']; 
			?>
			</p>
			<br>
			<h1>Deliverd to:</h1>
			<p style="font-size:24px;">
			<?php echo $_POST["f_name"] . " " . $_POST["l_name"] ?><br>
			<?php echo $_POST["address"] . "<br>" . $_POST["phone_number"] ?><br>
			Shipping Option: <?php echo $_POST["shipping"] ?>
			</p><br>

			<h1>Payment Confirmation And Email:</h1>
			<p style="font-size:24px;">
			Credit Card: <?php echo $_POST["creditcard"] ?><br>
			Email: <?php echo $_POST["email"] ?><br>
			</p>
		</div>
</body>
</html>
