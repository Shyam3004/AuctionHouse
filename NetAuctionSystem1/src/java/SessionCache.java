/*    */ import java.util.Enumeration;
/*    */ import java.util.Hashtable;
/*    */ 
/*    */ class SessionCache
/*    */   implements Runnable
/*    */ {
/*    */   private Hashtable sessionCache;
/*    */   private long flush;
/*    */   private Thread reaper;
/*    */ 
/*    */   SessionCache(long paramLong)
/*    */   {
/* 11 */     this.flush = paramLong;
/* 12 */     this.sessionCache = new Hashtable(100);
/* 13 */     this.reaper = new Thread(this);
/* 14 */     this.reaper.setPriority(1);
/* 15 */     this.reaper.start();
/*    */   }
/*    */ 
/*    */   public void run() {
/*    */     try {
/*    */       while (true) {
/* 21 */         Thread.sleep(this.flush);
/*    */ 
/* 25 */         long l = System.currentTimeMillis();
/* 26 */         Enumeration localEnumeration = this.sessionCache.elements();
/* 27 */         while (localEnumeration.hasMoreElements()) {
/* 28 */           Session localSession = (Session)localEnumeration.nextElement();
/* 29 */           if (l >= localSession.getExpires())
/* 30 */             this.sessionCache.remove(localSession.key());
/*    */         }
/*    */       }
/*    */     }
/*    */     catch (Exception localException)
/*    */     {
/*    */     }
/*    */   }
/*    */ 
/*    */   Session put(Session paramSession) {
/* 40 */     return (Session)this.sessionCache.put(paramSession.key(), paramSession);
/*    */   }
/*    */ 
/*    */   Session get(String paramString) {
/* 44 */     return (Session)this.sessionCache.get(paramString);
/*    */   }
/*    */ 
/*    */   Enumeration elements() {
/* 48 */     return this.sessionCache.elements();
/*    */   }
/*    */ 
/*    */   Enumeration keys() {
/* 52 */     return this.sessionCache.keys();
/*    */   }
/*    */ 
/*    */   void remove(Session paramSession) {
/* 56 */     this.sessionCache.remove(paramSession.key());
/*    */   }
/*    */ }

