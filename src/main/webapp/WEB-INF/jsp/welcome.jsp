<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome page</title>
</head>
<body>
Bienvenido
<b><%= request.getParameter("nombre") %></b>
<b><%= request.getParameter("apellido") %></b>
<b><%= request.getParameter("color") %></b>
</body>
</html>