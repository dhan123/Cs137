<!DOCTYPE html>
<?php include ('testingconnectionpdo.php'); ?>
<html>
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
			img {
				width: 200px;
			}
			.Main {
				width: 500px;
				display: block;
				margin: 0 auto;
				text-align: center;
			}
            #div1{
            	width: 80%;
            	text-align: right;
            	font-size: 40px;
            	font-weight: normal;
            }
            #div2{
            	width: 20%;
            	text-align: left;
            }
            ul{
            	font-weight: normal;
            	font-size: 30px;

            }
            label{
            	display: inline-block;
            	float: left;
            	clear: left;
            	width: 150px;
            }
            input {
                font-family: Moon Flower;
                color: black;
                font-size: 19px;
                font-weight: bold;
                display: inline-block;
                float:left;
            }
            input.radiobutton {
            	display:inline-block;
            	float:left;
            	margin-left:1cm;
            }


		</style>

		<script type="text/javascript">
            function submit_this(firstname, lastname, email, item, price, quantity, shipping_option) {
                //window.location("testingconnectionpdo.php")

            }

            function Validate() {
                var products = [];
                products["M1"] = "Canadian Bacon";
                products["M2"] = "Chicken Breast(s)";
                products["M3"] = "Rib Eye Steak(s)";
                products["M4"] = "Salmon";
                products["V1"] = "Baby Carrots";
                products["V2"] = "Romaine Lettuce";
                products["V3"] = "Spinach";
                products["V4"] = "Yellow Onion(s)";
                products["F1"] = "Apple(s)";
                products["F2"] = "Banana(s)";
                products["F3"] = "Dragonfruit(s)";
                products["F4"] = "Orange(s)";

                var prices = [];
                prices["M1"] = 50;
                prices["M2"] = 30;
                prices["M3"] = 70;
                prices["M4"] = 100;
                prices["V1"] = 5;
                prices["V2"] = 10;
                prices["V3"] = 33;
                prices["V4"] = 12;
                prices["F1"] = 9;
                prices["F2"] = 1;
                prices["F3"] = 44;
                prices["F4"] = 17;

                var pattern = /[A-Za-z ][A-Za-z ]*/g;
                var num_patt = /^[0-9]{12,19}/g;
                var qty_patt = /^0*[1-9][0-9]*/g;
                var addr_patt = /^[0-9]*[A-Za-z ]*/g;
                var f_name = document.getElementById("f_name").value;
                var f_name_result = f_name.match(pattern);
                var l_name = document.getElementById("l_name").value;
                var l_name_result = l_name.match(pattern);
                var creditcard = document.getElementById("creditcard").value;
                var credit_result = creditcard.match(num_patt);
                var qty = document.getElementById("qty").value;
                var qty_result = qty.match(qty_patt);
                var shipping_addr = document.getElementById("address").value;
                var shipping_addr_result = shipping_addr.match(addr_patt);
                var phone_number = document.getElementById("phone_number").value;
                var email = document.getElementById("email").value;
                var shipping_option = document.getElementById("regular").value;
                var product_id = document.getElementById("p_id").value;

                if (document.getElementById('1day').checked) {
 					shipping_option = document.getElementById('1day').value;
				}
				if (document.getElementById('2day').checked) {
					shipping_option = document.getElementById('2day').value;
				}

                if (f_name.length != f_name_result[0].length) {
                    alert("Error");
                    location = location.reload();
                } else if (l_name.length != l_name_result[0].length) {
                	alert("Error");
                    location = location.reload();
                } else if (credit_result == null || creditcard.length != credit_result[0].length) {
                    alert("Error");
                    location = location.reload();
                } else if (qty_result == null || qty.length != qty_result[0].length) {
                    alert("Error");
                    location = location.reload();
                } else if (shipping_addr.length != shipping_addr_result[0].length) {
                	alert("Error");
                    location = location.reload();
                } else if (phone_number.length != 7 && phone_number.length != 10) {
                	alert("Error");
                    location = location.reload();
                } else if (!(product_id in products)) {
                    alert("Error");
                    location = location.reload();
                } else {
                    alert("Thank you for purchasing from us today!");
                    location = "MainPage.html";
                    submit_this(f_name, l_name, email, products[product_id], prices[product_id], qty, shipping_option);
                }
            
            }
                

		</script>

		<br></br>
		<img id="img1" src="banner.jpg" >
		<br></br>
		<div><a href="MainPage.html", id="link">Home</a></div>
		<div><a href="AboutUs.html", id="link">About Us</a></div>
		<br></br>
	</head>

	<body>
		<table align="center">
			<tr>
				<td><img src="http://www.followingthenerd.com/site/wp-content/uploads/apple1.jpg" class="Main" alt="Apple"/></td>
				<td width="300px"style="font-size:16px;"><b>
                    
                    <?php
                        $myquery = "SELECT name FROM product WHERE name = 'apple'";
                        $name = $conn->query($myquery);
                        $result = $name->fetch(PDO::FETCH_ASSOC);
                        echo $result['name'];
                    ?>

                </b><br>

                <?php
                        $myquery = "SELECT description FROM product WHERE name = 'apple'";
                        $description = $conn->query($myquery);
                        $result = $description->fetch(PDO::FETCH_ASSOC);
                        echo $result['description'];
                    ?>
                
				</td>
			</tr>
			
		</table>

		<table align="center">
			<tr>
				<td><img src=

                    <?php
                        $myquery = "SELECT link1 FROM product WHERE name = 'apple'";
                        $link1 = $conn->query($myquery);
                        $result = $link1->fetch(PDO::FETCH_ASSOC);
                        echo "'" . $result['link1'] . "'";
                    ?> 


                    alt="apple1" /></td>
				<td><img src=

                    <?php
                        $myquery = "SELECT link2 FROM product WHERE name = 'apple'";
                        $link2 = $conn->query($myquery);
                        $result = $link2->fetch(PDO::FETCH_ASSOC);
                        echo "'" . $result['link2'] . "'";
                    ?> 

                    alt="apple2" /></td>
				<td><img src=

                    <?php
                        $myquery = "SELECT link3 FROM product WHERE name = 'apple'";
                        $link3 = $conn->query($myquery);
                        $result = $link3->fetch(PDO::FETCH_ASSOC);
                        echo "'" . $result['link3'] . "'";
                    ?> 

                    alt="apple3" /></td>
			</tr>
		</table>

		<br></br>
		<div id="div2"><br></br></div>
		<div id="div2" style="font-size:20px;font-weight:bold;width:80%;"> 
			Description:
				<ul> 
					<li>From 
                    <?php
                        $myquery = "SELECT origin FROM product WHERE name = 'apple'";
                        $origin = $conn->query($myquery);
                        $result = $origin->fetch(PDO::FETCH_ASSOC);
                        echo $result['origin'];
                    ?> 

                    </li>
					
                    <li>Amount of apples per order: 
                    
                    <?php
                        $myquery = "SELECT amount FROM product WHERE name = 'apple'";
                        $amount = $conn->query($myquery);
                        $result = $amount->fetch(PDO::FETCH_ASSOC);
                        echo $result['amount'];
                    ?> 

                    </li>
					<li>Product ID: 

                    <?php
                        $myquery = "SELECT p_id FROM product WHERE name = 'apple'";
                        $p_id = $conn->query($myquery);
                        $result = $p_id->fetch(PDO::FETCH_ASSOC);
                        echo $result['p_id'];
                    ?>
                    </li>
				</ul>
		</div>


		<br></br>
		<div id="div1">
			<b style="font-size:40px;"> Price: </b> $
            <?php

            $myquery = "SELECT price FROM product WHERE name = 'apple'";
            $price = $conn->query($myquery);
            $result = $price->fetch(PDO::FETCH_ASSOC);
            echo $result['price'];
             ?> 
		</div>

		
		<br></br>
		<br></br>
		<br></br>
		<br></br>
		<br></br>
		<br></br>
		<br>
		<form class="orderForm" action="http://localhost/takehomeassignment/purchased.php" onSubmit="return Validate();" method="post" align="left">
			<label>Product ID</label><input id="p_id" type="textbox" name="p_id" required /> <br />
			<label>Quantity</label> <input id="qty" type="number" name ="quantity" value="1" required /> <br />
			<label>First Name</label><input id="f_name" type="textbox" name="f_name" value="John" required /> <br />
			<label>Last Name</label><input id="l_name" type="textbox" name="l_name" value="Doe" required /> <br />
			<label>Phone Number</label><input id="phone_number" type="number" name="phone_number" required /> <br />
			<label>Email</label> <input type="email" id="email" name="email" value="jdoe@gmail.com" required /> <br />
			<label>Shipping Address</label><input id="address" type="textbox" name="address" required /> <br />
			<label>Credit Card</label> <input id="creditcard" type="textbox" name="creditcard" value="12345123456789" required /> <br />
			
			<labeL>Shipping Option</label>
				<label><input class="radiobutton" id="1day" type="radio" name="shipping" value="1 Day"/>1 Day</label> 
				<label><input class="radiobutton" id="2day" type="radio" name="shipping" value="2 Day"/>2 Day</label> 
				<label><input class="radiobutton" id="regular" type="radio" name="shipping" value="Regular" checked="checked" />Regular</label><br />
			<label><input type="submit" value="Purchase" /></label>
		</form>

	</body>
</html>