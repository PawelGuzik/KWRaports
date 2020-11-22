<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://www.google.com/recaptcha/api.js" async defer></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
/* The container */
body {
	text-align: center;
	background: red;
}

.leftdiv {
	background: blue;
	padding: left 33%;
	text-align: left;
}
</style>
<body>

	<p>Proszę wybrac, które informacje o mapach mają znalźć się w
		raporcie</p>


	<p>Label Name Proszę wybrac, które informacje o mapach mają znalźć
		się w raporcie Proszę wybrac, które informacje o mapach mają znalźć
		się w raporcie Proszę wybrac, które informacje o mapach mają znalźć
		się w raporcie Proszę wybrac, które informacje o mapach mają znalźć
		się w raporcie Proszę wybrac, które informacje o mapach mają znalźć
		się w raporcie</p>


	<input type="checkbox" id="checkbox-1" class="checkbox" />
	<label for="checkbox-1"></label>



	<form action="ProcessRaportServlet" method="POST">


		<c:forEach var="item" items="${itemsList}">


			<div class="leftdiv">
				<input type="checkbox" name="selectEntryBasis" value="${item.title}" />
				<label for="selectEntryBasis">${item.title}</label>

			</div>

		</c:forEach>



		<input type="submit" value="Wyślij">
		<div class="capt_style">
			<div class="g-recaptcha" data-theme="dark"
				style="transform: scale(0.45); margin-left: 0;"
				data-sitekey="6LeIxAcTAAAAAJcZVRqyHh71UMIEGNQ_MXjiZKhI"></div>
		</div>
	</form>


	<a href="${pageContext.request.contextPath}/index.html" class="button">Powrót
		do fromularza</a>


</body>
</html>