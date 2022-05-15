/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.Statement;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletConfig;
/*    */ import javax.servlet.ServletContext;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ public class DelCatItem extends HttpServlet
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
/*    */   public void doPost(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) throws ServletException, IOException {
/*    */     try {
/* 22 */       Statement localStatement = this.con.createStatement();
/* 23 */       String[] arrayOfString = paramHttpServletRequest.getParameterValues("chk");
/* 24 */       Object localObject = null;
/* 25 */       for (int i = 0; i < arrayOfString.length; i++)
/*    */       {
/*    */         try
/*    */         {
/* 29 */           localStatement.executeQuery("delete from category_master where catid=" + arrayOfString[i]);
/*    */         }
/*    */         catch (Exception localException2)
/*    */         {
/* 33 */           localException2.printStackTrace();
/*    */         }
/*    */       }
/* 36 */       RequestDispatcher localRequestDispatcher = paramHttpServletRequest.getRequestDispatcher("./DelItemCat");
/* 37 */       localRequestDispatcher.forward(paramHttpServletRequest, paramHttpServletResponse);
/*    */     }
/*    */     catch (Exception localException1)
/*    */     {
/* 41 */       localException1.printStackTrace();
/*    */     }
/*    */   }
/*    */ }

