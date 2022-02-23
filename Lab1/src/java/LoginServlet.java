/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LinhVT
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        //get form data	
        String u = request.getParameter("user");
        String p = request.getParameter("password");

        String user = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("password");

//          
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < p.length(); i++) {
            if (Character.toString(p.charAt(i)).matches("[A-Z]")) {
                count1++;
            }
            if (Character.toString(p.charAt(i)).matches("[^a-zA-Z0-9]")) {
                count2++;
            }
        }
        if (count1 == 0 || count2 == 0) {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<html>\n" +
"    <head>\n" +
"        <title>TODO supply a title</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    </head>\n" +
"    <body>\n" +
"        <form action=\"LoginServlet\" method=\"post\">\n" +
"	<table>\n" +
                        "Please reinput password"+
"		<tr>\n" +
"		   <td>User:</td><td><input type=\"text\" name=\"user\"/></td>\n" +
"                </tr>\n" +
"		<tr>\n" +
"		   <td>Password:</td><td><input type=\"text\" name=\"password\"/></td>\n" +
"		</tr>\n" +
"		<tr>\n" +
"		   <td><input type=\"submit\" value=\"Login\"/></td>\n" +
"		</tr>\n" +
"	</table>\n" +
"	</form>\n" +
"    </body>\n" +
"</html>");
            } 
        } else {
            request.getRequestDispatcher("welcome").forward(request, response);
        }
    }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
