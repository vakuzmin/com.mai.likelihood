<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <style type="text/css">

     .logo {
       float: left;
     }
     nav {
       float: right;
     }
     nav ul {
       margin: 0;
       padding: 0;
       list-style: none;
     }
     nav li {
       display: inline-block; /*один из способов разместить элементы в строку*/

     }

     .container {
       height: 100%;
       background-color: #DCDCDC;
       width: 100%;
       max-width: 1024px; /*максимальная ширина может иметь другое значение*/
       padding: 0 15px;
       margin: 0 auto;

     }
     .container:after {
       content: "";
       display: table;
       clear: both;
     }
     .container {
       width: 100%;
       max-width: 1024px;
       padding: 15px;
       margin: 0 auto;
     }
     .col-1-2 {
       width: 50%;
     }

    input[type="text"]:focus {
     color: #808080;}

    input[type="text"] {
     border:1px solid #aaa;
     box-shadow: 0px 0px 3px #ccc, 0 10px 15px #eee inset;
     border-radius:2px;}

     input[type="submit"] {
      display: inline-block;
        width: 15em;
        font-size: 80%;
        color: rgba(255,255,255,.9);
        text-shadow: #2e7ebd 0 1px 2px;
        text-decoration: none;
        text-align: center;
        line-height: 1.1;
        white-space: pre-line;
        padding: .7em 0;
        border: 1px solid;
        border-color: #60a3d8 #2970a9 #2970a9 #60a3d8;
        border-radius: 6px;
        outline: none;
        background: #60a3d8 linear-gradient(#89bbe2, #60a3d8 50%, #378bce);
        box-shadow: inset rgba(255,255,255,.5) 1px 1px;
      }
      input[type="submit"]:first-line{
        font-size: 170%;
        font-weight: 700;
      }
      input[type="submit"]:hover {
        color: rgb(255,255,255);
        background-image: linear-gradient(#9dc7e7, #74afdd 50%, #378bce);
      }
      input[type="submit"]:active {
        color: rgb(255,255,255);
        border-color: #2970a9;
        background-image: linear-gradient(#5796c8, #6aa2ce);
        box-shadow: none;
      }
  </style>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
	<spring:url value="/css/main.css" var="springCss" />
</head>
<body>
<header>
  <div class="container">
    <a href="/" class="logo">LOGO</a>
    <nav>
      <ul>
        <li><a href="">Main</a></li>
        <li><a href="src/main/webapp/WEB-INF/jsp/about.jsp">About</a></li>
        <li><a href="">Contucts</a></li>
      </ul>
    </nav>
  </div>
</header>

<div class="container">

    <div class="calculation">
         <div class="row">
             <div class="col-1-2">
                 <form action="/calculate" method="post">

                   <h2><span>Input your result: </span></h2><input type="text" name="score"/><br>  <br>

                   <input type="submit" name="submit" value="Calculate"/>
                 </form>
             </div>
         </div>
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
<footer>
<div class="container">
    <div class="col-1-3"></div>
    <div class="col-1-3"></div>
    <div class="col-1-3"></div>
  </div>
</footer>

</html>