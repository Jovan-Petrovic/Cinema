<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<div>

    <c:if test="${not empty messageProjection}">
        <div class="alert alert-info" role="alert mb-2">${messageProjection}</div>
    </c:if>

    <div class="container-fluid">
        <form:form action="${pageContext.request.contextPath}/projection/save" method="post" modelAttribute="projectionDto">
                                                  
            <div class="form-label-group">
                <label for="movieDto">Movie</label>
                <form:select path="movieDto" id="movieDto" class="form-control">
                    <form:options items="${movies}" itemLabel="title" itemValue="title" ></form:options>
                </form:select>
            </div>

            <div>Projection date and time</div>
            <div><form:input type="text" id="dateTime" path="dateTime" /></div>
            <div class="text-danger">
                <form:errors path="dateTime" cssClass="error" />
            </div>
            
            <div>Projection room</div>
            <div><form:input type="text" id="room" path="room" /></div>
            <div class="text-danger">
                <form:errors path="room" cssClass="error" />
            </div>
            
            <div>Projection remaining seats</div>
            <div><form:input type="text" id="remainingSeats" path="remainingSeats" /></div>
            <div class="text-danger">
                <form:errors path="remainingSeats" cssClass="error" />
            </div>
            
            
            <p/>
            <div><button id="save">Save</button> </div>
            <p/>
        </form:form>
    </div>

</div>