/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LinhVT
 */
@WebServlet(urlPatterns = {"/calculate"})
public class CalServlet extends HttpServlet {

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
            out.println("<html>\n"
                    + "    <head>\n"
                    + "        <title>TODO supply a title</title>\n"
                    + "        <meta charset=\"UTF-8\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "        <form action=\"calculate\" method=\"post\">\n"
                    + "            <table>\n"
                    + "                    <tr>\n"
                    + "                        <td>First:</td>\n"
                    + "                        <td><input type=\"number\" name=\"first\"></td>\n"
                    + "                    </tr>\n"
                    + "                    <tr>\n"
                    + "                        <td>Second:</td>\n"
                    + "                        <td><input type=\"number\" name=\"second\"></td>\n"
                    + "                    </tr>\n"
                    + "                    <tr>\n"
                    + "                        <td>Operator</td>\n"
                    + "                        <td>\n"
                    + "                            <select name=\"selection\">\n"
                    + "                                <option>+</option>\n"
                    + "                                <option>-</option>\n"
                    + "                                <option>*</option>\n"
                    + "                                <option>/</option>\n"
                    + "                            </select>\n"
                    + "                        </td>\n"
                    + "                    </tr>\n"
                    + "                    <tr>\n"
                    + "                        <td></td>\n"
                    + "                        <td>\n"
                    + "                            <input type=\"submit\" value=\"Compute\"/>\n"
                    + "                        </td>\n"
                    + "                    </tr>\n"
                    + "                    <tr>\n"
                    + "                        <td>Result:</td>\n"
                    + "                        <td><input type=\"text\" name=\"result\"></td>\n"
                    + "                    </tr>\n"
                    + "            </table>\n"
                    + "\n"
                    + "        </form>\n"
                    + "    </body>\n"
                    + "</html>");
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
//        processRequest(request, response);
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
        String first = request.getParameter("first");
        String second = request.getParameter("second");
        if (first.equals("") || second.equals("")) {
            response.sendRedirect("cal.html");
            return;
        }
        int result = 0;
        int a, b;
        a = Integer.parseInt(first);
        b = Integer.parseInt(second);
        String c = request.getParameter("selection");
        if (c.equals("+")) {
            result = a + b;
        }
        if (c.equals("-")) {
            result = a - b;
        }
        if (c.equals("*")) {
            result = a * b;
        }
        if (c.equals("/")) {
            if (b == 0) {
                response.sendRedirect("cal.html");
                return;
            }
            result = a / b;
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>\n"
                    + "    <head>\n"
                    + "        <title>TODO supply a title</title>\n"
                    + "        <meta charset=\"UTF-8\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "        <form action=\"calculate\" method=\"post\">\n"
                    + "            <table>\n"
                    + "                    <tr>\n"
                    + "                        <td>First:</td>\n"
                    + "                        <td><input type=\"number\" name=\"first\" value=" + a + "></td>\n"
                    + "                    </tr>\n"
                    + "                    <tr>\n"
                    + "                        <td>Second:</td>\n"
                    + "                        <td><input type=\"number\" name=\"second\" value=" + b + "></td>\n"
                    + "                    </tr>\n"
                    + "                    <tr>\n"
                    + "                        <td>Operator</td>\n"
                    + "                        <td>\n"
                    + "                            <select name=\"selection\">\n"
                    + "                                <option " + (c.equals("+") ? "selected=\"selected\"" : "") + ">+</option>\n"
                    + "                                <option " + (c.equals("-") ? "selected=\"selected\"" : "") + ">-</option>\n"
                    + "                                <option " + (c.equals("*") ? "selected=\"selected\"" : "") + ">*</option>\n"
                    + "                                <option " + (c.equals("/") ? "selected=\"selected\"" : "") + ">/</option>\n"
                    + "                            </select>\n"
                    + "                        </td>\n"
                    + "                    </tr>\n"
                    + "                    <tr>\n"
                    + "                        <td></td>\n"
                    + "                        <td>\n"
                    + "                            <input type=\"submit\" value=\"Compute\"/>\n"
                    + "                        </td>\n"
                    + "                    </tr>\n"
                    + "                    <tr>\n"
                    + "                        <td>Result:</td>\n"
                    + "                        <td><input type=\"text\" name=\"result\" value=" + result + "></td>\n"
                    + "                    </tr>\n"
                    + "            </table>\n"
                    + "\n"
                    + "        </form>\n"
                    + "    </body>\n"
                    + "</html>\n"
                    + "");
        }
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
