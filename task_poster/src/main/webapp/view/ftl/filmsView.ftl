<div id="content">
    <table class="Film">
        <tr>
            <th>id</th>
            <th>film name</th>
            <th>release date</th>
            <th>country</th>
            <th>producer</th>
            <th>lasting</th>
            <th>actors</th>
            <th>genres</th>
            <th>description</th>
        </tr>
        <#list .data_model["filmsModel"] as film>
        <tr>
            <td>${film.id}</td>
            <td>${film.name}</td>
            <td>${film.releaseDate}</td>
            <td>${film.country}</td>
            <td>${film.producer}</td>
            <td>${film.lasting}</td>
                <#--<#list .data_model["actors"] as actor>-->
            <#--<td>-->
                    <#--${actor}-->
            <#--</td>-->
                <#--</#list>-->
            <#--<#list  .data_model["genres"] as genre>-->
                <#--<td>${film.genre}</td>-->
            <#--</#list>-->
            <td>${film.description}</td>
        </tr>

        </#list>
    </table>
</div>