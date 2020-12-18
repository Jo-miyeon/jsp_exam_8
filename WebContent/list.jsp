<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import = "java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% //자바버전
	int num=10;
%>
<c:set var="num2" value="10"/>
<%
	out.println("jsp:"+num);
%>
<br>
<!-- jstl버전 -->
<c:out value="${num}"/>
<% if(num%2==0) {
	out.println("even");
	}else {
		out.println("odd");
	}
%>
<br>
<c:if test="${num2 % 2 == 0}">
	even
</c:if>


<c:choose>
	<c:when test="${num2%2==0}">
		even
	</c:when>
	<c:otherwise>
		odd
	</c:otherwise>
</c:choose>
<br>
<!-- 반복문 -->
<%
	for(int i=1;i<10;i++) {
		out.println(i+"");
	}
%>
<br>
<c:forEach var="i" begin="1" end="10" step="1"> <!-- 변수는 i step이 증가량 -->
	${i} <!-- jstl에서 변수를 의미 -->
</c:forEach>

<br>
<c:forEach var="j" begin="2" end="100" step="2">
	${j}
</c:forEach>
<br>
<c:set var="age" value="26"/>
<c:choose>
	<c:when test="${age<=19}">
		할인대상
	</c:when>
	<c:when test="${age>=60}">
		할인대상
	</c:when>
	<c:otherwise>
		할인대상아님
	</c:otherwise>
</c:choose>
<br>

<c:set var="n" value="4"/>
<c:set var="m" value="19"/>
<c:set var="limit" value="11"/>
<c:forEach var="dan" begin="${n}" end="${m}">
	<c:if test="${m%2!=0}"></c:if>
	<c:forEach var="i" begin="1" end="${limit}">
		<c:if test="${i%2==0}">
		${dan}*${i}=${dan*i}<br>
		</c:if>
	</c:forEach>
</c:forEach>
<br>

<c:set var="y" value="3"/>
<c:forEach var="i" begin="1" end="${y}">
	<c:forEach var="j" begin="1" end="${i}">
		*
	</c:forEach>
</c:forEach>
</body>
</html>
<br>

<%
	ArrayList<String> strList = new ArrayList<String>();
	
	strList.add("안녕");
	strList.add("반가워");
	strList.add("잘가");
	
	for(int i=0;i<strList.size();i++) {
		String str = strList.get(i);
		out.println(str);
	}
	
	for(String str:strList) {
		out.println(str);
	}
%>
<!-- jstl로 향상된for문 쓰는 방법 -->
<c:forEach var="str" items="${strList.size()}">
	${str.get(i)}
</c:forEach>

<c:forEach var="str" items="${strList}">
	${str}
</c:forEach>
