<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%
List<String> errores = (List<String>)request.getAttribute("errores");
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Formulario</title>
  </head>
  <body>
    <h3>Formulario</h3>
    <%
    if (errores != null && errores.size()>0) {
  %>

  <ul>
  <% for(String error: errores) {%>
<li><%=error%></li>
<%}%>
  </ul>


<%
    }
%>
    <form action="/lime/form" method="post">
      <div>
        <label for="username">Nombre</label>
        <div><input type="text" name="username" id="username" /></div>
      </div>

      <div>
        <label for="password">Password</label>
        <div><input type="password" name="password" id="password" /></div>
      </div>

      <div>
        <label for="email">Email</label>
        <div><input type="text" name="email" id="email" /></div>
      </div>

      <div>
        <label for="pais">Paises</label>
        <div>
          <select name="pais" id="pais">
            <option value="">--Seleccionar--</option>
            <option value="ES">España</option>
            <option value="MX">Mexico</option>
            <option value="AR">Argentina</option>
          </select>
        </div>
      </div>
      <br />
      <div>
        <label for="lenguaje">Lenguajes de Programacion</label>
        <div>
          <select name="lenguaje" id="lenguaje" multiple>
            <option value="">--Seleccionar--</option>
            <option value="java">Java</option>
            <option value="jakarta">Jakarta</option>
            <option value="Pyhton">Pyhton</option>
          </select>
        </div>
      </div>
      <br />
      <div>
        <label>roles</label>
        <div>
          <input type="checkbox" name="roles" value="ROLE_ADMIN" />
          <label for="">Adiministrador</label>
        </div>
        <div>
          <input type="checkbox" name="roles" value="ROLE_USER" />
          <label for="">Usuario</label>
        </div>
        <div>
          <input type="checkbox" name="roles" value="ROLE_MODERATOR" />
          <label for="">Moderador</label>
        </div>
      </div>
      <br />
     
      <br />
      <div>
        <label for="">Idiomas</label>
        <div>
          <input type="radio" name="idioma" value="es" />
          <label for="">Español</label>
        </div>
      </div>
      <div>
        <div>
          <input type="radio" name="idioma" value="en" />
          <label for="">Ingles</label>
        </div>
      </div>
      <div>
        <div>
          <input type="radio" name="idioma" value="fr" />
          <label for="">Frances</label>
        </div>
      </div>
      <div>
        <label for="habilitar">habilitar</label>
        <div>
            <input type="checkbox" name="habilitar" id="habilitar" checked>
        </div>
      </div>
      <input type="text" hidden name="secreto" name="123345">
      <div>
        <div>
          <input type="submit" name="" id="" value="Enviar" />
        </div>
      </div>
    </form>
  </body>
</html>
