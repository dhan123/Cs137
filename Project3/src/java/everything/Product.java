package everything;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Daniel
 */
public class Product extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
                //Starts Session for Last 5
        HttpSession session = request.getSession(true);
        ArrayList last = new ArrayList();

        //checks if a session has been created
        if(session.getAttribute("last")==null){
            last.add(request.getParameter("pid"));
        }
        else{
            last = (ArrayList)session.getAttribute("last");
            if(last.size()<5){
                if(!last.contains(request.getParameter("pid"))){
                        last.add(request.getParameter("pid"));
                }
                else{
                    last.remove(request.getParameter("pid"));
                    last.add(request.getParameter("pid"));
                }
            }
            else{
                if(!last.contains(request.getParameter("pid"))){
                    last.remove(0);
                    last.add(request.getParameter("pid"));
                }
                else{
                    last.remove(request.getParameter("pid"));
                    last.add(request.getParameter("pid"));
                }
            }
        }
        session.setAttribute("last", last);
        try {
            // Load the MYSQL JDBC driver.
            Class.forName("com.mysql.jdbc.Driver");
            
            
            // Create a connection to the Database with a specific user and 
            // password. Remember users have access to a specific tabel in the 
            // database.
            // URL: jdbc:mysql://<host_name>/<database_name>
//            Connection con = DriverManager.getConnection( "jdbc:mysql://sylvester-mccoy-v3.ics.uci.edu:3306/inf124grp31",
//                "inf124grp31",
//                "bRU@Eph2");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cs137", "danielhan", "12041992");
            
            Connection con = DriverManager.getConnection( "jdbc:mysql://sylvester-mccoy-v3.ics.uci.edu:3306/inf124grp31",
                "inf124grp31",
                "bRU@Eph2");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cs137", "danielhan", "12041992");
            // If the connection was successful, create a result set object
            Statement stmt = null;
            ResultSet rs = null;
            //SQL query command
            String SQL = "SELECT * FROM product WHERE P_Id = '" + request.getParameter("pid") + "'";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            
            
            // Creating a response object only if the connection was establihsed
            // successfully.
            response.setContentType("text/html;charset=UTF-8");

            try (PrintWriter out = response.getWriter()) {
                rs.next();
                out.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <style>\n" +
"            @font-face { font-family: Moon Flower; src: url('Moon Flower.ttf'); }\n" +
"            @font-face { font-family: Moon Flower; font-weight: bold; src: url('Moon Flower Bold.ttf');}\n" +
"\n" +
"            * {\n" +
"                font-family: Verdana;\n" +
"                font-size: 15px;\n" +
"            }\n" +
"\n" +
"            div.divLinks { width: 50%; height: 100%; float: left;text-align: center; font-size: 33px;font-weight: bold;}\n" +
"            #img1 {\n" +
"                margin-right: auto;\n" +
"                margin-left: auto;\n" +
"                display: block;\n" +
"                width: 1250px;\n" +
"                height: 400px;\n" +
"                text-align: center;\n" +
"\n" +
"            }\n" +
"            #link {\n" +
"                font-family: Moon Flower;\n" +
"                color: gray;\n" +
"                text-decoration: none;\n" +
"                font-size: 80px;\n" +
"            }\n" +
"            img {\n" +
"                width: 200px;\n" +
"            }\n" +
"            .Main {\n" +
"                width: 500px;\n" +
"                display: block;\n" +
"                margin: 0 auto;\n" +
"                text-align: center;\n" +
"            }\n" +
"            #div1{\n" +
"                width: 80%;\n" +
"                text-align: right;\n" +
"                padding-right: 25%;\n" +                  
"                font-size: 40px;\n" +
"                font-weight: normal;\n" +
"            }\n" +
"            #div2{\n" +
"                width: 20%;\n" +
"                text-align: left;\n" +
"                padding-left: 25%;\n" +                           
"            }\n" +
"            ul{\n" +
"                font-weight: normal;\n" +
"                font-size: 30px;\n" +
"\n" +
"            }\n" +
"            label{\n" +
"                display: inline-block;\n" +
"                float: left;\n" +
"                clear: left;\n" +
"                width: 150px;\n" +
"            }\n" +
"            input {\n" +
"                font-family: Moon Flower;\n" +
"                color: black;\n" +
"                font-size: 19px;\n" +
"                font-weight: bold;\n" +
"                display: inline-block;\n" +
"                float:left;\n" +
"            }\n" +
"            input.radiobutton {\n" +
"                display:inline-block;\n" +
"                float:left;\n" +
"                margin-left:1cm;\n" +
"            }\n" +
"            button {\n" +
"                display: block;\n" + 
"                margin: 0 auto;\n" + 
"            }\n" +    
"            #buttonWrapper {\n" + 
"               position: absolute;\n" +
"               left: 0;\n" + 
"               right: 0;\n" +                        
"            }\n" + 
"           #sublink {\n" +
"               font-family: Moon Flower;\n" +
"               color: gray;\n" +
"               text-decoration: none;\n" +
"               font-size: 60px;\n" +
"           }\n" +
"\n" +
"\n" +
"        </style>\n" +
"\n" +
"        <script type=\"text/javascript\">\n" +
"            function submit_this(firstname, lastname, email, item, price, quantity, shipping_option) {\n" +
"                //window.location(\"testingconnectionpdo.php\")\n" +
"\n" +
"            }\n" +
"\n" +
"            function Validate() {\n" +
"                var products = [];\n" +
"                products[\"M1\"] = \"Canadian Bacon\";\n" +
"                products[\"M2\"] = \"Chicken Breast(s)\";\n" +
"                products[\"M3\"] = \"Rib Eye Steak(s)\";\n" +
"                products[\"M4\"] = \"Salmon\";\n" +
"                products[\"V1\"] = \"Baby Carrots\";\n" +
"                products[\"V2\"] = \"Romaine Lettuce\";\n" +
"                products[\"V3\"] = \"Spinach\";\n" +
"                products[\"V4\"] = \"Yellow Onion(s)\";\n" +
"                products[\"F1\"] = \"Apple(s)\";\n" +
"                products[\"F2\"] = \"Banana(s)\";\n" +
"                products[\"F3\"] = \"Dragonfruit(s)\";\n" +
"                products[\"F4\"] = \"Orange(s)\";\n" +
"\n" +
"                var prices = [];\n" +
"                prices[\"M1\"] = 50;\n" +
"                prices[\"M2\"] = 30;\n" +
"                prices[\"M3\"] = 70;\n" +
"                prices[\"M4\"] = 100;\n" +
"                prices[\"V1\"] = 5;\n" +
"                prices[\"V2\"] = 10;\n" +
"                prices[\"V3\"] = 33;\n" +
"                prices[\"V4\"] = 12;\n" +
"                prices[\"F1\"] = 9;\n" +
"                prices[\"F2\"] = 1;\n" +
"                prices[\"F3\"] = 44;\n" +
"                prices[\"F4\"] = 17;\n" +
"\n" +
"                var pattern = /[A-Za-z ][A-Za-z ]*/g;\n" +
"                var num_patt = /^[0-9]{12,19}/g;\n" +
"                var qty_patt = /^0*[1-9][0-9]*/g;\n" +
"                var addr_patt = /^[0-9]*[A-Za-z ]*/g;\n" +
"                var f_name = document.getElementById(\"f_name\").value;\n" +
"                var f_name_result = f_name.match(pattern);\n" +
"                var l_name = document.getElementById(\"l_name\").value;\n" +
"                var l_name_result = l_name.match(pattern);\n" +
"                var creditcard = document.getElementById(\"creditcard\").value;\n" +
"                var credit_result = creditcard.match(num_patt);\n" +
"                var qty = document.getElementById(\"qty\").value;\n" +
"                var qty_result = qty.match(qty_patt);\n" +
"                var shipping_addr = document.getElementById(\"address\").value;\n" +
"                var shipping_addr_result = shipping_addr.match(addr_patt);\n" +
"                var phone_number = document.getElementById(\"phone_number\").value;\n" +
"                var email = document.getElementById(\"email\").value;\n" +
"                var shipping_option = document.getElementById(\"regular\").value;\n" +
"                var product_id = document.getElementById(\"p_id\").value;\n" +
"\n" +
"                if (document.getElementById('1day').checked) {\n" +
"                    shipping_option = document.getElementById('1day').value;\n" +
"                }\n" +
"                if (document.getElementById('2day').checked) {\n" +
"                    shipping_option = document.getElementById('2day').value;\n" +
"                }\n" +
"\n" +
"                if (f_name.length != f_name_result[0].length) {\n" +
"                    alert(\"Error\");\n" +
"                    location = location.reload();\n" +
"                } else if (l_name.length != l_name_result[0].length) {\n" +
"                    alert(\"Error\");\n" +
"                    location = location.reload();\n" +
"                } else if (credit_result == null || creditcard.length != credit_result[0].length) {\n" +
"                    alert(\"Error\");\n" +
"                    location = location.reload();\n" +
"                } else if (qty_result == null || qty.length != qty_result[0].length) {\n" +
"                    alert(\"Error\");\n" +
"                    location = location.reload();\n" +
"                } else if (shipping_addr.length != shipping_addr_result[0].length) {\n" +
"                    alert(\"Error\");\n" +
"                    location = location.reload();\n" +
"                } else if (phone_number.length != 7 && phone_number.length != 10) {\n" +
"                    alert(\"Error\");\n" +
"                    location = location.reload();\n" +
"                } else if (!(product_id in products)) {\n" +
"                    alert(\"Error\");\n" +
"                    location = location.reload();\n" +
"                } else {\n" +
"                    alert(\"Thank you for purchasing from us today!\");\n" +
"                    location = \"MainPage.html\";\n" +
"                    submit_this(f_name, l_name, email, products[product_id], prices[product_id], qty, shipping_option);\n" +
"                }\n" +
"            \n" +
"            }\n" +
"                \n" +
"\n" +
"        </script>\n" +
"\n" +
"        <br></br>\n" +
"        <img id=\"img1\" src=\"banner.jpg\" >\n" +
"        <br></br>\n" +
"        <div class=\"divLinks\"><a href=\"index.html\", id=\"link\">Home</a></div>\n" +
"        <div class=\"divLinks\"><a href=\"AboutUs.html\", id=\"link\">About Us</a></div>\n" +
"        <div><a href=\"checkout.jsp\", id=\"sublink\">Checkout Page</a></div>\n" +
"        <br></br>\n" +
"    </head>\n" +
"\n" +
"    <body>\n" +
"        <table align=\"center\">\n" +
"            <tr>\n" +
"                <td><img src=\n" +
                    rs.getString("main_photo") +
"			\" class=\"Main\" alt=\"productid: "+ rs.getString("p_id") + "/></td>\n" +
"\n" +
"                <td width=\"300px\"style=\"font-size:16px; left-padding:20%; right-padding:20%;\"><b>\n" +
"                    \n" + rs.getString("name") + "\n" + 
"\n" +
"                </b><br>\n" +
"\n" +
"                \n" + rs.getString("description") + 
"                    \n" +
"\n" +
"                </td>\n" +
"            </tr>\n" +
"\n" +
"        </table>\n" +
"\n" +
"        <table align=\"center\">\n" +
"            <tr>\n" +
"                <td><img src=\n" +
"\n" + rs.getString("link1") +
"\n" +
"\n" +
"                    alt=\"productid: "+ rs.getString("p_id") + "\"/></td>\n" +
"                <td><img src=\n" +
                        
                        
                        rs.getString("link2") + "\n" +
"\n" +
//"                    <?php\n" +
//"                        $myquery = \"SELECT link2 FROM product WHERE P_Id = '\" .  $_GET[\"productid\"] . \"';\";\n" +
//"                        $link2 = $conn->query($myquery);\n" +
//"                        $result = $link2->fetch(PDO::FETCH_ASSOC);\n" +
//"                        echo \"'\" . $result['link2'] . \"'\";\n" +
//"                    ?> \n" +
"\n" +
"                    alt=\"productid: "+ rs.getString("p_id") + "\"/></td>\n" +
"                <td><img src=\n" +
"\n" +
                        rs.getString("link3") + "\n" +
//"                    <?php\n" +
//"                        $myquery = \"SELECT link3 FROM product WHERE P_Id = '\" .  $_GET[\"productid\"] . \"';\";\n" +
//"                        $link3 = $conn->query($myquery);\n" +
//"                        $result = $link3->fetch(PDO::FETCH_ASSOC);\n" +
//"                        echo \"'\" . $result['link3'] . \"'\";\n" +
//"                    ?> \n" +
"\n" +
"                    alt=\"productid: "+ rs.getString("p_id") + "\"/></td>\n" +
"            </tr>\n" +
"        </table>\n" +
"\n" +
"        <br></br>\n" +
"        <div id=\"div2\"><br></br></div>\n" +
"        <div id=\"div2\" style=\"font-size:20px;font-weight:bold;width:80%;\">\n" +
"            Description:\n" +
"                <ul>\n" +
"                    <li>From\n" +
                        rs.getString("origin") + "\n" + 
//"                    <?php\n" +
//"                        $myquery = \"SELECT origin FROM product WHERE P_Id = '\" .  $_GET[\"productid\"] . \"';\";\n" +
//"                        $origin = $conn->query($myquery);\n" +
//"                        $result = $origin->fetch(PDO::FETCH_ASSOC);\n" +
//"                        echo $result['origin'];\n" +
//"                    ?>\n" +
"\n" +
"                    </li>\n" +
"\n" +
"                    <li>Amount of apples per order:\n" +
"\n" +
                        rs.getString("amount") + "\n" + 
//"                    <?php\n" +
//"                        $myquery = \"SELECT amount FROM product WHERE P_Id = '\" .  $_GET[\"productid\"] . \"';\";\n" +
//"                        $amount = $conn->query($myquery);\n" +
//"                        $result = $amount->fetch(PDO::FETCH_ASSOC);\n" +
//"                        echo $result['amount'];\n" +
//"                    ?>\n" +
"\n" +
"                    </li>\n" +
"                    <li>Product ID: \n" +
"\n" +
                        
                     rs.getString("p_id") + "\n" + 
//"                    <?php\n" +
//"                        $myquery = \"SELECT p_id FROM product WHERE P_Id = '\" .  $_GET[\"productid\"] . \"';\";\n" +
//"                        $p_id = $conn->query($myquery);\n" +
//"                        $result = $p_id->fetch(PDO::FETCH_ASSOC);\n" +
//"                        echo $result['p_id'];\n" +
//"                    ?>\n" +
"                    </li>\n" +
"                </ul>\n" +
"        </div>\n" +
"\n" +
"\n" +
"        <br></br>\n" +
"        <div id=\"div1\">\n" +
"            <b style=\"font-size:40px;\"> Price: </b> $\n" +
//"            <?php\n" +
//"\n" +
             rs.getString("price") + "\n" +
//"            $myquery = \"SELECT price FROM product WHERE P_Id = '\" .  $_GET[\"productid\"] . \"';\";\n" +
//"            $price = $conn->query($myquery);\n" +
//"            $result = $price->fetch(PDO::FETCH_ASSOC);\n" +
//"            echo $result['price'];\n" +
//"             ?>\n" +
"        </div>\n" +
"\n" +
"\n" +
"        <br></br>\n" +
"        <br></br>\n" +

"        <br>\n" + 
"        <div id=\"buttonWrapper\" style=\"text-align: center;\">\n" +  
"           <form action=\"ShoppingCart\">\n" +
"               <button style=\"text-align: center; width:150px;\" name=name"+ " value=\"" + rs.getString("name") + "\" >Add to Cart</button>\n" + 
"           </form>\n");
                out.println("        </div>\n");

/*                
                if(getServletContext().getAttribute(rs.getString("name")+"_access_count") == null) {
                    getServletContext().setAttribute(rs.getString("name")+"_access_count", 0);
                }
                
                if(session.getAttribute(rs.getString("history"))==null){
                } else {
                    if(getServletContext().getAttribute(session.getAttribute("history")+"_access_count") == null) {
                        getServletContext().setAttribute(session.getAttribute("history")+"_access_count", 0);
                    } else {
                        int previous_ac = (int) getServletContext().getAttribute(session.getAttribute("history")+"_access_count");
                        previous_ac--;
                        getServletContext().setAttribute(session.getAttribute("history")+"_access_count", previous_ac);
                    }
                }
                session.setAttribute("history", rs.getString("name"));

                int accessCount = (int) getServletContext().getAttribute(rs.getString("name")+"_access_count");
                accessCount++;
                getServletContext().setAttribute(rs.getString("name")+"_access_count", accessCount);

                int accessCount = 1;
                out.println("Access Count:" + accessCount);
*/                
                out.println("</body>");
                out.println("</html>");
            }
            con.close();
        
        } catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            processRequest(request, response);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {        
//        
//        processRequest(request, response);
//    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
