$(function(){
	console.log("Hello Word");
	
	$('#connect').click(function () {
		$.get(`${url}/download`).done(function(data){
			console.log(data);
		})
	});
})