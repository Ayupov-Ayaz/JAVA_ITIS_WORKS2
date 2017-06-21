
<#ftl encoding='utf-8'>

<#import "spring.ftl" as spring />
<head>
   <title>Добавление нового фильма</title>
    <meta charset="UTF-8">
</head>

<body>
    <div id="container">
        <form action="/films/admin/add" method="post">
            <input type="text" name="name" placeholder="| Название фильма" required><br>
            <input type="text" name="releaseDate" placeholder="| Дата релиза" required><br>
            <input type="text" name="lasting" placeholder="| Длительность" required><br>
            <input type="text" name="country" placeholder="| Страна" required><br>
            <input type="text" name="producer" placeholder="| Режисcер" required><br>
            <input type="text" name="description" placeholder="| Описание фильма" required><br>
            <input type="text" name="actors" placeholder="| Актеры" required><br>
            <div id="filmGenres">
                <#list model["genres"] as genre>
                        <input id="${genre.id}" type="checkbox" name="genres" value="${genre.genre}">
                        <label for="${genre.id}">${genre.genre}</label>
                </#list>
            <input type="submit" name="submit" value="Отправить" required><br>
            </div>
        </form>

    </div>
</body>