/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;

/*     */ import javax.servlet.ServletConfig;
/*     */ import javax.servlet.ServletContext;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.http.Cookie;
/*     */ import javax.servlet.http.HttpServlet;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ 
/*     */ public class SellServlet extends HttpServlet
/*     */ {
/*     */   protected SessionCache sessionCache;
/*  12 */   protected long flushTimeout = 600000L;
/*  13 */   protected long sessionTimeout = 7200000L;
		Connection con;
/*     */ 
/*     */   public Connection getConnection() throws SQLException
/*     */   {
/*  17 */     Connection localConnection = null;
/*     */     try {
/*  19 */      Class.forName("com.mysql.jdbc.Driver");
/* 14 */       this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/netauction","root","password");
/*     */     } catch (Exception localException) {
/*     */     }
/*  23 */     return localConnection;
/*     */   }
/*     */ 
/*     */   public void init(ServletConfig paramServletConfig) throws ServletException {
/*  27 */     super.init(paramServletConfig);
/*  28 */     this.sessionCache = new SessionCache(this.flushTimeout);
/*     */   }
/*     */ 
/*     */   public void doPost(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
/*     */     throws IOException
/*     */   {
/*  34 */     Object localObject = null;
/*     */ 
/*  37 */     paramHttpServletResponse.setContentType("text/html");
/*  38 */     PrintWriter localPrintWriter = paramHttpServletResponse.getWriter();
/*  39 */     localPrintWriter.println("<BODY bgColor=#a3d881 leftMargin=0 topMargin=0 MARGINHEIGHT=0 MARGINWIDTH=0><!-- ImageReady Slices (Untitled-1) -->");
/*     */ 
/*  42 */     localPrintWriter.println("<p align=right><TABLE cellSpacing=0 cellPadding=0 width=781 border=0><TBODY><BR><TR><TD><A href='./home.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>HOME</STRONG></A> </TD>      <TD>  <A href='./login.jsp'><STRONG> <FONT COLOR='BROWN' FACE='CURLZ MT'>LOGIN</STRONG>  </A></TD>      <TD>    <A href='./registration.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>REGISTER</STRONG></A></TD>    <TD> <A href='./sell.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>SELL</STRONG>      </A></TD>   <TD> <A href='./ForSale.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>CURRENT BID ITEMS</STRONG>      </A></TD> <TD> <A href='./help.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>HELP</STRONG> </A></TD></TR><TD></TD>  </TBODY></TABLE></p><br><br>");
/*  43 */     localPrintWriter.println("<p align=right><FORM name=form1 action='./SearchServlet'  method=post >Search:<INPUT name=sstring> ");
/*  44 */     localPrintWriter.println("<SELECT  name=category > <option >Choose Category</option>");
/*     */     try {
/*  46 */       Connection localConnection1 = getConnection();
/*  47 */       Statement localStatement1 = localConnection1.createStatement();
/*  48 */       ResultSet localResultSet1 = localStatement1.executeQuery("select cat_name from category_master");
/*  49 */       while (localResultSet1.next())
/*  50 */         localPrintWriter.println("<OPTION>" + localResultSet1.getString(1) + "</OPTION>");
/*  51 */       localPrintWriter.println("</SELECT> <INPUT type=submit value=Go > ");
/*  52 */       localPrintWriter.println("</FORM></p><!-- End ImageReady Slices -->");
/*     */ 	//Session localSession = "null";
/*  54 */       Session localSession = validateSession(paramHttpServletRequest, paramHttpServletResponse);
/*  55 */       setNoCache(paramHttpServletRequest, paramHttpServletResponse);
/*     */ 
/*  57 */       if (localSession == null)
/*     */       {
/*  59 */         String str1 = paramHttpServletRequest.getParameter("seller");
		System.out.println("seller="+str1);
/*  60 */         String str2 = paramHttpServletRequest.getParameter("password");
/*  61 */         String str3 = paramHttpServletRequest.getParameter("itemname");
/*  62 */         String str4 = paramHttpServletRequest.getParameter("category");
/*  63 */         String str5 = paramHttpServletRequest.getParameter("description");
/*  64 */         String str6 = paramHttpServletRequest.getParameter("summary");
/*  65 */         int d1 = Integer.parseInt(paramHttpServletRequest.getParameter("startprice"));
/*  66 */         int d2 = Integer.parseInt(paramHttpServletRequest.getParameter("incrprice"));
/*  67 */         int i = Integer.parseInt(paramHttpServletRequest.getParameter("auctiondays"));
			String enddate = paramHttpServletRequest.getParameter("enddate");
/*     */ 
/*  69 */         ResultSet localResultSet2 = localStatement1.executeQuery("select pwd from uinfo_master where uname='" + str1 + "' ");
/*  70 */         boolean bool = localResultSet2.next();
/*  71 */         if (bool == true)
/*     */         {
/*  73 */           String str7 = localResultSet2.getString(1);
/*  74 */           System.out.println(str7);
/*  75 */           System.out.println(str2);
/*  76 */           System.out.println(str7.equals(str2));
/*  77 */           if (str7.equals(str2))
/*     */           {
/*  79 */             localSession = startSession(paramHttpServletRequest.getParameter("seller"), paramHttpServletRequest.getParameter("password"), paramHttpServletResponse);
/*  80 */             PreparedStatement localPreparedStatement1 = localConnection1.prepareStatement("select catid from category_master where cat_name=?");
/*  81 */             localPreparedStatement1.setString(1, str4);
/*  82 */             localResultSet1 = localPreparedStatement1.executeQuery();
/*  83 */             localResultSet1.next();
/*  84 */             String str8 = localResultSet1.getString(1);
/*  85 */             int j = str8.charAt(0);
/*  86 */             System.out.println("cword: " + j);
/*  87 */             PreparedStatement localPreparedStatement2 = localConnection1.prepareStatement("select max(itemid) from item_master");
/*  88 */             ResultSet localResultSet3 = localPreparedStatement2.executeQuery();
/*  89 */             localResultSet3.next();
/*  90 */             String str9 = "";
/*  91 */             int k = 0;
/*  92 */             str9 = "" + localResultSet3.getString(1);
/*  93 */             System.out.println(str9);
/*  94 */             if (str9.equals("null"))
/*  95 */               k = 0;
/*     */             else {
/*  97 */               k = Integer.parseInt(str9);
/*     */             }
/*  99 */             System.out.println("1: " + k);
/* 100 */             String str10 = "";
/* 101 */             k++;
/* 102 */             System.out.println("2: " + k);
/*     */ 
/* 104 */             System.out.println("3: " + str10);
/*     */ 
/* 106 */             Connection localConnection2 = getConnection();
/* 107 */             Statement localStatement2 = localConnection2.createStatement();
/* 108 */             String str11 = "insert into item_master values(" + k + "," + str8 + ",'" + str3 + "','" + str5 + "','" + str6 + "'," + d1 + "," + d2 + ",CURDATE(),'"+enddate+"','" + str1 + "',0) ";
/* 109 */             System.out.println("----" + str11 + " -------");
/* 110 */             int m = localStatement2.executeUpdate(str11);
/*     */ 
/* 112 */             localPrintWriter.println("<b><center> U have Sucess fully have posted u r item to auction online<b><br>");
/* 113 */             localPrintWriter.println("<br> <center>u r item id is: <b> " + str10);
/*     */ 
/* 115 */             localConnection1.close();
/*     */           }
/*     */           else
/*     */           {
/* 119 */             localPrintWriter.println("<br><br><center>wrong password");
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 124 */           localPrintWriter.println("<br><br>user name does not exist");
/*     */         }
/*     */       }
/* 127 */       localPrintWriter.println("</b><br><br><br></CENTER><CENTER><STRONG></STRONG>");
/* 128 */       localPrintWriter.println("<A href='./NewToday'>New Items</A><STRONG></STRONG>");
/* 129 */       localPrintWriter.println("<A href='./EndToday'>Closing Items</A>");
/* 130 */       localPrintWriter.println("<STRONG></STRONG><A href=./sell.jsp>Sell Items</A>");
/* 131 */       localPrintWriter.println("<STRONG></STRONG><A href=./home.jsp>Home/Search</A>"); } catch (Exception localException) {
/* 132 */       localException.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   protected boolean verifyPassword(String paramString1, String paramString2) {
/* 137 */     String str = null;
/*     */     try
/*     */     {
/* 141 */       Connection localConnection = getConnection();
/* 142 */       Statement localStatement = localConnection.createStatement();
/* 143 */       localStatement.executeQuery("select pwd from uinfo_master where uname='" + paramString1 + "'");
/* 144 */       ResultSet localResultSet = localStatement.getResultSet();
/* 145 */       if (localResultSet.next())
/*     */       {
/* 147 */         str = localResultSet.getString(1);
/*     */       }
/* 149 */       localStatement.close();
/* 150 */       localConnection.close();
/* 151 */       if (str.equals(paramString2))
/*     */       {
/* 153 */         return true;
/*     */       }
/*     */ 
/* 157 */       return false;
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/* 162 */       System.out.println("Exception: verifyPassword=" + localException);
/*     */     }
/* 164 */     return false;
/*     */   }
/*     */ 
/*     */   protected Session startSession(String paramString1, String paramString2, HttpServletResponse paramHttpServletResponse)
/*     */   {
/* 169 */     Session localSession = null;
/* 170 */     if (verifyPassword(paramString1, paramString2))
/*     */     {
/* 172 */       localSession = new Session(paramString1);
/* 173 */       localSession.setExpires(this.sessionTimeout + System.currentTimeMillis());
/* 174 */       this.sessionCache.put(localSession);
/*     */ 
/* 177 */       Cookie localCookie = new Cookie("AUCTION", String.valueOf(localSession.getId()));
/* 178 */       localCookie.setMaxAge(-1);
/* 179 */       paramHttpServletResponse.addCookie(localCookie);
/*     */     }
/* 181 */     return localSession;
/*     */   }
/*     */ 
/*     */   private Session validateSession(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) {
/* 185 */     Cookie[] arrayOfCookie = paramHttpServletRequest.getCookies();
/* 186 */     Session localSession = null;
/* 187 */     if (arrayOfCookie != null) {
/* 188 */       for (int i = 0; (i < arrayOfCookie.length) && (localSession == null); i++) {
/* 189 */         if (arrayOfCookie[i].getName().equals("AUCTION")) {
/* 190 */           String str = String.valueOf(arrayOfCookie[i].getValue());
/* 191 */           localSession = this.sessionCache.get(str);
/*     */         }
/*     */       }
/*     */     }
/* 195 */     return localSession;
/*     */   }
/*     */ 
/*     */   protected void endSession(Session paramSession) {
/* 199 */     synchronized (this.sessionCache) {
/* 200 */       this.sessionCache.remove(paramSession);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void setNoCache(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
/*     */   {
/* 207 */     if (paramHttpServletRequest.getProtocol().compareTo("HTTP/1.0") == 0)
/* 208 */       paramHttpServletResponse.setHeader("Pragma", "no-cache");
/* 209 */     else if (paramHttpServletRequest.getProtocol().compareTo("HTTP/1.1") == 0) {
/* 210 */       paramHttpServletResponse.setHeader("Cache-Control", "no-cache");
/*     */     }
/* 212 */     paramHttpServletResponse.setDateHeader("Expires", 0L);
/*     */   }
/*     */ }

