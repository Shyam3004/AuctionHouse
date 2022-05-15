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
        <form id="form1" action="RegistrationServlet" method="post">
          <p align="center"><b><font face="Arial" color="#cc0000" size="4">Step One<font 
  color="#003399" size="3"> - </font></font><font face="Arial" color="#003399" 
  size="3">Your information </font></b> </p>
          <center>
          <table bordercolor="#cccc99" cellspacing="0" cellpadding="0" width="500" border="1">
            <tbody>
              <tr>
                <td><table cellspacing="2" cellpadding="2" width="100%" border="0">
                    <tbody>
                      <tr>
                        <td valign="top" align="right" width="39%" bgcolor="#bae39a"><table cellspacing="0" cellpadding="0" width="100%" border="0">
                            <tbody>
                              <tr bgcolor="#bae39a">
                                <td align="right" colspan="2"><font face="Arial" size="2"><b>Login 
                                  ID:</b></font> </td>
                              </tr>
                              <tr>
                                <td align="right" width="49%" bgcolor="#bae39a"><font 
                    face="Arial"><font face="Arial" size="1"></font></font></td>
                                <td align="right" width="51%">&nbsp;</td>
                              </tr>
                            </tbody>
                        </table></td>
                        <td valign="top" nowrap="nowrap" width="61%"><font size="2">
                          <input name="uname" 
              size="30" maxlength="20" />
                          </font><font face="Arial" color="#cc0000" 
              size="2"><b>*</b><br />
                            </font><font face="Arial" size="1">Not case 
                              sensitive, 5 characters minimum, 20 maximum<br />
                            </font></td>
                      </tr>
                      <tr valign="top">
                        <td valign="top" align="right" width="39%" bgcolor="#bae39a"><b><font 
              face="Arial" size="2">Password:</font></b></td>
                        <td valign="top" width="61%"><font size="2">
                          <input type="password" 
              maxlength="30" size="30" name="password" />
                          </font><b><font face="Arial" 
              color="#cc0000" size="2">*</font></b><br />
                          <font face="Arial" 
              size="1"><br />
                        </font></td>
                      </tr>
                      <tr>
                        <td align="right" width="39%" bgcolor="#bae39a"><b><font face="Arial" 
              size="2">Verify Password:</font> </b></td>
                        <td width="61%"><font size="2">
                          <input type="password" maxlength="30" 
              size="30" name="verpwd" />
                        </font><b><font face="Arial" color="#cc0000" 
              size="2">*</font></b></td>
                      </tr>
                      <tr>
                        <td valign="top" align="right" width="39%" bgcolor="#bae39a"><b><font 
              face="Arial" size="2">Primary Email Address:</font> </b></td>
                        <td valign="top" width="61%"><font size="2">
                          <input name="email" 
              size="30" maxlength="50" />
                          </font><b><font face="Arial" color="#cc0000" 
              size="2">*</font></b><br />
                          <font face="Arial" size="1">Address of all your 
                            correspondence.</font><br /></td>
                      </tr>
                      <tr>
                        <td align="right" width="39%" bgcolor="#bae39a"><b><font face="Arial" 
              size="2">First Name: </font></b></td>
                        <td><font size="2">
                          <input name="fname" size="30" maxlength="14" />
                          </font><b><font face="Arial" color="#cc0000" size="2">*</font></b>&nbsp; 
                          &nbsp; </td>
                      </tr>
                      <tr>
                        <td align="right" width="39%" bgcolor="#bae39a"><b><font face="Arial" 
              size="2">Last Name:</font></b></td>
                        <td width="61%"><font size="2">
                          <input maxlength="14" size="30" 
              name="lname" />
                        </font><b><font face="Arial" color="#cc0000" 
              size="2">*</font></b></td>
                      </tr>
                      <tr valign="top">
                        <td align="right" width="39%" bgcolor="#bae39a"><b><font face="Arial" 
              size="2"><b>Phone Number:</b></font></b> </td>
                        <td nowrap="nowrap" width="61%"><font size="2">
                          <input maxlength="10" size="10" 
              name="phno" />
                          </font><b><font color="#cc0000">*</font><font face="Arial" 
              size="1"><br />
                            Just Numbers, No dashes</font><font 
              color="#cc0000"></font><b><font color="#cc0000"> </font></b></b></td>
                      </tr>
                    </tbody>
                </table></td>
              </tr>
            </tbody>
          </table>
          <br />
          <b><font 
  face="Arial" color="#cc0000" size="4">Step Two<font color="#003399" size="3"> - </font></font><font face="Arial" color="#003399" size="3">Address Information </font></b>
          <center>
            <table bordercolor="#cccc99" cellspacing="0" cellpadding="0" width="500" border="1">
              <tbody>
                <tr>
                  <td><table cellspacing="2" cellpadding="2" width="100%" border="0">
                      <tbody>
                        <tr>
                          <td bgcolor="#bae39a" colspan="2"><div><font face="Arial" color="#000000" size="2"><b><font 
              color="#003399">Address Information:</font> </b><small></small></font></div></td>
                        </tr>
                        <tr>
                          <td align="right" width="39%" bgcolor="#bae39a"><b><font face="Arial" 
              size="2">House No:</font></b></td>
                          <td nowrap="nowrap" width="61%"><font size="2">
                            <input maxlength="30" size="30" 
              name="hno" />
                          </font><b><font color="#cc0000">*</font></b><br /></td>
                        </tr>
                        <tr>
                          <td align="right" width="39%" bgcolor="#bae39a"><b><font face="Arial" 
              size="2">Street No:</font></b></td>
                          <td width="61%"><font size="2">
                            <input maxlength="30" size="30" 
              name="stno" />
                            <font size="1"><br />
                              Please enter full street 
                              address.</font> </font></td>
                        </tr>
                        <tr height="45">
                          <td valign="top" align="right" width="39%" bgcolor="#bae39a"><b><font 
              face="Arial" size="2">City:</font></b></td>
                          <td nowrap="nowrap" width="61%"><font size="2">
                            <input maxlength="30" size="30" 
              name="city" />
                            </font><b><font color="#cc0000">*</font></b><br />
                            <font 
              size="1">Full spelling, no punctuation or numbers.</font></td>
                        </tr>
                        <tr>
                          <td align="right" width="39%" bgcolor="#bae39a"><b><font face="Arial" 
              size="2">State:</font></b></td>
                          <td nowrap="nowrap"><font size="2">
                            <select size="1" name="state">
                              <option 
                selected="selected">A.P</option>
                              <option>T.M</option>
                              <option>K.A</option>
                              <option>KL</option>
                              <option>B.H</option>
                              <option>AZ</option>
                              <option>AR</option>
                              <option>CA</option>
                              <option>CO</option>
                              <option>CT</option>
                              <option>DE</option>
                              <option>DC</option>
                              <option>FL</option>
                              <option>GA</option>
                              <option>HI</option>
                              <option>ID</option>
                              <option>IL</option>
                              <option>IN</option>
                              <option>IA</option>
                              <option>KS</option>
                              <option>KY</option>
                              <option>LA</option>
                              <option>ME</option>
                              <option>MD</option>
                              <option>MA</option>
                              <option>MI</option>
                              <option>MN</option>
                              <option>MS</option>
                              <option>MO</option>
                              <option>MT</option>
                              <option>NE</option>
                              <option>NV</option>
                              <option>NH</option>
                              <option>NJ</option>
                              <option>NM</option>
                              <option>NY</option>
                              <option>NC</option>
                              <option>ND</option>
                              <option>OH</option>
                              <option>OK</option>
                              <option>OR</option>
                              <option>PA</option>
                              <option>RI</option>
                              <option>SC</option>
                              <option>SD</option>
                              <option>TN</option>
                              <option>TX</option>
                              <option>UT</option>
                              <option>VT</option>
                              <option>VA</option>
                              <option>WA</option>
                              <option>WV</option>
                              <option>WI</option>
                              <option>WY</option>
                            </select>
                          </font><font 
              color="#cc0000"><b>*</b></font></td>
                        </tr>
                        <tr>
                          <td align="right" width="39%" bgcolor="#bae39a"><b><font face="Arial" 
              size="2">Country:</font></b></td>
                          <td width="61%"><font face="Arial"><font size="2">
                            <select size="1" 
              name="country">
                              <option selected="selected">India</option>
                              <option>Australia</option>
                              <option>bangladesh</option>
                              <option>pakistan</option>
                              <option>japan</option>
                              <option>newzland</option>
                              <option>AR</option>
                              <option>CA</option>
                              <option>CO</option>
                              <option>CT</option>
                              <option>DE</option>
                              <option>DC</option>
                              <option>FL</option>
                              <option>GA</option>
                              <option>HI</option>
                              <option>ID</option>
                              <option>IL</option>
                              <option>IN</option>
                              <option>IA</option>
                              <option>KS</option>
                              <option>KY</option>
                              <option>LA</option>
                              <option>ME</option>
                              <option>MD</option>
                              <option>MA</option>
                              <option>MI</option>
                              <option>MN</option>
                              <option>MS</option>
                              <option>MO</option>
                              <option>MT</option>
                              <option>NE</option>
                              <option>NV</option>
                              <option>NH</option>
                              <option>NJ</option>
                              <option>NM</option>
                              <option>NY</option>
                              <option>NC</option>
                              <option>ND</option>
                              <option>OH</option>
                              <option>OK</option>
                              <option>OR</option>
                              <option>PA</option>
                              <option>RI</option>
                              <option>SC</option>
                              <option>SD</option>
                              <option>TN</option>
                              <option>TX</option>
                              <option>UT</option>
                              <option>VT</option>
                              <option>VA</option>
                              <option>WA</option>
                              <option>WV</option>
                              <option>WI</option>
                              <option>WY</option>
                            </select>
                          </font><font 
              color="#cc0000" size="1"><b>*</b></font></font></td>
                        </tr>
                        <tr>
                          <td align="right" width="39%" bgcolor="#bae39a"><b><font face="Arial" 
              size="2">&nbsp;Zip:</font></b></td>
                          <td width="61%"><font face="Arial">
                            <input maxlength="6" size="15" 
              name="pin" />
                          </font></td>
                        </tr>
                        <tr>
                          <td bgcolor="#bae39a"></td>
                        </tr>
                      </tbody>
                  </table></td>
                </tr>
              </tbody>
            </table>
          </center>
          <br />
          <center>
            <table bordercolor="#cccc99" height="37" cellspacing="0" cellpadding="0" width="268" 
  border="1">
              <tbody>
                <tr>
                  <td><input onfocus="MM_validateForm('uname','','R','email','','RisEmail','fname','','R','phno','','RisNum','hno','','R','city','','R','password','','R','verpwd','','R');NoPopup();return;return document.MM_returnValue" document.mm_returnvalue="document.mm_returnvalue" type="submit" value="COMPLETE MY REGISTRATION" name="submitRegistration" /></td>
                </tr>
              </tbody>
            </table>
          </center>
          <p align="center"></p>
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
