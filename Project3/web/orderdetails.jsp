<%-- 
    Document   : orderdetails
    Created on : May 27, 2016, 1:02:24 AM
    Author     : franklinwork
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>


<!DOCTYPE html>
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

            #aboutlink{ font-family: Moon Flower; color: gray; text-decoration: none; width: 50%; height: 100%; float: right;text-align: center; font-size: 80px;font-weight: bold;}
            #homelink{ font-family: Moon Flower; color: gray; text-decoration: none; width: 50%; height: 100%; float: left;text-align: center; font-size: 80px;font-weight: bold;}

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
            #ty {
                font-size: 70px;
                font-family: Moon Flower;
                text-decoration: none;
            }
            ul{
                font-weight: normal;
                font-size: 30px;

            }
        </style>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    
        <script src = "https://ajax.googleapis.cpi/ajax/libs/jquery/2.2.2/jquery.min.js">
	</script>

        <br></br>
        <img id="img1" src="banner.jpg" alt="banner" >
        <!--
        <img id="img1" src="http://www.progressivegrocer.com/sites/default/files/styles/article-full/public/PG%20Articles/Fresh%20Foods_0.jpg?itok=bm6ELlOG" > -->
        <br></br>
        <div><a href="index.jsp", id="homelink">Home</a></div>
        <div><a href="AboutUs.html", id="aboutlink">About Us</a></div>
        <br></br>
    </head>

    <body>
        <div>
        <text id="ty">Thank You For Your Order!</text><hr><br>
            <p style="font-family: Moon Flower; font-size:40px;">
                The details of your order are listed below. <br>
                Please purchase from us again!
            </p>
            <br></br>
            <h1>Order Info:</h1>
            <p style="font-size:24px;">
        

            <p><HR Width="60%"></p>

            <%
            int oid = Integer.parseInt(request.getParameter("oid"));
            int total = 0;
       
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://sylvester-mccoy-v3.ics.uci.edu:3306/inf124grp31",
                "inf124grp31",
                "bRU@Eph2");
            
            // If the connection was successful, create a result set object
            Statement stmt = null;
            ResultSet rs = null;
            //SQL query command
            String SQL = String.format("SELECT * FROM order_items WHERE oid = %d", oid);
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            
            while (rs.next()) {
                String price_Q = String.format("SELECT price FROM product WHERE name = '%s'", rs.getString("name"));
                Statement stmt_price = null;
                ResultSet rs_price = null;
                stmt_price = con.createStatement();
                rs_price = stmt_price.executeQuery(price_Q);
                rs_price.next();
                
                int price = (int)rs_price.getDouble("price");
                int quantity = rs.getInt("quantity");
                
                out.println("Product: " + rs.getString("name") + "&nbsp&nbspPrice: $" + price + 
                        "&nbsp&nbspQuantity: " + quantity);
                total += price * quantity;
            %>
                <p><HR Width="60%"></p>
            <%
            }
            %>
            
            <p><HR Width="60%"></p>
            
            <%
                SQL = String.format("SELECT * FROM creditcard WHERE oid = '%s'", oid);
                stmt = null;
                rs = null;
                
                stmt = con.createStatement();
                rs = stmt.executeQuery(SQL);
                
                rs.next();
                
                String shipping_Q = String.format("SELECT shipping FROM order_details WHERE oid = '%d'", oid);
                Statement stmt_ship = null;
                ResultSet rs_ship = null;
                stmt_ship = con.createStatement();
                rs_ship = stmt_ship.executeQuery(shipping_Q);
                rs_ship.next();
                
                out.println("Order Shipped to: " + rs.getString("FirstName") + " " + rs.getString("LastName") + " at "
                        + rs.getString("Address") + " with shipping option " +
                        rs_ship.getString("shipping"));
       
                if (rs_ship.getString("shipping").equals("Regular")) {
                    total = total + 5;
                }
                if (rs_ship.getString("shipping").equals("2 Day")) {
                    total = total + 10;
                }
                if (rs_ship.getString("shipping").equals("1 Day")) {
                    total = total + 15;
                }
                out.println("<br></br>Total: $" + total);

            con.close();
           
            %> 
        </div>    
</body>
</html>
