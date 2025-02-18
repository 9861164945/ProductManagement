<%@page import="java.util.Iterator"%>
<%@page import="com.servlet.ProductManagement.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.servlet.ProductManagement.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
AdminBean ab=(AdminBean)session.getAttribute("abean");
ArrayList<ProductBean>al=(ArrayList<ProductBean>)session.getAttribute("alist");1
out.println("Page Belongs to Admin:"+ab.getFname()+"<br>");
if(al.size()==0)
{
	out.println("Products Not Avaliable..<br>");
	
}

else
{
	Iterator<ProductBean>it=al.iterator();
	
	while(it.hasNext())
      {
		ProductBean pb=(ProductBean)it.next();
		out.println(pb.getCode()+"%nbsp$nbsp"+
		pb.getName()+"%nbsp$nbsp"+pb.getPrice()+"%nbsp$nbsp"+pb.getQty()+"%nbsp$nbsp"+
				"<a href='edit'>Edit</a>"+"%nbsp$nbsp"+
		"<a href='delete'>Delete</a>"+"<br>");
		}
	}
%>
<a href="Product.html">AddProduct</a>
<a href="Logout">Logout</a>

</body>
</html>