<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.*" %>

<%
    Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-2.2.4.min.js"
        integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
        crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
    <nav class="navbar navbar-inverse">
       <div class="container-fluid">
           <!-- Brand and toggle get grouped for better mobile display -->
           <div class="navbar-header" id="div1">
               <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                   data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                   <span class="sr-only">Toggle navigation</span>
                   <span class="icon-bar"></span>
                   <span class="icon-bar"></span>
                   <span class="icon-bar"></span>
               </button>
               <a class="navbar-brand" href="#" id="enlace1">Rutas App</a>
           </div>

           <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
               <ul class="nav navbar-nav">
                   <li class="dropdown">
                       <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                           aria-haspopup="true" aria-expanded="false">Choferes<span
                               class="caret"></span></a>
                       <ul class="dropdown-menu">
                           <li><a href="<%=request.getContextPath()%>/choferes/listar">Lista Choferes</a></li>
                           <li><a href="<%=request.getContextPath()%>/choferes/alta">Alta Chofer</a></li>
                       </ul>
                   </li>

                   <li class="dropdown">
                       <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                           aria-haspopup="true" aria-expanded="false">Camiones<span
                               class="caret"></span></a>
                       <ul class="dropdown-menu">
                           <li><a href="<%=request.getContextPath()%>/camiones/listar">Lista Camiones</a></li>
                           <li><a href="<%=request.getContextPath()%>/camiones/alta">Alta Camion</a></li>
                       </ul>
                   </li>

                   <li class="dropdown">
                       <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                           aria-haspopup="true" aria-expanded="false">Rutas<span
                               class="caret"></span></a>
                       <ul class="dropdown-menu">
                           <li><a href="<%=request.getContextPath()%>/rutas/alta">Alta Ruta</a></li>
                       </ul>
                   </li>
               </ul>
           </div><!-- /.navbar-collapse -->
       </div><!-- /.container-fluid -->
    </nav>

    <div class="container">
        <div class="row">
            <div class="col-12">
                <h2>Formulario alta camiones</h2>
            </div>
        </div>

        <br>

        <% if (errores != null && !errores.isEmpty()) { %>
            <ul class="alert alert-danger mx-5 px-5">
                <% for (String error : errores.values()) { %>
                    <li><%= error %></li>
                <% } %>
            </ul>
        <% } %>

        <div class="row">
            <form action="<%= request.getContextPath() %>/choferes/alta" method="post">
                <div class="col-md-12">
                    <div class="form-group">
                        <label for="matricula">matricula</label>
                        <input type="text" name="matricula" id="matricula" class="form-control" value="<%= request.getParameter("matricula") != null ? request.getParameter("matricula") : "" %>">
                        <% if (errores != null && errores.containsKey("matricula")) { %>
                            <span class='text-danger'><%= errores.get("matricula") %></span>
                        <% } %>
                    </div>

                    <div class="form-group">
                        <label for="tipo_camion">tipo camion</label>
                        <input type="text" name="tipo_camion" id="tipo_camion" class="form-control" value="<%= request.getParameter("tipo_camion") != null ? request.getParameter("tipo_camion") : "" %>">
                        <% if (errores != null && errores.containsKey("tipo_camion")) { %>
                            <span class='text-danger'><%= errores.get("tipo_camion") %></span>
                        <% } %>
                    </div>

                    <div class="form-group">
                        <label for="modelo">modelo</label>
                        <input type="text" name="modelo" id="modelo" class="form-control" value="<%= request.getParameter("modelo") != null ? request.getParameter("modelo") : "" %>">
                        <% if (errores != null && errores.containsKey("modelo")) { %>
                            <span class='text-danger'><%= errores.get("modelo") %></span>
                        <% } %>
                    </div>

                    <div class="form-group">
                        <label for="marca">marca</label>
                        <input type="text" name="marca" id="marca" class="form-control" value="<%= request.getParameter("marca") != null ? request.getParameter("marca") : "" %>">
                        <% if (errores != null && errores.containsKey("marca")) { %>
                            <span class='text-danger'><%= errores.get("marca") %></span>
                        <% } %>
                    </div>

                    <div class="form-group">
                        <label for="capacidad">capacidad</label>
                        <input type="text" name="capacidad" id="capacidad" class="form-control" value="<%= request.getParameter("capacidad") != null ? request.getParameter("capacidad") : "" %>">
                        <% if (errores != null && errores.containsKey("capacidad")) { %>
                            <span class='text-danger'><%= errores.get("capacidad") %></span>
                        <% } %>
                    </div>

                    <div class="form-group">
                        <label for="kilometraje">kilometraje</label>
                        <input type="text" name="kilometraje" id="kilometraje" class="form-control" value="<%= request.getParameter("kilometraje") != null ? request.getParameter("kilometraje") : "" %>">
                        <% if (errores != null && errores.containsKey("kilometraje")) { %>
                            <span class='text-danger'><%= errores.get("kilometraje") %></span>
                        <% } %>
                    </div>

                    <div class="form-group">
                        <label for="disponibilidad">Disponibilidad</label>
                        <input type="checkbox" name="disponibilidad" id="disponibilidad" class="form-check-input" <%= "on".equals(request.getParameter("disponibilidad")) ? "checked" : "" %> >
                    </div>

                    <div class="form-group">
                        <button type="submit" class="btn btn-success">Guardar</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

</body>
</html>