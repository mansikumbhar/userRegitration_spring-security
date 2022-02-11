<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"  content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: black;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password],input[type=textarea] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus,input[type=textarea] {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: #04AA6D;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>


<title>User Registration Page</title>
</head>
<body>
<body>
	<form action="updateRegistrationData" method="post">
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

	<label for="emp_id"><b>emp_id</b></label>
    <input type="text" placeholder="Enter emp_id" name="emp_id" id="emp_id" value="${registration.emp_id}" required>

	<label for="emp-name"><b>Name</b></label>
    <input type="text" placeholder="Enter name" name="emp_name" id="emp_name" value="${registration.emp_name}"required>

	
	
    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" id="email" value="${registration.email}" required>

    <label for="city"><b>City</b></label>
    <input type="text" placeholder="Enter city" name="city" id="city" value="${registration.city}" required>

    <label for="mobile"><b>Mobile</b></label>
    <input type="text" placeholder="Enter mobile" name="mobile" id="mobile" value="${registration.mobile}" required>
    
    <label for="address"><b>Address</b></label>
    <input type="textarea" placeholder="Enter Address" name="address" id="address" value="${registration.address}" required>

    
    <hr>

    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
    <button type="submit" class="registerbtn">update</button>
  </div>

  
</form>
	${msg}
	
	<a href="getRegistration ">Click to see all locations</a>
	
	
</body>

</html>