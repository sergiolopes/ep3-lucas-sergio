<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Cadastro de filmes</title>
</head>
<body>
<f:view>
	<jsp:include page="menu.jsp"/>
	
	<h1>Cadastro de filmes</h1>

	<h:form>
		<h:panelGrid>
			<h:outputText value="Nome:" />
			<h:inputText value="#{movieHandler.movie.name}"/>
			
			<h:outputText value="Diretor:"/>
			<h:inputText value="#{movieHandler.movie.director}" />
			
			<h:outputText value="Gêneros: (um por linha)"/>
			<h:inputTextarea value="#{movieHandler.genres}"/>
			
			<h:outputText value="Atores: (um por linha)"/>
			<h:inputTextarea value="#{movieHandler.cast}"/>
			
			<h:outputText value="Ano:"/>
			<h:inputText value="#{movieHandler.movie.year}"/>
			
			<h:outputText value="Duração: (em minutos)"/>
			<h:inputText value="#{movieHandler.movie.duration}"/>
			
			<h:commandButton value="Salvar" actionListener="#{movieHandler.register}"/>
		</h:panelGrid>
	</h:form>
	
	<h:form>
		<h2>Buscar filme por:</h2>
		
		<h:selectOneRadio value="#{movieSearchHandler.searchType}">
			<f:selectItem itemLabel="ID" itemValue="ID"/>
			<f:selectItem itemLabel="NOME" itemValue="NAME"/>
			<f:selectItem itemLabel="DIRETOR" itemValue="DIRECTOR"/>
			<f:selectItem itemLabel="GÊNERO E ANO" itemValue="GENRE_AND_YEAR"/>
		</h:selectOneRadio>
		
		<h:inputText value="#{movieSearchHandler.search}"/>
		
		<h:commandButton value="BUSCAR"/>
	</h:form>
	
	<h:dataTable var="movie" value="#{movieSearchHandler.movies}">
		<h:column>
			<f:facet name="header">
				<h:outputText value="ID"/>
			</f:facet>
			<h:outputText value="#{movie.id}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Nome"/>
			</f:facet>
			<h:outputText value="#{movie.name}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Diretor"/>
			</f:facet>
			<h:outputText value="#{movie.director}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Gêneros"/>
			</f:facet>
			<h:outputText value="#{movie.genre}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Ano"/>
			</f:facet>
			<h:outputText value="#{movie.year}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Duração"/>
			</f:facet>
			<h:outputText value="#{movie.duration}"/>
		</h:column>
	</h:dataTable>	
</f:view>
</body>
</html>