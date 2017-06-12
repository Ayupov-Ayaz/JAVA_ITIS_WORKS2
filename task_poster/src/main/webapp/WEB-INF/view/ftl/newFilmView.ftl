<#ftl encoding='UTF-8'>
<#import "spring.ftl" as spring />

<!DOCTYPE html>
<head>
   <title>Новый фильм</title>
    <#--<link rel="stylesheet" type="text/css" href="/resources/css/film.css">-->
</head>

<body>
    <div id="container">
        <form action="newFilmView.ftl" method="post">
            <input type="text" name="name" placeholder="| Название фильма" required><br>
            <input type="text" name="releaseDate" placeholder="| Дата релиза" required><br>
            <input type="text" name="lasting" placeholder="| Длительность" required><br>
            <input type="text" name="country" placeholder="| Страна" required><br>
            <input type="text" name="producer" placeholder="| Режисер" required><br>
            <input type="text" name="description" placeholder="| Описание фильма" required><br>
            <input type="text" name="actors" placeholder="| Актеры" required><br>
            <input type="submit" name="submit" value="Отправить" required><br>
            <div id="filmGenres">
                <#list model["genres"] as genre>
                        <input id="${genre.id}" type="checkbox" name="${genre.genre}">
                        <label for="${genre.id}">${genre.genre}</label>
                </#list>
            </div>
        </form>

    </div>
</body>