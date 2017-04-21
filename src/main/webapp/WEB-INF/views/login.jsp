<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
<style type="text/css">
  html, body {
    height: 100%;
  }
  #tableContainer-1 {
    height: 100%;
    width: 100%;
    display: table;
  }
  #tableContainer-2 {
    vertical-align: middle;
    display: table-cell;
    height: 100%;
  }
  #myTable {
    margin: 0 auto;
  }

</style>
</head>
<body>
<body style="background-color:#CAE1FF ">
<h3>Please Enter Your Credentials</h3>
	<div id="tableContainer-1">
  	  <div id="tableContainer-2">
		<form method="post" action="afterlogin">
            <center>
            <table id="myTable" border="1" width="30%" cellpadding="3" style="background-color: #8B8989;">
                <thead>
                    <tr>
                        <th colspan="2">Login Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>User Name</td>
                        <td><input type="text" name="userName" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="userPassword" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Login" /></td>
                    </tr>
                   
                </tbody>
            </table>
            </center>
         </form>
        </div> 
     </div>
     <div><%=session.getAttribute("user_session") %></div>
</body>

</html>