/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;

import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class SellProduct extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIRECTORY = "web\\Files";
    private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        RequestDispatcher rd;
        PreparedStatement ps;
        String fileName = null;
        String a=null,b=null;
        String a1,b1;
        
        HashMap hm = new HashMap(); 
        /*if (ServletFileUpload.isMultipartContent(request)) {
        // if not, we stop here
        return;
        }*/

        // configures some settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(THRESHOLD_SIZE);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setSizeMax(REQUEST_SIZE);
        HttpSession session = request.getSession(true);
      //  String userName = (String) session.getAttribute("username");

 
        // constructs the directory path to store upload file
         String uploadPath = getServletContext().getRealPath("productimages");
        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        try {
            try {

                List formItems = upload.parseRequest(request);
                Iterator iter = formItems.iterator();


                // iterates over form's fields
                while (iter.hasNext()) {
                    FileItem item = (FileItem) iter.next();
                    // processes only fields that are not form fields
                    if (!item.isFormField()) {
                        fileName = new File(item.getName()).getName();
                        String filePath = uploadDir + File.separator + fileName;
                        String[] arr = filePath.split("\\.");
                        long sysTime = System.currentTimeMillis();
                        
                        filePath = arr[0] +"."+arr[1];
                        File storeFile = new File(filePath);
                        // saves the file on disk
                        item.write(storeFile);
                        String dbFileName[] = fileName.split("\\.");
                        String dbFile = dbFileName[0]+"."+arr[1];
                      hm.put("filename",dbFile); 
                        
                    } else {
                         a = item.getFieldName();
                         //a1.item.getFieldName();
                         b = item.getString();
                        System.out.println(a + " - " + b);
                        
                         //hm.put("ownername", b); 
                        if(a != null && a.equalsIgnoreCase("seller")){
                            hm.put("seller", b); 
                            
                        }
                        
                           else if(a != null && a.equalsIgnoreCase("itemname")){
                            hm.put("itemname", b); 
                        }
                         else if(a != null && a.equalsIgnoreCase("category")){
                            hm.put("category", b); 
                        }
                            else if(a != null && a.equalsIgnoreCase("summary")){
                            hm.put("summary", b); 
                        }
                               else if(a != null && a.equalsIgnoreCase("startprice")){
                            hm.put("startprice", b); 
                        }
                                else if(a != null && a.equalsIgnoreCase("incrprice")){
                            hm.put("incrprice", b); 
                        }
                                 else if(a != null && a.equalsIgnoreCase("description")){
                            hm.put("description", b); 
                        }
                                  else if(a != null && a.equalsIgnoreCase("enddate")){
                            hm.put("enddate", b); 
                        }
                        else if(a != null && a.equalsIgnoreCase("fu")){
                            hm.put("asdf", b); 
                        }
                        
                    }
                }
               
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/netauction","root","password");
                    String sql = "insert into item_master(catid,itemname,descr,summary,startprice,incrprice,stdate,enddate,seller,bidcnt,filename) values('" + hm.get("category") + "','" + hm.get("itemname") + "','" + hm.get("description") + "','" + hm.get("summary") + "','" + hm.get("startprice") + "','" + hm.get("incrprice") + "',CURDATE(),'" + hm.get("enddate") + "','" + hm.get("seller") + "',1,'" + hm.get("filename") + "')";
                    Statement localStatement1 = con.createStatement();
	
      int i1 = localStatement1.executeUpdate(sql);
                        con.close();
                       
                        if (i1 != 0) {
                            request.setAttribute("id", "Your File Successfully Uploaded");
                            
                               rd = request.getRequestDispatcher("insertsuccess1.jsp");
                            rd.forward(request, response);  
                            
                        } else {
                            request.setAttribute("id", "invalid id");
                            rd = request.getRequestDispatcher("failure.jsp");
                            rd.forward(request, response);
                        }

                        } catch (Exception ex) {
                            System.out.println(ex);
                        } finally {
                            //out.close();
                        }
             
                System.out.println(fileName);
                request.setAttribute("message", "Upload has been done successfully!");



            } catch (Exception ex) {
                System.out.println(ex);
            } finally {
                out.close();
            }

        } catch (Exception ex) {
            request.setAttribute("message", "There was an error: " + ex.getMessage());
        }
        //getServletContext().getRequestDispatcher("/uploadsuccess.jsp").forward(request, response);
        /* finally {            
        out.close();
        } */
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
