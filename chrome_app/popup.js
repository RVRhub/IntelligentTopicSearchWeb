$(document).ready(function()
{
	$('#btn_submit').click(function(e)
	{
		e.preventDefault();
		
		var input = $('#input').val();
		
		var url = "http://translate.yandex.net/api/v1/tr.json/translate";
		
		var parent = /[à-ÿ¸¨]/i;
		
		var language = (parent.test(input))? 'ru-en' : 'en-ru';
		
		$.getJSON(url, {lang: language, text: input}, function(res){
			$('#result').text("");
			for(var i in res.text)
			{
				$('#result').text($('#result').text() + res.text[i] + " ");
			}
		}
	}
}