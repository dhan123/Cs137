<%-- 
    Document   : index
    Created on : May 27, 2016, 2:59:32 AM
    Author     : Sharon
--%>

<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Collections"%>
<%@page import="javax.servlet.ServletException"%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.http.*"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>

<%@page import="java.io.*,java.util.*"%>
<%@page import="javax.servlet.*" %>

 
<!DOCTYPE html>
<html>
    <head>
        <style>
            @font-face { font-family: Moon Flower; src: url('Moon Flower.ttf'); }
            @font-face { font-family: Moon Flower; font-weight: bold; src: url('Moon Flower Bold.ttf');}

            div{ width: 50%; height: 100%; float: left;text-align: center; font-size: 33px;font-weight: bold;}
            table {
                    /*border: 1px solid blue;*/
                    font-family: "Verdana";
                    border-spacing: 2em;
            }
            td {
                    /*border: 1px solid green;*/
                    text-align: center;
                    width: 500px;
            }
            p {
                    margin: 0;
            }
            img.table {
                    border: 3px solid black;
                    width: 250px;
                    height: 250px;
            }
            img.table:hover{ 
                    width: 400px;
                    height: 400px;
            }
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
            #sublink {
                font-family: Moon Flower;
                color: gray;
                text-decoration: none;
                font-size: 60px;
            }
            .category {
                    font-size:2em;
            }
            /*
            body{
                    background: rgba(242,246,248,1);
            }*/
        </style>

        <script type="text/javascript">

        </script>

        <br></br>
        <img id = "img1" src="banner.jpg">
        <!--<img id="img1" src="http://www.progressivegrocer.com/sites/default/files/styles/article-full/public/PG%20Articles/Fresh%20Foods_0.jpg?itok=bm6ELlOG" >-->
        <br></br>
        <!--<div><a href="MainPage.html"><img src="home.png", height="100px"></a></div>
        <div><a href="AboutUs.html"><img src="aboutus.png", height="100px"></a></div>-->
        <div><a href="index.jsp", id="link">Home</a></div>
        <div><a href="AboutUs.html", id="link">About Us</a></div>
        <div><a href="checkout.jsp", id="sublink">Checkout Page</a></div><div></div>
        <br></br>
    </head>
    <body>
        </br>
        <%--<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"--%>
            <!--url="jdbc:mysql://sylvester-mccoy-v3.ics.uci.edu:3306/inf124grp31"-->
            <!--user="inf124grp31"  password="bRU@Eph2"/>-->

        <%
            
            response.setContentType("text/html;charset=UTF-8");
        
            //Starts Session for Last 5        
            HttpSession b_session = request.getSession(true);
            ArrayList last = null;
            //checks if a session has been created
            if(b_session.getAttribute("last")==null){
                //do nothing
            }
            else{
                last = (ArrayList)b_session.getAttribute("last");

            }
            
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://sylvester-mccoy-v3.ics.uci.edu:3306/inf124grp31",
                "inf124grp31",
                "bRU@Eph2");
            
            Statement m1_stmt = null; ResultSet m1_rs = null;
            String M1SQL = "SELECT * FROM product WHERE P_Id='M1'";
            m1_stmt = con.createStatement();
            m1_rs = m1_stmt.executeQuery(M1SQL);
            m1_rs.next();
            
            Statement m2_stmt = null; ResultSet m2_rs = null;
            String M2SQL = "SELECT * FROM product WHERE P_Id='M2'";
            m2_stmt = con.createStatement();
            m2_rs = m2_stmt.executeQuery(M2SQL);
            m2_rs.next();

            
            Statement m3_stmt = null; ResultSet m3_rs = null;
            String M3SQL = "SELECT * FROM product WHERE P_Id='M3'";
            m3_stmt = con.createStatement();
            m3_rs = m3_stmt.executeQuery(M3SQL);
            m3_rs.next();
            
            Statement m4_stmt = null; ResultSet m4_rs = null;
            String M4SQL = "SELECT * FROM product WHERE P_Id='M4'";
            m4_stmt = con.createStatement();
            m4_rs = m4_stmt.executeQuery(M4SQL);
            m4_rs.next();

            Statement v1_stmt = null; ResultSet v1_rs = null;
            String V1SQL = "SELECT * FROM product WHERE P_Id='V1'";
            v1_stmt = con.createStatement();
            v1_rs = v1_stmt.executeQuery(V1SQL);
            v1_rs.next();
            
            Statement v2_stmt = null; ResultSet v2_rs = null;
            String V2SQL = "SELECT * FROM product WHERE P_Id='V2'";
            v2_stmt = con.createStatement();
            v2_rs = v2_stmt.executeQuery(V2SQL);
            v2_rs.next();

            
            Statement v3_stmt = null; ResultSet v3_rs = null;
            String V3SQL = "SELECT * FROM product WHERE P_Id='V3'";
            v3_stmt = con.createStatement();
            v3_rs = v3_stmt.executeQuery(V3SQL);
            v3_rs.next();
            
            Statement v4_stmt = null; ResultSet v4_rs = null;
            String V4SQL = "SELECT * FROM product WHERE P_Id='V4'";
            v4_stmt = con.createStatement();
            v4_rs = v4_stmt.executeQuery(V4SQL);
            v4_rs.next();

            Statement f1_stmt = null; ResultSet f1_rs = null;
            String F1SQL = "SELECT * FROM product WHERE P_Id='F1'";
            f1_stmt = con.createStatement();
            f1_rs = f1_stmt.executeQuery(F1SQL);
            f1_rs.next();
            
            Statement f2_stmt = null; ResultSet f2_rs = null;
            String F2SQL = "SELECT * FROM product WHERE P_Id='F2'";
            f2_stmt = con.createStatement();
            f2_rs = f2_stmt.executeQuery(F2SQL);
            f2_rs.next();

            
            Statement f3_stmt = null; ResultSet f3_rs = null;
            String F3SQL = "SELECT * FROM product WHERE P_Id='F3'";
            f3_stmt = con.createStatement();
            f3_rs = f3_stmt.executeQuery(F3SQL);
            f3_rs.next();
            
            Statement f4_stmt = null; ResultSet f4_rs = null;
            String F4SQL = "SELECT * FROM product WHERE P_Id='F4'";
            f4_stmt = con.createStatement();
            f4_rs = f4_stmt.executeQuery(F4SQL);
            f4_rs.next();

        
            out.println(
"		<p>\n" +
"		<table align=\"center\">\n" +
"			<tr>\n" +
"				<td class=\"category\">Meats</td>   <!--in every table row, there are different table data cells-->\n" +
"				<td class=\"category\">Vegetables</td>\n" +
"				<td class=\"category\">Fruits</td>\n" +
"			</tr>\n" +
"			<tr>\n" +
"\n" +
"            <tr>\n" +
"				<td><a href=\"Product?pid=m1\" name=\"m1\"><img class=\"table\" src=\"" + m1_rs.getString("main_photo") + "\" alt=\"" + m1_rs.getString("name") + "\"/></a><p>$" + m1_rs.getString("price") + "</p><p>" + m1_rs.getString("name") + "</p></td>\n" +
"\n" +
"				<td><a href=\"Product?pid=v1\" name=\"v1\"><img class=\"table\" src=\"" + v1_rs.getString("main_photo") + "\" alt=\"" + v1_rs.getString("name") + "\"/></a><p>$" + v1_rs.getString("price") + "</p><p>" + v1_rs.getString("name") + "</p></td>\n" +
"\n" +
"				<td><a href=\"Product?pid=f1\" name=\"f1\"><img class=\"table\" src=\"" + f1_rs.getString("main_photo") + "\" alt=\"" + f1_rs.getString("name") + "\"/></a><p>$" + f1_rs.getString("price") + "</p><p>" + f1_rs.getString("name") + "</p></td>\n" +
"			</tr>\n" +
"\n" +
"            <tr>\n" +
"				<td><a href=\"Product?pid=m2\" name=\"m2\"><img class=\"table\" src=\"" + m2_rs.getString("main_photo") + "\" alt=\"" + m2_rs.getString("name") + "\"/></a><p>$" + m2_rs.getString("price") + "</p><p>" + m2_rs.getString("name") + "</p></td>\n" +
"\n" +
"				<td><a href=\"Product?pid=v2\" name=\"v2\"><img class=\"table\" src=\"" + v2_rs.getString("main_photo") + "\" alt=\"" + v2_rs.getString("name") + "\"/></a><p>$" + v2_rs.getString("price") + "</p><p>" + v2_rs.getString("name") + "</p></td>\n" +
"\n" +
"				<td><a href=\"Product?pid=f2\" name=\"f2\"><img class=\"table\" src=\"" + f2_rs.getString("main_photo") + "\" alt=\"" + f2_rs.getString("name") + "\"/></a><p>$" + f2_rs.getString("price") + "</p><p>" + f2_rs.getString("name") + "</p></td>\n" +
"			</tr>\n" +
"\n" +
"            <tr>\n" +
"				<td><a href=\"Product?pid=m3\" name=\"m3\"><img class=\"table\" src=\"" + m3_rs.getString("main_photo") + "\" alt=\"" + m3_rs.getString("name") + "\"/></a><p>$" + m3_rs.getString("price") + "</p><p>" + m3_rs.getString("name") + "</p></td>\n" +
"\n" +
"				<td><a href=\"Product?pid=v3\" name=\"v3\"><img class=\"table\" src=\"" + v3_rs.getString("main_photo") + "\" alt=\"" + v3_rs.getString("name") + "\"/></a><p>$" + v3_rs.getString("price") + "</p><p>" + v3_rs.getString("name") + "</p></td>\n" +
"\n" +
"				<td><a href=\"Product?pid=f3\" name=\"f3\"><img class=\"table\" src=\"" + f3_rs.getString("main_photo") + "\" alt=\"" + f3_rs.getString("name") + "\"/></a><p>$" + f3_rs.getString("price") + "</p><p>" + f3_rs.getString("name") + "</p></td>\n" +
"			</tr>\n" +
"            <tr>\n" +
"				<td><a href=\"Product?pid=m4\" name=\"m4\"><img class=\"table\" src=\"" + m4_rs.getString("main_photo") + "\" alt=\"" + m4_rs.getString("name") + "\"/></a><p>$" + m4_rs.getString("price") + "</p><p>" + m4_rs.getString("name") + "</p></td>\n" +
"\n" +
"				<td><a href=\"Product?pid=v4\" name=\"v4\"><img class=\"table\" src=\"" + v4_rs.getString("main_photo") + "\" alt=\"" + v4_rs.getString("name") + "\"/></a><p>$" + v4_rs.getString("price") + "</p><p>" + v4_rs.getString("name") + "</p></td>\n" +
"\n" +
"				<td><a href=\"Product?pid=f4\" name=\"f4\"><img class=\"table\" src=\"" + f4_rs.getString("main_photo") + "\" alt=\"" + f4_rs.getString("name") + "\"/></a><p>$" + f4_rs.getString("price") + "</p><p>" + f4_rs.getString("name") + "</p></td>\n" +
"			</tr>\n" +
"		</table>\n" +
"	</p>\n" + 
"       <br><br><br> <div style=\"font-weight:normal\"> <b>Your Last Viewed Items:</b>");
        if (b_session.getAttribute("last") == null) {
            ;
        } else {
            Collections.reverse(last);        
            for(int i=0;i<last.size(); i++){
                out.println(last.get(i) + " ");
            }
            Collections.reverse(last);
        }
        out.print("</div>	</body>\n" +
        "</html>");
        
