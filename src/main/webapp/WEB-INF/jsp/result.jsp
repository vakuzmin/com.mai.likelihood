<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <style type="text/css">
          .container {
            background-color: #C0C0C0;
            text-align: center;}

  </style>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <spring:url value="/css/main.css" var="springCss"/>
</head>
<body>
<div class="container">

    <div class="starter-template">
        <h1>Result: </h1>
        <h2>${calculationResponse.result}</h2>
    </div>

</div>

<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>