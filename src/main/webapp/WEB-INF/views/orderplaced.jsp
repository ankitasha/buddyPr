<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Placed</title>
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
    	<th width="120">Order Id</th>
		<th width="120">Product Code</th>
		<th width="120">Order Date</th>
    <tr>
       <td id="row">${orders.orderid}</td>
       <td id="row">${orders.productId}</td>
       <td id="row">${orders.orderDate}</td>
       
   </tr>
</table>
  <br>
  <br>
  <br><br>
<form method="get" action="/emp/thankyou">
    	<button id="thankyou" type="submit">Exit</button>
    </form>
    <br>
     <form method="get" action="/emp/logout">
    	<button id="logout" type="submit">logout</button>
    </form>
     <br>
     <br>
  <div><%=session.getAttribute("user_session") %></div>   

</body>
</html>