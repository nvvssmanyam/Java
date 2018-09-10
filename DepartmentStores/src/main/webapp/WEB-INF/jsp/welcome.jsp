<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Welcome</title>
</head>
<body>
	<div class="container">
		<!-- Static navbar -->
		<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Departmental Stores</a>
			</div>
			<!--/.nav-collapse -->
		</div>
		<!--/.container-fluid --> </nav>
		<div>
			<input type="button" class="btn btn-default" id="getLocBtn"
				value="Load Locations" />
		</div>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$("#getLocBtn").click(function() {
			alert("clicked");
			$.ajax({
				url : "/location",
				success : function(result) {
					console.log(result);
				}
			});
		});
	});
</script>
</html>