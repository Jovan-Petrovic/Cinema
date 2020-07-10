<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

    <a class="navbar-brand" href="#">Cinema web MVC application</a>
    <ul class="navbar-nav mr-auto d-flex justify-content-end">
        <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Movie
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="<c:url value = "/user/movie"/>">Movie home</a>
                <a class="dropdown-item" href="<c:url value = "/user/movie/all"/>">Movie all</a>
            </div>
            
        </div>   
    </ul>
    <ul class="navbar-nav mr-auto d-flex justify-content-end">
        <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Projection
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="<c:url value = "/user/projection"/>">Projection home</a>
                <a class="dropdown-item" href="<c:url value = "/user/projection/all"/>">Projection all</a>
            </div> 
        </div>
    </ul>
    <ul class="navbar-nav mr-auto d-flex justify-content-end">
        <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Reservation
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="<c:url value = "/user/reservation"/>">Reservation home</a>
                <a class="dropdown-item" href="<c:url value = "/user/reservation/all"/>">All yours reservations</a>
            </div>
            
        </div>   
    </ul>
</nav>
