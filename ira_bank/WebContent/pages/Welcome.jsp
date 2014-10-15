<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" media="screen" href="css/bootstrap.css" />  
<style>
    body {
        margin-top: 60px;
    }
</style>
<script type="text/javascript">
window.history.forward(1);
function noBack()
{
	window.history.forward(); 
}
</script>
</head>

<body onload="noBack();" onpageshow="if (event.persisted) noBack();" onload="">
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.php">Home</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
                    <li><a href="#about">Search</a>
                    </li>
                    <li><a href="#services">View Templates</a>
                    </li>
                    <li><a href="#contact">Organization Info</a>
                    </li>
                    <li><a href="/RecommendationSystem">Log out</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <div class="container">

        <div class="row">
            <div class="col-lg-12">
                <h1>Welcome ${userName}</h1>
                <br>
               	<br> 
                <h2>Search Templates</h2>
            </div>
        </div>

    </div>
    <!-- /.container -->

    <!-- JavaScript -->
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.js"></script>


</body>
</head>

</html>