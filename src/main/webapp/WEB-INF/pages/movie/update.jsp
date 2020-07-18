<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<div>
    <c:if test="${not empty messageMovie}">
        <div class="alert alert-info" role="alert mb-2">${messageMovie}</div>
    </c:if>

    <div class="container-fluid">
        <form:form action="${pageContext.request.contextPath}/movie/update" method="post" modelAttribute="movieDto">
            <div>Movie id:</div>
            <div><form:input type="text" id="id" path="id" readonly="true"/></div>
            <div class="text-danger">
                <form:errors path="id" cssClass="error" />
            </div>

            <div>Movie title:</div>
            <div><form:input type="text" id="title" path="title"/></div>
            <div class="text-danger">
                <form:errors path="title" cssClass="error" />
            </div>
            
            <div>Movie duration:</div>
            <div><form:input type="text" id="duration" path="duration"/></div>
            <div class="text-danger">
                <form:errors path="duration" cssClass="error" />
            </div>
            
            <div>Movie genre:</div>
            <div><form:input type="text" id="genre" path="genre"/></div>
            <div class="text-danger">
                <form:errors path="genre" cssClass="error" />
            </div>
            
            <div>Movie year:</div>
            <div><form:input type="text" id="year" path="year"/></div>
            <div class="text-danger">
                <form:errors path="year" cssClass="error" />
            </div>
            
            <div>Movie language:</div>
            <div><form:input type="text" id="language" path="language"/></div>
            <div class="text-danger">
                <form:errors path="language" cssClass="error" />
            </div>
            
            <div>Movie ratingIMDb:</div>
            <div><form:input type="text" id="ratingIMDb" path="ratingIMDb"/></div>
            <div class="text-danger">
                <form:errors path="ratingIMDb" cssClass="error" />
            </div>
            
            <p/>
            <div><button id="update">Update</button> </div>
            <p/>
        </form:form>
    </div>

</div>