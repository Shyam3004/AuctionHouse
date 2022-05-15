
import java.util.*;
   import java.io.*;
   import java.sql.*;
   import javax.servlet.*;
   import javax.servlet.http.*;

public class homeworkassign extends HttpServlet
{
  public void doPost(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws ServletException, IOException
  {
    paramHttpServletResponse.setContentType("text/html");
    PrintWriter localPrintWriter = paramHttpServletResponse.getWriter();
	ResultSet rs=null;
    System.out.println("ERRor");
    Connection localConnection = null;
    String str1 = "jdbc:mysql://localhost:3306/";
    String str2 = "netauction";
    String str3 = "com.mysql.jdbc.Driver";
    String str4 = "root";
    String str5 = "password";

    String str6 = paramHttpServletRequest.getParameter("seller");
    String str7 = paramHttpServletRequest.getParameter("password");
    String str8 = paramHttpServletRequest.getParameter("itemname");
    String str9 = paramHttpServletRequest.getParameter("category");
    String str10 = paramHttpServletRequest.getParameter("summary");
    String str11 = paramHttpServletRequest.getParameter("startprice");
    String str12 = paramHttpServletRequest.getParameter("incrprice");
    String str13 = paramHttpServletRequest.getParameter("description");
    //String str14 = paramHttpServletRequest.getParameter("auctiondays");
	String enddate = paramHttpServletRequest.getParameter("enddate");
try
    {
	Class.forName(str3).newInstance();
      localConnection = DriverManager.getConnection(str1 + str2, str4, str5);
	Statement st = localConnection.createStatement();
            rs = st.executeQuery("select * from uinfo_master where uname='"+str6+"' && pwd='"+str7+"'");
            if(rs.next()) {

    Object localObject1 = null;
    try
    {
      
      System.out.println("Connected to the database");
     Statement localStatement2 = localConnection.createStatement();

      String str18 = "";


      Object localObject2 = null;

      ArrayList localArrayList = new ArrayList();
      String str15 = "insert into item_master(catid,itemname,descr,summary,startprice,incrprice,stdate,enddate,seller,bidcnt) values('" + str9 + "','" + str8 + "','" + str13 + "','" + str10 + "','" + str11 + "','" + str12 + "',CURDATE(),'" + enddate + "','" + str6 + "',1)";
      Statement localStatement1 = localConnection.createStatement();
	
      int i1 = localStatement1.executeUpdate(str15);
      System.out.println("query" + str15);
      if (i1 > 0)
      {
        paramHttpServletResponse.sendRedirect("insertsuccess1.jsp");
      }
      localConnection.close();
      System.out.println("Disconnected from database");
    } catch (Exception localException) {
      localException.printStackTrace();
    }
	}
	else
	{
		paramHttpServletResponse.sendRedirect("failure.jsp");
	}
	}
	catch (Exception localException) {
      localException.printStackTrace();
    }
  }
}