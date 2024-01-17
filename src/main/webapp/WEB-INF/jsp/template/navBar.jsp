<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container-fluid page-body-wrapper">

  <nav class="sidebar sidebar-offcanvas" id="sidebar">
    <ul class="nav">
      <li class="nav-item">
        <a class="nav-link" href="">
          <i class="mdi mdi-grid-large menu-icon"></i>
          <span class="menu-title">Dashboard</span>
        </a>
      </li>
<%--     Meubles--%>
      <li class="nav-item nav-category">Patient</li>
      <li class="nav-item">
        <a class="nav-link" data-bs-toggle="collapse" href="#patient" aria-expanded="false"
           aria-controls="patient">
          <i class="menu-icon mdi mdi-card-text-outline"></i>
          <span class="menu-title">Patient</span>
          <i class="menu-arrow"></i>
        </a>
        <div class="collapse" id="patient">
          <ul class="nav flex-column sub-menu">
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/insertPatient">ajouter</a></li>

          </ul>
        </div>
      </li>

<%--      Style--%>


      <li class="nav-item nav-category">Consultation</li>
      <li class="nav-item">
        <a class="nav-link" data-bs-toggle="collapse" href="#Style" aria-expanded="false"
           aria-controls="Style">
          <i class="menu-icon mdi mdi-card-text-outline"></i>
          <span class="menu-title">Consultation</span>
          <i class="menu-arrow"></i>
        </a>
        <div class="collapse" id="Style">
          <ul class="nav flex-column sub-menu">
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/insertConsultation">ajouter</a></li>



          </ul>
        </div>
      </li>

    </ul>
  </nav>

