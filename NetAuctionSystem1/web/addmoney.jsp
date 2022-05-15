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
.style24 {
	font-size: 14px;
	font-weight: bold;
	color: #000000;
	font-family: Arial, Helvetica, sans-serif;
}
.style25 {
	font-weight: bold;
	font-family: Geneva, Arial, Helvetica, sans-serif;
}
.style28 {font-weight: bold}
.style29 {font-size: large}
.style30 {font-weight: bold; font-family: Geneva, Arial, Helvetica, sans-serif; font-size: large; }
.style31 {font-weight: bold}
.style32 {font-size: large; font-weight: bold; }
.style33 {font-weight: bold}
.style12 {color: #333333}
.style15 {font-size: 18px; color: #333333; }
.style22 {font-size: 24px}
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
          <li><a href="register.jsp"></a></li>
          <li><a href="userlogin.jsp"><span> User Logout </span></a></li>
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
        <table width="642" height="249" border="0">
          <tr>
            <td><div align="center">
              <form id="form3" name="form3" method="post" action="AddMoney">
                <table width="384" height="186" border="0" bordercolor="#666666">
                  <tbody>
                    <tr>
                      <td height="52" colspan="2" bgcolor="#F1F1F1"><div align="center" class="style12"><span class="style22">Add Money </span></div></td>
                    </tr>
                    
                    <tr>
                      <td width="187" height="57" bgcolor="#F1F1F1" class="style4"><div align="center" class="style12">Amount</div></td>
                      <td width="187" bgcolor="#F1F1F1"><div align="center" class="style12">
                          <label>
                          <input name="amount" type="text" id="amount" />
                          </label>
                      </div></td>
                    </tr>
                    <tr>
                      <td colspan="2" bgcolor="#F1F1F1"><div align="center" class="style12">
                          <label></label>
                          <p>
                            <input type="submit" name="Submit222" value="Add" />
                          </p>
                          <p>
                            <label>
                            <input name="username" style="visibility:hidden" type="text" id="username" value="<%=session.getAttribute("user")%>" />
                            </label>
                          </p>
                      </div></td>
                    </tr>
                  </tbody>
                </table>
                </form>
              <p>&nbsp;</p>
              <p></p>
            </div></td>
          </tr>
        </table>
        <h2 align="center">&nbsp;</h2>
        <div class="bg"></div>
      </div>
      <div class="right">
        <h2>Sidebar<span> Menu</span></h2>
        <ul>
          <li><a href="login.jsp">Logout</a></li>
          <li><a 
href="wallet.jsp">Wallet</a></li>
          <li><a 
href="./NewToday">New Items</a></li>
          <li><a 
href="./EndToday">Closing Items</a></li>
          <li><a href="./sell.jsp"><strong>SELL</strong></a><a href="register.jsp"></a></li>
          <li><a href='./Buy.jsp?theuser=<%=session.getAttribute("user")%>'><strong>BUY</strong></a><a href="userlogin.jsp"></a></li>
          <li class="style24"><span class="style25"><a
  href="Sold.jsp?theuser=<%=session.getAttribute("user")%>">SOLD ITEMS </a></span></li>
        </ul>
        <p>&nbsp;</p>
        <h2>&nbsp;</h2>
        <div class="search2 style28">
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