//        <p>
//            <table align="center">
//                <tr>
//                    <td class="category">Meats</td>   <!--in every table row, there are different table data cells-->
//                    <td class="category">Vegetables</td>
//                    <td class="category">Fruits</td>
//                </tr>
//                <tr>
//<!--                    <td><a href="Product?pid=m1" name="m1"><img class="table" src="http://www.seriouseats.com/images/2015/04/20150408-canadian-bacon-taste-test.jpg" alt="Bacon"/></a><p>$50.00</p><p>Canadian Bacon</p></td>
//                    <td><a href="Product?pid=v1" name="v1"><img class="table" src="https://dbjpq4m8xws63.cloudfront.net/gallery/article/136129-2669" alt="Baby Carrots"/></a><p>$5.00</p><p>Baby Carrots</p></td>
//                    <td><a href="Product?pid=f1" name="f1"><img class="table" src="http://www.followingthenerd.com/site/wp-content/uploads/apple1.jpg" alt="Apple"/></a><p>$9.00</p><p>Apples</p></td>-->
//                </tr>
//
//                <tr>
//                    <td><a href="Product?pid=m2"><img class="table" src="http://www.glatt-organics.com/wp-content/uploads/2013/08/iStock_000010753409Large.jpg" alt="Chicken Breast"/></a><p>$30.00</p><p>Chicken Breast</p></td>
//                    <td><a href="Product?pid=v2"><img class="table" src="http://www.specialtyproduce.com/sppics/581.png" alt="Romaine Lettuce"/></a><p>$10.00</p><p>Romaine Lettuce</p></td>
//                    <td><a href="Product?pid=f2"><img class="table" src="http://dreamatico.com/data_images/banana/banana-3.jpg" alt="Banana"/></a><p>$1.00</p><p>Bananas</p></td>
//                </tr>
//
//                <tr>
//                    <td><a href="Product?pid=m3"><img class="table" src="http://cdn1.bigcommerce.com/n-ww20x/uvsd1rv/products/80/images/280/Ribeye_Steak__19258.1385953288.1280.1280.jpg?c=2" alt="Rib Eye Steak"/></a><p>$70.00</p><p>Rib Eye Steak</p></td>
//                    <td><a href="Product?pid=v3"><img class="table" src="http://www.kontrolmag.com/wp-content/uploads/2015/05/Spinach.jpg" alt="Spinach"/></a></p>$33.00</p><p>Spinach</p></td>
//                    <td><a href="Product?pid=f3"><img class="table" src="https://upload.wikimedia.org/wikipedia/commons/4/43/Pitaya_cross_section_ed2.jpg" alt="Dragonfruit"/></a></p>$44.00</p><p>Dragonfruit</p></td>
//                </tr>
//
//                <tr>
//                    <td><a href="Product?pid=m4"><img class="table" src="http://sushistik.com.ua/image/data/Salmon.png" alt="Salmon"/></a><p>$100.00</p><p>Salmon</p></td>
//                    <td><a href="Product?pid=v4"><img class="table" src="http://www.legacygreens.com/wp-content/uploads/2016/03/Yellow-onion.jpg" alt="Yellow Onion"/></a><p>$12.00</p><p>Yellow Onions</p></td>
//                    <td><a href="Product?pid=f4"><img class="table" src="https://upload.wikimedia.org/wikipedia/commons/c/c4/Orange-Fruit-Pieces.jpg" alt="Oranges"/></a><p>$17.00</p><p>Oranges</p></td>
//                </tr>
//            </table>
//        </p>
//        </br>
//        </br>
//        <h2>Last 5 Viewed Products: </h2>   
        con.close();
                
        %>
    </body>
</html>
