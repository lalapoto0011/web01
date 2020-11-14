<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book ${book.title}</title>
</head>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="./css/my.css">
<link rel="stylesheet" href="./css/main.css">

<script type="text/javascript">
	function modify() { //하단의 버튼 onclick쪽과 같게
		alert("수정")
	}
	function bookDelete() {
//		alert("삭제")
		if (confirm("정말 삭제할거니?")) {
			f.action = "bookDelete.do";
			f.submit();
		}
	}
	function bookList() {
//		alert("목록")
		f.action = "bookList.do";
		f.submit();
	}
</script>

<body>
<%@ include file="common/header.jsp" %>
<section>

<h2>Book 상세보기 : ${book.title}</h2>

<form action="" name="f" method="get">
<input type="hidden" name="bookno" value="${book.bookno}">
		
<table>
<tr>
	<td>도서 제목: ${book.title}</td>
</tr>
<tr>
	<td>출판사: ${book.publisher}</td>
</tr>
<tr>
	<td>가격 : ${book.price}</td>
</tr>
<tr>
	<td colspan="2"><img alt="...." src="./img/book1.png"></td>
</table>	
<table>
	<tr>
		<td align="center">
			<input type="button" value="수정" onclick="modify()">
			<input type="button" value="삭제" onclick="bookDelete()">
			<input type="button" value="목록" onclick="bookList()">
		</td>
	</tr>


</table>
</form>

		<button type="button">장바구니</button>
		<button type="button">구매하기</button>
		<td><a href="bookList.do">뒤로가기<td>
		
		
</section>
<%@ include file="common/footer.jsp" %>
</body>
</html>