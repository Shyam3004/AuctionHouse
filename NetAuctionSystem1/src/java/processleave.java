import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.*;
import java.sql.*;
import java.util.*;

public class processleave extends HttpServlet{

   public void doGet(HttpServletRequest request, HttpServletResponse response)
                                   throws ServletException,IOException{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
           String str[]=request.getRequestURI().toString().split("/");
            String username=str[3];
			System.out.println("leave management system");

            Connection conn = null;
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "elearning";
			String driver = "com.mysql.jdbc.Driver";
			String userName = "root";
			String password = "password";

			Statement st;
			try {
				Class.forName(driver).newInstance();
				conn = DriverManager.getConnection(url+dbName,userName,password);
				System.out.println("Connected to the database");


				ArrayList userList=null;
				String query = "select * from homework where username='"+username+"'";
				System.out.println("query " + query);
				st = conn.createStatement();
				ResultSet  rs = st.executeQuery(query);

                while(rs.next())
				{
                  userList =new ArrayList();
				  userList.add(rs.getString(1));
				  userList.add(rs.getString(2));
				  userList.add(rs.getString(3));
				  userList.add(rs.getString(4));
				  userList.add(rs.getString(5));
				  userList.add(rs.getString(6));
				  userList.add(rs.getInt(7));
				  userList.add(rs.getString(8));     
				  //userList.add(rs.getString(9));
				 //userList.add(rs.getString(10));
				 //userList.add(rs.getString(11));
                                 //userList.add(rs.getString(12));
                                 //userList.add(rs.getString(13));
                                 

				}

				request.setAttribute("userList",userList);

                String nextJSP = "/approveleave.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request,response);
				conn.close();
				System.out.println("Disconnected from database");
			} catch (Exception e) {
			e.printStackTrace();
			}
  }
}