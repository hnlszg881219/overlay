$(document).ready(function(){
	$("#result pre").hide();
	//success
	var $success = function(data){
		$("#result pre").show().val(eval("("+data+")"));
	};
	//error
	var $error = function(XMLHttpRequest, textStatus, errorThrown){
		$("#result pre").show().val(textStatus);
	};
	//get
	$("#get").click(function(){
		var data = $("#content").val();
		$.ajax({
			type: "GET",
            url: $("#url").val(),
            data: data ,
            dataType: "json",
            success:$success,
            error:$error
		});
	});
	//put
	$("#put").click(function(){
		console.log($("#content").val());
		var data = $("#content").val().trim();
		$.ajax({
			type: "PUT",
			url: $("#url").val(),
            data: data,
            dataType: "json",
            success:$success,
            error:$error
		});
	});
	//delete
	$("#delete").click(function(){
		$.ajax({
			type: "DELETE",
			url: $("#url").val(),
            data: $("#content").val(),
            dataType: "json",
            success:$success,
            error:$error
		});
	});
	//post
	$("#post").click(function(){
		$.ajax({
			type: "POST",
			url: $("#url").val(),
            data: $("#content").val(),
            dataType: "json",
            success:$success,
            error:$error
		});
	});
});