/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import javax.servlet.ServletConfig;
/*     */ import javax.servlet.ServletContext;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.http.HttpServlet;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ 
/*     */ public class AuctionServlet extends HttpServlet
/*     */ {
/*     */   Connection con;
/*     */   PrintWriter pw;
		ResultSet localObject;
/*     */ 
/*     */   public void init(ServletConfig paramServletConfig)
/*     */     throws ServletException
/*     */   {
/*     */     try
/*     */     {
/*  18 */       super.init(paramServletConfig);
/*  19 */       Class.forName("com.mysql.jdbc.Driver");
/*  20 */       this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/netauction","root","password");
/*     */     } catch (Exception localException) {
/*  22 */       localException.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*  26 */   public void doGet(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) throws ServletException, IOException { paramHttpServletResponse.setContentType("text/html");
/*  27 */     this.pw = paramHttpServletResponse.getWriter();
/*     */     try {
/*  29 */       this.pw.println("<BODY bgColor=#a3d881 leftMargin=0 topMargin=0 MARGINHEIGHT=0 MARGINWIDTH=0><!-- ImageReady Slices (Untitled-1) -->");
/*     */ 
/*  32 */       this.pw.println("<p align=right><TABLE cellSpacing=0 cellPadding=0 width=781 border=0><TBODY><BR><TR><TD><A href='./home.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>HOME</STRONG></A> </TD>      <TD>  <A href='./login.jsp'><STRONG> <FONT COLOR='BROWN' FACE='CURLZ MT'>LOGIN</STRONG>  </A></TD>      <TD>    <A href='./registration.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>REGISTER</STRONG></A></TD>    <TD> <A href='./sell.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>SELL</STRONG>      </A></TD>  <TD> <A href='./ForSale.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>CURRENT BID ITEMS</STRONG>      </A></TD> <TD> <A href='./help.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>HELP</STRONG> </A></TD></TR><TD></TD>  </TBODY></TABLE></p><br><br>");
/*  33 */       this.pw.println("<p align=right><FORM name=form1 action='./SearchServlet'  method=post >Search:<INPUT name=sstring> ");
/*  34 */       this.pw.println("<SELECT  name=category > <option >Choose Category</option>");
/*     */       try
/*     */       {
/*  37 */         Statement localStatement1 = this.con.createStatement();
/*  38 */         localObject = localStatement1.executeQuery("select cat_name from category_master");
/*  39 */         while (((ResultSet)localObject).next())
/*  40 */           this.pw.println("<OPTION>" + ((ResultSet)localObject).getString(1) + "</OPTION>");
/*     */       } catch (Exception localException1) {
/*     */       }
/*  43 */       this.pw.println("</SELECT> <INPUT type=submit value=Go > ");
/*  44 */       this.pw.println("</FORM></p><!-- End ImageReady Slices -->");
/*  45 */       Statement localStatement2 = this.con.createStatement();
/*  46 */       Object localObject = paramHttpServletRequest.getParameter("bidder");
            String biduser = paramHttpServletRequest.getParameter("bidder");
/*  47 */       String str1 = paramHttpServletRequest.getParameter("password");
/*  48 */       String str2 = paramHttpServletRequest.getParameter("amount");
int totprice = Integer.parseInt(paramHttpServletRequest.getParameter("startprice"))+Integer.parseInt(str2);
/*  49 */      
Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from wallet where username='"+biduser+"'");
            if(rs.next()) {

 int amount1=0;
               
                amount1 = Integer.parseInt(rs.getString(2));
                
                if(amount1>=totprice)
                {
if (str2.length() > 0)
/*     */       {
/*  51 */         int i = Integer.parseInt(str2);
/*  52 */         String str3 = paramHttpServletRequest.getParameter("id");
/*  53 */         int j = Integer.parseInt(paramHttpServletRequest.getParameter("hbid"));
/*  54 */         int k = Integer.parseInt(paramHttpServletRequest.getParameter("min"));
/*  55 */         ResultSet localResultSet1 = localStatement2.executeQuery("select pwd from uinfo_master where uname='" + (String)localObject + "' ");
/*  56 */         if (localResultSet1.next())
/*     */         {
/*  58 */           String str4 = localResultSet1.getString(1);
/*  59 */           if (!str1.equals(str4)) {
/*  60 */             this.pw.println("<center><b>in valid password</b></center><br<br>");
/*  61 */           } else if (i >= j + k)
/*     */           {
/*  63 */             Statement localStatement3 = this.con.createStatement();
/*     */ 
/*  83 */             ResultSet localResultSet2 = localStatement3.executeQuery("select enddate from item_master where itemid='"+str3+"' and enddate>= CURDATE()");
/*  84 */             if (localResultSet2.next())
/*     */             {
/*  86 */               String m = localResultSet2.getString(1);
/*  87 */               //if (m < 0)
/*     */               //{
/*  89 */                // this.pw.println("<center><b>auction is closed a " + -1 * m + " day(s) before</b><br<br></center>");
/*     */               //}
/*     */               //else
/*     */               //{
/*  99 */                 Statement localStatement4 = this.con.createStatement();
/* 100 */                 int n = localStatement4.executeUpdate("Update bidding_info set status=0 where itemid=" + str3 + " and status!=2");
/* 101 */                 n = localStatement4.executeUpdate("insert into bidding_info values('" + (String)localObject + "'," + i + "," + str3 + ",CURDATE(),1) ");
/*     */ 
/* 103 */                 Statement localStatement5 = this.con.createStatement();
/* 104 */                 localStatement5.executeUpdate("update item_master set bidcnt=bidcnt+1 where itemid=" + str3 + " ");
/* 105 */                 this.pw.println("<center><b>congratulations u have sucessfully bid for the item</b><br<br></center>");
/*     */               //}
/*     */ 		
/*     */             }
			else
			{
			 this.pw.println("<center><b>auction is closed</b><br<br></center>");
			}
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/* 124 */             this.pw.println("<center><b>bid more than current value + mininmum increament</b><br<br></center>");
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 129 */           this.pw.println("<center><b>User Name doesnot exist</b></center><br<br>");
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 134 */         this.pw.println("<br><center>specify the bid amount</center>");
/*     */       }
}
            }
                 else
/*     */       {
/* 134 */         this.pw.println("<br><center>Not enough amount in wallet</center>");
/*     */       }
/*     */     } catch (NumberFormatException localNumberFormatException) {
/* 137 */       this.pw.println("<br><b><center>enter a numeric value</center></b><br><br>"); } catch (Exception localException2) {
/* 138 */       localException2.printStackTrace();
/* 139 */     }this.pw.println("<br><br><br><CENTER><STRONG></STRONG>");
/* 140 */     this.pw.println("<A href=./NewToday>New Items</A><STRONG></STRONG>");
/* 141 */     this.pw.println("<A href=./EndToday>Closing Items</A>");
/* 142 */     this.pw.println("<STRONG></STRONG><A href=./sell.jsp>Sell Items</A>");
/* 143 */     this.pw.println("<STRONG></STRONG><A href=./home.jsp>Home</A>");
/*     */   }
/*     */ }

