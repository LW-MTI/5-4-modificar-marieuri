/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ittepic.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.edu.ittepic.edu.EJB.EJBOperaciones;

/**
 *
 * @author marieuri
 */
@WebServlet(name = "ActualizaUsuario", urlPatterns = {"/ActualizaUsuario"})
public class ActualizaUsuario extends HttpServlet {
    @EJB
    private EJBOperaciones ejb;

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
            out.println("<title>Servlet ActualizaUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ActualizaUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
       response.setContentType("application/json;charset=UTF-8");
       //Obligar al cliente http a no guardar el resultado de este Servet en chace
       response.setHeader("Cache-Control","no-store");
       
       PrintWriter p= response.getWriter();
       //int idlugar, String nombreLugar,
                //String descripcion,char tipolugar
        int idusuario=Integer.parseInt(request.getParameter("idusuario"));
        String nombreusuario=request.getParameter("nombreusuario");
        String contrasena=request.getParameter("contrasena");
        String correoelectronico=request.getParameter("correoelectronico");
        //int idpais= Integer.parseInt(request.getParameter("idpais"));
       
       
      
       p.write(ejb.actualizaUsuario(idusuario,nombreusuario,contrasena,correoelectronico));
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
