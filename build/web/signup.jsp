<%-- 
    Document   : signup.jsp
    Created on : Jun 22, 2018, 7:58:01 AM
    Author     : Arvind Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <title>Registration</title>
    </head>
     <style>
        #signup{
            margin-top:100px;

        }
        .lgn{
            border: 3px solid darkgreen;
            padding:30px;
        }
        label{
            color:#0056b3;
        }
        </style>
        <script language="JavaScript">
            function validate(){
                if(document.form1.UserName.value==""){
                    alert("UserName cannot be blank");
                    return;
                }
                if(document.form1.Password.value==""){
                    alert("Password cannot be blank");
                    return;
                }
                if(document.form1.Password.value!=document.form1.Password2.value){
                    alert("The two Password do not match");
                    return;
                }
                if(document.form1.FirstName.value==""){
                    alert("First Name cannot be blank");
                     return;
                }
                if(document.form1.LastName.value==""){
                    alert("Last Name cannot be blank");
                     return;
                }
                if(document.form1.Address1.value==""){
                    alert("Address cannot be blank");
                     return;
                }
                if(document.form1.City.value==""){
                    alert("City cannot be blank");
                     return;
                }
                if(document.form1.State.value=="Select State"){
                    alert("You must select a state");
                     return;
                }
                if(document.form1.PinCode.value==""){
                    alert("PinCode cannot be blank");
                     return;
                }
                if(document.form1.Email.value==""){
                    alert("Email ID cannot be blank");
                     return;
                }
                if(document.form1.Phone.value==""){
                    alert("Phone Number cannot be blank");
                     return;
                }
                document.forms[0].action="Sign.jsp";
                document.forms[0].submit();
            }
        </script>
    <body>
        <section id="signup">
            <div class="container">
                <div class="row">
                    <div class="col-sm-3"></div>
                    <div class="col-sm-6 lgn">
                        <u> <h4 class="text-center">Online Shopping Cart</h4></u>
                        <h5 class="text-center">New User Registration</h5>
                        <form name="form1" method="post">
                            <label>(Field marked * are necessary)</label>
                            <br>
                            <label>User *</label>
                            <input type="text" class="form-control" placeholder="Username" name="UserName">
                            <label>Password *</label>
                            <input type="password" class="form-control" placeholder="Password"name="Password">
                            <label>Confirm Password*</label>
                            <input type="password" class="form-control" placeholder="Confirm Password" name="Password2">
                            <label>First Name *</label>
                            <input type="text" class="form-control" placeholder="First Name" name="FirstName">
                            <lable>Middle Name *</label>
                            <input type="text" class="form-control" placeholder="Middle Name" name="MiddleName">
                            <label>Last Name</label>
                            <input type="text" class="form-control" placeholder="Last Name" name="LastName">
                            <label>Address1 *</label>
                            <input type="text" class="form-control" placeholder="Adress 1" name="Address1">
                            <label>Address2</label>
                            <input type="text" class="form-control" placeholder="Address2" name="Address2">
                            <label>City *</label>
                            <input type="text" class="form-control" name="City">
                            <label>State *</label>
                            <select class="form-control" name="State">
                                <option selected value="Select State">--Select State--</option>
                                <option>Assam</option>
                                <option>Arunachal Pradesh</option>
                                <option>Haryana</option>
                                <option>Maharashtra</option>
                                <option>Rajasthan</option>
                                <option>Uttar Pradesh</option>
                            </select>
                            <label>Pin Code *</label>
                            <input type="number" class="form-control" placeholder="Pin Code" name="PinCode">
                            <label>Email Id *</label>
                            <input type="email" class="form-control" placeholder="Email" name="Email">
                            <label>Phone Number *</label>
                            <input type="number" class="form-control" placeholder="Phone Number" name="Phone">
                            <br>
                            <input type="submit" class="btn btn-success" value="Submit" name="B1" onclick="validate();">
                        </form>
                    </div>
                    <div class="col-sm-3"></div>
                </div>
            </div>
        </section>
    </body>
</html>
