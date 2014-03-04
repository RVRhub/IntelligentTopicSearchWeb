<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>Spring MVC - Ajax</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
  </head>
  <body>
	
	<div id="container">
	
		<h1>Test Page</h1>
		<p>This page demonstrates Spring MVC's powerful Ajax functionality. Retrieve a
		random document without page reload.
		</p>
		
		<h2>Random Document Generator</h2>
		<input type="submit" id="randomDocument" value="Get Random Document" /><br/><br/>
		<div id="documentResponse"> </div>
		
		<hr/>
		
		
	</div>
	
	
	<script type="text/javascript">
	
		$(document).ready(function() {
			

			$('#randomDocument').click(function() {
				$.getJSON('${pageContext.request.contextPath}/restful/document/listdatafirst', function(document) {
					$('#documentResponse').text(document.title);
				});
			});
			
			
		});
		
		
		
	
	</script>
	
  </body>
</html>