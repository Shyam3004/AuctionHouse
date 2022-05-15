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
/*    */ public class AdminLogin1 extends HttpServlet
/*    */ {
/*    */   Connection con;
/*    */ 	ResultSet localObject;
/*    */   public void init(ServletConfig paramServletConfig)
/*    */     throws ServletException
/*    */   {
/* 10 */     super.init(paramServletConfig);
/*    */     try
/*    */     {
/* 13 */       Class.forName("com.mysql.jdbc.Driver");
/* 14 */       this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/netauction","root","password"); } catch (Exception localException) {
/* 15 */       System.out.println(localException);
/*    */     }
/*    */   }
/*    */ 
/* 19 */   public void doPost(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) throws ServletException, IOException { paramHttpServletResponse.setContentType("text/html");
/* 20 */     PrintWriter localPrintWriter = paramHttpServletResponse.getWriter();
/* 21 */     localPrintWriter.println("<BODY bgColor=#a3d881 leftMargin=0 topMargin=0 MARGINHEIGHT=0 MARGINWIDTH=0><!-- ImageReady Slices (Untitled-1) -->");
/*    */ 
/* 24 */     localPrintWriter.println("<p align=right><TABLE cellSpacing=0 cellPadding=0 width=781 border=0><TBODY><BR><TR><TD><A href='./home.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>HOME</STRONG></A> </TD>      <TD>  <A href='./login.jsp'><STRONG> <FONT COLOR='BROWN' FACE='CURLZ MT'>LOGIN</STRONG>  </A></TD>      <TD>    <A href='./registration.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>REGISTER</STRONG></A></TD>    <TD> <A href='./sell.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>SELL</STRONG>      </A></TD> <TD> <A href='./help.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>HELP</STRONG> </A></TD></TR><TD></TD>  </TBODY></TABLE></p><br><br>");
/* 25 */     localPrintWriter.println("<p align=right><FORM name=form1 action='./SearchServlet'  method=post >Search:<INPUT name=sstring> ");
/* 26 */     localPrintWriter.println("<SELECT  name=category > <option >Choose Category</option>");
/*    */     try
/*    */     {
/* 29 */       Statement localStatement = this.con.createStatement();
/* 30 */       localObject = localStatement.executeQuery("select cat_name from category_master");
/* 31 */       while (((ResultSet)localObject).next())
/* 32 */         localPrintWriter.println("<OPTION>" + ((ResultSet)localObject).getString(1) + "</OPTION>");
/*    */     } catch (Exception localException) {
/*    */     }
/* 35 */     localPrintWriter.println("</SELECT> <INPUT type=submit value=Go > ");
/* 36 */     localPrintWriter.println("</FORM></p><!-- End ImageReady Slices -->");
/* 37 */     String str = paramHttpServletRequest.getParameter("usr");
/* 38 */     Object localObject = paramHttpServletRequest.getParameter("password");
/* 39 */     if ((str.equals("admin")) && (((String)localObject).equals("netaucs")))
/*    */     {
/* 41 */       localPrintWriter.println("<center><h2>Administartor Page<h2><br>");
/* 42 */       localPrintWriter.println("<table><tr><td><a href='./DelItemCat'>Delete a Item Category</a> </td></tr>");
/* 43 */       localPrintWriter.println("<tr><td><a href='./DelBidItem'>Delete Bid Item </a> </td></tr>");
/* 44 */       localPrintWriter.println("</table><br>");
/*    */     }
/*    */     else
/*    */     {
/* 48 */       localPrintWriter.println("<center><h2>Sorry your r not Valid Admin User <h2><br><br><br>");
/* 49 */       localPrintWriter.println("<input type=button value=back onClick='history.back()'>");
/*    */     }
/* 51 */     localPrintWriter.println("<br><br><br><CENTER><STRONG></STRONG><br><br>");
/* 52 */     localPrintWriter.println("<A href=./NewToday>New Items</A><STRONG></STRONG>");
/* 53 */     localPrintWriter.println("<A href=./EndToday>Closing Items</A>");
/* 54 */     localPrintWriter.println("<STRONG></STRONG><A href=./sell.jsp>Sell Items</A>");
/* 55 */     localPrintWriter.println("<STRONG></STRONG><A href=./home.jsp>Home</A>");
/* 56 */     localPrintWriter.println("<br><br>");
/*    */   }
/*    */ }
