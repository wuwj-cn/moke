<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String data = "{'success': true,'children': [{'id':'3', 'text': '网络',  'children': [{'id':'3-1', 'text': '电子图书', 'leaf': true },{'id':'3-2', 'text': '开心游戏', 'leaf': true}] },{ 'id':'4','text': '视频', 'leaf': true }]}"; 
response.getWriter().write(data);	
%> 
</body>
</html>