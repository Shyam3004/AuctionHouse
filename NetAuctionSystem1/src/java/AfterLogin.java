/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import java.io.PrintWriter;
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.sql.Statement;
/*    */ import javax.servlet.ServletConfig;
/*    */ import javax.servlet.ServletContext;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ public class AfterLogin extends HttpServlet
/*    */ {
/*    */   Connection con;
/*    */ 
/*    */   public void init(ServletConfig paramServletConfig)
/*    */     throws ServletException
/*    */   {
/* 11 */     super.init(paramServletConfig);
/*    */     try
/*    */     {
/* 14 */       Class.forName("com.mysql.jdbc.Driver");
/* 15 */       this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/netauction","root","password"); } catch (Exception localException) {
/* 16 */       System.out.println(localException);
/*    */     }
/*    */   }
/*    */ 
/* 20 */   public void doGet(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) throws ServletException, IOException { paramHttpServletResponse.setContentType("text/html");
/* 21 */     PrintWriter localPrintWriter = paramHttpServletResponse.getWriter();
/* 22 */     HttpSession localHttpSession = paramHttpServletRequest.getSession(true);
/*    */ 
/* 24 */     String str1 = paramHttpServletRequest.getParameter("theuser");
/*    */     try
/*    */     {
/* 27 */       Statement localStatement = this.con.createStatement();
/* 28 */       System.out.println("select * from uinfo_master where uname='" + str1 + "' ");
/* 29 */       ResultSet localResultSet = localStatement.executeQuery("select * from uinfo_master where uname='" + str1 + "' ");
/* 30 */       String str2 = ""; String str3 = ""; String str4 = ""; String str5 = ""; String str6 = ""; String str7 = ""; String str8 = ""; String str9 = ""; String str10 = ""; String str11 = ""; String str12 = "";
/* 31 */       while (localResultSet.next())
/*    */       {
/* 33 */         
/*    */       }
/*    */ 
/* 45 */     } catch (SQLException localSQLException) {
/* 82 */       System.out.println(localSQLException);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\User\Desktop\Desktop\From ramesh sir\Net Auction System\Net Auction System\WEB-INF\classes\
 * Qualified Name:     AfterLogin
 * JD-Core Version:    0.6.2
 */