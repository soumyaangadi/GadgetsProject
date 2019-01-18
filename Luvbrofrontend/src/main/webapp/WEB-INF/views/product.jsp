<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix='c' uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<style> 

body  {

    background-image:  none;
    background-color: white;
   
}

input[type=text],input[type=number], select {
    width: 100%;
    padding: 10px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    background-color: black;
    box-sizing: border-box;
    color: white;
}

input[type=submit],input[type=reset],input[type=cancel] {
    width: 10%;
    background-color: #e5e5e5;
    color: black;
    padding: 10px 10px;
    margin: 8px 0;
    border: 2;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #949494;
}
input[type=reset]:hover {
    background-color: #949494;
}
input[type=cancel]:hover {
    background-color: #949494;
}

div {
    border-radius: 5px;
    background-color: #d4d4d4;
    padding: 20px;
}

@media screen and (max-width: 300px) {
    .editbtn, .deletebtn {
       width: 10%;
    }
}

</style>
<body>



<div>
  <c:url value="/Add_product" var="p"/>
<form:form action="${p}" method="POST" commandName="product" enctype="multipart/form-data">

<h3>Product Details:</h3>
<label for="pid"><b>Product ID</b></label>
    <form:input type="text" id="pid" name="productid" placeholder="Your product id.." path="p_id"/>

    <label for="pname"><b>Product Name</b></label>
    <form:input type="text" id="pname" name="productname" placeholder="Your product name.." path="p_name"/>

    <label for="pquantity"><b>Product Quantity</b></label>
    <form:input type="number" id="pquantity" name="productquantity" placeholder="Your product quantity.." path="p_q"/>
    
     <label for="pcost"><b>Product Cost</b></label>
    <form:input type="number" id="pcost" name="productcost" placeholder="Your product cost.." path="p_c"/>

     <label for="pdescription"><b>Product Description</b></label>
    <form:input type="text" id="pdescription" name="productdescription" placeholder="Your product description.." path="des"/>
    
    
    
      <label for="sel1">Supplier Product&nbsp &nbsp &nbsp</label>
      <form:select path="supplier.S_id" multiple="false">
    <c1:forEach items="${suppliers}" var="d">   
    <form:option value="${d.getS_id()}" label="${d.getS_name()}"/>
      </c1:forEach>
</form:select>
 
    <label for="sel1">Product Category &nbsp &nbsp &nbsp</label>
       <form:select path="category.C_id" multiple="false">
    <c1:forEach items="${categories}" var="d">   
    <form:option value="${d.getC_id()}" label="${d.getC_name()}"/>
      </c1:forEach>
</form:select>

<form:input path="pimg" type="file" name="image" value="upload file"/>
  
<center>    <input type="submit" value="Submit">
<input type="reset" value="Reset">
<input type="cancel" value="Cancel"></center>

  </form:form>
</div>
<table style="width:100%">
  <tr>
  <th>Product Image</th>
    <th>Product ID</th>
    <th> Product name</th> 
    <th> Product Quantity</th>
    <th> Product cost</th> 
    <th> Product Description</th>
    <th>Category Name</th>
    <th>Seller Name</th>
    <th>Edit the Details</th>
<th>Cancel the Details</th>
 </tr>
  <c1:forEach items="${products}" var="product">
  <tr>
    <td><img src="<c:url value='/resource/images/${product.getP_id()}.jpg'/>" , width=100px, height=200px></td>
    <td>${product.getP_id()}</td>
    <td>${product.getP_name()}</td>
    <td>${product.getP_q()}</td>
    <td>${product.getP_c()}</td>
    <td>${product.getDes()}</td>
    <td> ${product.category.getC_name() }</td>
    <td>${product.supplier.getS_name() }
    <td><a href="<c:url value="/editproduct/${product.getP_id()}"/>" class="editbtn">Edit</a></td>
    <td> <a href="<c:url value="/deleteproduct/${product.getP_id()}"/>" class="deletebtn">Delete</a></td>
  </tr></c1:forEach>
  </table>

</body>
</html>
