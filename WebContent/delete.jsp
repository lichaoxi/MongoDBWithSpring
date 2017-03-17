<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>delete</title>
    <link rel="shortcut icon" type="image/x-icon" href="favicon.ico" media="screen">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-table.css" rel="stylesheet">
  </head>
  <body>
	  <div class="panel	panel-warning" style="width:20%">
	  	<div class="panel-heading">删除文档</div>
  		<div class="panel-body">
		  	<form action="DeletePerson">
				<input type="text" name="name" class="form-control" placeholder="name" aria-describedby="basic-addon1">
				<br/>
				<button type="submit" class="btn btn-default">删除</button>
		  	</form>
	  	</div>
	  </div>
    <script src="js/jquery-1.9.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrap-table.js"></script>
  </body>
</html>