<%-- 
    Document   : Admin
    Created on : Jul 10, 2018, 6:53:49 PM
    Author     : Arvind Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Admin</title>
    </head>
    <body>
        <section>
            <div class="container">
                <div class="row">
                    <div class="col">
                        <h2 class="text-center"><u>Administering Online Shopping Cart</u></h2>
                        <br>
                        <hr>
                        <br>
                        <h3 class="text-center">Welcome Administrator</h3>
                        <form name="admin" method="post">
                            <table class="table">
                                <tr>
                                    <th></th>
                                    <th></th>
                                    <th></th>
                                    <th></th>
                                </tr>
                                <tr>
                                    <th>1</th>
                                    <th>Book</th>
                                    <th><a href="Insert.jsp">Insert new Book Details</a></th>
                                    <th><a href="Modify.jsp">Modify Book Details</a></th>
                                </tr>
                                <tr>
                                    <th>2</th>
                                    <th>Category</th>
                                    <th><a href="Insert_Category.jsp">Insert Book Category</a></th>
                                    <th><a href="Update_Category.jsp">Modify Book Category</a></th>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
