<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>Demo</title>
	<link rel="stylesheet" href="css/zzsc.css" type="text/css">
	<script src="js/jquery-3.3.1.js"></script>
	<script type="text/javascript">
		/*$(document).ready(function(e) {
			$(".jquery_div").click(function(){
				
				alert("jquery单击"); 
			 	 
			});
		});*/
		function pageUp(){
			alert("单击事件");
			$.ajax({
		        type: "POST",
		        contentType: "application/json",
		        url: "/page",
		        data: JSON.stringify(search),
		        dataType: 'json',
		        cache: false,
		        timeout: 600000,
		        success: function (data) {
		            var json = "<h4>Ajax Response</h4><pre>"
		                + JSON.stringify(data, null, 4) + "</pre>";
		            $('#feedback').html(json);
		            console.log("SUCCESS : ", data);
		            $("#btn-search").prop("disabled", false);
		        },
		        error: function (e) {
		            var json = "<h4>Ajax Response</h4><pre>"
		                + e.responseText + "</pre>";
		            $('#feedback').html(json);
		            console.log("ERROR : ", e);
		            $("#btn-search").prop("disabled", false);
		        }
		    });
		}	
	</script>	
	</head>

	<body>  <br/>  <br/>  <br/>  <br/>  <br/>  <br/>  <br/>
		<table border="1" cellpadding="0" cellspacing="0" width="100%" height="50px">
			<tr>
				<#if num == 0>
					<#list list	as test>
						<td>
							name:  ${test.name} <br/>
							age :  ${test.age} <br/>
							id	:  ${test.id} <br/>
						</td>
					</#list>
				</#if>
				<#if num != 0>
					<#list list	as test>
						<td>
							name:  ${test.name} <br/>
							age :  ${test.age} <br/>
							id	:  ${test.id} <br/>
						</td>
					</#list>
				</#if>
			</tr>
		</table>
			
		<!-- 代码 开始 -->
		<div class="pagnation" id="pagnation">
			<a href="#" style="visibility: hidden;" id="pages" page="0">隐藏标签</a>
			<a href="#" target="_blank" class="page-prev" page="0">上一页</a>
			<a href="#" target="_blank" class="current" page="0">1</a>
			<a href="#" target="_blank" page="0">2</a>
			<a href="#" target="_blank" page="0">3</a>
			<a href="#" target="_blank" page="0">4</a>
			<a href="#" target="_blank" page="0">5</a>...
			<a href="#" target="_blank" page="0">13</a>
			<a href="javascript:pageUp();" target="_blank" class="page-next">下一页</a>
		</div>
		<!-- <script>
			var pagnation=$("#pagnation");
			$(document).on("keydown",function(event){
				switch(event.keyCode){
					 case 37 : window.location.href = pagnation.find(".page-prev").attr("href");break;
					 case 39 : window.location.href = pagnation.find(".page-next").attr("href");break
				}
			});
		</script> -->
		<!-- 代码 结束 -->
	</body>
</html>