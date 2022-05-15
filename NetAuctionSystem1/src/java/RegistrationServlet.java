   import java.io.*;
   import java.sql.*;
   import javax.servlet.*;
   import javax.servlet.http.*;
   public class RegistrationServlet extends HttpServlet {
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    RequestDispatcher rd=null;
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException {
        String uname= req.getParameter("uname");
        String password= req.getParameter("password");
        String fname= req.getParameter("fname");
        String lname= req.getParameter("lname");
        String email= req.getParameter("email");
	String phno= req.getParameter("phno");
	String hno= req.getParameter("hno");
	String stno= req.getParameter("stno");
		String address= hno + stno;
		String city= req.getParameter("city");
		System.out.println("Address:"+address);
		String state= req.getParameter("state");
		String pin= req.getParameter("pin");
		String country= req.getParameter("country");
		
        RequestDispatcher rd;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/netauction","root","password");
            st = con.createStatement();
            int add=st.executeUpdate("insert into uinfo_master values('"+uname+"','"+password+"','"+fname+"','"+lname+"','"+email+"','"+phno+"','"+address+"','"+city+"','"+state+"','"+pin+"','"+country+"')");
			
            rd=req.getRequestDispatcher("insertsuccess.jsp");
            rd.forward(req,res);
        } catch(Exception e2) {
             rd=req.getRequestDispatcher("failure.jsp.jsp");
        }
    }
}