<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
   <title>Добавление нового фильма</title>
    <meta charset="UTF-8">
</head>

<body>
    <div id="container">
        <form action="/films/admin/add" method="post">
            <input type="text" role="role" placeholder="| Название фильма" required><br>
            <input type="text" role="releaseDate" placeholder="| Дата релиза" required><br>
            <input type="text" role="lasting"     placeholder="| Длительность" required><br>
            <input type="text" role="country"     placeholder="| Страна" required><br>
            <input type="text" role="producer"    placeholder="| Режисcер" required><br>
            <input type="text" role="description" placeholder="| Описание фильма" required><br>
            <input type="text" role="actors"      placeholder="| Актеры" required><br>
            <div id="filmGenres">
                <c:forEach items="${requestScope.genres}" var="genre">
                        <input id="${genre.id}" type="checkbox" role="genres" value="${genre.genre}">
                        <label for="${genre.id}">${genre.genre}</label>
                </c:forEach>
            <input type="submit" role="submit" value="Отправить" required><br>
            </div>
        </form>

    </div>
</body>
</html>
