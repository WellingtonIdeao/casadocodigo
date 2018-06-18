<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de produtos</title>
</head>
<body>
<!--url ="/casadocodigo/produtos" -->
<c:url value="/produtos" var="url" />
											<!-- commandName="product" -->	
	<form:form action="${url}" method="post" commandName="objetoAtual">
		<div>
			<label for="title">Titulo</label>
			<form:input path="title"/>
			<form:errors path="title"/>
		</div>
		<div>
			<label for="description">Descrição</label>
			<form:textarea path="description" rows="10"/>
			<form:errors path="description" />
		</div>
		<div>
			<label for="pages">Número de paginas</label>
			<form:input path="pages"/>
			<form:errors path="pages"/>
		</div>
		<div>
			<label for="releaseDate">Data de lançamento</label> 
			<input name="releaseDate" type="date" />
			<form:errors path="releaseDate" />
		</div>
		<c:forEach items="${types}" var="bookType" varStatus="status">
			<div>
				<label for="price_${bookType}">${bookType}</label> 
				<input type="text" name="prices[${status.index}].value" id="price_${bookType}" />
				<input type="hidden" name="prices[${status.index}].bookType" value="${bookType}" />
			</div>
		</c:forEach>
		<div>
			<input type="submit" value="Enviar">
		</div>
		
	</form:form>
</body>
</html>