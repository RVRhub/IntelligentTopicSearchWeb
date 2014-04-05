<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>IntelligentTopicSearch</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
  </head>
  <body>
	
	<div id="container">

        <label >Please Enter the number topics</label>
        <input type="text" name="thingy" onchange="updateInput(value)" />
		
		<h2>List topics: </h2>

        <div id='foo'/>


		
	</div>

    <script type="text/javascript">
        function updateInput(ish) {

            var ulClear = document.getElementById('foo');
            if(ulClear != null)
                ulClear.innerHTML = "";

            var list = document.createElement('ul');

            for(var i = 0; i < ish; i++) {
                // Create the list item:
                var item = document.createElement('li');

                // Set its contents:

                item.setAttribute("id", 'topic'+i);

                var ahref = document.createElement('a');
                ahref.setAttribute("href", '#');
                ahref.setAttribute("onclick", 'showListLinks('+i+');');
                ahref.appendChild(document.createTextNode('Topic ' + i));


                var listLicks = document.createElement('ul');
                listLicks.setAttribute("id", 'list_topic'+i);
                ahref.appendChild(listLicks);

                item.appendChild(ahref);

                // Add it to the list:
                list.appendChild(item);
            }

            document.getElementById('foo').appendChild(list);
        }


            function showListLinks(id) {
                var ul = document.getElementById('list_topic'+id);
                ul.innerHTML = "";
				$.getJSON('${pageContext.request.contextPath}/restful/document/'+id, function(document) {

                    $.each(document.documents, function (i, documents) {
                        var option_cate = ('<li class="item"><a href="' + documents.url + '">' + documents.title + '</a></li>');
                        $('#list_topic'+id).append(option_cate);

                    });

                });
			}
			

		
		
		
	
	</script>
	
  </body>
</html>