<#ftl encoding='UTF-8'>
<#import "spring.ftl" as spring />
<html>
<head>
    <title>Все фильмы</title>
    <link rel="stylesheet" type="text/css" href="../../../css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../../../css/myStyle.css">
</head>
<body style="background: url('images/background.png ') ">
<div id="container">
   
        <h2>Все доступные фильмы</h2>

    <div id="main">
    <#list model["filmsModel"] as film>
        <div class="col-lg-6">
            <a href="http://localhost:8080/films/${film.id}" >
                <h3 id="title_film">${film.name}</h3>
            </a>
            <img id="img-films" src="${film.picture}" alt=" =( "
                 style="width: 350px;
             height: 450px; ">
            <br>
            <p>страна:<a href="http://localhost:8080/films/country/${film.country}">${film.country}</a></p>

            <p>режиссер:<a href="http://localhost:8080/films/producer/${film.producer}">
            ${film.producer}
            </a></p>
            <p>продолжительность: ${film.lasting}</p>
            <p>жанры: <#list film.genres as genre>
                <a href="http://localhost:8080/films/genre/${genre}">${genre}</a>
            </#list></p>

        </div>
        <hr>
    </#list>
    </div>
</div>
</body>

</html>
