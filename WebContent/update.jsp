<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>update</title>
    <link rel="shortcut icon" type="image/x-icon" href="favicon.ico" media="screen">    
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-table.css" rel="stylesheet">
  </head>
  <body>
	  <div class="panel	panel-warning" style="width:20%">
	  	<div class="panel-heading">根据name更新age</div>
  		<div class="panel-body">
		  	<form action="UpdatePerson">
				<input type="text" name="queryname" class="form-control" placeholder="queryname" aria-describedby="basic-addon1">
				<br/>
				<input type="text" name="updateage" class="form-control" placeholder="updateage" aria-describedby="basic-addon1">
				<br/>
				<button type="submit" class="btn btn-default">更新</button>
		  	</form>
	  	</div>
	  </div>
    <script src="js/jquery-1.9.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrap-table.js"></script>
  </body>
</html>