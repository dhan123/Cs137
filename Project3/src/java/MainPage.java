/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
public class MainPage extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<style>\n" +
"			@font-face { font-family: Moon Flower; src: url('Moon Flower.ttf'); }\n" +
"			@font-face { font-family: Moon Flower; font-weight: bold; src: url('Moon Flower Bold.ttf');}\n" +
"\n" +
"			div{ width: 50%; height: 100%; float: left;text-align: center; font-size: 33px;font-weight: bold;}\n" +
"			table {\n" +
"				/*border: 1px solid blue;*/\n" +
"				font-family: \"Verdana\";\n" +
"				border-spacing: 2em;\n" +
"			}\n" +
"			td {\n" +
"				/*border: 1px solid green;*/\n" +
"				text-align: center;\n" +
"				width: 500px;\n" +
"			}\n" +
"			p {\n" +
"				margin: 0;\n" +
"			}\n" +
"			img.table {\n" +
"				border: 3px solid black;\n" +
"				width: 250px;\n" +
"				height: 250px;\n" +
"			}\n" +
"			img.table:hover{ \n" +
"				width: 400px;\n" +
"				height: 400px;\n" +
"			}\n" +
"			#img1 {\n" +
"				margin-right: auto;\n" +
"				margin-left: auto;\n" +
"				display: block;\n" +
"				max-width: 100%;\n" +
"				width: auto;\n" +
"				height: auto;\n" +
"				text-align: center;\n" +
"			}\n" +
"			#link {\n" +
"				font-family: Moon Flower;\n" +
"				color: gray;\n" +
"				text-decoration: none;\n" +
"				font-size: 80px;\n" +
"			}\n" +
"			.category {\n" +
"				font-size:2em;\n" +
"			}\n" +
"			/*\n" +
"			body{\n" +
"				background: rgba(242,246,248,1);\n" +
"			}*/\n" +
"		</style>");
            out.println("<script type=\"text/javascript\">\n" +
"\n" +
"		</script>\n" +
"\n" +
"		<br></br>\n" +
"		<img id = \"img1\" src=\"banner.jpg\">\n" +
"		<!--<img id=\"img1\" src=\"http://www.progressivegrocer.com/sites/default/files/styles/article-full/public/PG%20Articles/Fresh%20Foods_0.jpg?itok=bm6ELlOG\" >-->\n" +
"		<br></br>\n" +
"		<!--<div><a href=\"index.html\"><img src=\"home.png\", height=\"100px\"></a></div>\n" +
"		<div><a href=\"AboutUs.html\"><img src=\"aboutus.png\", height=\"100px\"></a></div>-->\n" +
"		<div><a href=\"MainPage\", id=\"link\">Home</a></div>\n" +
"		<div><a href=\"AboutUs.html\", id=\"link\">About Us</a></div>\n" +
"		<br></br>\n" +
"	</head>\n" +
"\n" +
"	<body>\n" +
"		<br>\n" +
"		<p>\n" +
"		<table align=\"center\">\n" +
"			<tr>\n" +
"				<td class=\"category\">Meats</td>   <!--in every table row, there are different table data cells-->\n" +
"				<td class=\"category\">Vegetables</td>\n" +
"				<td class=\"category\">Fruits</td>\n" +
"			</tr>\n" +
"			<tr>\n" +
"				<td><a href=\"Product?pid=m1\" name=\"m1\"><img class=\"table\" src=\"http://www.seriouseats.com/images/2015/04/20150408-canadian-bacon-taste-test.jpg\" alt=\"Bacon\"/></a><p>$50.00</p><p>Canadian Bacon</p></td>\n" +
"\n" +
"				<td><a href=\"Product?pid=v1\" name=\"v1\"><img class=\"table\" src=\"https://dbjpq4m8xws63.cloudfront.net/gallery/article/136129-2669\" alt=\"Baby Carrots\"/></a><p>$5.00</p><p>Baby Carrots</p></td>\n" +
"\n" +
"				<td><a href=\"Product?pid=f1\" name=\"f1\"><img class=\"table\" src=\"http://www.followingthenerd.com/site/wp-content/uploads/apple1.jpg\" alt=\"Apple\"/></a><p>$9.00</p><p>Apples</p></td>\n" +
"			</tr>\n" +
"\n" +
"            <tr>\n" +
"				<td><a href=\"Product?pid=m2\" name=\"m2\"><img class=\"table\" src=\"http://www.glatt-organics.com/wp-content/uploads/2013/08/iStock_000010753409Large.jpg\" alt=\"Chicken Breast\"/></a><p>$30.00</p><p>Chicken Breast</p></td>\n" +
"\n" +
"                <td><a href=\"Product?pid=v2\" name=\"v2\"><img class=\"table\" src=\"http://www.specialtyproduce.com/sppics/581.png\" alt=\"Romaine Lettuce\"/></a><p>$10.00</p><p>Romaine Lettuce</p></td>\n" +
"\n" +
"                <td><a href=\"Product?pid=f2\" name=\"f2\"><img class=\"table\" src=\"http://dreamatico.com/data_images/banana/banana-3.jpg\" alt=\"Banana\"/></a><p>$1.00</p><p>Bananas</p></td>\n" +
"            </tr>\n" +
"\n" +
"            <tr>\n" +
"				<td><a href=\"Product?pid=m3\" name=\"m3\"><img class=\"table\" src=\"http://cdn1.bigcommerce.com/n-ww20x/uvsd1rv/products/80/images/280/Ribeye_Steak__19258.1385953288.1280.1280.jpg?c=2\" alt=\"Rib Eye Steak\"/></a><p>$70.00</p><p>Rib Eye Steak</p></td>\n" +
"\n" +
"                <td><a href=\"Product?pid=v3\" name=\"v3\"><img class=\"table\" src=\"http://www.kontrolmag.com/wp-content/uploads/2015/05/Spinach.jpg\" alt=\"Spinach\"/></a></p>$33.00</p><p>Spinach</p></td>\n" +
"\n" +
"                <td><a href=\"Product?pid=f3\" name=\"f3\"><img class=\"table\" src=\"https://upload.wikimedia.org/wikipedia/commons/4/43/Pitaya_cross_section_ed2.jpg\" alt=\"Dragonfruit\"/></a></p>$44.00</p><p>Dragonfruit</p></td>\n" +
"            </tr>\n" +
"\n" +
"            <tr>\n" +
"				<td><a href=\"Product?pid=m4\" name=\"m4\"><img class=\"table\" src=\"http://sushistik.com.ua/image/data/Salmon.png\" alt=\"Salmon\"/></a><p>$100.00</p><p>Salmon</p></td>\n" +
"\n" +
"                <td><a href=\"Product?pid=v4\" name=\"v4\"><img class=\"table\" src=\"http://www.legacygreens.com/wp-content/uploads/2016/03/Yellow-onion.jpg\" alt=\"Yellow Onion\"/></a><p>$12.00</p><p>Yellow Onions</p></td>\n" +
"\n" +
"                <td><a href=\"Product?pid=f4\" name=\"f4\"><img class=\"table\" src=\"https://upload.wikimedia.org/wikipedia/commons/c/c4/Orange-Fruit-Pieces.jpg\" alt=\"Oranges\"/></a><p>$17.00</p><p>Oranges</p></td>\n" +
"            </tr>\n" +
"		</table>\n" +
"	</p>\n" +
"	</body>\n" +
"</html>");

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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
