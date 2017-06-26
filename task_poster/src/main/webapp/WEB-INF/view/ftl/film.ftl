<#ftl encoding='UTF-8'>
<#import "spring.ftl" as spring />
<@spring.bind "model" />
<html>
<head>
    <link rel="stylesheet" href="../../../css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="../../../css/main.css" type="text/css">
    <link rel="stylesheet" href="../../../css/film.css" type="text/css">
    <meta charset="UTF-8"/>
    <title>${model.film.role}</title>
</head>
<body>
<div id="film_container" class="col-lg-10">

        <h3>${model.film.role}</h3>
            <img class="single_film" src="${model.film.picture}" alt=" picture is not found ">

        <p>дата релиза: ${model.film.releaseDate}</p>
        <p>страна:<a href="http://localhost:8080/films/country/${model.film.country}">
        ${model.film.country}
        </a></p>
        <p>режиссер: <a href="http://localhost:8080/films/producer/${model.film.producer}">
        ${model.film.producer}</a>
        </p>
        <p>продолжительность: ${model.film.lasting}</p>
            <p>${model.film.description}</p>
        <p>жанры: <#list model.film.genres as genre>
            <a href="http://localhost:8080/films/genre/${genre}">
            ${genre}</a>
        </#list></p>
        <p>актеры: <#list model.film.actors as actor>
            <a href="http://localhost:8080/films/actor/${actor}">${actor}</a>
        </#list></p>


</div>


</body>
</html>