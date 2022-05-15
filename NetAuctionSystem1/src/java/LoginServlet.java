/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
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
/*     */ import javax.servlet.http.HttpSession;
/*     */ 
/*     */ public class LoginServlet extends HttpServlet
/*     */ {
/*     */   protected SessionCache sessionCache;
/*  10 */   protected long flushTimeout = 600000L;
/*  11 */   protected long sessionTimeout = 7200000L;
/*     */ 
/*     */   public Connection getConnection() throws SQLException
/*     */   {
/*  15 */     return DriverManager.getConnection("jdbc:mysql://localhost:3306/netauction","root","password");
/*     */   }
/*     */ 
/*     */   public void init(ServletConfig paramServletConfig) throws ServletException
/*     */   {
/*  20 */     super.init(paramServletConfig);
/*     */     try
/*     */     {
/*  24 */       Class.forName("com.mysql.jdbc.Driver");
/* 14 */       //this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/netauction","root","password");
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/*  28 */       System.out.println("new pool error" + localException);
/*     */     }
/*     */ 
/*  31 */     this.sessionCache = new SessionCache(this.flushTimeout);
/*     */   }
/*     */ 
/*     */   public void service(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
/*     */     throws IOException
/*     */   {
/*  37 */     Object localObject = null;
/*     */ 
/*  39 */     HttpSession localHttpSession = paramHttpServletRequest.getSession(true);
/*     */ 
/*  42 */     paramHttpServletResponse.setContentType("text/html");
/*  43 */     PrintWriter localPrintWriter = paramHttpServletResponse.getWriter();
/*     */ 
/*  45 */     Session localSession = validateSession(paramHttpServletRequest, paramHttpServletResponse);
/*     */ 
/*  47 */     String str = paramHttpServletRequest.getParameter("theuser");
/*  48 */     localSession = startSession(str, paramHttpServletRequest.getParameter("password"), paramHttpServletResponse);
/*  49 */     System.out.println("the user=" + str);
/*  50 */     localHttpSession.setAttribute("user", str);
/*  51 */     if (localSession == null)
/*     */     {
/*  53 */       localPrintWriter.println("<BODY bgColor=#a3d881 leftMargin=0 topMargin=0 MARGINHEIGHT=0 MARGINWIDTH=0><!-- ImageReady Slices (Untitled-1) -->");
/*     */ 
/*  56 */       localPrintWriter.println("<p align=right><TABLE cellSpacing=0 cellPadding=0 width=781 border=0><TBODY><BR><TR><TD><A href='./home.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>HOME</STRONG></A> </TD>      <TD>  <A href='./login.jsp'><STRONG> <FONT COLOR='BROWN' FACE='CURLZ MT'>LOGIN</STRONG>  </A></TD>      <TD>    <A href='./registration.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>REGISTER</STRONG></A></TD>    <TD> <A href='./sell.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>SELL</STRONG>      </A></TD>  <TD> <A href='./ForSale.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>CURRENT BID ITEMS</STRONG>      </A></TD> <TD> <A href='./help.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>HELP</STRONG> </A></TD></TR><TD></TD>  </TBODY></TABLE></p><br><br>");
/*  57 */       localPrintWriter.println("<p align=right><FORM name=form1 action='./SearchServlet'  method=post >Search:<INPUT name=sstring> ");
/*  58 */       localPrintWriter.println("<SELECT  name=category > <option >Choose Category</option>");
/*     */       try
/*     */       {
/*  61 */         Connection localConnection = getConnection();
/*  62 */         Statement localStatement = localConnection.createStatement();
/*  63 */         ResultSet localResultSet = localStatement.executeQuery("select cat_name from category_master");
/*  64 */         while (localResultSet.next())
/*  65 */           localPrintWriter.println("<OPTION>" + localResultSet.getString(1) + "</OPTION>");
/*     */       } catch (Exception localException) {
/*     */       }
/*  68 */       localPrintWriter.println("</SELECT> <INPUT type=submit value=Go > ");
/*  69 */       localPrintWriter.println("</FORM></p><!-- End ImageReady Slices -->");
/*  70 */       localPrintWriter.println("<br><br><center><b>in valid user name or password</b></center>");
/*     */ 
/*  72 */       localPrintWriter.println("</center><br><br><br><CENTER><STRONG></STRONG>");
/*  73 */       localPrintWriter.println("<A href='./NewToday'>New Items</A><STRONG></STRONG>");
/*  74 */       localPrintWriter.println("<A href='./EndToday'>Closing Items</A>");
/*  75 */       localPrintWriter.println("<STRONG></STRONG><A href='./sell.jsp'>Sell Items</A>");
/*  76 */       localPrintWriter.println("<STRONG></STRONG><A href='./home.jsp'>Home</A>");
/*  77 */       localPrintWriter.println("<br><br>");
/*     */     }
/*     */ 
/*  81 */     if (localSession != null)
/*     */     {
/*  84 */       if (!paramHttpServletResponse.containsHeader("Expires"))
/*     */       {
/*  87 */         paramHttpServletResponse.setDateHeader("Expires", localSession.getExpires());
/*     */       }
/*  89 */       paramHttpServletResponse.sendRedirect("./userpage.jsp");
/*     */     }
/*     */   }
/*     */ 
/*     */   protected boolean verifyPassword(String paramString1, String paramString2) {
/*  94 */     String str = null;
/*     */     try
/*     */     {
/*  97 */       Connection localConnection = getConnection();
/*  98 */       Statement localStatement = localConnection.createStatement();
/*  99 */       localStatement.executeQuery("select pwd from uinfo_master where uname='" + paramString1 + "'");
/* 100 */       ResultSet localResultSet = localStatement.getResultSet();
/* 101 */       if (localResultSet.next()) {
/* 102 */         str = localResultSet.getString(1);
/* 103 */         System.out.println("Original pwd : " + str);
/* 104 */         System.out.println("Original pwd : " + paramString2);
/*     */       }
/* 106 */       localStatement.close();
/* 107 */       localConnection.close();
/* 108 */       if (str.equals(paramString2)) {
/* 109 */         return true;
/*     */       }
/* 111 */       return false;
/*     */     }
/*     */     catch (Exception localException) {
/* 114 */       System.out.println("Exception: verifyPassword=" + localException);
/* 115 */     }return false;
/*     */   }
/*     */ 
/*     */   protected Session startSession(String paramString1, String paramString2, HttpServletResponse paramHttpServletResponse)
/*     */   {
/* 121 */     Session localSession = null;
/* 122 */     if (verifyPassword(paramString1, paramString2))
/*     */     {
/* 124 */       localSession = new Session(paramString1);
/* 125 */       localSession.setExpires(this.sessionTimeout + System.currentTimeMillis());
/* 126 */       this.sessionCache.put(localSession);
/*     */ 
/* 129 */       Cookie localCookie = new Cookie("AUCTION", String.valueOf(localSession.getId()));
/* 130 */       localCookie.setMaxAge(-1);
/* 131 */       paramHttpServletResponse.addCookie(localCookie);
/*     */     }
/*     */     else {
/* 134 */       return null;
/* 135 */     }return localSession;
/*     */   }
/*     */ 
/*     */   private Session validateSession(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) {
/* 139 */     Cookie[] arrayOfCookie = paramHttpServletRequest.getCookies();
/* 140 */     Session localSession = null;
/* 141 */     if (arrayOfCookie != null) {
/* 142 */       for (int i = 0; (i < arrayOfCookie.length) && (localSession == null); i++) {
/* 143 */         if (arrayOfCookie[i].getName().equals("AUCTION")) {
/* 144 */           String str = String.valueOf(arrayOfCookie[i].getValue());
/* 145 */           localSession = this.sessionCache.get(str);
/*     */         }
/*     */       }
/*     */     }
/* 149 */     return localSession;
/*     */   }
/*     */ 
/*     */   protected void endSession(Session paramSession) {
/* 153 */     synchronized (this.sessionCache) {
/* 154 */       this.sessionCache.remove(paramSession);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void setNoCache(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
/*     */   {
/* 161 */     if (paramHttpServletRequest.getProtocol().compareTo("HTTP/1.0") == 0)
/* 162 */       paramHttpServletResponse.setHeader("Pragma", "no-cache");
/* 163 */     else if (paramHttpServletRequest.getProtocol().compareTo("HTTP/1.1") == 0) {
/* 164 */       paramHttpServletResponse.setHeader("Cache-Control", "no-cache");
/*     */     }
/* 166 */     paramHttpServletResponse.setDateHeader("Expires", 0L);
/*     */   }
/*     */ }
