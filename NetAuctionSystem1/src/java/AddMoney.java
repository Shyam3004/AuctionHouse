import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
   public class AddMoney extends HttpServlet {
    String username="";
    String password="";
    String type="";
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException {
        String username = req.getParameter("username");
        String amount = req.getParameter("amount");
     
	HttpSession sn = req.getSession(true);
     
		RequestDispatcher rd = null;
             
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/netauction","root","password");
            st = con.createStatement();
            rs = st.executeQuery("select * from wallet where username='"+username+"'");
            if(rs.next()) {
                int amount1=0;
               
                amount1 = Integer.parseInt(rs.getString(2))+Integer.parseInt(amount);
                
                String query = "update wallet set amount = ? where username = ?";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setInt   (1, amount1);
      preparedStmt.setString(2, username);
   
      // execute the java preparedstatement
      preparedStmt.executeUpdate();
           
           
               rd=req.getRequestDispatcher("addsuccess.jsp");  
           }
                else {
                  Statement st1 = con.createStatement();
            int add2=st1.executeUpdate("insert into wallet values('"+username+"','"+amount+"')");
           
               rd=req.getRequestDispatcher("addsuccess.jsp");
	       
            }		
     rd.forward(req,res);
              
         
        }
        catch(Exception e2)
         {
             
            System.out.println("Exception : "+e2.toString());
            
        }
    }
}