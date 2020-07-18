<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!--<script src="jquery-ui/external/jquery/jquery.js"></script>
<script src="jquery-ui/jquery-ui.min.js"></script>-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
    let actorsIds = [];
    function actorChosen($val) {
        if (actorsIds.includes(parseInt($val)) === false) {
            actorsIds.push(parseInt($val));
            alert('Actor added');
        }
        console.log("actorsIds")
        console.log(actorsIds);

        if (actorsIds.size === 0) {
            return;
        }
        var chosenActorsDropDown = document.getElementById("selectedActor");
        chosenActorsDropDown.options.length = 0;
        for (var i = 0; i < actorsIds.length; i++) {
            var opt = actorsIds[i];
            var el = document.createElement("option");
            el.textContent = opt;
            el.value = opt;
            chosenActorsDropDown.appendChild(el);
        }
        var elements = document.getElementById("actorDtos").options;

        for (var i = 0; i < elements.length; i++) {
            elements[i].selected = false;
        }
    }

    function removeActors() {
        actorsIds = [];
        var chosenDirectorsDropDown = document.getElementById("selectedActor");
        chosenDirectorsDropDown.options.length = 0;

        console.log("actorsIds")
        console.log(actorsIds);
    }

    let directorsIds = [];
    function directorsChosen($val) {
        if (directorsIds.includes(parseInt($val)) === false) {
            directorsIds.push(parseInt($val));
            alert('Director added');
        }
        console.log("directorsIds")
        console.log(directorsIds);

        if (directorsIds.size === 0) {
            return;
        }
        var chosenDirectorsDropDown = document.getElementById("selectedDirector");
        chosenDirectorsDropDown.options.length = 0;
        for (var i = 0; i < directorsIds.length; i++) {
            var opt = directorsIds[i];
            var el = document.createElement("option");
            el.textContent = opt;
            el.value = opt;
            chosenDirectorsDropDown.appendChild(el);
        }

        var elements = document.getElementById("directorDtos").options;

        for (var i = 0; i < elements.length; i++) {
            elements[i].selected = false;
        }
    }

    function removeDirectors() {
        directorsIds = [];
        var chosenDirectorsDropDown = document.getElementById("selectedDirector");
        chosenDirectorsDropDown.options.length = 0;

        console.log("directorsIds")
        console.log(directorsIds);
    }

    function onSubmitForm() {
        var title = document.getElementById("title").value;
        var duration = parseInt(document.getElementById("duration").value);
        var genre = document.getElementById("genre").value;
        var year = parseInt(document.getElementById("year").value);
        var language = document.getElementById("language").value;
        var rating = parseFloat(document.getElementById("ratingIMDb").value);

        var jsonObject = {};
        jsonObject["title"] = title;
        jsonObject["duration"] = duration;
        jsonObject["genre"] = genre;
        jsonObject["year"] = year;
        jsonObject["language"] = language;
        jsonObject["ratingIMDb"] = rating;
        jsonObject["directorIds"] = directorsIds;
        jsonObject["actorIds"] = actorsIds;
        console.log(jsonObject)

        request = $.ajax({
            url: "http://localhost:8080/Cinema/movie/save",
            method: "POST",
            data: JSON.stringify(jsonObject),
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Content-Type", "application/json");
            }
        })

    }
</script>
<div>

    <c:if test="${not empty message}">
        <div class="alert alert-info" role="alert mb-2">${message}</div>
    </c:if>

    <div class="container-fluid">
        <form:form action="#" onsubmit="event.preventDefault(); onSubmitForm()" modelAttribute="movieDto">
            <%--<form:form action="${pageContext.request.contextPath}/movie/save" method="post" modelAttribute="movieDto">--%>

            <div class="form-label-group">
                <label for="directorDtos">Directors</label>
                <form:select path="directorDtos" id="directorDtos" class="form-control" onchange="directorsChosen(value)">
                    <form:options items="${directors}" itemLabel="name" itemValue="id" ></form:options>
                </form:select>
            </div>

            <div class="form-label-group">
                <label for="selectedDirector">Selected directors</label>
                <select id="selectedDirector">
                </select>
                <p/>
                <div><button id="removeAllDirectors" onclick="event.preventDefault(); removeDirectors()">Remove all directors</button> </div>
                <p/>
            </div>

            <div class="form-label-group">
                <label for="actorDtos">Actors</label>
                <form:select path="actorDtos" id="actorDtos" class="form-control" onchange="actorChosen(value)">
                    <form:options items="${actors}" itemLabel="name" itemValue="id" ></form:options>
                </form:select>
            </div>

            <div class="form-label-group">
                <label for="selectedActor">Selected actors</label>
                <select id="selectedActor">
                    <!--<option>Choose a actor</option>-->
                </select>
                <p/>
                <div><button id="removeAllActors" onclick="event.preventDefault(); removeActors()">Remove all actors</button> </div>
                <p/>
            </div>

            <div>Movie title:</div>
            <div><form:input type="text" id="title" path="title" /></div>
            <div class="text-danger">
                <form:errors path="title" cssClass="error" />
            </div>

            <div>Movie duration:</div>
            <div><form:input type="number" id="duration" path="duration" min="0" /></div>
            <div class="text-danger">
                <form:errors path="duration" cssClass="error" />
            </div>

            <div>Movie genre:</div>
            <div><form:input type="text" id="genre" path="genre" /></div>
            <div class="text-danger">
                <form:errors path="genre" cssClass="error" />
            </div>

            <div>Movie year:</div>
            <div><form:input type="text" id="year" path="year" /></div>
            <div class="text-danger">
                <form:errors path="year" cssClass="error" />
            </div>

            <div>Movie language:</div>
            <div><form:input type="text" id="language" path="language" /></div>
            <div class="text-danger">
                <form:errors path="language" cssClass="error" />
            </div>

            <div>Movie ratingIMDb:</div>
            <div><form:input type="text" id="ratingIMDb" path="ratingIMDb" /></div>
            <div class="text-danger">
                <form:errors path="ratingIMDb" cssClass="error" />
            </div>

            <p/>
            <div><button id="save">Save</button> </div>
            <p/>
        </form:form>
    </div>

</div>