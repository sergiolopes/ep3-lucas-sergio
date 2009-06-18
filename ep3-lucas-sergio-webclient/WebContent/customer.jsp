<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Cadastro de usuários</title>
</head>
<body>
<f:view>
	<jsp:include page="menu.jsp"/>
	
	<h1>Cadastro de usuários</h1>
	
	<h:form>
		<h:panelGrid>
			<h:outputText value="Nome:"/>
			<h:inputText value="#{customerHandler.customer.name}"/>
			
			<h:outputText value="Telefone:"/>
			<h:inputText value="#{customerHandler.customer.phone}"/>
			
			<h:commandButton actionListener="#{customerHandler.register}" value="Salvar"/>
		</h:panelGrid>
	</h:form>
	
	<h:form>
		<h2>Buscar cliente por:</h2>
		
		<h:selectOneRadio value="#{customerSearchHandler.searchType}">
			<f:selectItem itemLabel="ID" itemValue="ID"/>
			<f:selectItem itemLabel="NOME" itemValue="NAME"/>
			<f:selectItem itemLabel="TELEFONE" itemValue="PHONE"/>
		</h:selectOneRadio>
		
		<h:inputText value="#{customerSearchHandler.search}"/>
		
		<h:commandButton value="BUSCAR"/>
	</h:form>
	
	<h:dataTable value="#{customerSearchHandler.customers}" var="customer">
		<h:column>
			<f:facet name="header">
				<h:outputText value="ID"/>
			</f:facet>
			<h:outputText value="#{customer.id}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="NAME"/>
			</f:facet>
			<h:outputText value="#{customer.name}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="PHONE"/>
			</f:facet>
			<h:outputText value="#{customer.phone}"/>
		</h:column>
	</h:dataTable>

</f:view>
</body>
</html>