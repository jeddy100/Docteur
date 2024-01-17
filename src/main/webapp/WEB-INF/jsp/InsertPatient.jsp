<%@ page import="com.example.docteur.model.Parametre" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% List<Parametre>listParametres= (List<Parametre>) request.getAttribute("listParametres"); %>
<jsp:include page="template/header.jsp" />

<div class="col-md-12  grid-margin stretch-card ">
    <div class="card">
        <div class="card-body">
<h2>Ajouter un Client</h2>

<form action="/patientpost" method="post">
    <label for="nom">Nom du Patient:</label>
    <input type="text" id="nom" name="nom" required><br><br>

    <label for="age">Age du Patient:</label>
    <input type="number" id="age" name="age" required><br><br>

    <h3>Informations sur les Paramètres</h3>

    <% for (Parametre parametre : listParametres){%>
        <label for="etat_<%= parametre.getId() %>"><%= parametre.getNom_parametre()%> - État:</label>
        <input type="number" id="etat_<%= parametre.getId()%>" name="etat_<%= parametre.getId()%>" placeholder="0" required><br>
    <%}%>
    <br>
    <input type="submit" value="Ajouter le Client">
</form>
        </div>
    </div>
</div>
<jsp:include page="template/footer.jsp"/>