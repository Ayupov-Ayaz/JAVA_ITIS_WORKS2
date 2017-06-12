<#ftl encoding='UTF-8'>
<#import "spring.ftl" as spring />
<@spring.bind "model" />
<head>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="../../../css/myStyle.css" type="text/css">
    <link rel="stylesheet" href="../../../css/bootstrap.min.css" type="text/css">
    <title>${model.film.name}</title>
</head>
<body>
<div id="container">
    <div >
        <h3>${model.film.name}</h3>
        <img src="https://htstatic.imgsmail.ru/pic_image/e6fd77f3ca05b444adec983ea9b6317a/1920/-/1220069/" alt=" =( "
             style=" width: 300px">
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

</div>


</body>