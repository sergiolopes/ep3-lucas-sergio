<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Cadastro de cópias de filmes</title>
</head>
<body>
<f:view>
	<jsp:include page="menu.jsp"/>
	
	<h1>Cadastro de cópias de filmes</h1>
	
	<h:form>
		<h:panelGrid>
			<h:outputText value="Filme:"/>
			<h:selectOneMenu value="#{movieCopyHandler.movieCopy.movieId}">
				<f:selectItems value="#{movieSearchHandler.movieItems}"/>
			</h:selectOneMenu>
			
			<h:outputText value="Tipo de mídia:"/>
			<h:selectOneMenu value="#{movieCopyHandler.movieCopy.mediaType}">
				<f:selectItem itemLabel="VHS" itemValue="0"/>
				<f:selectItem itemLabel="DVD" itemValue="1"/>
				<f:selectItem itemLabel="BD"  itemValue="2"/>
			</h:selectOneMenu>
			
			<h:commandButton actionListener="#{movieCopyHandler.register}" value="Salvar"/>
		</h:panelGrid>
	</h:form>
	
	<h3 style="color: darkgreen">
		<h:outputText value="Cópia cadastrada com sucesso!" rendered="#{movieCopyHandler.cadastrado}"/>
	</h3>

</f:view>
</body>
</html>