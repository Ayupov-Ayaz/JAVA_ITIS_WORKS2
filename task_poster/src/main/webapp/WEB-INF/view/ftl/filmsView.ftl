<#ftl encoding='UTF-8'>
<#import "spring.ftl" as spring />
<html>
<head>
    <title>Все фильмы</title>
    <link rel="stylesheet" type="text/css" href="../../../css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../../../css/main.css">
    <link rel="stylesheet" type="text/css" href="../../../css/films.css">
</head>
<body>
<div class ="container">
   
        <h2>Все доступные фильмы</h2>
        <hr>


    <#list model["filmsModel"] as film>
        <div class="main col-lg-6">
            <a href="http://localhost:8080/films/${film.id}" >
                <h3 id="title_film">${film.role}</h3>
            </a>
            <p><img class="img-films" src="${film.picture}" alt=" =( "></p>
            <br>
            <div id="text_films">
                <p>страна:<a href="http://localhost:8080/films/country/${film.country}">${film.country}</a></p>

                <p>режиссер:<a href="http://localhost:8080/films/producer/${film.producer}">
                ${film.producer}
                </a></p>
                <p>продолжительность: ${film.lasting}</p>
                <p>жанры: <#list film.genres as genre>
                    <a href="http://localhost:8080/films/genre/${genre}">${genre}</a>
                </#list></p>
            </div>
        </div>
    </#list>

</div>
</body>

</html>
