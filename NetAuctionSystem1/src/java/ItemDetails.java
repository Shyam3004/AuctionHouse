/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
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
/*    */ public class ItemDetails extends HttpServlet
/*    */ {
/*    */   Connection con;
/*    */   PrintWriter pw;
		ResultSet localObject;
/*    */ 
/*    */   public void init(ServletConfig paramServletConfig)
/*    */     throws ServletException
/*    */   {
/*    */     try
/*    */     {
/* 15 */       super.init(paramServletConfig);
/* 16 */       Class.forName("com.mysql.jdbc.Driver");
/* 14 */       this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/netauction","root","password"); } catch (Exception localException) {
/* 18 */       localException.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void doGet(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) throws ServletException, IOException {
/*    */     try { paramHttpServletResponse.setContentType("text/html");
/* 24 */       this.pw = paramHttpServletResponse.getWriter();
/*    */ 
/* 26 */       this.pw.println("<BODY bgColor=#a3d881 leftMargin=0 topMargin=0 MARGINHEIGHT=0 MARGINWIDTH=0><!-- ImageReady Slices (Untitled-1) -->");
/*    */ 
/* 29 */       this.pw.println("<p align=right><TABLE cellSpacing=0 cellPadding=0 width=781 border=0><TBODY><BR><TR><TD><A href='./home.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>HOME</STRONG></A> </TD>      <TD>  <A href='./login.jsp'><STRONG> <FONT COLOR='BROWN' FACE='CURLZ MT'>LOGIN</STRONG>  </A></TD>      <TD>    <A href='./registration.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>REGISTER</STRONG></A></TD>    <TD> <A href='./sell.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>SELL</STRONG>      </A></TD>  <TD> <A href='./ForSale.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>CURRENT BID ITEMS</STRONG>      </A></TD> <TD> <A href='./help.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>HELP</STRONG> </A></TD></TR><TD></TD>  </TBODY></TABLE></p><br><br>");
/* 30 */       this.pw.println("<p align=right><FORM name=form1 action='./SearchServlet'  method=post >Search:<INPUT name=sstring> ");
/* 31 */       this.pw.println("<SELECT  name=category > <option >Choose Category</option>");
/*    */       try
/*    */       {
/* 34 */         Statement localStatement1 = this.con.createStatement();
/* 35 */         localObject = localStatement1.executeQuery("select cat_name from category_master");
/* 36 */         while (((ResultSet)localObject).next())
/* 37 */           this.pw.println("<OPTION>" + ((ResultSet)localObject).getString(1) + "</OPTION>");
/*    */       } catch (Exception localException1) {
/*    */       }
/* 40 */       this.pw.println("</SELECT> <INPUT type=submit value=Go > ");
/* 41 */       this.pw.println("</FORM></p><!-- End ImageReady Slices -->"); this.pw.println("<h2><center>Item Wise Details</h2>");
/*    */ 
/* 43 */       String str1 = paramHttpServletRequest.getParameter("id");
/* 44 */       System.out.println(str1);
/* 45 */       Object localObject = this.con.createStatement();
/* 46 */       ResultSet localResultSet1 = ((Statement)localObject).executeQuery("select itemname from item_master where itemid=" + str1);
/* 47 */       localResultSet1.next();
/* 48 */       String str2 = localResultSet1.getString(1);
/* 49 */       this.pw.println("<center><font size=+2 face=Arial ><u>" + str2 + "</u></font></center><br>");
/* 50 */       Statement localStatement2 = this.con.createStatement();
/* 51 */       ResultSet localResultSet2 = localStatement2.executeQuery("select bidderid,bamt from bidding_info where itemid=" + str1 + " and bamt=(select max(bamt) from bidding_info where itemid=" + str1 + ")");
/* 52 */       String str3 = "No Bidder Till now";
/* 53 */       int i = 0;
/* 54 */       if (localResultSet2.next()) {
/* 55 */         str3 = localResultSet2.getString(1);
/* 56 */         i = localResultSet2.getInt(2);
/*    */       }
/* 58 */       Statement localStatement3 = this.con.createStatement();
/* 59 */       ResultSet localResultSet3 = localStatement3.executeQuery("select * from item_master where itemid=" + str1);
/* 60 */       this.pw.println("<center><table border=2>");
/* 61 */       String str4 = "";
/* 62 */       String str5 = "";
/* 63 */       while (localResultSet3.next())
/*    */       {
/* 65 */         String str6 = localResultSet3.getString(4);
/* 66 */         str4 = localResultSet3.getString(6);
/* 67 */         str5 = localResultSet3.getString(7);
/* 68 */         Date localDate1 = localResultSet3.getDate(8);
/* 69 */         Date localDate2 = localResultSet3.getDate(9);
/* 70 */         String str7 = localResultSet3.getString(10);
/* 71 */         String str8 = localResultSet3.getString(11);
 String str9 = localResultSet3.getString(12);
/* 72 */         if (i == 0)
/* 73 */           i = Integer.parseInt(str4);
/* 74 */         this.pw.println("<TR><TD>Start Price</TD><td>" + str4 + "</td></tr>");
/* 75 */         this.pw.println("<TR><TD>MinimunIncrement</TD><td>" + str5 + "</td></tr>");
/* 76 */         this.pw.println("<TR><TD>Number Of Bids</TD><td>" + str8 + "</td></tr>");
/* 77 */         this.pw.println("<TR><TD>Auction Start Date</TD><td>" + localDate1 + "</td></tr>");
/* 78 */         this.pw.println("<TR><TD>Auction Ending Date</TD><td>" + localDate2 + "</td></tr>");
/* 79 */         this.pw.println("<TR><TD>Seller</TD><td>" + str7 + "</td></tr>");
/* 80 */         this.pw.println("<TR><TD>High Bidder</TD><td>" + str3 + "</td></tr>");
/* 81 */         this.pw.println("<tr><td>Current Bid Price</td><td>" + i + "</td></tr>");
/* 82 */         this.pw.println("<TR><TD>Description</TD><td>" + str6 + "</td></tr>");
                this.pw.println("<TR><TD>Product Image</TD><td><img src=\"productimages/"+ str9 +"\" alt=\"1\" width=\"165\" height=\"99\" /></td></tr>");
/*    */       }
/*    */       
/* 85 */       this.pw.println("</table><center>");
/* 86 */       this.pw.println("<P><STRONG>Do you want to bid on this item?</STRONG>");
/* 87 */       this.pw.println("<form action=./AuctionServlet>");
/* 88 */       this.pw.println("<input type=hidden name=id value=" + paramHttpServletRequest.getParameter("id"));
/* 89 */       this.pw.println("><input type=hidden name=hbid value=" + i);
/* 90 */       this.pw.println("><input type=hidden name=min value=" + str5);
this.pw.println("><input type=hidden name=startprice value=" + str4);
/* 91 */       this.pw.println("><TABLE><TR><TD>Enter your user id:</TD><TD><INPUT TYPE=\"TEXT\" SIZE=20 NAME=\"bidder\"></TD></TR>");
/* 92 */       this.pw.println("<TR><TD>Enter your password:</TD><TD><INPUT TYPE=PASSWORD SIZE=20 NAME=password></TD>");
/* 93 */       this.pw.println("</TR><TR><TD>Your Bid Amount:</TD><TD><INPUT TYPE=\"TEXT\" SIZE=60 NAME=\"amount\"  onBlur=f()></TD></TR></TABLE><br><br><input type=submit value=\"Bid for Item\"></form>");
/*    */ 
/* 95 */       this.pw.println("<CENTER><STRONG></STRONG>");
/* 96 */       this.pw.println("<A href=./NewToday>New Items</A><STRONG></STRONG>");
/* 97 */       this.pw.println("<A href=./EndToday>Closing Items</A>");
/* 98 */       this.pw.println("<STRONG></STRONG><A href=./sell.jsp>Sell Items</A>");
/* 99 */       this.pw.println("<STRONG></STRONG><A href=./home.jsp>Home</A>");
/*    */     } catch (Exception localException2) {
/* 101 */       localException2.printStackTrace();
/*    */     }
/*    */   }
/*    */ }

