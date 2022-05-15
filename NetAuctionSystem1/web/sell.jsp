<%@ page import="java.sql.*"%>
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
.style34 {font-size: x-large}
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

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_validateForm() { //v4.0
  var i,p,q,nm,test,num,min,max,errors='',args=MM_validateForm.arguments;
  for (i=0; i<(args.length-2); i+=3) { test=args[i+2]; val=MM_findObj(args[i]);
    if (val) { nm=val.name; if ((val=val.value)!="") {
      if (test.indexOf('isEmail')!=-1) { p=val.indexOf('@');
        if (p<1 || p==(val.length-1)) errors+='- '+nm+' must contain an e-mail address.\n';
      } else if (test!='R') { num = parseFloat(val);
        if (isNaN(val)) errors+='- '+nm+' must contain a number.\n';
        if (test.indexOf('inRange') != -1) { p=test.indexOf(':');
          min=test.substring(8,p); max=test.substring(p+1);
          if (num<min || max<num) errors+='- '+nm+' must contain a number between '+min+' and '+max+'.\n';
    } } } else if (test.charAt(0) == 'R') errors += '- '+nm+' is required.\n'; }
  } if (errors) alert('The following error(s) occurred:\n'+errors);
  document.MM_returnValue = (errors == '');
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
             <form action="SellProduct" method="post" enctype="multipart/form-data" id="form1">
                <table height="472" width="583" align="center">
                  <tbody>
                    <tr>
                      <td height="53" colspan="2" align="right" valign="center"><div align="center" class="style34">SELL ITEMS </div></td>
                      </tr>
                    <tr>
                      <td valign="center" align="right" width="235"><div align="left"><strong> Enter user 
                        name:</strong></div></td>
                      <td valign="center" width="336"><input readonly="true" name="seller" value="<%=session.getAttribute("user")%>" /></td>
                    </tr>
                    
                    <tr>
                      <td height="21" align="right" valign="center"><div align="left"><strong>Item Name:</strong></div></td>
                      <td valign="center"><input id="itemname" name="itemname" /></td>
                    </tr>
                    <tr>
                      <td height="31" align="right" valign="top"><div align="left"><strong>Category:</strong></div></td>
                      <td valign="top"><select name="category" id="category">
                          <option selected="selected">Choose Category</option>
                          <%try
	{
		Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/netauction","root","password");
         Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select catid,cat_name from category_master");
		while(rs.next()){%>
                          <option value="<%=rs.getString(1)%>"><%=rs.getString(2)%></option>
                        <%}
		}catch(Exception e) { System.out.println(e); }%>
                        </select>
                          <label></label></td>
                    </tr>
                    <tr>
                      <td valign="top" align="right"><div align="left"><strong>Summary:</strong></div></td>
                      <td valign="center"><input size="40" name="summary" /></td>
                    </tr>
                    <tr>
                      <td valign="center" align="right"><div align="left"><strong>Initial starting price: </strong></div></td>
                      <td valign="center"><input size="10" name="startprice" /></td>
                    </tr>
                    <tr>
                      <td valign="center" align="right"><div align="left"><strong>Increment Price:</strong></div></td>
                      <td valign="center"><input id="incrprice" size="10" name="incrprice" /></td>
                    </tr>
                    <tr>
                      <td valign="center" align="right"><div align="left"><strong>Description of item:</strong></div></td>
                      <td valign="center"><textarea name="description" rows="8" cols="40"></textarea></td>
                    </tr>
                    <tr>
                      <td valign="center" align="right"><strong>End date: </strong>:</td>
                      <td valign="center"><input name="enddate" type="text" id="enddate" />
                        (YYYY-MM-DD)</td>
                    </tr>
                    <tr>
                      <td height="33" align="right" valign="center"><strong>Image upload : </strong>:</td>
                      <td valign="center"><input name="fu" type="file" id="fu" /></td>
                    </tr>
                    <tr>
                      <td valign="center" align="right">&nbsp;</td>
                      <td valign="center" align="middle"><input name="Submit" type="submit" onfocus="MM_validateForm('seller','','R','itemname','','R','summary','','R','startprice','','RisNum','incrprice','','RisNum','description','','R','password','','R');return document.MM_returnValue" value="Post Item" /></td>
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
