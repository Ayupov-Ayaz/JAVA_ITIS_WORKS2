<#ftl encoding='UTF-8'>
<#import "spring.ftl" as spring />
<div id="content">
    <table class="Film">
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
        <#list model["filmsModel"] as film>
        <tr>
            <td>${film.id}</td>
            <td>${film.name}</td>
            <td>${film.releaseDate}</td>
            <td>${film.country}</td>
            <td>${film.producer}</td>
            <td>${film.lasting}</td>
            <td>${film.description}</td>
            <td>
                <#list film.genres as genre>
                    ${genre}
                    <br>
                </#list>
            </td>
            <td>
                <#list film.actors as actor>
                    ${actor}
                    <br>
                </#list>
            </td>
        </tr>

        </#list>
    </table>
</div>