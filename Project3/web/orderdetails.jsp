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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    
        <script src = "https://ajax.googleapis.cpi/ajax/libs/jquery/2.2.2/jquery.min.js">
	</script>

        <br></br>
        <img id="img1" src="banner.jpg" alt="banner" >
        <!--
        <img id="img1" src="http://www.progressivegrocer.com/sites/default/files/styles/article-full/public/PG%20Articles/Fresh%20Foods_0.jpg?itok=bm6ELlOG" > -->
        <br></br>
        <div><a href="MainPage.html", id="link">Home</a></div>
        <div><a href="AboutUs.html", id="link">About Us</a></div>
        <br></br>
    </head>

    <body>

        <text id="ty">Thank You For Your Order!</text><hr><br>
            <p style="font-size:18px;">
                The details of your order are listed below. <br>
                Please purchase from us again!
            </p>
            <br></br>
            <h1>Order Info:</h1>
            <p style="font-size:24px;">
            <%
/*            int oid = Integer.parseInt(request.getParameter("oid"));
            int sum = 0;
       
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://sylvester-mccoy-v3.ics.uci.edu:3306/inf124grp31",
                "inf124grp31",
                "bRU@Eph2");
            
            // If the connection was successful, create a result set object
            Statement stmt = null;
            ResultSet rs = null;
            //SQL query command
            String SQL = "SELECT * FROM students";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            
            while (rs.next()) {
                int price = rs.getInt("product-price");
                int quantity = rs.getInt("quantity");
                sum += price * quantity;
                out.println("Item: " + rs.getString("product-id") + "Price: " +
                        price + "Quantity: " + quantity);
                out.println("</br>");
            }
            out.println("Total: " + sum);
*/            %>
            
            <p><HR Width="60%"></p>
            
            <%/*
                SQL = "something";
                stmt = null;
                rs = null;
                
                stmt = con.createStatement();
                rs = stmt.executeQuery(SQL);
                
                out.println("Order Shipped to: " + rs.getString("name") + "at "
                        + rs.getString("address") + "with shipping option " +
                        rs.getString("shipoption"));
            
            con.close();
           
*/            %> 
            
</body>
</html>
