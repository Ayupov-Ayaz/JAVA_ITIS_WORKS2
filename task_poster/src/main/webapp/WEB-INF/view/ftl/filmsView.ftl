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
        <#list .data_model["filmsModel"] as film>
        <tr>
            <td>${film.id}</td>
            <td>${film.name}</td>
            <td>${film.releaseDate}</td>
            <td>${film.country}</td>
            <td>${film.producer}</td>
            <td>${film.lasting}</td>

                <#--<#list film.actors as actor>-->
            <#--<td>-->
                    <#--&lt;#&ndash;${actor.actorName}&ndash;&gt;-->

            <#--</td>-->
                <#--</#list>-->
            <#--<#list  .data_model["genres"] as genre>-->
                <#--<td>${film.genres}</td>-->
            <#--</#list>-->
            <#--<td>${film.description}</td>-->
        </tr>

        </#list>
    </table>
</div>