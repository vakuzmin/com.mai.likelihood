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

    <div class="starter-template">
        <h2>Welcome: ${message}</h2>
    </div>

    <div class="calculation">

        <form action="/calculate" method="post">

            <span>val 1: </span><input type="text" name="val1"/>
            <span>val 2: </span><input type="text" name="val2"/>

            <input type="submit" name="submit" value="Calculate"/>
        </form>
    </div>

</div>

<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>