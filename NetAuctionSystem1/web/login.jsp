<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Net Auction System</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/arial.js"></script>
<script type="text/javascript" src="js/cuf_run.js"></script>
<style type="text/css">
<!--
.style12 {color: #333333}
.style15 {font-size: 18px; color: #333333; }
.style20 {font-size: 18px; color: #996633; }
.style22 {font-size: 24px}
.style23 {font-size: 16px}
.style4 {font-size: 18px}
-->
</style>
<script type="text/javascript">
   <!--
      // Form validation code will come here.
      function validate()
      {
	  var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/; 
var numbers = /^[0-9]+$/;
var letters = /^[a-zA-Z]+$/;
var usecase = /^[0-9a-zA-Z]+$/;
      
         if( document.myForm.username.value == "" )
         {
            alert( "Please provide your username!" );
            document.myForm.username.focus() ;
            return false;
         }
         
         if( document.myForm.password.value == "" )
         {
            alert( "Please provide your password!" );
            document.myForm.password.focus() ;
            return false;
         }
         
                
         if( document.myForm.fullname.value == "" )
         {
            alert( "Please provide your fullname!" );
			document.myForm.fullname.focus() ;
            return false;
         }
		 
		  if( document.myForm.age.value == "" || !document.myForm.age.value.match(numbers) )
         {
            alert( "Please provide your age!" );
			document.myForm.age.focus() ;
            return false;
         }
		 
		   if( document.myForm.prof.value == "" )
         {
            alert( "Please provide your profession!" );
			document.myForm.prof.focus() ;
            return false;
         }
		 
		  if( document.myForm.city.value == "" )
         {
            alert( "Please provide your city!" );
			document.myForm.city.focus() ;
            return false;
         }
		 
		 if( document.myForm.state.value == "" )
         {
            alert( "Please provide your state!" );
			document.myForm.state.focus() ;
            return false;
         }
		 
		  if( document.myForm.country.value == "" )
         {
            alert( "Please provide your country!" );
			document.myForm.country.focus() ;
            return false;
         }
		 
		  if( document.myForm.mobileno.value == "" || !document.myForm.mobileno.value.match(numbers) || document.myForm.mobileno.value.length < 10 || document.myForm.mobileno.value.length > 10)
         {
            alert( "Please provide your mobileno!" );
			document.myForm.mobileno.focus() ;
            return false;
         }
		 
		  if( document.myForm.emailid.value == "" || !document.myForm.emailid.value.match(mailformat))
         {
            alert( "Please provide your emailid!" );
			document.myForm.emailid.focus() ;
            return false;
         }
		 
         return( true );
      }
   //-->
</script>
</head>
<body>
<!-- START PAGE SOURCE -->
<div class="main">
  <div class="header">
    <div class="header_resize">
      <div class="menu">
        <ul>
          <li><a href="index.jsp" class="active"><span> Home </span></a></li>
          <li><a href="register.jsp"><span> User Registration </span></a></li>
          <li><a href="userlogin.jsp"><span> User Login </span></a></li>
          
        </ul>
      </div>
      <div class="search">
        <form id="form1" name="form1" method="post" action="#">
        </form>
      </div>
      <div class="clr"></div>
      <div class="logo">
        <h1><a href="index.html"><span>Net Auction System </span><br />
        </a></h1>
      </div>
      <div class="clr"></div>
    </div>
  </div>
  <div class="body">
    <div class="body_resize">
      <div class="left">
        <form id="form1" name="form1" method="post" action="LoginServlet">
           <table width="384" height="186" border="0" bordercolor="#666666">
             <tbody>
               <tr>
                 <td height="52" colspan="2" bgcolor="#F1F1F1"><div align="center" class="style12"><span class="style22">User Login</span></div></td>
               </tr>
               <tr>
                 <td width="187" height="57" bgcolor="#F1F1F1" class="style4"><div align="center" class="style15">Username </div></td>
                 <td width="187" bgcolor="#F1F1F1"><span class="style12">
                   <label></label>
                   </span>
                     <div align="center" class="style12">
                       <label>
                       <input name="theuser" type="text" id="theuser" />
                       </label>
                   </div></td>
               </tr>
               <tr>
                 <td height="57" bgcolor="#F1F1F1" class="style4"><div align="center" class="style12">Password </div></td>
                 <td bgcolor="#F1F1F1"><div align="center" class="style12">
                     <label>
                     <input name="password" type="password" id="password" />
                     </label>
                 </div></td>
               </tr>
               <tr>
                 <td colspan="2" bgcolor="#F1F1F1"><div align="center" class="style12">
                     <label></label>
                     <p>
                       <input type="submit" name="Submit222" value="Login" />
                     </p>
                   <p><a href="register.jsp"><strong>Click here for Registration</strong></a> </p>
                 </div></td>
               </tr>
             </tbody>
           </table>
         </form>
        <h2>&nbsp;</h2>
        <div class="bg"></div>
      </div>
      <div class="right">
        <h2>Sidebar<span> Menu</span></h2>
        <ul>
          <li><a href="index.jsp">Home</a></li>
          <li><a href="register.jsp">User Registration </a></li>
          <li><a href="userlogin.jsp">User Login </a></li>
        </ul>
        <p>&nbsp;</p>
        <h2>&nbsp;</h2>
        <div class="search2">
          <form id="form2" method="post" action="#">
          </form>
        </div>
      </div>
      <div class="clr"></div>
    </div>
  </div>
  <div class="FBG">
    <div class="FBG_resize">
      <div class="clr"></div>
    </div>
  </div>
  <div class="footer">
    <div class="footer_resize">
      <p class="lf">Copyright &copy; - All Rights Reserved</p>
      <div class="clr"></div>
    </div>
  </div>
</div>
</body>
</html>
