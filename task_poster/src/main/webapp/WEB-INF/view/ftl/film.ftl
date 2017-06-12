<#ftl encoding='UTF-8'>
<#import "spring.ftl" as spring />
<@spring.bind "model" />
<head>
    <meta  charset="UTF-8"/>
    <title>${model.film.name}</title>
</head>
<body>
<div id="container">

    <table class="Films">
        <tr>
            <th>id</th>
            <th>film name</th>
            <th>release date</th>
            <th>country</th>
            <th>producer</th>
            <th>lasting</th>
            <th>description</th>
            <th>genres</th>
            <th>actors</th>
        </tr>
        
    <tr>
        <td>${model.film.id}</td>
        <td>${model.film.name}</td>
        <td>${model.film.releaseDate}</td>
        <td>${model.film.country}</td>
        <td>${model.film.producer}</td>
        <td>${model.film.lasting}</td>
        <td>${model.film.description}</td>
        <td>
            <#list model.film.genres as genre>
                ${genre}
                <br>
            </#list>
        </td>
        <td>
            <#list model.film.actors as actor>
                ${actor}
                <br>
            </#list>
        </td>


    </tr>



    </table>
</div>


</body>