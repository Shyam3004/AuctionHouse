<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
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
.style21 {color: #687A66}
.style22 {font-size: medium;
	font-weight: bold;
}
.style22 {font-size: medium; font-weight: bold; color: #687A66; }
.style5 {color: #E1EAF1;
	font-size: 24px;
}
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
          <li><a href="adminlogin.jsp"><span> User Logout </span></a></li>
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
              <table width="668" height="224" border="0" >
                <tr>
                  <td height="52" colspan="6" bgcolor="#666666"><div align="center"><span class="style5">Bidding Information </span></div></td>
                </tr>
                <tr>
                  <td width="112" bordercolor="#FFFFFF"><div align="center" class="style22">Item Name </div></td>
                  <td width="296" bordercolor="#FFFFFF"><div align="center" class="style21"><span class="style22">Description</span></div></td>
                  <td width="296" bordercolor="#FFFFFF"><div align="center"><span class="style22">Summary</span></div></td>
                  <td width="296" bordercolor="#FFFFFF"><div align="center"><span class="style22">Start Date </span></div></td>
                  <td width="296" bordercolor="#FFFFFF"><div align="center"><span class="style22">End Date </span></div></td>
                  <td width="296" bordercolor="#FFFFFF"><div align="center"><span class="style22">Seller</span></div></td>
                </tr>
                <%
                                        try {
                                         
							//String username, user;
        PreparedStatement ps;
        ResultSet rs;
		//Connection con = null;
		Statement st,st1,st2,st3,st4;
                                            
                                            Class.forName("com.mysql.jdbc.Driver");
                                      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/netauction","root","password");
                                            String query = "select * from item_master"; 
                                            st = con.createStatement();
                                            rs = st.executeQuery(query);

                                            while (rs.next()) {
                                                
                                                String s1 = rs.getString(3);
                                                String s2 = rs.getString(4);
												
												String s3 = rs.getString(5);
                                                String s4 = rs.getString(8);
												
												String s5 = rs.getString(9);
                                                String s6 = rs.getString(10);
												 
                                               
                                               // String oriName[] = fileName.split("____");
                                               // oriName[1].split("\\.");
                                              //  String originalName =oriName[0]+"."+oriName[1].split("\\.")[1];
                                    %>
                <tr>
                  <td><div align="center"><%=s1%></div></td>
                  <td><div align="center"><%=s2%></div></td>
                  <td><div align="center"><%=s3%></div></td>
                  <td><div align="center"><%=s4%></div></td>
                  <td><div align="center"><%=s5%></div></td>
                  <td><div align="center"><%=s6%></div></td>
                </tr>
                <tr>
                  <td colspan="6"><div align="center"></div></td>
                </tr>
                <%

                                            }
                                            con.close();
                                        } catch (Exception e) {
                                            out.println(e);
                                        }

                                    %>
              </table>
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
          <li></li>
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
