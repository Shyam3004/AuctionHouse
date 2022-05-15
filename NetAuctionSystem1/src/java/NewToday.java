/*    */ import java.io.IOException;
/*    */ import java.io.PrintWriter;
/*    */ import java.sql.Connection;
/*    */ import java.sql.Date;
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
/*    */ public class NewToday extends HttpServlet
/*    */ {
/*    */   Connection con;
/*    */   PrintWriter pw;
		ResultSet localResultSet;
/*    */ 
/*    */   public void init(ServletConfig paramServletConfig)
/*    */     throws ServletException
/*    */   {
/*    */     try
/*    */     {
/* 15 */       super.init(paramServletConfig);
/* 16 */      Class.forName("com.mysql.jdbc.Driver");
/* 14 */       this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/netauction","root","password");
/*    */     } catch (Exception localException) {
/* 19 */       localException.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void doGet(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) throws ServletException, IOException {
/*    */     try { paramHttpServletResponse.setContentType("text/html");
/* 25 */       this.pw = paramHttpServletResponse.getWriter();
/* 26 */       this.pw.println("<BODY bgColor=#a3d881 leftMargin=0 topMargin=0 MARGINHEIGHT=0 MARGINWIDTH=0><!-- ImageReady Slices (Untitled-1) -->");
/* 27 */       this.pw.println("<p align=right><TABLE cellSpacing=0 cellPadding=0 width=781 border=0><TBODY><BR><TR><TD><A href='./home.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>HOME</STRONG></A> </TD>      <TD>  <A href='./login.jsp'><STRONG> <FONT COLOR='BROWN' FACE='CURLZ MT'>LOGIN</STRONG>  </A></TD>      <TD>    <A href='./registration.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>REGISTER</STRONG></A></TD>    <TD> <A href='./sell.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>SELL</STRONG>      </A></TD>  <TD> <A href='./ForSale.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>CURRENT BID ITEMS</STRONG>      </A></TD> <TD> <A href='./help.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>HELP</STRONG> </A></TD></TR><TD></TD>  </TBODY></TABLE></p><br><br>");
/*    */ 
/* 29 */       this.pw.println("<p align=right><FORM name=form1 action='./SearchServlet'  method=post >Search:<INPUT name=sstring> ");
/* 30 */       this.pw.println("<SELECT  name=category > <option >Choose Category</option>");
/*    */       try
/*    */       {
/* 33 */         Statement localStatement1 = this.con.createStatement();
/* 34 */         localResultSet = localStatement1.executeQuery("select cat_name from category_master");
/* 35 */         while (localResultSet.next())
/* 36 */           this.pw.println("<OPTION>" + localResultSet.getString(1) + "</OPTION>");
/*    */       } catch (Exception localException1) {
/*    */       }
/* 39 */       this.pw.println("</SELECT> <INPUT type=submit value=Go > ");
/* 40 */       this.pw.println("</FORM></p><!-- End ImageReady Slices -->");
/*    */ 
/* 43 */       this.pw.println("<h2><center>New ITems</h2><br>");
/* 44 */       Statement localStatement2 = this.con.createStatement();
/* 45 */       ResultSet localResultSet = localStatement2.executeQuery("select * from item_master where stdate=CURDATE()");
/* 46 */       this.pw.println("<center><table border=3 bordercolor=green>");
/* 47 */       this.pw.println("<thead><th>Item<Th>Description<Th>Current Price");
/* 48 */       this.pw.println("<Th>Number Of Bids<Th>Auction Ending Date</thead>");
/* 49 */       while (localResultSet.next())
/*    */       {
/* 51 */         String str1 = localResultSet.getString(1);
/* 52 */         String str2 = localResultSet.getString(4);
/* 53 */         String str3 = localResultSet.getString(6);
/* 54 */         Date localDate = localResultSet.getDate(9);
/* 55 */         String str4 = localResultSet.getString(11);
/* 56 */         this.pw.println("<tr><td><a href='./ItemDetails?id=" + str1 + "' >" + str1 + "</a></td>");
/* 57 */         this.pw.println("<td>" + str2 + "</td>");
/* 58 */         this.pw.println("<td>" + str3 + "</td>");
/* 59 */         this.pw.println("<td>" + str4 + "</td>");
/* 60 */         this.pw.println("<td align=center>" + localDate + "</td></tr>");
/*    */       }
/* 62 */       this.pw.println("</table></center><br><br>");
/*    */ 
/* 64 */       this.pw.println("<CENTER><STRONG></STRONG>");
/* 65 */       this.pw.println("<A href=./NewToday>New Items</A><STRONG></STRONG>");
/* 66 */       this.pw.println("<A href=./EndToday>Closing Items</A>");
/* 67 */       this.pw.println("<STRONG></STRONG><A href=./sell.jsp>Sell Items</A>");
/* 68 */       this.pw.println("<STRONG></STRONG><A href=./userpage.jsp>Back/Search</A>");
/*    */     } catch (Exception localException2) {
/* 70 */       localException2.printStackTrace();
/*    */     }
/*    */   }
/*    */ }

