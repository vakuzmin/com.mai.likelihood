<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <spring:url value="/css/main.css" var="springCss"/>
</head>
<body>
<header>
<div class="container">
    <a href="/" class="logo">LOGO</a>
    <nav>
      <ul>
        <li><a href="src/main/webapp/WEB-INF/jsp/welcome.jsp">Main</a></li>
        <li><a href="src/main/webapp/WEB-INF/jsp/about.jsp">About</a></li>
        <li><a href="">Контакты</a></li>
      </ul>
    </nav>
  </div>
</header>
</header>
<div class="main">
    <div class= "container">
    </div>
</div>
<footer></footer>
<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>