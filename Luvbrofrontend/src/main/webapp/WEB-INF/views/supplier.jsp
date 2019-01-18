<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="s1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix='c' uri="http://www.springframework.org/tags" %>

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

<h3>Supplier Details:</h3>

<div>
<c:url value="/Add_supplier" var="s"/>
<form:form action="${s}" method="POST" commandName="supplier">  
  <label for="sid">Supplier ID</label>
    <form:input type="text" id="sid" name="supplierid" placeholder="Your id.." path="S_id"/>
    <label for="sname">Supplier Name</label>
    <form:input type="text" id="sname" name="suppliername" placeholder="Your name.." path="S_name"/>

    <label for="snum">Supplier Number</label>
    <form:input type="number" id="snum" name="suppliernumber" placeholder="Your number.." path="S_num"/>
    
    <label for="sproduct">Supplier Product</label>
    <form:input type="text" id="sproduct" name="supplierproduct" placeholder="Your name.." path="S_product"/>

<center><input type="submit" value="Submit">
<input type="reset" value="Reset">
<input type="cancel" value="Cancel"></center>

  </form:form>
</div>

<table style="width:100%">
  <tr>
    <th>Supplier ID</th>
    <th>Supplier name</th> 
    <th>Supplier Number</th>
   <th>Supplier Product</th>
   <th>Edit the Details</th>
<th>Cancel the Details</th>
  </tr>
    <s1:forEach items="${suppliers}" var="supplier">
  <tr>
    <td>${supplier.getS_id()}</td>
    <td>${supplier.getS_name()}</td>
    <td>${supplier.getS_num() }</td>
    <td>${supplier.getS_product()}</td>
    <td><a href="<c:url value="/editsupplier/${supplier.getS_id()}"/>" class="editbtn">Edit</a></td>
    <td> <a href="<c:url value="/deletesupplier/${supplier.getS_id()}"/>" class="deletebtn">Delete</a></td>
  </tr></s1:forEach>
  </table>


</body>
</html>
