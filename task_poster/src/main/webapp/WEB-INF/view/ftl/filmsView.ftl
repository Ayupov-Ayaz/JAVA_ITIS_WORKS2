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
        <a href="http://localhost:8080/films/${film.id}" >
            <h3 id="title_film">${film.name}</h3>
        </a>
        <img src="http://kak-narisovat.com/wp-content/uploads/2015/11/how-to-draw-pikachu-pokemon_1_000000015052_5.jpg" alt=" =( ">
        <p>страна:<a href="http://localhost:8080/films/country/${film.country}">
             ${film.country}
        </a></p>

        <p>режиссер:<a href="http://localhost:8080/films/producer/${film.producer}">
             ${film.producer}
        </a></p>
            <p>продолжительность: ${film.lasting}</p>
            <p>жанры: <#list film.genres as genre>
                <a href="http://localhost:8080/films/genre/${genre}">${genre}</a>
            </#list></p>
        <hr>
    </#list>
    </div>
</div>
</body>

</html>
