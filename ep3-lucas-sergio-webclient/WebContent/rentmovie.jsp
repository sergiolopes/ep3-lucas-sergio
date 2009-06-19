<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Alugar uma cópia de filme</title>
</head>
<body>
<f:view>
	<jsp:include page="menu.jsp"/>
	
	<h1>Alugar uma cópia de filme</h1>
	
	<h:form>
		Selecione o cliente:
		<h:selectOneMenu value="#{rentHandler.rentedMovieCopy.customerId}">
			<f:selectItems value="#{customerSearchHandler.customersSelectItems}"/>
		</h:selectOneMenu>
		
		<p>(a data de entrega será amanhã)</p>
	
		<h:dataTable value="#{rentHandler.availableMovieCopies}" var="movieCopyInfo">
			<h:column>
				<f:facet name="header">
					<h:outputText value="CopyID"/>
				</f:facet>
				<h:outputText value="#{movieCopyInfo.movieCopyId}"/>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Filme"/>
				</f:facet>
				<h:outputText value="#{movieCopyInfo.movieName}"/>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Tipo"/>
				</f:facet>
				<h:outputText value="VHS" rendered="#{movieCopyInfo.movieCopyType eq 0}"/>
				<h:outputText value="DVD" rendered="#{movieCopyInfo.movieCopyType eq 1}"/>
				<h:outputText value="BD" rendered="#{movieCopyInfo.movieCopyType eq 2}"/>
			</h:column>
			<h:column>
				<h:commandButton value="Alugar" actionListener="#{rentHandler.rentMovieCopy}">
					<f:param id="movieCopyInfo" value="#{movieCopyInfo}"/>
				</h:commandButton>
			</h:column>
		</h:dataTable>
	</h:form>
</f:view>
</body>
</html>