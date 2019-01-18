<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix='c' uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<c:url value="/resource/images" var="img"/>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #e7e5e0;
}

body,html
{ 
background-color : black;
}

li  {
    float: left;
}

li a 
{
    display: block;
    color: black;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover {
    background-color: #ffffff;
}

* {box-sizing:border-box}
body {font-family: Verdana,sans-serif;}
.mySlides {display:none}


.slideshow-container {
  max-width: 1000px;
  position: relative;
  margin: auto;
}


.text {
  color: #f2f2f2;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  bottom: 8px;
  width: 100%;
  text-align: center;
}


.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}


.dot {
  height: 13px;
  width: 13px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active {
  background-color: #717171;
}

.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 1.5s;
  animation-name: fade;
  animation-duration: 1.5s;
}

@-webkit-keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

@keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

@media only screen and (max-width: 300px) {
  .text {font-size: 11px}
}

</style>
</head>
<body>

<ul>
<c1:if test="${pageContext.request.userPrincipal.name!=null }">
<security:authorize access="hasRole('ROLE_ADMIN')">
  <li><a  class="active" href="#home">Home</a></li>
  <li><a href="<c:url value="/product"/>">Add products</a></li>
  <li><a href="<c:url value="/supplier"/>">Add supplier</a></li>
  <li><a href="<c:url value="/category"/>">Add category</a></li>
    </security:authorize>
   </c1:if>
  <li><a href="<c:url value="/allproducts"/>">All products</a></li>
  <li><a href="<c:url value="/viewcart"/>"><img src="${img}/logo.png"  height="30px"  width="30px">${items}</a></li>
  
  
  <c1:if test="${pageContext.request.userPrincipal.name==null }">
   <li><i aria-hidden="true" ></i><a href="<c:url value="/login"/>">login</a></li>
   <li><a href="<c:url value='/user'/>"></a><i aria-hidden="true" ></i>
   <a href="<c:url value="/user"/>">signup</a></li>
    </c1:if>
   
   
   <c1:if test="${pageContext.request.userPrincipal.name!=null }">
   <li><a href="<c:url value='/j_spring_security_logout'/>">
   <br>Welcome&nbsp;
   <i aria-hidden="true"></i>
   ${pageContext.request.userPrincipal.name}
   <i aria-hidden="true"></i>
   <li>SignOut</li>
   </a>
   </li>
   </c1:if>
</ul>
<div class="slideshow-container">

<div class="mySlides fade">
  <div class="numbertext">1 / 3</div>
  <img src="${img}/11.jpg" style="width:100%">
  <div class="text">Caption Text</div>
</div>

<div class="mySlides fade">
  <div class="numbertext">2 / 3</div>
  <img src="${img}/2.jpg" style="width:100%">
  <div class="text">Caption Two</div>
</div>

<div class="mySlides fade">
  <div class="numbertext">3 / 3</div>
  <img src="${img}/33.jpg" style="width:100%">
  <div class="text">Caption Three</div>
</div>

</div>
<br>

<div style="text-align:center">
  <span class="dot"></span> 
  <span class="dot"></span> 
  <span class="dot"></span> 
</div>

<script>
var slideIndex = 0;
showSlides();

function showSlides() {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    var dots = document.getElementsByClassName("dot");
    for (i = 0; i < slides.length; i++) {
       slides[i].style.display = "none";  
    }
    slideIndex++;
    if (slideIndex> slides.length) {slideIndex = 1}    
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[slideIndex-1].style.display = "block";  
    dots[slideIndex-1].className += " active";
    setTimeout(showSlides, 4000); // Change image every 2 seconds
}
</script>

</body>
</html>
