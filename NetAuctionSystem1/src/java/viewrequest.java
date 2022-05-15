import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.*;
import java.sql.*;
import java.util.*;

public class viewrequest extends HttpServlet{

   public void doGet(HttpServletRequest request, HttpServletResponse response)
                                   throws ServletException,IOException{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			System.out.println("Leave mangement system");
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

				ArrayList al=null;
				ArrayList userList =new ArrayList();
				String query = "select * from homework";
				System.out.println("query " + query);
				st = conn.createStatement();
				ResultSet  rs = st.executeQuery(query);


				while(rs.next())
				{
					al  = new ArrayList();

				  al.add(rs.getString(1));
				 al.add(rs.getString(2));
				 al.add(rs.getString(3));
				 al.add(rs.getString(4));
				 al.add(rs.getString(5));
				 al.add(rs.getString(6));
				 // al.add(rs.getInt(7));
				 // al.add(rs.getString(8));
				 // al.add(rs.getString(9));
				 // al.add(rs.getString(10));
				 // al.add(rs.getString(11));

				 System.out.println("al :: "+al);
				  userList.add(al);
				}

				request.setAttribute("userList",userList);

                String nextJSP = "/manageleave2.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request,response);
				conn.close();
				System.out.println("Disconnected from database");
			} catch (Exception e) {
			e.printStackTrace();
			}
  }
}