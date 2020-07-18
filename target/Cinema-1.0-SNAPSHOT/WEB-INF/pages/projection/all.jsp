<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<div>


    <form>
        <c:if test="${not empty messageProjection}">
            <div class="alert alert-info" role="alert mb-2">${messageProjection}</div>
        </c:if>

        <div class="container-fluid">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Date and time</th>
                        <th scope="col">Room</th>
                        <th scope="col">Remainig seats</th>
                        <th scope="col">Movie</th> 
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach
                        items="${projections}"
                        var="projection"
                        varStatus="loop">
                        <tr>
                            <td>${projection.id}</td>
                            <td>${projection.dateTime}</td>
                            <td>${projection.room}</td>
                            <td>${projection.remainingSeats}</td>
                            <td>${projection.movieDto.title}</td>
                            <td>
                                <ul class="navbar-nav mr-auto d-flex justify-content-end">
                                    <div class="dropdown">
                                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            action
                                        </button>
                                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                            <a class="dropdown-item" href="<c:url value = "/projection/${projection.id}/delete/">

                                                </c:url>">Delete</a>

                                            <a class="dropdown-item" href="<c:url value = "/projection/${projection.id}/view/">

                                                </c:url>">View</a>
                                            <a class="dropdown-item" href="<c:url value = "/projection/${projection.id}/updateView/">

                                                </c:url>">Update</a>
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