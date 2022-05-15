/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import java.io.PrintWriter;
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.Statement;
/*    */ import javax.servlet.ServletConfig;
/*    */ import javax.servlet.ServletContext;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ public class DelItemCat extends HttpServlet
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
/* 14 */       this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/netauction","root","password"); } catch (Exception localException) {
/* 16 */       System.out.println(localException); }  } 
/* 20 */   public void doGet(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) throws ServletException, IOException { paramHttpServletResponse.setContentType("text/html");
/* 21 */     PrintWriter localPrintWriter = paramHttpServletResponse.getWriter();
/* 22 */     localPrintWriter.println("<BODY bgColor=#a3d881 leftMargin=0 topMargin=0 MARGINHEIGHT=0 MARGINWIDTH=0><!-- ImageReady Slices (Untitled-1) -->");
/*    */ 
/* 25 */     localPrintWriter.println("<p align=right><TABLE cellSpacing=0 cellPadding=0 width=781 border=0><TBODY><BR><TR><TD><A href='./home.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>HOME</STRONG></A> </TD>      <TD>  <A href='./login.jsp'><STRONG> <FONT COLOR='BROWN' FACE='CURLZ MT'>LOGIN</STRONG>  </A></TD>      <TD>    <A href='./registration.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>REGISTER</STRONG></A></TD>    <TD> <A href='./sell.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>SELL</STRONG>      </A></TD> <TD> <A href='./help.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>HELP</STRONG> </A></TD></TR><TD></TD>  </TBODY></TABLE></p><br><br>");
/*    */ 
/* 27 */     localPrintWriter.println("<p align=right><FORM name=form1 action='./SearchServlet'  method=post >Search:<INPUT name=sstring> ");
/* 28 */     localPrintWriter.println("<SELECT  name=category > <option >Choose Category</option>");
/*    */     ResultSet localResultSet;
/*    */     try { Statement localStatement1 = this.con.createStatement();
/* 32 */       localResultSet = localStatement1.executeQuery("select cat_name from category_master");
/* 33 */       while (localResultSet.next())
/* 34 */         localPrintWriter.println("<OPTION>" + localResultSet.getString(1) + "</OPTION>");
/*    */     } catch (Exception localException1) {
/*    */     }
/* 37 */     localPrintWriter.println("</SELECT> <INPUT type=submit value=Go > ");
/* 38 */     localPrintWriter.println("</FORM></p><!-- End ImageReady Slices -->");
/* 39 */     localPrintWriter.println("<form method='POST' action='./DelCatItem'>");
/* 40 */     localPrintWriter.println("<center><h2>ItemCategory List<h2><br>");
/*    */     try {
/* 42 */       Statement localStatement2 = this.con.createStatement();
/* 43 */       localResultSet = localStatement2.executeQuery("select cat_name,catid from category_master");
/* 44 */       localPrintWriter.println("<table>");
/* 45 */       while (localResultSet.next())
/* 46 */         localPrintWriter.println("<tr><td>" + localResultSet.getString(1) + "</td><td><input type=checkbox name=chk value='" + localResultSet.getString(2) + "'></td></tr>");
/* 47 */       localPrintWriter.println("</table><br><center><input type=submit value='Delete' ><input type=button value=back onClick='history.back()'> </form>");
/*    */     }
/*    */     catch (Exception localException2)
/*    */     {
/* 51 */       localException2.printStackTrace();
/*    */     }
/* 53 */     localPrintWriter.println("<br><br><br><CENTER><STRONG></STRONG><br><br>");
/* 54 */     localPrintWriter.println("<A href=./NewToday>New Items</A><STRONG></STRONG>");
/* 55 */     localPrintWriter.println("<A href=./EndToday>Closing Items</A>");
/* 56 */     localPrintWriter.println("<STRONG></STRONG><A href=./sell.jsp>Sell Items</A>");
/* 57 */     localPrintWriter.println("<STRONG></STRONG><A href=./home.jsp>Home</A>");
/* 58 */     localPrintWriter.println("<br><br>");
/*    */   }
/*    */ }
