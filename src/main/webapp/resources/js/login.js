$(document).ready(function(){
	$("#divMsg").ajaxStart(function(){
		  $(this).show().html("�������ڷ�����!");
	});
	$("#divMsg").ajaxStop(function(){
		  $(this).hide().html("���������!");
	});
});