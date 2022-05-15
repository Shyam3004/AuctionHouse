/*    */ import java.net.URLDecoder;
/*    */ import java.net.URLEncoder;
/*    */ import java.util.Random;
/*    */ 
/*    */ public class Session
/*    */ {
/*    */   private String theuser;
/*    */   private int id;
/*    */   private long expires;
/*    */ 
/*    */   public Session(String paramString)
/*    */   {
/* 10 */     this.theuser = URLEncoder.encode(paramString);
/* 11 */     this.id = Math.abs(new Random(System.currentTimeMillis()).nextInt());
/* 12 */     this.expires = 0L;
/*    */   }
/*    */ 
/*    */   public synchronized void setExpires(long paramLong) {
/* 16 */     this.expires = paramLong;
/*    */   }
/*    */ 
/*    */   public long getExpires() {
/* 20 */     return this.expires;
/*    */   }
/*    */ 
/*    */   public String key() {
/* 24 */     return String.valueOf(this.id);
/*    */   }
/*    */ 
/*    */   public String getEncodedUser() {
/* 28 */     return this.theuser;
/*    */   }
/*    */ 
/*    */   public String getUser() {
/*    */     try {
/* 33 */       return URLDecoder.decode(this.theuser); } catch (Exception localException) {
/*    */     }
/* 35 */     return null;
/*    */   }
/*    */ 
/*    */   public int getId()
/*    */   {
/* 40 */     return this.id;
/*    */   }
/*    */ }

