<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Movies Web</title>
    <link href="styles/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="styles/navbar.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Movies</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Link</a></li>
                    <li><a href="#">Link</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
    </nav>

    <h1>Welcome to Movies App</h1>
    <p class="lead">Manage your favorites movies</p>

    <div class="row">

        <div class="col-md-7">
            <c:if test="${requestScope.listSize > 0}">
                <table class="table table-hover">
                    <caption>My Movies</caption>
                    <thead>
                    <tr>
                        <th>#</th>
                        <th colspan="2">Title</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.movies}" var="m" varStatus="status">
                        <tr>
                            <td>${status.index + 1}</td>
                            <td><a title="${m.title}" href="#">${m.title}</a></td>
                            <td>
                                <button type="button" class="btn btn-primary btn-xs" onclick="deleteMovie('${m.id}');">
                                    <span class="glyphicon glyphicon-remove-circle"></span> Delete
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>


        <div class="col-md-5">

            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Add New Movie</h3>
                </div>
                <div class="panel-body">

                    <form class="form-horizontal" role="form" action="list" method="POST">
                        <div class="form-group">
                            <label for="movieTitle" class="col-sm-2 control-label">Title</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="movieTitle" name="movieTitle" placeholder="title">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">Add!</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>

</div>

<script src="js/jquery-1.11.1.min.js"></script>
<script src="styles/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>