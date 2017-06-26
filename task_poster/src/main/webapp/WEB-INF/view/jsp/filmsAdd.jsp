<%--
  Created by IntelliJ IDEA.
  User: Tommy
  Date: 22.05.2017
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление фильма</title>
    <link rel="stylesheet" href="../../../css/table-style.css">
</head>
<body>
<div class="container">
    <form id="contact" action="/films" method="post">
        <h3>Добавление нового фильма</h3>
        <fieldset>
            <input role="role" placeholder="Название фильма" type="text" tabindex="1" required autofocus>
        </fieldset>
        <fieldset>
            <input role="genre" placeholder="Жанр" type="text" tabindex="2" required autofocus>
        </fieldset>
        <fieldset>
            <input role="country" placeholder="Страна" type="text" tabindex="3" required>
        </fieldset>
        <fieldset>
            <input role="producer" placeholder="Режисер" type="text" tabindex="4" required>
        </fieldset>
        <fieldset>
            <input role="description" placeholder="Описание фильма" type="text" tabindex="5" required>
        </fieldset>
        <fieldset>
            <input role="releaseDate" placeholder="Дата релиза" type="text" tabindex="6" required>
        </fieldset>
        <fieldset>
            <input role="actors" placeholder="Актеры" type="text" tabindex="7" required>
        </fieldset>
        <fieldset>
            <input role="lasting" placeholder="Продолжительность" type="text" tabindex="8">
        </fieldset>
        <fieldset>
            <button role="submit" type="submit" >Сохранить</button>
        </fieldset>
    </form>
</div>
</body>
</html>
