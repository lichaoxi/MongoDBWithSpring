<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>find</title>
    <link rel="shortcut icon" type="image/x-icon" href="favicon.ico" media="screen">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-table.css" rel="stylesheet">
  </head>
  <body>
	<div class="panel panel-warning" style="width:50%">
		<div class="panel-heading">查找全部数据</div>
		<div class="panel-body">
		<table data-toggle="table" 
		       data-url="FindPerson"
		       data-classes="table table-hover table-condensed"
		       data-striped="true">
		    <thead>
		    <tr>
		        <th class="col-xs-2" data-field="_id">_id</th>
		        <th class="col-xs-2" data-field="name">name</th>
		        <th class="col-xs-2" data-field="age">age</th>
		    </tr>
		    </thead>
		</table>
		</div>
	</div>
    <script src="js/jquery-1.9.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrap-table.js"></script>
  </body>
</html>