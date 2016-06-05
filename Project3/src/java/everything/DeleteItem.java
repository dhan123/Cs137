package everything;

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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Daniel
 */
public class DeleteItem extends HttpServlet {

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
        
        HttpSession session = request.getSession(true);
        String product = request.getParameter("name");
        Cart removeme = new Cart();        

        //product = product.replaceAll("\\s","");
        if(session.getAttribute("shoppingcart")==null){
            removeme.createCart();
        }
        else{
            removeme = (everything.Cart)session.getAttribute("shoppingcart");
            everything.Item i = removeme.getItem(product);
            removeme.setQuantity(i, 0);
        }
        //synchronized(session){
        session.setAttribute("shoppingcart", removeme);
  
        response.sendRedirect("checkout.jsp");
        return;
        
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//          out.println("<!DOCTYPE html>\n" +
//"<html>\n" +
//"	<head>\n" +
//"		<style>\n" +
//"			@font-face { font-family: Moon Flower; src: url('Moon Flower.ttf'); }\n" +
//"			@font-face { font-family: Moon Flower; font-weight: bold; src: url('Moon Flower Bold.ttf');}\n" +
//"\n" +
//"			div{ width: 50%; height: 100%; float: left;text-align: center; font-size: 33px;font-weight: bold;}\n" +
//"			\n" +
//"			p {\n" +
//"				margin: 0;\n" +
//"				font-size: 30px;\n" +
//"				text-align: center;\n" +
//"			}\n" +
//"			img.table {\n" +
//"				border: 3px solid black;\n" +
//"				width: 250px;\n" +
//"				height: 250px;\n" +
//"			}\n" +
//"			img.table:hover{ \n" +
//"				width: 400px;\n" +
//"				height: 400px;\n" +
//"			}\n" +
//"			#img1 {\n" +
//"				margin-right: auto;\n" +
//"				margin-left: auto;\n" +
//"				display: block;\n" +
//"				max-width: 100%;\n" +
//"				width: auto;\n" +
//"				height: auto;\n" +
//"				text-align: center;\n" +
//"			}\n" +
//"			#link {\n" +
//"				font-family: Moon Flower;\n" +
//"				color: gray;\n" +
//"				text-decoration: none;\n" +
//"				font-size: 80px;\n" +
//"			}\n" +
//"                       #sublink {\n" +
//"                          font-family: Moon Flower;\n" +
//"                          color: gray;\n" +
//"                          text-decoration: none;\n" +
//"                          font-size: 60px;\n" +
//"                       }\n" +
//"			.category {\n" +
//"				font-size:2em;\n" +
//"			}\n" +
//"		</style>\n" +
//"		<br></br>\n" +
//"		<img id = \"img1\" src=\"banner.jpg\">\n" +
//"		<br></br>\n" +
//"		<div><a href=\"index.jsp\", id=\"link\">Home</a></div>\n" +
//"		<div><a href=\"AboutUs.html\", id=\"link\">About Us</a></div>\n" +
//"               <div><a href=\"checkout.jsp\", id=\"sublink\">Checkout Page</a></div>\n" +
//"		<br></br>\n" +
//"	</head>\n" +
//"	<body>\n" +
//"		<br>'" +  
//"		<br></br>\n" +
//"		<br></br>\n" + 
//"		<p>\n" +
//"			You have removed " + product + " from Cart!	Amount of " + product + "(s): 0	\n");
//
//          out.print(
//"	</p>\n" +
//"	</body>\n" +
//"</html>");
//        }
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