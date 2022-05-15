/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.rmi.RemoteException;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import java.util.StringTokenizer;
/*     */ import java.util.Vector;
/*     */ import javax.servlet.ServletConfig;
/*     */ import javax.servlet.ServletContext;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.http.HttpServlet;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ 
/*     */ public class SearchServlet extends HttpServlet
/*     */ {
/*     */   Connection con;
/*     */ 
/*     */   public void init(ServletConfig paramServletConfig)
/*     */     throws ServletException
/*     */   {
/*  15 */     super.init(paramServletConfig);
/*     */     try {
/*  17 */       Class.forName("com.mysql.jdbc.Driver");
/* 14 */       this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/netauction","root","password"); } catch (Exception localException) {
/*  19 */       System.out.println(localException);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void doPost(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) throws ServletException, IOException {
/*     */     try {
/*  25 */       paramHttpServletResponse.setContentType("text/html");
/*  26 */       PrintWriter localPrintWriter = paramHttpServletResponse.getWriter();
/*     */ 
/*  28 */       String str1 = paramHttpServletRequest.getParameter("sstring");
/*  29 */       String str2 = paramHttpServletRequest.getParameter("category");
/*     */ 
/*  31 */       localPrintWriter.println("<BODY bgColor=#a3d881 leftMargin=0 topMargin=0 MARGINHEIGHT=0 MARGINWIDTH=0><!-- ImageReady Slices (Untitled-1) -->");
/*     */ 
/*  34 */       localPrintWriter.println("<p align=right><TABLE cellSpacing=0 cellPadding=0 width=781 border=0><TBODY><BR><TR><TD><A href='./home.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>HOME</STRONG></A> </TD>      <TD>  <A href='./login.jsp'><STRONG> <FONT COLOR='BROWN' FACE='CURLZ MT'>LOGIN</STRONG>  </A></TD>      <TD>    <A href='./registration.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>REGISTER</STRONG></A></TD>    <TD> <A href='./sell.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>SELL</STRONG>      </A></TD>  <TD> <A href='./ForSale.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>CURRENT BID ITEMS</STRONG>      </A></TD> <TD> <A href='./help.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>HELP</STRONG> </A></TD></TR><TD></TD>  </TBODY></TABLE></p><br><br>");
/*  35 */       localPrintWriter.println("<p align=right><FORM name=form1 action='./SearchServlet'  method=post >Search:<INPUT name=sstring> ");
/*  36 */       localPrintWriter.println("<SELECT  name=category > <option >Choose Category</option>");
/*     */       try
/*     */       {
/*  39 */         Statement localStatement = this.con.createStatement();
/*  40 */         ResultSet localResultSet = localStatement.executeQuery("select cat_name from category_master");
/*  41 */         while (localResultSet.next())
/*  42 */           localPrintWriter.println("<OPTION>" + localResultSet.getString(1) + "</OPTION>");
/*     */       } catch (Exception localException2) {
/*     */       }
/*  45 */       localPrintWriter.println("</SELECT> <INPUT type=submit value=Go > ");
/*  46 */       localPrintWriter.println("</FORM></p><!-- End ImageReady Slices -->");
/*  47 */       Vector localVector = new Vector();
/*  48 */       int i = 0;
/*  49 */       if ((str1.length() == 0) && (!str2.equals("Choose Category")))
/*     */       {
/*  51 */         System.out.println("in second");
/*  52 */         localVector = searchCatInfo(str2);
/*  53 */         i = 2;
/*     */       }
/*  55 */       if ((str1.length() == 0) && (str2.equals("Choose Category")))
/*     */       {
/*  57 */         System.out.println("in third");
/*  58 */         localPrintWriter.println("<b><center>give a search string or category<b></center>");
/*  59 */         i = 3;
/*     */       }
/*  61 */       if ((str1.length() != 0) && (!str2.equals("Choose Category")))
/*     */       {
/*  63 */         System.out.println("in fourth");
/*  64 */         localVector = searchCatItemInfo(str1, str2);
/*  65 */         i = 4;
/*     */       }
/*  67 */       if ((str1.length() != 0) && (str2.equals("Choose Category")))
/*     */       {
/*  69 */         System.out.println("in first");
/*  70 */         localVector = searchItemInfo(str1);
/*  71 */         i = 1;
/*     */       }
/*     */ 
/*  74 */       if (i != 3)
/*     */       {
/*  76 */         int j = localVector.size();
/*  77 */         System.out.println(j);
/*  78 */         localPrintWriter.println("<br><center><b> U r Search String has found " + j);
/*  79 */         localPrintWriter.println("records</b></center><br>");
/*  80 */         if (j > 0)
/*     */         {
/*  82 */           localPrintWriter.println("<table border=2>");
/*  83 */           localPrintWriter.println("<tr><td><b>Item Code</b></td><td><b>Category Id</b></td><td><b>Item Name</b></td>");
/*  84 */           localPrintWriter.println("<td><b>Description</b></td><td><b>Summary</b></td><td><b>Start Price</b></td>");
/*  85 */           localPrintWriter.println("<td><b>Increament Amount</b></td><td><b>Start Date</b></td><td><b>End Date</b></td>");
/*  86 */           localPrintWriter.println("<td><b>Seller Id</b></td><td><b>Bid Count</b></td></tr>");
/*     */ 
/*  88 */           for (int k = 0; k < j; k++)
/*     */           {
/*  90 */             StringTokenizer localStringTokenizer = new StringTokenizer((String)localVector.elementAt(k), "~");
/*  91 */             localPrintWriter.println("<tr>");
/*  92 */             String str3 = localStringTokenizer.nextToken();
/*  93 */             localPrintWriter.println("<td><a href='./ItemDetails?id=" + str3 + "' >" + str3 + "</a></td>");
/*  94 */             while (localStringTokenizer.hasMoreTokens())
/*     */             {
/*  96 */               localPrintWriter.println("<td>" + localStringTokenizer.nextToken());
/*  97 */               localPrintWriter.println("</td>");
/*     */             }
/*  99 */             localPrintWriter.println("</tr>");
/*     */           }
/*     */         }
/*     */       }
/* 103 */       localPrintWriter.println("</table></center><br><br><br><CENTER><STRONG></STRONG>");
/* 104 */       localPrintWriter.println("<A href=./NewToday>New Items</A><STRONG></STRONG>");
/* 105 */       localPrintWriter.println("<A href=./EndToday>Closing Items</A>");
/* 106 */       localPrintWriter.println("<STRONG></STRONG><A href=./sell.jsp>Sell Items</A>");
/* 107 */       localPrintWriter.println("<STRONG></STRONG><A href=./home.jsp>Home</A>");
/* 108 */       localPrintWriter.println("<br><br>"); } catch (Exception localException1) {
/* 109 */       localException1.printStackTrace();
/*     */     }
/*     */   }
/* 112 */   public Vector searchItemInfo(String paramString) throws RemoteException { Vector localVector = new Vector();
/*     */     try {
/* 114 */       PreparedStatement localPreparedStatement = this.con.prepareStatement("select * from item_master where summary like ?");
/* 115 */       localPreparedStatement.setString(1, "%" + paramString + "%");
/* 116 */       ResultSet localResultSet = localPreparedStatement.executeQuery();
/* 117 */       while (localResultSet.next())
/*     */       {
/* 119 */         String str = localResultSet.getString(1) + "~" + localResultSet.getString(2) + "~" + localResultSet.getString(3) + "~" + localResultSet.getString(4) + "~" + localResultSet.getString(5) + "~" + localResultSet.getString(6) + "~" + localResultSet.getString(7) + "~" + localResultSet.getString(8) + "~" + localResultSet.getString(9) + "~" + localResultSet.getString(10) + "~" + localResultSet.getString(11);
/* 120 */         localVector.addElement(str);
/*     */       }
/*     */     } catch (Exception localException) { localException.printStackTrace(); }
/* 123 */     return localVector; }
/*     */ 
/*     */   public Vector searchCatInfo(String paramString)
/*     */     throws RemoteException
/*     */   {
/* 128 */     Vector localVector = new Vector();
/* 129 */     String str1 = "";
/*     */     try {
/* 131 */       PreparedStatement localPreparedStatement1 = this.con.prepareStatement("select catid from category_master where cat_name=?");
/* 132 */       localPreparedStatement1.setString(1, paramString);
/* 133 */       ResultSet localResultSet1 = localPreparedStatement1.executeQuery();
/* 134 */       localResultSet1.next();
/* 135 */       String str2 = localResultSet1.getString(1);
/* 136 */       localResultSet1.close();
/* 137 */       localPreparedStatement1.close();
/* 138 */       if (str2 != null)
/*     */       {
/* 140 */         PreparedStatement localPreparedStatement2 = this.con.prepareStatement("select * from item_master where catid =?");
/* 141 */         localPreparedStatement2.setString(1, str2);
/* 142 */         ResultSet localResultSet2 = localPreparedStatement2.executeQuery();
/* 143 */         while (localResultSet2.next())
/*     */         {
/* 145 */           str1 = localResultSet2.getString(1) + "~" + localResultSet2.getString(2) + "~" + localResultSet2.getString(3) + "~" + localResultSet2.getString(4) + "~" + localResultSet2.getString(5) + "~" + localResultSet2.getString(6) + "~" + localResultSet2.getString(7) + "~" + localResultSet2.getString(8) + "~" + localResultSet2.getString(9) + "~" + localResultSet2.getString(10) + "~" + localResultSet2.getString(11);
/* 146 */           localVector.addElement(str1);
/*     */         }
/*     */       }
/*     */     } catch (Exception localException) { localException.printStackTrace(); }
/* 150 */     return localVector;
/*     */   }
/*     */ 
/*     */   public Vector searchCatItemInfo(String paramString1, String paramString2) throws RemoteException
/*     */   {
/* 155 */     Vector localVector = new Vector();
/*     */     try
/*     */     {
/* 159 */       PreparedStatement localPreparedStatement1 = this.con.prepareStatement("select catid from category_master where cat_name=?");
/* 160 */       localPreparedStatement1.setString(1, paramString2);
/* 161 */       ResultSet localResultSet1 = localPreparedStatement1.executeQuery();
/* 162 */       localResultSet1.next();
/* 163 */       String str1 = localResultSet1.getString(1);
/* 164 */       System.out.println("cat id : " + str1);
/* 165 */       localResultSet1.close();
/* 166 */       localPreparedStatement1.close();
/* 167 */       if (str1 != null)
/*     */       {
/* 169 */         PreparedStatement localPreparedStatement2 = this.con.prepareStatement("select * from item_master where catid =? and summary like ?");
/* 170 */         int i = Integer.parseInt(str1);
/* 171 */         localPreparedStatement2.setString(1, str1);
/* 172 */         localPreparedStatement2.setString(2, "%" + paramString1 + "%");
/* 173 */         ResultSet localResultSet2 = localPreparedStatement2.executeQuery();
/* 174 */         System.out.println("after result set: " + paramString1);
/* 175 */         while (localResultSet2.next())
/*     */         {
/* 177 */           System.out.println("1");
/* 178 */           String str2 = localResultSet2.getString(1) + "~" + localResultSet2.getString(2) + "~" + localResultSet2.getString(3) + "~" + localResultSet2.getString(4) + "~" + localResultSet2.getString(5) + "~" + localResultSet2.getString(6) + "~" + localResultSet2.getString(7) + "~" + localResultSet2.getString(8) + "~" + localResultSet2.getString(9) + "~" + localResultSet2.getString(10) + "~" + localResultSet2.getString(11);
/* 179 */           System.out.println("2");
/* 180 */           localVector.addElement(str2);
/* 181 */           System.out.println("3");
/*     */         }
/*     */       }
/*     */     } catch (Exception localException) { localException.printStackTrace(); }
/* 185 */     return localVector;
/*     */   }
/*     */ }

