<%-- 
    Document   : index
    Created on : May 26, 2016, 11:43:53 PM
    Author     : franklinwork
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="everything.Cart"%>
<%@page import="everything.Item"%>
<%@page import="java.util.HashMap"%>


<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html>
    <head>
        <style>
            @font-face { font-family: Moon Flower; src: url('Moon Flower.ttf'); }
            @font-face { font-family: Moon Flower; font-weight: bold; src: url('Moon Flower Bold.ttf');}

            * {
                font-family: Verdana;
                font-size: 15px;
            }
            
            div{width: 100%; height: 100%; float: center; text-align: center}

            #aboutlink{ width: 50%; height: 100%; float: right;text-align: center; font-size: 33px;font-weight: bold;}
            #homelink{ width: 50%; height: 100%; float: left;text-align: center; font-size: 33px;font-weight: bold;}

            #img1 {
                margin-right: auto;
                margin-left: auto;
                display: block;
	 	max-width: 100%;
                width: auto;
                height: auto;
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

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"> </script>
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
                var addr_patt = /^[0-9]+[ ]+[A-Za-z ]+/g;
		var email_patt = /^[A-Za-z0-9]+@[A-Za-z0-9]+\.[A-Za-z0-9]+/g;
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
		var email_result = email.match(email_patt);
                var shipping_option = document.getElementById("regular").value;
                var product_id = document.getElementById("p_id").value.toUpperCase();

                if (document.getElementById('1day').checked) {
                    shipping_option = document.getElementById('1day').value;
                }
                if (document.getElementById('2day').checked) {
                    shipping_option = document.getElementById('2day').value;
                }
		if ( !(product_id in products) ) {
		    alert("Error: invalid product id");
		    return false;	
		} else if (qty_result == null || qty.length != qty_result[0].length) {
                    alert("Error: invalid quantity");
                    return false;
                } else if ( f_name_result == null || f_name.length != f_name_result[0].length) {
                    alert("Error: invalid first name");
                    return false;
                } else if ( l_name_result  == null || l_name.length != l_name_result[0].length) {
                    alert("Error: invalid last name");
                    return false;
	        } else if (phone_number.length != 7 && phone_number.length != 10) {
                    alert("Error: invalid phone number");
                    return false;
		} else if (email_result == null || email.length == 0) {
		    alert("Error: invalid email address");
		    return false;
		} else if (shipping_addr_result == null || shipping_addr.length != shipping_addr_result[0].length) {
                    alert("Error: invalid shipping address");
                    return false;
		} else if (credit_result == null || creditcard.length != credit_result[0].length) {
                    alert("Error: invalid credit card number");
                    return false;
                              } else {
                    alert("Thank you for purchasing from us today!");
                    submit_this(f_name, l_name, email, products[product_id], prices[product_id], qty, shipping_option);
                    return true;
                }
            
            }
                
	    
	    }
	
        </script>


        <br></br>
        <img id="img1" src="banner.jpg" >
        <br></br>
        <div><a href="MainPage.html", id="homelink">Home</a></div>
        <div><a href="AboutUs.html", id="aboutlink">About Us</a></div>
        <br></br>
    </head>

    <body>
        
        <div>
           
            <p><HR Width="60%"></p>

           <%
               HttpSession a_session = request.getSession(true);
               
               Cart session_cart = (Cart)a_session.getAttribute("shoppingcart");
               
               HashMap<Item, Integer> c = session_cart.getCart();
               for (Item i: c.keySet()){
                   if(session_cart.getQuantity(i) > 0){
                       out.println("Name: " + session_cart.getName(i) + "Price: " + session_cart.getPrice(i) +
                               "Quantity: " + session_cart.getQuantity(i));
                       %>
                        <p><HR Width="60%"></p>
                        <%

                   }
               }
           //String[] name = cart.getName();
           //int price = cart.getPrice();
           //int quantity = cart.getQuantity();
           
           /*for(int i = 0; i < 12; i++) {
               out.println("Your IP address is " + request.getRemoteAddr());
*/
               %>
               <!-- <p><HR Width="60%"></p> -->
               <%
          // }
           %>
        </div>
        
        <div>
        <form class="orderForm" action="purchased.php" onSubmit="return Validate();" method="post" align="left">
            <label>First Name</label><input id="f_name" type="textbox" name="f_name" value="John" required /> <br />
            <label>Last Name</label><input id="l_name" type="textbox" name="l_name" value="Doe" required /> <br />
            <label>Phone Number</label><input id="phone_number" type="number" name="phone_number" required /> <br />
            <label>Email</label> <input type="email" id="email" name="email" value="jdoe@gmail.com" required /> <br />
            <label>Shipping Address</label><input id="address" type="textbox" name="address" required /> <br />
            <label>Credit Card</label> <input id="creditcard" type="textbox" name="creditcard" value="12345123456789" required /> <br />

            <label>Shipping Option</label>
                <label><input class="radiobutton" id="1day" type="radio" name="shipping" value="1 Day"/>1 Day</label>
                <label><input class="radiobutton" id="2day" type="radio" name="shipping" value="2 Day"/>2 Day</label>
                <label><input class="radiobutton" id="regular" type="radio" name="shipping" value="Regular" checked="checked" />Regular</label><br />
            <label><input type="submit" value="Purchase" /></label>
        </form>
	<br></br><br></br>
	<p id="shipprice">Shipping Price: $5.00</p>
	<script>
	    $('input[name="shipping"]').on('change',function() {
		if ($(this).val()=='1 Day') {
		    $("#shipprice").text("Shipping Price: $15.00");
		} else if ($(this).val()=='2 Day') {
		    $("#shipprice").text("Shipping Price: $10.00");
		} else {
		    $("#shipprice").text("Shipping Price: $5.00");
		}
	    });
	</script>
        </div>
    </body>
</html>
