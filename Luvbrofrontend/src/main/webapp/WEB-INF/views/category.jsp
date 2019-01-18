<%-- <%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%> --%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
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

<h3>Category Details:</h3>

<div>
<c:url value="/Add_category" var="c"/>
<form:form action="${c} " method="POST" commandName="category">
  <label for="cid">Category ID</label>
    <form:input type="text" id="cid" name="categoryid" placeholder="Your categoryID.."  path="C_id"/>

    <label for="cname">Category Name</label>
    <form:input type="text" id="cname" name="categoryname" placeholder="Your category name.."  path="C_name"/>

    <label for="scname">Sub-category Name</label>
    <form:input type="text" id="scname" name="subcategoryname" placeholder="Your sub-category name.."  path="subC_name"/>

<center><input type="submit" value="Submit">
<input type="reset" value="Reset">
<input type="cancel" value="Cancel"></center>  </form:form>
</div>
<table style="width:100%">
  <tr>
    <th>Category ID</th>
    <th>Category Name</th> 
    <th>Sub-Category Name</th>
    <th>Edit the Details</th>
<th>Cancel the Details</th>
  </tr>
  <c1:forEach items="${categories}" var="category">
  <tr>
    <td>${category.getC_id()}</td>
    <td>${category.getC_name()}</td>
    <td>${category.getSubC_name()}</td>
    <td><a href="<c:url value="/editcategory/${category.getC_id()}"/>" class="editbtn">Edit</a></td>
    <td> <a href="<c:url value="/deletecategory/${category.getC_id()}"/>" class="deletebtn">Delete</a></td>
  </tr></c1:forEach>

  </table>

</body>
</html>
