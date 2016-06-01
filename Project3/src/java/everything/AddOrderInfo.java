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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import javax.servlet.http.HttpSession;

/**
 *
 * @author franklinwork
 */
public class AddOrderInfo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    public String insert_creditcard(Connection con, String f_name, String l_name, 
            String number, String email, String address, String credit, int oid){
        Statement stmt = null;
        ResultSet rs = null;
        String SQL = String.format("INSERT INTO creditcard VALUES('%s', '%s', '%s', '%s', '%s', '%s', %d)",
                f_name, l_name, number, email, address, credit, oid);
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(SQL);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return SQL;
    }
    
    public void insert_orderdetails(Connection con, String shipping, int oid){
        Statement stmt = null;
        ResultSet rs = null;
        
        String SQL = String.format("INSERT INTO order_details VALUES(%d, '%s')", oid, shipping);
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(SQL);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void insert_item(Connection con, int oid, String name, int quantity){
        Statement stmt = null;
        ResultSet rs = null;
        
        String SQL = String.format("INSERT INTO order_items VALUES (%d, '%s', %d)", oid, name, quantity);
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(SQL);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void insert_orderitems(HttpServletRequest request, Connection con, int oid){        
        HttpSession session = request.getSession(true);
        Cart shoppingcart = (Cart) session.getAttribute("shoppingcart");

        HashMap<Item, Integer> c = shoppingcart.getCart();
        for(Item i: c.keySet()){
            if (shoppingcart.getQuantity(i) > 0){
                insert_item(con, oid, shoppingcart.getName(i), shoppingcart.getQuantity(i));
            }
        }
    }
    
    public int get_oid(Connection con){
        Statement stmt = null;
        ResultSet rs = null;
        
        String SQL = "SELECT MAX(oid) AS max_oid FROM order_details";
        int max_oid = 0;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            
            rs.next();
            max_oid = rs.getInt("max_oid");
        } catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
        return max_oid + 1;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://sylvester-mccoy-v3.ics.uci.edu:3306/inf124grp31",
                "inf124grp31",
                "bRU@Eph2");
            
            String f_name = request.getParameter("f_name");
            String l_name = request.getParameter("l_name");
            String number = request.getParameter("phone_number");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String credit = request.getParameter("creditcard");
            String shipping = request.getParameter("shipping");
            int new_oid = get_oid(con);
            
            String dan = insert_creditcard(con, f_name, l_name, number, email,  address, credit, new_oid);
            insert_orderdetails(con, shipping, new_oid);
            insert_orderitems(request, con, new_oid);
            
            con.close();
            String orderdetailsJSP = "orderdetails.jsp";
            response.sendRedirect(orderdetailsJSP);
            return;
            //out.println(dan);
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
