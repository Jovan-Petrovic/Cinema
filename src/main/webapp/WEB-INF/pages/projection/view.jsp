<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<div>
    <c:if test="${not empty message}">
        <div class="alert alert-info" role="alert mb-2">${message}</div>
    </c:if>

    <div class="container-fluid">
        <form:form action="${pageContext.request.contextPath}/projection/save" method="post" modelAttribute="projectionDto">
            <div>Projection id:</div>
            <div><form:input type="text" id="id" path="id" readonly="true"/></div>
            <div class="text-danger">
                <form:errors path="id" cssClass="error" />
            </div>

            <div>Projection date and time:</div>
            <div><form:input type="text" id="dateTime" path="dateTime" readonly="true"/></div>
            <div class="text-danger">
                <form:errors path="dateTime" cssClass="error" />
            </div>
            
            <div>Projection room:</div>
            <div><form:input type="text" id="room" path="room" readonly="true"/></div>
            <div class="text-danger">
                <form:errors path="room" cssClass="error" />
            </div>
            
            <div>Projection remaining seats:</div>
            <div><form:input type="text" id="remainingSeats" path="remainingSeats" readonly="true"/></div>
            <div class="text-danger">
                <form:errors path="remainingSeats" cssClass="error" />
            </div>
            
            <div>Projection movie:</div>
            <div><form:input type="text" id="movieDto.title" path="movieDto.title" readonly="true"/></div>
            <div class="text-danger">
                <form:errors path="movieDto.title" cssClass="error" />
            </div>
            
           <p/>
        </form:form>
    </div>

</div>