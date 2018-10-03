<%-- 
    Document   : login.jsp
    Created on : Jun 21, 2018, 4:57:23 PM
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
        <title>login</title>
        <script>
            
        </script>
    </head>
    <style>
        #login{
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
                if(document.frm.UserName.value==""||document.frm.Password.value==""){
                    alert("UserName or Passsword can not be blank.");
                    return;
                }
                document.frm.action="Validate.jsp";
                document.frm.submit();
            }
        </script>
    <body>
        <section id="login">
            <div class="container">
                <div class="row">
                    <div class="col-sm-3"></div>
                    <div class="col-sm-6 lgn">
                        <u> <h4 class="text-center">Online Shopping Cart</h4></u>
                        <h3 class="text-center">Login Here</h3>
                        <form name="frm" method="post">
                            <label>Username</label>
                            <input type="text" class="form-control" placeholder="Enter Username" name="UserName">
                            <label>Password</label>
                            <input type="password" class="form-control" placeholder="Enter Password" name="Password">
                            <br>
                            <input type="submit" class="btn btn-success w-100" value="Login" name="B1" onclick="validate();">
                        </form>
                        <span>New user?</span><a href="signup.jsp">Register here</a>
                    </div>
                    <div class="col-sm-3"></div>
                </div>
            </div>
        </section>
    </body>
</html>
