<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario</title>
</head>
<body>
<h3>Formulario</h3>
<form action="/lime/form" method="post">
    <div>
        <label for="username">Nombre</label>
        <div><input type="text" name="username" id="username"></div>
    </div>

    <div>
        <label for="password">Email</label>
        <div><input type="password" name="password" id="password"></div>
    </div>

    <div>
        <label for="email">Email</label>
        <div><input type="text" name="email" id="email"></div>
    </div>
    <div>
        <div>
            <input type="submit" name="" id="" value="Enviar">
        </div>
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
    <div>
        <label for="lenguaje">Lenguajes de Programacion</label>
        <div>
            <select name="pais" id="pais">
                <option value="">--Seleccionar--</option>
                <option value="java">Java</option>
                <option value="jakarta">Jakarta</option>
                <option value="Pyhton">Pyhton</option>
            </select>
        </div>
    </div>
</form>
</body>
</html>