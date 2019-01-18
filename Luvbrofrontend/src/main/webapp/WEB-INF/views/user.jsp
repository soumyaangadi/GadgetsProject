<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="u1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix='c' uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<style>
/* Full-width input fields */
input[type=text], input[type=password],input[type=email],input[type=number] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

/* Set a style for all buttons */
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

/* Extra styles for the cancel button */
.cancelbtn {
    padding: 14px 20px;
    background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn,.signupbtn {
    float: left;
    width: 50%;
}

/* Add padding to container elements */
.container {
    padding: 16px;
}

/* Clear floats */
.clearfix::after {
    content: "";
    clear: both;
    display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
    .cancelbtn, .signupbtn {
       width: 100%;
    }
}



</style>
<body>

<h2>Signup Form</h2>
<c:url value="/Add_user" var="u"/>
<form:form action="${u}" style="border:1px solid #ccc" method="POST" commandName="user">
  <div class="container">
     <label><b>User id:</b></label>
     <form:input type="text" placeholder="enter your id" name="id" path="U_id" />
     
     <label><b>User name:</b></label>
     <form:input type="text" placeholder="enter your name" name="name" path="U_name" />

    <label><b>Email</b></label>
    <form:input type="email" placeholder="Enter Email" name="email" path="U_email_addr" />

    <label><b>Password</b></label>
    <form:input type="password" placeholder="Enter Password" name="psw" path="U_password" />

    <label><b>Repeat Password</b></label>
    <form:input type="password" placeholder="Repeat Password" name="psw-repeat" path="U_rptpwd" />

    <label><b>Phone number</b></label>
    <form:input type="number" placeholder="enter your Phone Number" name="number" path="U_phoneno" />
    <input type="checkbox" checked="checked"> Remember me
    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

    <div class="clearfix">
      <button type="button" class="cancelbtn">Cancel</button>
      <button type="submit" class="signupbtn">Sign Up</button>
    </div>
  </div>
</form:form>
<style>
table, th, td {
    text-align:center;
    border: 1px solid #e5e5e5;
    border-collapse: collapse;
}
@media screen and (max-width: 300px) {
    .editbtn, .deletebtn {
       width: 10%;
    }
    </style>

<!-- <tr> -->
<!--     <td>17</td> -->
<!--     <td>Prashanth</td> -->
<!--     <td>prashanth@gmail.com</td> -->
<!--     <td>priya</td> -->
<!--     <td>priya</td> -->
<!--     <td>9036106898</td> -->
<!--     <td><button type="button" class="editbtn">Edit</button></td> -->
<!--     <td>  <button type="button" class="deletebtn">Delete</button> -->
<!--   </tr> -->
  
</table>

</body>
</html>
