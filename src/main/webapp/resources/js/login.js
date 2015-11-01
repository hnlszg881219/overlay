$(document).ready(function(){
	$("#divMsg").ajaxStart(function(){
		  $(this).show().html("请求正在发送中!");
	});
	$("#divMsg").ajaxStop(function(){
		  $(this).hide().html("请求已完成!");
	});
});