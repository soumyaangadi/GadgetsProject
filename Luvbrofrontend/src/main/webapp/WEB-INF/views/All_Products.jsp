<%@taglib prefix='c' uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<c:url value="/resource/images" var="img"/>

<style>
div.gallery {
    margin: 5px;
    border: 1px solid #ccc;
    float: left;
    width: 180px;
}

div.gallery:hover {
    border: 1px solid #777;
}

div.gallery img {
    width: 100%;
    height: auto;
}

div.desc {
    padding: 15px;
    text-align: center;
}
@media screen and (max-width: 300px) {
    .addtocart {
       width: 10%;
    }
}
</style>
</head>
<body>

<div class="gallery">
<a href="<c:url value="/watch1des"/>"><img src="${img}\images1.jpg" ></a>
  
  
  <div class="desc">Titan analog watch RS.4,550<button type="button" class="addtocart">Add To Cart</button></div>
</div>



<c1:forEach  items="${productlist}" var="product">
	<div class="gallery">
	<img src="<c:url value='/resource/images/${product.getP_id()}.jpg'/>">
	<h3>${product.getP_name()}   ${product.getP_c()}</h3>
<a  href="<c:url value="/addtocart/${product.getP_id()}"/>" title="add to cart"> Add to cart</a>
</div>
</c1:forEach>

</body>
</html>
