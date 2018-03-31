<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
	<spring:url value="/css/main.css" var="springCss" />
</head>
<body>

<div class="container">

    <div class="calculation">

        <form action="/calculate" method="post">

            <h2><span>input your score: </span></h2><input type="text" name="score"/>

            <input type="submit" name="submit" value="Calculate"/>
        </form>
    </div>

    <c:choose>
        <c:when test="${error != null}">

            <div class="alert alert-danger" style="margin-top: 20px">
                <strong>Error!</strong> Please check your input and try again.
            </div>

        </c:when>
    </c:choose>

</div>

<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>