/*    */ import java.io.PrintStream;
/*    */ import java.io.PrintWriter;
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.PreparedStatement;
/*    */ import javax.servlet.ServletConfig;
/*    */ import javax.servlet.ServletContext;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ public class EditUserInfo extends HttpServlet
/*    */ {
/*    */   Connection con;
/*    */   PreparedStatement ps;
/*    */ 
/*    */   public void init(ServletConfig paramServletConfig)
/*    */     throws ServletException
/*    */   {
/* 12 */     super.init(paramServletConfig);
/*    */     try
/*    */     {
/* 15 */       Class.forName("com.mysql.jdbc.Driver");
/* 14 */       this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/netauction","root","password");
/* 17 */       this.ps = this.con.prepareStatement("update uinfo_master set pwd=?,fname=?,lname=?,email=?,phno=?,address=?,city=?,state=?,pin=?,country=? where uname=?"); } catch (Exception localException) {
/* 18 */       System.out.println(localException);
/*    */     }
/*    */   }
/*    */ 
/*    */   public void doPost(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) throws ServletException {
/*    */     try {
/* 24 */       paramHttpServletResponse.setContentType("text/html");
/* 25 */       PrintWriter localPrintWriter = paramHttpServletResponse.getWriter();
/* 26 */       HttpSession localHttpSession = paramHttpServletRequest.getSession(true);
/*    */ 
/* 29 */       String str1 = paramHttpServletRequest.getParameter("theuser");
/* 30 */       String str2 = paramHttpServletRequest.getParameter("password");
/* 31 */       String str3 = paramHttpServletRequest.getParameter("fname");
/* 32 */       String str4 = paramHttpServletRequest.getParameter("lname");
/* 33 */       String str5 = paramHttpServletRequest.getParameter("email");
/* 34 */       String str6 = paramHttpServletRequest.getParameter("phno");
/* 35 */       String str7 = paramHttpServletRequest.getParameter("address");
/* 36 */       String str8 = paramHttpServletRequest.getParameter("city");
/* 37 */       String str9 = paramHttpServletRequest.getParameter("state");
/* 38 */       String str10 = paramHttpServletRequest.getParameter("pin");
/* 39 */       String str11 = paramHttpServletRequest.getParameter("country");
/* 40 */       String str12 = paramHttpServletRequest.getParameter("ccardno");
/*    */ 
/* 42 */       this.ps.setString(1, str2);
/* 43 */       this.ps.setString(2, str3);
/* 44 */       this.ps.setString(3, str4);
/* 45 */       this.ps.setString(4, str5);
/* 46 */       this.ps.setString(5, str6);
/* 47 */       this.ps.setString(6, str7);
/* 48 */       this.ps.setString(7, str8);
/* 49 */       this.ps.setString(8, str9);
/* 50 */       this.ps.setString(9, str10);
/* 51 */       this.ps.setString(10, str11);
/*    */ 
/* 53 */       this.ps.setString(11, str1);
/*    */ 
/* 55 */       int i = this.ps.executeUpdate();
/*    */ 
/* 57 */       localPrintWriter.println("<BODY bgColor=#a3d881 leftMargin=0 topMargin=0 MARGINHEIGHT=0 MARGINWIDTH=0><!-- ImageReady Slices (Untitled-1) -->");
/*    */ 
/* 59 */       localPrintWriter.println("<p align=right><TABLE cellSpacing=0 cellPadding=0 width=500 border=0><TBODY><BR><TR><TD align=center><A href='./AfterLogin?theuser=" + str1 + "'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>My Profile</STRONG></A></TD><td align=center> | </td><TD align=center><A href='./Buy.jsp?theuser=" + str1 + "'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>Buy Item</STRONG></A></TD><td align=center> | </td><TD align=center><A href='./Sold.jsp?theuser=" + str1 + "'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>Sold Items</STRONG></A></TD><td align=center> | </td><TD align=center>  <A href='./login.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>LogOut</STRONG></A></TD>  </TR><TD></TD>  </TBODY></TABLE></p><br><br>");
/*    */ 
/* 73 */       localPrintWriter.println("<marquee behaviour='ALTERNATE'><B><FONT COLOR='arun'><FONT FACE=' Georgia' SIZE='6'> A secured Net Auction System </FONT></B></marquee>");
/*    */ 
/* 75 */       if (i == 1)
/*    */       {
/* 77 */         localPrintWriter.println("<br><br><br><b><center>Your profile has been Updated</center></b>");
/*    */       }
/*    */       else
/*    */       {
/* 81 */         localPrintWriter.println("<br><center>Problem with Database");
/*    */       }
/*    */ 
/* 84 */       localPrintWriter.println("<br><br><br><CENTER><STRONG></STRONG><br><br>");
/* 85 */       localPrintWriter.println("<A href=./NewToday>New Items</A><STRONG></STRONG>");
/* 86 */       localPrintWriter.println("<A href=./EndToday>Closing Items</A>");
/* 87 */       localPrintWriter.println("<STRONG></STRONG><A href=./sell.jsp>Sell Items</A>");
/* 88 */       localPrintWriter.println("<STRONG></STRONG><A href=./home.jsp>Home</A>");
/* 89 */       localPrintWriter.println("<br><br>");
/*    */     } catch (Exception localException) {
/* 91 */       System.out.println(localException);
/*    */     }
/*    */   }
/*    */ }

