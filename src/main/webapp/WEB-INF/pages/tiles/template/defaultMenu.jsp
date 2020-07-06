<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

    <a class="navbar-brand" href="#">My web MVC Cinema application</a>
    <ul class="navbar-nav mr-auto d-flex justify-content-end">
        <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Movie
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="<c:url value = "/movie"/>">Movie home</a>
                <a class="dropdown-item" href="<c:url value = "/movie/add"/>">Movie add</a>
                <a class="dropdown-item" href="<c:url value = "/movie/all"/>">Movie all</a>
            </div>
            
        </div>   
    </ul>
    <ul class="navbar-nav mr-auto d-flex justify-content-end">
        <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Projection
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="<c:url value = "/projection"/>">Projection home</a>
                <a class="dropdown-item" href="<c:url value = "/projection/add"/>">Projection add</a>
                <a class="dropdown-item" href="<c:url value = "/projection/all"/>">Projection all</a>
            </div> 
        </div>
    </ul>
</nav>
