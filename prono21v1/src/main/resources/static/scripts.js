$.get('http://localhost:8080/api', function(data){
	console.log(data);
}, 'html')
	.done(function(){
		alert("Completed");
	})
	.fail(function(e){
		console.log('error:');
		console.error(e);
	})
	.always(function(){
		alert("always runs");
	});