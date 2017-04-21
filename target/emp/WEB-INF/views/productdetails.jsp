<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Details</title>
<style type="text/css">
	#button {
     line-height: 12px;
     padding:5px;
     width: 100px;
     font-size: 8pt;
     font-family: tahoma;
     margin-top: 1px;
     margin-right: 0px;
     position:absolute;
     top:0;
     right:0;
 	}
 
 	#menu {
     line-height: 12px;
     padding:5px;
     width: 100px;
     font-size: 8pt;
     font-family: tahoma;
     margin-top: 1px;
     margin-right: 120px;
     position:absolute;
     top:0;
     right:0;
 	}
 
 	#row{
 	background-color: #C1C1C1;
 	}
</style>
</head>
<body style="background-color: #EEE9BF">
<table border="1">
  	<tr style="background-color: #BDFCC9">
    	<th width="120">Product Code</th>
		<th width="120">Product Name</th>
		<th width="120">Product Price</th>
    <tr>
       <td id="row">${productdetails.code}</td>
       <td id="row">${productdetails.name}</td>
       <td id="row">${productdetails.price}</td>
 	<td style="background-color: #5CACEE"><a href="confirm/${productdetails.code}">confirm</a></td>  
   </tr>
</table>
<br><br><br><br><br><br><br>
<form method="get" action="login">
    	<button id="login" type="submit">LOGIN</button>
    </form>
<br><br><br><br><br><br><br>   
<form method="get" action="productlist">
    	<button id="productlist" type="submit">Back to Products</button>
    </form>
  
  <div><%=session.getAttribute("user_session") %></div>   

</body>
</html>