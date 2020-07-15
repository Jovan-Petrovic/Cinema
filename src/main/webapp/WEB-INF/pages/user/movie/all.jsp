<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<div>


    <form>
        <c:if test="${not empty message}">
            <div class="alert alert-info" role="alert mb-2">${message}</div>
        </c:if>

        <div class="container-fluid">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Title</th>
                        <th scope="col">Duration</th>
                        <th scope="col">Genre</th>
                        <th scope="col">Year</th>
                        <th scope="col">Language</th>
                        <th scope="col">IMDb rating</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach
                        items="${movies}"
                        var="movie"
                        varStatus="loop">
                        <tr>
                            <td>${movie.id}</td>
                            <td>${movie.title}</td>
                            <td>${movie.duration}</td>
                            <td>${movie.genre}</td>
                            <td>${movie.year}</td>
                            <td>${movie.language}</td>
                            <td>${movie.ratingIMDb}</td>
                            <td>
                                <ul class="navbar-nav mr-auto d-flex justify-content-end">
                                    <div class="dropdown">
                                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            action
                                        </button>
                                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                            <a class="dropdown-item" href="<c:url value = "/user/movie/${movie.id}/view/">

                                                </c:url>">View</a>
                                        </div>
                                    </div>
                                </ul>
                            </td>
                        </tr>
                    </c:forEach>


                </tbody>
            </table>
        </div>
    </form>
</div>